package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n=Integer.parseInt(scan.nextLine());

        List<String> strings=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            strings.add(scan.nextLine());
        }

        Box <String> box = new Box (strings);

        String [] tokens=scan.nextLine().split("\\s+");
        int indexOne= Integer.parseInt(tokens[0]);
        int indexTwo= Integer.parseInt(tokens[1]);

        box.swap(indexOne,indexTwo);

        for (String element : strings) {
            System.out.println(element.getClass().getName()+": "+element);
        }
    }
}
