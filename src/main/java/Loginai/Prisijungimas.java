package Loginai;

import java.util.Map;
import java.util.Scanner;

public class Prisijungimas {
    Data data = new Data();
    public Scanner sc = new Scanner(System.in);
    Boolean check;

    public void saveData(Map<String, Object> map, Scanner sc) {

        System.out.println("Iveskite varda");
        String customerName = data.setVardas(sc.nextLine());
        System.out.println("Iveskite pavarde");
        String pavarde = data.setPavarde(sc.nextLine());

                System.out.println("Iveskite Id");
                String id = data.setId(sc.nextLine());
                if (!chekExisted(map, id)) {
                    return;
                }



        System.out.println("Iveskite slaptažodi");
        String customerPassword = data.setSlaptazodis(sc.nextLine());
        System.out.println("Pakartokite slaptažodi");
        if (customerPassword.equals(sc.nextLine())) {
            map.put(id, customerPassword);
        } else {
            System.out.println("Slaptažodis neteisingas");
            return;
        }

    }

    public void getData(Map<String, Object> map, Scanner scanner) {
        System.out.println("Iveskite Id");
        String name = scanner.nextLine();
        System.out.println();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("Iveskite slaptažodi " + entry.getKey());
                if (entry.getValue().equals(sc.nextLine())) {
                    System.out.println("Sveikiname prisijungus"+data.getVardas()+" " +data.getPavarde());
                    return;
                } else {
                    System.out.println("Slaptažodis neteisingas");
                    return;
                }
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("Tokio vardo nėra");
        }
    }

    public Boolean chekExisted(Map<String, Object> map, String name) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("Asmuo jau egzistuoja");
                return false;
            }
        }
        return true;
    }
}
