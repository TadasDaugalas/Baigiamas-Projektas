package Sasaja;
import Loginai.Prisijungimas;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Meniu {


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        boolean stop = true;
        Statusas statusas = Statusas.NEPRISIJUNGES;
        Prisijungimas prisijungimas = new Prisijungimas();
        Map<String, Object> dėstytojai = new HashMap<>();
        while (stop) {
            System.out.println("1 - Prisijungti");
            //System.out.println("2 - Registruotis");
            System.out.println("3 - Išeiti");
            switch (prisijungimas.sc.nextLine()) {
                case "1":
                    System.out.println("1 - Destytojas");
                    System.out.println("2 - Studentas ");
                    switch (prisijungimas.sc.nextLine()) {
                        case "1":
                            prisijungimas.getData(dėstytojai, prisijungimas.sc);
                            break;
                        case "2":
                            prisijungimas.getData(dėstytojai, prisijungimas.sc);
                            break;
                    }
                    break;
//                case "2" :
//                    System.out.println("1 - Destytojas");
//                    System.out.println("2 - Studentas ");
//                    switch (prisijungimas.sc.nextLine()){
//                        case "1":prisijungimas.saveData(dėstytojai,prisijungimas.sc);
//                            dėstytojai.put("Dėstytojas",new Studentas(meniu.data.getVardas(), meniu.data.getPavarde(), meniu.data.getId()));break;
//                        case "2":prisijungimas.saveData(meniu.dėstytojas,prisijungimas.sc);
//                           meniu.dėstytojas.put("Studentas",new Studentas(meniu.data.getVardas(), meniu.data.getPavarde(), meniu.data.getId()));break;
//                    }break;
                case "3":
                    stop = false;
            }
        }
    }

}
