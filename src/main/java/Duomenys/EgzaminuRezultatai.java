package Duomenys;

import java.io.Serializable;
import java.util.List;

public class EgzaminuRezultatai implements Serializable {
    private List<StudentuEgzaminoRezultatai> egzaminai;

    public EgzaminuRezultatai() {
    }

    public List<StudentuEgzaminoRezultatai> getEgzaminai() {
        return egzaminai;
    }

    public void setEgzaminai(List<StudentuEgzaminoRezultatai> egzaminai) {
        this.egzaminai = egzaminai;
    }
}
