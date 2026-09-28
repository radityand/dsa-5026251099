package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> requests = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();

        books.add(new String[] {"Kalkulus", "2"});
        books.add(new String[] {"Fisika", "1"});
        books.add(new String[] {"Statistika", "2"});
        int MAX_BORROW = 2;

       
        while (sc.hasNext()) {
            String name = sc.next();
            String title = sc.next();
            String[] request = new String[] {name, title};
            requests.add(request);
            boolean nameExist = false;
            for (String[] member : members) {
                if (member[0].equals(name)) {
                    nameExist = true;
                }
            }
            if (!nameExist) {
                members.add(new String[] {name, "0"});
            }
        }
        sc.close();

        Queue<String[]> queue = new LinkedList<>();
        for (String[] request : requests) {
            queue.add(request);
        }
        Stack<String[]> failedRequests = new Stack<>();
        LinkedList<String[]> successfulRequests = new LinkedList<>();

        while (!queue.isEmpty()) {
            String[] request = queue.poll();
            String name = request[0];
            String title = request[1];
            String[] requestedBook = null;
            String[] requestingMember = null;

            for (String[] book : books) {
                if (book[0].equals(title)) {
                    requestedBook = book;
                }
            }

            for (String[] member : members) {
                if (member[0].equals(name)) {
                    requestingMember = member;
                }
            }

            if (Integer.parseInt(requestedBook[1]) <= 0) {
                failedRequests.push(request);
            } else if (Integer.parseInt(requestingMember[1]) >= MAX_BORROW) {
                failedRequests.push(request);
            } else {
                requestedBook[1] = Integer.toString(Integer.parseInt(requestedBook[1]) - 1);
                requestingMember[1] = Integer.toString(Integer.parseInt(requestingMember[1]) + 1);
                successfulRequests.add(request);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] request : successfulRequests) {
            System.out.println(request[0] + " " + request[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] book : books) {
            System.out.println(book[0] + " : " + book[1]);
        }

        System.out.println("=== Failed Requests ===");
        while (!failedRequests.isEmpty()) {
            String[] request = failedRequests.pop();
            System.out.println(request[0] + " " + request[1]);
        }
    }
}

