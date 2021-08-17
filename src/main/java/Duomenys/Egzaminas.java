package Duomenys;

import java.io.Serializable;


public class Egzaminas implements Serializable {
    private String pavadinimas;
    private String id;
    private String tipas;

    public Egzaminas() {
    }

    public Egzaminas(String pavadinimas, String id, String tipas) {
        this.pavadinimas = pavadinimas;
        this.id = id;
        this.tipas = tipas;

    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    @Override
    public String toString() {
        return "Egzaminas{" +
                "pavadinimas='" + pavadinimas + '\'' +
                ", id='" + id + '\'' +
                ", tipas='" + tipas + '\'' +
                '}';
    }
}
