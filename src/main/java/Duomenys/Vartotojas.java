package Duomenys;

import Servisai.Enumai.VartotojoTipas;

import java.io.Serializable;

public class Vartotojas implements Serializable {
    private String slapyvardis;
    private String slaptazodis;
    private String id;
    private VartotojoTipas vartotojoTipas;

    public Vartotojas(String id, String slapyvardis, String slaptazodis,  VartotojoTipas vartotojoTipas) {
        this.slapyvardis = slapyvardis;
        this.slaptazodis = slaptazodis;
        this.id = id;
        this.vartotojoTipas = vartotojoTipas;
    }

    public Vartotojas() {
    }

    public VartotojoTipas getVartotojoTipas() {
        return vartotojoTipas;
    }

    public void setVartotojoTipas(VartotojoTipas vartotojoTipas) {
        this.vartotojoTipas = vartotojoTipas;
    }

    public String getSlapyvardis() {
        return slapyvardis;
    }

    public void setSlapyvardis(String slapyvardis) {
        this.slapyvardis = slapyvardis;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
