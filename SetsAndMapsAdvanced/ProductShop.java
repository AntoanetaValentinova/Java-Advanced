import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Map<String, Map<String,Double>> shops=new TreeMap<>();
        while (!input.equals("Revision")) {
            String [] current = input.split(",\\s+");
            String shop=current[0];
            String product=current[1];
            double price=Double.parseDouble(current[2]);
            shops.putIfAbsent(shop,new LinkedHashMap<>());
            shops.get(shop).put(product,price);
            input=scan.nextLine();
        }

        shops
                .entrySet()
                .stream()
                .forEach(s-> {
                    System.out.println(s.getKey()+"->");
                    s
                            .getValue()
                            .entrySet()
                            .stream()
                            .forEach(p-> System.out.printf("Product: %s, Price: %.1f%n",p.getKey(),p.getValue()));
                });
    }
}
