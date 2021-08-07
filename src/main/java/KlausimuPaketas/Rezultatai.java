package KlausimuPaketas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rezultatai {
    public static void tikrintiRezultatus() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map=mapper.readValue(Paths.get("Klausimai.json").toFile(),Map.class);
        Klausimynas klausimynas = new Klausimynas();
        Klausimai klausimai = new Klausimai();
        List<Klausimai>a = new ArrayList<>();

        Map<Integer, String> map1 = new HashMap<>();
//        for (Map.Entry<String,Object> entry : map.entrySet()){
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
        System.out.println(klausimynas.getMap());
    }

    public static void main(String[] args) throws IOException {
        tikrintiRezultatus();
    }
}
