import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<String,Integer> parse=e-> Integer.parseInt(e);

        String [] input=scan.nextLine().split(", ");

        System.out.println("Count = "+Arrays.stream(input)
                .map(parse)
                .count());

        System.out.println("Sum = "+Arrays.stream(input)
                .map(parse)
                .mapToInt(Integer::valueOf)
                .sum());
    }
}
