package Duomenys;

import java.io.Serializable;

public class StudentoRezultatas implements Serializable {
    private String id;
    private String vardas;
    private String pavarde;
    private int ivertinimas;

    public StudentoRezultatas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getIvertinimas() {
        return ivertinimas;
    }

    public void setIvertinimas(int ivertinimas) {
        this.ivertinimas = ivertinimas;
    }
}
