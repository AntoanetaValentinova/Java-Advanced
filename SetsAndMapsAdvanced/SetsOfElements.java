import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split("\\s+");
        int n= Integer.parseInt(input[0]);
        int m= Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i <n ; i++) {
            int current= Integer.parseInt(scan.nextLine());
            firstSet.add(current);
        }
        for (int i = 0; i <m ; i++) {
            int current= Integer.parseInt(scan.nextLine());
            secondSet.add(current);
        }

        for (Integer current:firstSet) {
            if (secondSet.contains(current)) {
                System.out.print(current+" ");
            }
        }
    }
}
