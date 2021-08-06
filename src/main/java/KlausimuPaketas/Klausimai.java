package KlausimuPaketas;

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
    public static void main(String[] args) throws IOException{

        File file = new File("Klausimai.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Klaida sukuriant failą" + e);
        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map= new HashMap<>();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        List<Klausimynas> klausimynas = Arrays.asList(new Klausimynas(1,"a"),new Klausimynas(2,"b"));
        Studentas studentas = new Studentas("Jonas", "Petraitis", 154);
        Egzaminas egzaminas = new Egzaminas("OOP pagrindai",114,"Testas");
        map.put("Studentas",studentas);
        map.put("Egzaminas",egzaminas);
        map.put("Atsakymai",klausimynas);
        mapper.writeValue(file,map);
        Atsakymai atsakymai = new Atsakymai();
        atsakymai.teisingiAtsakymai();



    }
}
