package GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        List<String> strings=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            strings.add(scan.nextLine());
        }

        String element = scan.nextLine();

        Box <String> box=new Box<>(strings);

        List<String> newStrings=box.getGreater(element);

        System.out.println(newStrings.size());

    }
}
