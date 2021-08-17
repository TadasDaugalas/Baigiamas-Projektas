package Servisai;

import Duomenys.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EgzaminuServisas {
    public void skaiciuotiRezultatus(String atsakymuDirektorijaKelias , String teisinguAtsakymuFailoKelias) throws Exception {
        File atsakymuDirektorija = new File(atsakymuDirektorijaKelias);
        if (!atsakymuDirektorija.exists() || !atsakymuDirektorija.isDirectory()) {
            throw new Exception("Nera atsakymu direktorijos");
        }

        List<String> atsakymuFailuKeliai = new ArrayList<>();
        for (File file : atsakymuDirektorija.listFiles()) {
            if (file.getName().endsWith(".json")) {
                String name = file.getAbsolutePath();
                atsakymuFailuKeliai.add(name);
            }
        }
        if (atsakymuFailuKeliai.size() == 0) {
            throw new Exception("Nera atsakymu failu");
        }

        File teisinguAtsakymuFailas = new File(teisinguAtsakymuFailoKelias);
        if (!teisinguAtsakymuFailas.exists() || !teisinguAtsakymuFailas.isFile()) {
            throw new Exception("Nera teisingu atsakymo failo");
        }

        List<StudentoEgzaminas> studentoEgzaminai = nuskaitytiStudentuEgzaminus(atsakymuFailuKeliai);
        TeisingiAtsakymai teisingiAtsakymai = nuskaitytiTeisingusAtsakymus(teisinguAtsakymuFailas);
//        spausdinti(studentoEgzaminai,teisingiAtsakymai);

        EgzaminuRezultatai egzaminuRezultatai = apskaiciuotiEgzaminuRezultatai(studentoEgzaminai, teisingiAtsakymai);
        issaugotiEgzaminuRezultatus(teisinguAtsakymuFailas.getParent(), egzaminuRezultatai);
    }

    private List<StudentoEgzaminas> nuskaitytiStudentuEgzaminus (List<String> failuKeliai) throws IOException {
        List<StudentoEgzaminas> studentoEgzaminas = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (String failoKelias : failuKeliai) {
            studentoEgzaminas.add(mapper.readValue(new File(failoKelias), StudentoEgzaminas.class));
        }

        return studentoEgzaminas;
    }

    private TeisingiAtsakymai nuskaitytiTeisingusAtsakymus (File failas) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(failas, TeisingiAtsakymai.class);
    }

    private void spausdinti(List<StudentoEgzaminas> egzaminai,TeisingiAtsakymai teisingiAtsakymai){
        egzaminai.forEach(System.out::println);
        System.out.println(teisingiAtsakymai);
    }
    private EgzaminuRezultatai apskaiciuotiEgzaminuRezultatai(List<StudentoEgzaminas> egzaminai, TeisingiAtsakymai teisingiAtsakymai){
        EgzaminuRezultatai egzaminuRezultatai = new EgzaminuRezultatai();
        egzaminuRezultatai.setEgzaminai(new ArrayList<>());

        StudentuEgzaminoRezultatai studentuEgzaminoRezultatai = new StudentuEgzaminoRezultatai();
        studentuEgzaminoRezultatai.setId(teisingiAtsakymai.getEgzaminas().getId());
        studentuEgzaminoRezultatai.setPavadinimas(teisingiAtsakymai.getEgzaminas().getPavadinimas());
        studentuEgzaminoRezultatai.setStudentuRezultatai(new ArrayList<>());
        egzaminuRezultatai.getEgzaminai().add(studentuEgzaminoRezultatai);

        for (StudentoEgzaminas studentoEgzaminas: egzaminai){
            if(studentoEgzaminas.getEgzaminas().getId().equals(teisingiAtsakymai.getEgzaminas().getId())){
                StudentoRezultatas studentoRezultatas = new StudentoRezultatas();
                studentoRezultatas.setId(studentoEgzaminas.getStudentas().getId());
                studentoRezultatas.setVardas(studentoEgzaminas.getStudentas().getVardas());
                studentoRezultatas.setPavarde(studentoEgzaminas.getStudentas().getPavarde());
                studentoRezultatas.setIvertinimas(skaiciuotiRezultata(studentoEgzaminas.getAtsakymai(), teisingiAtsakymai.getAtsakymai()));

                studentuEgzaminoRezultatai.getStudentuRezultatai().add(studentoRezultatas);
            }
        }

        return egzaminuRezultatai;
    }

    private int skaiciuotiRezultata(List<Atsakymas<String, String>> studentoAtsakymai, List<Atsakymas<String, String>> teisingiAtsakymai) {
        int teisinguAtsakymuKiekis = 0;

        for (Atsakymas<String, String> teisingasAts: teisingiAtsakymai) {
            Optional<Atsakymas<String, String>> studentoAts = studentoAtsakymai
                    .stream()
                    .filter(ats -> ats.getKlausimas().equals(teisingasAts.getKlausimas()))
                    .findFirst();

            if (studentoAts.isPresent() && studentoAts.get().getAtsakymas().equals(teisingasAts.getAtsakymas())){
                teisinguAtsakymuKiekis++;
            }
        }

        return (int) Math.round(teisinguAtsakymuKiekis * 10.0 / teisingiAtsakymai.size());
    }

    private void issaugotiEgzaminuRezultatus(String atsakymuDirektorijaKelias , EgzaminuRezultatai egzaminuRezultatai) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(atsakymuDirektorijaKelias + "\\rezultatai.json");
        if (file.exists()) {
            file.delete();
        }
        mapper.writeValue(file, egzaminuRezultatai);
    }
}
