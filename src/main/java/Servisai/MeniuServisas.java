package Servisai;

import Duomenys.Vartotojas;
import Loginai.Prisijungimas;
import Servisai.Enumai.MeniuStatusas;
import Servisai.Enumai.VartotojoTipas;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MeniuServisas {
    MeniuStatusas statusas = MeniuStatusas.NEPRISIJUNGES;
    Prisijungimas prisijungimas = new Prisijungimas();

    Scanner sc = new Scanner(System.in);

    public void Rodyti() {
        int komanda;
        boolean testi = true;
        while (testi) {
            switch (statusas) {
                case NEPRISIJUNGES:
                    rodytiNeprisijungusioVartotojoMeniu();
                    komanda = apdorotiKomanda(1);
                    if (komanda == 0) {
                        System.out.println("Viso gero");
                        testi = false;
                    }
                    apdorotiNeprisijungusioVartotojoKomanda(komanda);
                    break;
                case SLAPYVARDIS_SLAPTAZODIS:
                    System.out.println("Iveskite slapyvardi");
                    String slapyvardis  = sc.nextLine();
                    System.out.println("Iveskite slaptazodi");
                    String slaptazodis  =sc.nextLine();

                    VartotojoServisas vartotojoServisas = new VartotojoServisas();
                    Optional<Vartotojas> vartotojas = vartotojoServisas.prisijungiti(slapyvardis, slaptazodis);

                    if (vartotojas.isPresent())
                        statusas = vartotojas.get().getVartotojoTipas() == VartotojoTipas.DESTYTOJAS
                                ? MeniuStatusas.DESTYTOJAS
                                : MeniuStatusas.STUDENTAS;
                    else {
                        System.out.println("Neteisingas slapyvardis ar/ir slaptazodis");
                        statusas = MeniuStatusas.NEPRISIJUNGES;
                    }

                    break;
                case DESTYTOJAS:
                    System.out.println("Labas destytokas");
                    break;
            }
        }
//        boolean testi = true;
//        while (testi) {
//            System.out.println("1 - Prisijungti");
//            //System.out.println("2 - Registruotis");
//            System.out.println("3 - Išeiti");
//            switch (prisijungimas.sc.nextLine()) {
//                case "1":
//                    System.out.println("1 - Destytojas");
//                    System.out.println("2 - Studentas ");
//                    switch (prisijungimas.sc.nextLine()) {
//                        case "1":
//                            prisijungimas.getData(dėstytojai, prisijungimas.sc);
//                            break;
//                        case "2":
//                            prisijungimas.getData(dėstytojai, prisijungimas.sc);
//                            break;
//                    }
//                    break;
////                case "2" :
////                    System.out.println("1 - Destytojas");
////                    System.out.println("2 - Studentas ");
////                    switch (prisijungimas.sc.nextLine()){
////                        case "1":prisijungimas.saveData(dėstytojai,prisijungimas.sc);
////                            dėstytojai.put("Dėstytojas",new Studentas(meniu.data.getVardas(), meniu.data.getPavarde(), meniu.data.getId()));break;
////                        case "2":prisijungimas.saveData(meniu.dėstytojas,prisijungimas.sc);
////                           meniu.dėstytojas.put("Studentas",new Studentas(meniu.data.getVardas(), meniu.data.getPavarde(), meniu.data.getId()));break;
////                    }break;
//                case "3":
//                    testi = false;
//
//            }
//        }
    }


    private void rodytiNeprisijungusioVartotojoMeniu() {
        System.out.println("1 - Prisijungti");
        //System.out.println("2 - Registruotis");
        System.out.println("0 - Išeiti");
    }

    private void apdorotiNeprisijungusioVartotojoKomanda(int komanda) {
        if (komanda == 1) {
            statusas = MeniuStatusas.SLAPYVARDIS_SLAPTAZODIS;
        }
    }

    private int apdorotiKomanda(int max) {
        boolean testi = true;
        int skaicius=0;
        do {
            String a = sc.nextLine();

            try {
                skaicius = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                System.out.println("Klaida , iveskite skaičių");
                continue;
            }
            testi = !(0 <= skaicius && skaicius <= max);
            if(testi){
                System.out.println("Klaida, tokios komandos nėra");
            }
        } while (testi);
        return skaicius;
    }
}
