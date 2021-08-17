package Servisai;

import Duomenys.Vartotojas;
import Servisai.Enumai.VartotojoTipas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class VartotojoServisas {
    List<Vartotojas> vartotojuSarasas ;
    private String kelias;
    public VartotojoServisas(String kelias) {
//        vartotojuSarasas.add(new Vartotojas("1","admin","admin_pass", VartotojoTipas.DESTYTOJAS));
        nuskaitytiVartotojus(kelias);
        this.kelias=kelias;
    }
    public Optional<Vartotojas> prisijungiti(String slapyvardis, String slaptazodis){
       return vartotojuSarasas.stream().findFirst().filter(v->v.getSlapyvardis().equals(slapyvardis) && v.getSlaptazodis().equals(slaptazodis));
    }
    private void nuskaitytiVartotojus(String kelias) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            vartotojuSarasas=mapper.readValue(new File(kelias + "\\vartotojai.json"), new TypeReference<List<Vartotojas>>() {
            });
        } catch (IOException e) {
            vartotojuSarasas=new ArrayList<>();
        }
    }
    private void issaugotiVartotojus() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new FileWriter(kelias+"\\vartotojai.json"),vartotojuSarasas);
    }
    public Vartotojas registruoti (Vartotojas vartotojas) throws Exception {
        if(vartotojas.getSlapyvardis().isEmpty()|| vartotojas.getSlaptazodis().isEmpty()){
            throw  new Exception("Slaptažodis arba slapyvardis tuščias");
        }
        if(vartotojuSarasas.stream().filter(v->v.getSlapyvardis().equals(vartotojas.getSlapyvardis())).findFirst().isPresent()){
            throw new Exception("Toks slapyvardis egzistuoja");
        }
        vartotojas.setVartotojoTipas(VartotojoTipas.STUDENTAS);
        vartotojas.setId(vartotojuSarasas.stream().map(v->v.getId()).max(Comparator.naturalOrder()).orElse(1));
        vartotojuSarasas.add(vartotojas);
        issaugotiVartotojus();
        return vartotojas;
    }


}

