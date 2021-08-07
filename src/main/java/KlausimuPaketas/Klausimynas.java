package KlausimuPaketas;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Klausimynas implements Serializable {
  private int klausimoNr;
  private String klausimoAtsakymas;
  Map<Integer,String> map = new HashMap<>();

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Klausimynas(int klausimoNr, String klausimoAtsakymas) {
        this.klausimoNr = klausimoNr;
        this.klausimoAtsakymas = klausimoAtsakymas;
        map.put(klausimoNr,klausimoAtsakymas);
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
