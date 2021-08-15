package Duomenys;

import java.util.List;

public class Rezultatai {
    private Egzaminas egzaminas;
    private List<Studentas> studentuSarasas;

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public List<Studentas> getStudentuSarasas() {
        return studentuSarasas;
    }

    public void setStudentuSarasas(List<Studentas> studentuSarasas) {
        this.studentuSarasas = studentuSarasas;
    }
}
