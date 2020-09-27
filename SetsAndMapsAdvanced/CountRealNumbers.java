import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split("\\s+");

        Map<Double,Integer> numbers =new LinkedHashMap<>();
        for (int i = 0; i <input.length ; i++) {
            double currentNumber=Double.parseDouble(input[i]);
            numbers.putIfAbsent(currentNumber,0);
            numbers.put(currentNumber,numbers.get(currentNumber)+1);
        }

        numbers
                .entrySet()
                .stream()
                .forEach(e-> System.out.printf("%.1f -> %d%n",e.getKey(),e.getValue()));
    }
}
