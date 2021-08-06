package KlausimuPaketas;

import java.io.Serializable;
import java.util.Map;

public class Klausimynas implements Serializable {
  private int klausimoNr;
  private String klausymoAtsakymas;

    public Klausimynas(int klausimoNr, String klausymoAtsakymas) {
        this.klausimoNr = klausimoNr;
        this.klausymoAtsakymas = klausymoAtsakymas;
    }

    public int getKlausimoNr() {
        return klausimoNr;
    }

    public void setKlausimoNr(int klausimoNr) {
        this.klausimoNr = klausimoNr;
    }

    public String getKlausymoAtsakymas() {
        return klausymoAtsakymas;
    }

    public void setKlausymoAtsakymas(String klausymoAtsakymas) {
        this.klausymoAtsakymas = klausymoAtsakymas;
    }
}
