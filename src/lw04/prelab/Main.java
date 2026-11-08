package lw04.prelab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] dicari = new int[m];
        for (int i = 0; i < m; i++) {
            dicari[i] = sc.nextInt();
        }

        for (int i = 1; i <= 3; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] < key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(list[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            boolean status = false;
            for (int j = 0; j < n; j++) {
                if (dicari[i] == list[j]) {
                    System.out.println(dicari[i] + ": FOUND at index " + j);
                    status = true;
                    break;
                }
            }
            if (!status) {
                System.out.println(dicari[i] + ": NOT FOUND");
            }
        }

        sc.close();
    }
}
