import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] text=scan.nextLine().split(" ");

        Predicate<String> isUpperCaseWord=word->Character.isUpperCase(word.charAt(0));

        System.out.println(Arrays.stream(text)
                .filter(isUpperCaseWord)
                .count());

        Arrays.stream(text)
                .filter(isUpperCaseWord)
                .forEach(word-> System.out.println(word));
    }
}
