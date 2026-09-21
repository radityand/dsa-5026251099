package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        List<Rental> rentals = new ArrayList<>();
        int[] units = new int[100]; // Assuming a maximum of 100 rentals
        int i = 0;

        while (sc.hasNext()) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            units[i] = sc.nextInt();

            if (type.equals("LAPTOP")) {
                rentals.add(new LaptopRental(id, days));
            } else if (type.equals("PROJECTOR")) {
                rentals.add(new ProjectorRental(id, days));
            }
        }

        sc.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary(i));
        }
    }
}
