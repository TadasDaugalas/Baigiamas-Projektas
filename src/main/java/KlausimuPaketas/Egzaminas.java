package KlausimuPaketas;

import java.io.Serializable;


public class Egzaminas implements Serializable {
    private String pavadinimas;
    private int id;
    private String tipas;



    public Egzaminas(String pavadinimas, int id, String tipas) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }
}
