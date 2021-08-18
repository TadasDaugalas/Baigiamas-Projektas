package Servisai;

import Duomenys.Vartotojas;
import Servisai.Enumai.MeniuStatusas;
import Servisai.Enumai.VartotojoTipas;

import java.util.Optional;
import java.util.Scanner;

public class MeniuServisas {
    MeniuStatusas statusas = MeniuStatusas.NEPRISIJUNGES;
    Scanner sc = new Scanner(System.in);

    public void Rodyti() {
        int komanda;
        boolean testi = true;
        VartotojoServisas vartotojoServisas = new VartotojoServisas("C:\\Tadas\\Desktop\\Java kursai\\BaigiamasProjektas\\src\\main\\resources");
        while (testi) {
            switch (statusas) {
                case NEPRISIJUNGES:
                    rodytiNeprisijungusioVartotojoMeniu();
                    komanda = apdorotiKomanda(2);
                    if (komanda == 0) {
                        System.out.println("Viso gero");
                        testi = false;
                    }
                    apdorotiNeprisijungusioVartotojoKomanda(komanda);
                    break;
                case SLAPYVARDIS_SLAPTAZODIS:
                    System.out.println("Iveskite slapyvardi");
                    String slapyvardis = sc.nextLine();
                    System.out.println("Iveskite slaptazodi");
                    String slaptazodis = sc.nextLine();

                    Optional<Vartotojas> vartotojas = vartotojoServisas.prisijungiti(slapyvardis, slaptazodis);

                    if (vartotojas.isPresent()) {
                        statusas = vartotojas.get().getVartotojoTipas() == VartotojoTipas.DESTYTOJAS
                                ? MeniuStatusas.DESTYTOJAS
                                : MeniuStatusas.STUDENTAS;
                    } else {
                        System.out.println("Neteisingas slapyvardis ar/ir slaptazodis");
                        statusas = MeniuStatusas.NEPRISIJUNGES;
                    }

                    break;
                case DESTYTOJAS:
                    rodytiDestytojoMeniu();
                    komanda = apdorotiKomanda(1);
                    apdorotiDestytojoKomanda(komanda);
                    break;
                case REGISTRACIJA:
                    Vartotojas naujasVartotojas = new Vartotojas();
                    System.out.println("Iveskite varda");
                    naujasVartotojas.setVardas(sc.nextLine());
                    System.out.println("Iveskite pavarde");
                    naujasVartotojas.setPavarde(sc.nextLine());
                    System.out.println("Iveskite slapyvardi");
                    naujasVartotojas.setSlapyvardis(sc.nextLine());
                    System.out.println("Iveskite slaptazodi");
                    naujasVartotojas.setSlaptazodis(sc.nextLine());
                    try {
                        vartotojoServisas.registruoti(naujasVartotojas);
                        statusas = MeniuStatusas.STUDENTAS;
                    } catch (Exception e) {
                        System.out.println("Nepavyko prisiregistruoti" + e.getMessage());
                        statusas = MeniuStatusas.NEPRISIJUNGES;
                    }
                    break;
                case STUDENTAS:
                    System.out.println("Sveikas Studente");
                    statusas = MeniuStatusas.NEPRISIJUNGES;
                    break;
            }
        }
    }


    private void rodytiNeprisijungusioVartotojoMeniu() {
        System.out.println("1 - Prisijungti");
        System.out.println("2 - Registruotis");
        System.out.println("0 - Išeiti");
    }

    private void rodytiDestytojoMeniu() {
        System.out.println("1 - Skaiciuoti egzamino rezultata");
        System.out.println("0 - Išeiti");
    }

    private void apdorotiNeprisijungusioVartotojoKomanda(int komanda) {
        if (komanda == 1) {
            statusas = MeniuStatusas.SLAPYVARDIS_SLAPTAZODIS;
        } else if (komanda == 2) {
            statusas = MeniuStatusas.REGISTRACIJA;
        }
    }

    private void apdorotiDestytojoKomanda(int komanda) {
        if (komanda == 0) {
            statusas = MeniuStatusas.NEPRISIJUNGES;
        } else if (komanda == 1) {
            EgzaminuServisas egzaminuServisas = new EgzaminuServisas();
            try {
                egzaminuServisas.skaiciuotiRezultatus("C:\\Tadas\\Desktop\\Java kursai\\BaigiamasProjektas\\src\\main\\resources\\Atsakymai",
                        "C:\\Tadas\\Desktop\\Java kursai\\BaigiamasProjektas\\src\\main\\resources\\Teisingi-Atsakymai.json");
            } catch (Exception e) {
                System.out.println("Nepavyko " + e.getMessage());
                return;
            }
            System.out.println("Rezultato failas sukurtas");
        }
    }

    private int apdorotiKomanda(int max) {
        boolean testi = true;
        int skaicius = 0;
        do {
            String a = sc.nextLine();

            try {
                skaicius = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                System.out.println("Klaida , iveskite skaičių");
                continue;
            }
            testi = !(0 <= skaicius && skaicius <= max);
            if (testi) {
                System.out.println("Klaida, tokios komandos nėra");
            }
        } while (testi);
        return skaicius;
    }
}
