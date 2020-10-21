import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        String [] strings=scan.nextLine().split(", ");

        Predicate<Integer> isEven=num -> num % 2 == 0;

         String collect = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .filter(e->isEven.test(e))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(collect);

        collect = Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .filter(e->isEven.test(e))
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(collect);


    }
}
