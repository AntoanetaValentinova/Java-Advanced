import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Map<String,Integer> resources=new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource=input;
            int quantity= Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(resource,0);
            resources.put(resource,resources.get(resource)+quantity);
            input=scan.nextLine();
        }

        resources
                .entrySet()
                .stream()
                .forEach(e-> System.out.printf("%s -> %d%n",e.getKey(),e.getValue()));
    }
}
