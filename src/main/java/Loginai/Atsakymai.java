package Loginai;

import java.util.List;

public class Atsakymai <K,V>{
//    public void teisingiAtsakymai() throws IOException {
//        FailuTvarkyklė failuTvarkyklė = new FailuTvarkyklė();
//        File failas = failuTvarkyklė.kurtiNaujaFaila("Tesisingi-Atsakymai.json");
//        List<Klausimynas> klausimai = Arrays.asList(new Klausimynas(1,"b"),new Klausimynas(2,"b"));
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String,Object> map= new HashMap<>();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//        Egzaminas egzaminas = new Egzaminas("OOP pagrindai","114","Testas");
//        map.put("Egzaminas",egzaminas);
//        map.put("Teisingi atsakymai",klausimai);
//        mapper.writeValue(failas,map);
//    }
    private K k;
    private V v;

    public Atsakymai() {
    }

}
