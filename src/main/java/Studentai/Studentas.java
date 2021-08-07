package Studentai;

import java.io.Serializable;

public class Studentas implements Serializable {
    private String vardas;
    private String pavarde;
    private String id;

    public Studentas(String vardas, String pavarde, String id) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
