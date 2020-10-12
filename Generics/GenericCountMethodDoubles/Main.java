package GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        List<Double> doubles=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            doubles.add(Double.parseDouble(scan.nextLine()));
        }

        Double element = Double.parseDouble(scan.nextLine());

        Box <Double> box=new Box<>(doubles);

        List<Double> newDoubles=box.getGreater(element);

        System.out.println(newDoubles.size());

    }
}
