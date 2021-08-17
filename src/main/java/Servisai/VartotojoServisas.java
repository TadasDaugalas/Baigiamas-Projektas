package Servisai;

import Duomenys.Vartotojas;
import Servisai.Enumai.VartotojoTipas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class VartotojoServisas {
    List<Vartotojas> vartotojuSarasas = new ArrayList<>();

    public VartotojoServisas() {
        vartotojuSarasas.add(new Vartotojas("1","admin","admin_pass", VartotojoTipas.DESTYTOJAS));
    }
    public Optional<Vartotojas> prisijungiti(String slapyvardis, String slaptazodis){
       return vartotojuSarasas.stream().findFirst().filter(v->v.getSlapyvardis().equals(slapyvardis) && v.getSlaptazodis().equals(slaptazodis));
    }
}

