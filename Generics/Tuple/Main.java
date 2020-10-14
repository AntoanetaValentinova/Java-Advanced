package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] nameAndAdress = scan.nextLine().split("\\s+");
        String name = nameAndAdress[0] + " " + nameAndAdress[1];
        String adress = nameAndAdress[2];
        Tuple<String, String> tuple = new Tuple<String, String>(name, adress);
        System.out.println(tuple);
        String[] nameAndBeers = scan.nextLine().split("\\s+");
        String name1 = nameAndBeers[0];
        int beers = Integer.parseInt(nameAndBeers[1]);
        Tuple<String, Integer> tuple1 = new Tuple<String, Integer>(name1, beers);
        System.out.println(tuple1);
        String [] tokens=scan.nextLine().split("\\s+");
        int integer= Integer.parseInt(tokens[0]);
        double doubleN=Double.parseDouble(tokens[1]);
        Tuple <Integer,Double> tuple2=new Tuple<Integer, Double>(integer,doubleN);
        System.out.println(tuple2);
    }
}
