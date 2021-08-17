package Servisai;

import Duomenys.StudentoEgzaminas;
import Duomenys.TeisingiAtsakymai;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        spausdinti(studentoEgzaminai,teisingiAtsakymai);

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
}
