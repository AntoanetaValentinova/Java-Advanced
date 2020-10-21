import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int n = Integer.parseInt(scan.nextLine());

        Predicate<Integer> isDivisibleByN= num->num%n==0;

        collect.removeIf(isDivisibleByN);
        Collections.reverse(collect);

        collect.forEach(num -> System.out.print(num+" "));
    }
}
