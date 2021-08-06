package KlausimuPaketas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Atsakymai {
    public void teisingiAtsakymai() throws IOException {
        File file = new File("Teisingi-Atsakymai.json");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println("Nepavyko sukurti failo" + e);
        }
        List<Klausimynas> klausimai = Arrays.asList(new Klausimynas(1,"b"),new Klausimynas(2,"b"));
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map= new HashMap<>();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Egzaminas egzaminas = new Egzaminas("OOP pagrindai",114,"Testas");
        map.put("Egzaminas",egzaminas);
        map.put("Teisingi atsakymai",klausimai);
        mapper.writeValue(file,map);
    }
}
