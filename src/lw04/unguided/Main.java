package lw04.unguided;

import java.util.*;

public class Main {
    static void selectionSort(int[] arr, int passes) {
        for (int i = 0; i < passes && i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] dicari = new int[m];
        for (int i = 0; i < m; i++) {
            dicari[i] = sc.nextInt();
        }
        sc.close();

        selectionSort(cards, 2);

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int index = linearSearch(cards, dicari[i]);
            if (index != -1) {
                System.out.println(dicari[i] + ": FOUND at index " + index);
            } else {
                System.out.println(dicari[i] + ": NOT FOUND");
            }
        }
    }
}
