import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] tokens=scan.nextLine().split("\\s+");
        int lowerBound= Integer.parseInt(tokens[0]);
        int upperBound= Integer.parseInt(tokens[1]);

        String command=scan.nextLine();
        Predicate<Integer> predicate=findEvenOrOdd(command);
        List<Integer> nums=new ArrayList<>();
        for (int i = lowerBound; i <=upperBound ; i++) {
            nums.add(i);
        }

        nums
                .stream()
                .filter(e->predicate.test(e))
                .forEach(e-> System.out.print(e+" "));
    }

    private static Predicate<Integer> findEvenOrOdd(String command) {
        if (command.equals("even")) {
            return n->n%2==0;
        }
        return n->n%2!=0;
    }
}
