package Loginai;

import java.util.Map;
import java.util.Scanner;

public class Prisijungimas {
    Data data = new Data();
    Scanner sc = new Scanner(System.in);
    Boolean check;

    public void saveData(Map<String, String> map, Scanner sc) {

        System.out.println("Iveskite varda");
        String customerName = data.setId(sc.nextLine());
        if (!chekExisted(map, customerName)) {
            return;
        }
        System.out.println("Iveskite slaptažodi");
        String customerPassword = data.setSlaptazodis(sc.nextLine());
        System.out.println("Pakartokite slaptažodi");
        if (customerPassword.equals(sc.nextLine())) {
            map.put(customerName, customerPassword);
        } else {
            System.out.println("Slaptažodis neteisingas");
            return;
        }

    }

    public void getData(Map<String, String> map, Scanner scanner) {
        System.out.println("Iveskite varda");
        String name = scanner.nextLine();
        System.out.println();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("Iveskite slaptažodi " + entry.getKey());
                if (entry.getValue().equals(sc.nextLine())) {
                    System.out.println("Sveikiname prisijungus");
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

    public Boolean chekExisted(Map<String, String> map, String name) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                System.out.println("Vardas jau egzistuoja");
                return false;
            }
        }
        return true;
    }
}
