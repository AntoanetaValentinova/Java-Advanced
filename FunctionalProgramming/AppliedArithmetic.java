import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.valueOf(e))
                .boxed()
                .collect(Collectors.toList());

        String command=scan.nextLine();


        while (!command.equals("end")) {
            if (command.equals("add")) {
                Function<Integer,Integer> operation=num->num+=1;
                collect=collect
                        .stream()
                        .map(operation::apply)
                        .collect(Collectors.toList());
            } else if (command.equals("multiply")) {
                Function<Integer,Integer> operation=num->num*=2;
                collect=collect
                        .stream()
                        .map(operation::apply)
                        .collect(Collectors.toList());
            } else if (command.equals("subtract")) {
                Function<Integer,Integer> operation=num->num-=1;
                collect=collect
                        .stream()
                        .map(operation::apply)
                        .collect(Collectors.toList());

            } else if (command.equals("print")) {
                Consumer <Integer> print=num-> System.out.print(num+" ");
                collect
                        .forEach(e->print.accept(e));
                System.out.println();
            }
            command=scan.nextLine();
        }
    }

}
