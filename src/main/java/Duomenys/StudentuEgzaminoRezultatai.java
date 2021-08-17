package Duomenys;

import java.io.Serializable;
import java.util.List;

public class StudentuEgzaminoRezultatai implements Serializable {
    private String id;
    private String pavadinimas;
    private List<StudentoRezultatas> studentuRezultatai;

    public StudentuEgzaminoRezultatai() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<StudentoRezultatas> getStudentuRezultatai() {
        return studentuRezultatai;
    }

    public void setStudentuRezultatai(List<StudentoRezultatas> studentuRezultatai) {
        this.studentuRezultatai = studentuRezultatai;
    }
}
