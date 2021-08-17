package Duomenys;

import java.util.List;

public class TeisingiAtsakymai {
    private Egzaminas egzaminas;
    private List<Atsakymas<String, String>> atsakymai;

    public Egzaminas getEgzaminas() {
        return egzaminas;
    }

    public void setEgzaminas(Egzaminas egzaminas) {
        this.egzaminas = egzaminas;
    }

    public List<Atsakymas<String, String>> getAtsakymai() {
        return atsakymai;
    }

    public void setAtsakymai(List<Atsakymas<String, String>> atsakymai) {
        this.atsakymai = atsakymai;
    }

    @Override
    public String toString() {
        return "TeisingiAtsakymai{" +
                "egzaminas=" + egzaminas +
                ", atsakymai=" + atsakymai +
                '}';
    }
}
