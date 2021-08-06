package KlausimuPaketas;

import java.io.Serializable;

public class Klausimynas implements Serializable {
  private int klausimoNr;
  private String klausimoAtsakymas;

    public Klausimynas(int klausimoNr, String klausimoAtsakymas) {
        this.klausimoNr = klausimoNr;
        this.klausimoAtsakymas = klausimoAtsakymas;
    }
    public Klausimynas(){

    }

    public int getKlausimoNr() {
        return klausimoNr;
    }

    public void setKlausimoNr(int klausimoNr) {
        this.klausimoNr = klausimoNr;
    }

    public String getKlausimoAtsakymas() {
        return klausimoAtsakymas;
    }

    public void setKlausimoAtsakymas(String klausimoAtsakymas) {
        this.klausimoAtsakymas = klausimoAtsakymas;
    }
}
