import java.util.*;
import java.util.stream.Stream;

public class Legendary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        boolean isWinning = false;
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("shards", 0);
        map.put("fragments", 0);
        map.put("motes", 0);
        Map<String, Integer> other = new LinkedHashMap<>();

        while (!isWinning) {
            String[] input = scan.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String keyMaterials = input[i + 1].toLowerCase();
                if (map.containsKey(keyMaterials)) {
                    addToMap(map, quantity, keyMaterials);
                    isWinning = isWinning(map, keyMaterials);
                    if (isWinning) {
                        break;
                    }
                } else {
                    addToMap(other, quantity, keyMaterials);
                }
            }
        }
        map
                .entrySet()
                .stream()
                .sorted((i1,i2)-> {
                    int result=i2.getValue().compareTo(i1.getValue());
                    if(result==0) {
                        result=i1.getKey().compareTo(i2.getKey());
                    }
                    return result;
                })
                .forEach(i-> System.out.println(String.format("%s: %d",i.getKey(),i.getValue())));

        other
                .entrySet()
                .stream()
                .sorted((i1,i2)->i1.getKey().compareTo(i2.getKey()))
                .forEach(i-> System.out.println(String.format("%s: %d",i.getKey(),i.getValue())));
    }


    private static boolean isWinning(Map<String, Integer> map, String keyMaterials) {
        if (map.get(keyMaterials) >= 250) {
            int newQuantity = map.get(keyMaterials) - 250;
            map.put(keyMaterials, newQuantity);
            switch (keyMaterials) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    break;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    break;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    break;
            }
            return true;
        }
        return false;
    }


    private static void addToMap(Map<String, Integer> map, int quantity, String keyMaterials) {
        map.putIfAbsent(keyMaterials, 0);
        int quantityNew = map.get(keyMaterials)+quantity;
        map.put(keyMaterials, quantityNew);
    }

}

