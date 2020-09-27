import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        Set<String> chemicals=new TreeSet<>();
        for (int i = 0; i <n ; i++) {
            String [] input=scan.nextLine().split("\\s+");
            for (int j = 0; j <input.length ; j++) {
                chemicals.add(input[j]);
            }
        }

        for (String chemical:chemicals) {
            System.out.print(chemical+" ");
        }
    }
}
