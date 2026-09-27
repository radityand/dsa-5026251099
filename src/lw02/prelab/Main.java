package lw02.prelab;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> transaction = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();

        while (sc.hasNext()) {
            String name = sc.next();
            String type = sc.next();
            String amount = sc.next();
            transaction.add(new String[]{name, type, amount});
            boolean nameExist = false;
            for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    nameExist = true;
                }
            }

            if (!nameExist) {
                customer.add(new String[]{name, "0"});
            }
        }
        sc.close();

        Queue<String[]> queue = new LinkedList<>(transaction);
        Stack<String[]> stack = new Stack<>();

        while(!queue.isEmpty()){
            String[] data = queue.poll();
            String name = data[0];
            String type = data[1];
            int amount = Integer.parseInt(data[2]);

            if(type.equals("DEPOSIT")){
                for(String[] cust : customer){
                    if(cust[0].equals(name)){
                        int saldo = Integer.parseInt(cust[1]);
                        saldo += amount;
                        String saldoBaru = Integer.toString(saldo);
                        cust[1] = saldoBaru;
                    }
                }
            }

            if(type.equals("WITHDRAW")){
                for(String[] cust : customer){
                    if(cust[0].equals(name)){
                        int saldo = Integer.parseInt(cust[1]);
                        if(amount > saldo){
                            stack.push(data);
                        }
                        else{
                            saldo -= amount;
                            String saldoBaru = Integer.toString(saldo);
                            cust[1] = saldoBaru;
                        }
                    }
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for(String[] cust : customer){
            System.out.println(cust[0] + " : " + cust[1]);
        }
        System.out.println("=== Failed Transactions ===");
        while(!stack.isEmpty()){
            String[] data = stack.pop();
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        }
        sc.close();
    }
}
