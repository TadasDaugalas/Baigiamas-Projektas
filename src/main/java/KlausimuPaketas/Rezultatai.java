package KlausimuPaketas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Rezultatai {
    public static void tikrintiRezultatus() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map=mapper.readValue(Paths.get("Klausimai.json").toFile(),Map.class);
        Map<Integer,String>map1=new HashMap<>();

        for (Map.Entry<String,Object> entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        tikrintiRezultatus();
    }
}
