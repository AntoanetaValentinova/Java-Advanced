import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> printWithSir=string-> System.out.println("Sir "+string);
        Arrays.stream(scan.nextLine().split("\\s+"))
                .forEach(printWithSir);
    }
}
