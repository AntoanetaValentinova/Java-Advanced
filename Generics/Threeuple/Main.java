package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] nameAndAdress = scan.nextLine().split("\\s+");
        String name = nameAndAdress[0] + " " + nameAndAdress[1];
        String adress = nameAndAdress[2];
        String town = nameAndAdress[3];
        Tuple<String, String, String> tuple = new Tuple<String, String, String>(name, adress, town);
        System.out.println(tuple);
        String[] nameAndBeers = scan.nextLine().split("\\s+");
        String name1 = nameAndBeers[0];
        int beers = Integer.parseInt(nameAndBeers[1]);
        String drunk = nameAndBeers[2];
        if (drunk.equals("drunk")) {
            Tuple<String, Integer, String> tuple1 = new Tuple<String, Integer,String>(name1, beers, "true");
            System.out.println(tuple1);
        } else {
            Tuple<String, Integer, String> tuple1 = new Tuple<String, Integer,String>(name1, beers, "false");
            System.out.println(tuple1);
        }
        String[] tokens = scan.nextLine().split("\\s+");
        String name2 = tokens[0];
        double accountBalance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Tuple<String, Double,String> tuple2 = new Tuple<String, Double,String>(name2, accountBalance, bankName);
        System.out.println(tuple2);
    }
}
