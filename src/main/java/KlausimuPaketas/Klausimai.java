package KlausimuPaketas;

import Loginai.Data;
import Loginai.Prisijungimas;
import Studentai.Studentas;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Klausimai {
    private Map<String,Object> dėstytojas = new HashMap<>();
    Map<String,Object> map= new HashMap<>();
    Data data = new Data();
    boolean check =true;
    public static void main(String[] args) throws IOException{
        Klausimai klausimai = new Klausimai();

        File file = new File("Klausimai.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Klaida sukuriant failą" + e);
        }
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Klausimynas> klausimynas = Arrays.asList(new Klausimynas(1,"a"),new Klausimynas(2,"b"));
//        Studentas studentas = new Studentas("Jonas", "Petraitis", "154");
//        Egzaminas egzaminas = new Egzaminas("OOP pagrindai","1","Testas");
//        map.put("Studentas",studentas);
//        map.put("Egzaminas",egzaminas);
        klausimai.map.put("Atsakymai",klausimynas);
        Atsakymai atsakymai = new Atsakymai();
        atsakymai.teisingiAtsakymai();
        Prisijungimas prisijungimas = new Prisijungimas();
        while (klausimai.check){
            System.out.println("1 - Prisijungti");
            System.out.println("2 - Registruotis");
            System.out.println("3 - Išeiti");
            switch (prisijungimas.sc.nextLine()){
                case "1" :
                    System.out.println("1 - Destytojas");
                    System.out.println("2 - Studentas ");
                    switch (prisijungimas.sc.nextLine()){
                        case "1":prisijungimas.getData(klausimai.dėstytojas,prisijungimas.sc);break;
                        case "2":prisijungimas.getData(klausimai.dėstytojas,prisijungimas.sc);break;
                }break;
                case "2" :
                    System.out.println("1 - Destytojas");
                    System.out.println("2 - Studentas ");
                    switch (prisijungimas.sc.nextLine()){
                        case "1":prisijungimas.saveData(klausimai.dėstytojas,prisijungimas.sc);
                        klausimai.map.put("Dėstytojas",new Studentas(klausimai.data.getVardas(), klausimai.data.getPavarde(),klausimai.data.getId()));break;
                        case "2":prisijungimas.saveData(klausimai.dėstytojas,prisijungimas.sc);
                           klausimai.map.put("Studentas",new Studentas(klausimai.data.getVardas(), klausimai.data.getPavarde(),klausimai.data.getId()));break;
                    }break;
                case "3" : klausimai.check=false;
            }
        }
        mapper.writeValue(file,klausimai.map);

    }
}
