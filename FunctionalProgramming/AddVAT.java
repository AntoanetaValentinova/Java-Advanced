import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        UnaryOperator<Double> addVat=price->price*1.2;
        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(e->addVat.apply(Double.parseDouble(e)))
                .forEach(e-> System.out.printf("%.2f%n",e));
    }
}
