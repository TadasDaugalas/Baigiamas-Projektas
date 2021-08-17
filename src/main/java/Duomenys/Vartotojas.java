package Duomenys;

import Servisai.Enumai.VartotojoTipas;

import java.io.Serializable;

public class Vartotojas implements Serializable {
    private String slapyvardis;
    private String slaptazodis;
    private int id;
    private VartotojoTipas vartotojoTipas;
    private String vardas;
    private String pavarde;

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Vartotojas(String slapyvardis, String slaptazodis, int id, VartotojoTipas vartotojoTipas, String vardas, String pavarde) {
        this.slapyvardis = slapyvardis;
        this.slaptazodis = slaptazodis;
        this.id = id;
        this.vartotojoTipas = vartotojoTipas;
        this.vardas = vardas;
        this.pavarde = pavarde;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
