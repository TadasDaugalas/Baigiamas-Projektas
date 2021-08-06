package KlausimuPaketas;

import Studentai.Studentas;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        JSONObject jsonObject = new JSONObject();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Studentas studentas = new Studentas("Jonas", "Petraitis", 154);
        Egzaminas egzaminas = new Egzaminas("OOP pagrindai",114,"Testas");
        jsonObject.put("Egzaminas",egzaminas);
        jsonObject.put("Studentas",studentas);
        Map<String,Object> map= new HashMap<>();
        map.put("Egzaminas",egzaminas);
        map.put("Studentas",studentas);
        List<Klausimynas> klausimynas = Arrays.asList(new Klausimynas(1,"a"),new Klausimynas(2,"b"));
        map.put("Atsakymai",klausimynas);
        mapper.writeValue(file,map);


    }
}
