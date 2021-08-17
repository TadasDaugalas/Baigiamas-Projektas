package Duomenys;

import java.io.Serializable;

public class StudentoRezultatas implements Serializable {
    private int id;
    private String vardas;
    private String pavarde;
    private int ivertinimas;

    public StudentoRezultatas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
