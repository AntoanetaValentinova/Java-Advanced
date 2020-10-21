import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BiPredicate<List<Integer>,Integer> predicate = (list,number) -> {
            for (Integer currentNum : list) {
                if (number%currentNum!=0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <=n ; i++) {
            if (predicate.test(numbers,i)) {
                System.out.print(i+" ");
            }
        }
    }
}
