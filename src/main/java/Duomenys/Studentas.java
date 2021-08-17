package Duomenys;

import java.io.Serializable;

public class Studentas implements Serializable {
    private String vardas;
    private String pavarde;
    private int id;

    public Studentas() {
    }

    public Studentas(String vardas, String pavarde, int id) {
        this.vardas = vardas;
        this.pavarde = pavarde;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Studentas{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
