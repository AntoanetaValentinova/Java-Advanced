import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> materials=new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e->materials.push(e));
        Deque<Integer> magic=Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        Map<String,Integer> craftedToys=new TreeMap<>();
        craftedToys.put("Doll",0);
        craftedToys.put("Wooden train",0);
        craftedToys.put("Teddy bear",0);
        craftedToys.put("Bicycle",0);

        while (!materials.isEmpty()&&!magic.isEmpty()) {
            int currentMaterial=materials.peek();
            int currentMagic=magic.peek();
            int totalMagic=currentMagic*currentMaterial;
            if (totalMagic==150) {
                getCraftToy(materials, magic, craftedToys,"Doll");
            } else if (totalMagic==250) {
                getCraftToy(materials, magic, craftedToys,"Wooden train");
            } else if (totalMagic==300) {
                getCraftToy(materials, magic, craftedToys,"Teddy bear");
            } else if (totalMagic==400) {
                getCraftToy(materials, magic, craftedToys,"Bicycle");
            } else if (totalMagic<0) {
                int sum=currentMaterial+currentMagic;
                materials.pop();
                magic.poll();
                materials.push(sum);
            } else if (totalMagic>0) {
                magic.poll();
                materials.push(materials.pop()+15);
            } else if (currentMagic==0&&currentMaterial==0) {
                materials.pop();
                magic.poll();
            } else if (currentMaterial==0) {
                materials.pop();
            } else if (currentMagic==0) {
                magic.poll();
            }
        }

        if ((craftedToys.get("Doll")>=1&&craftedToys.get("Wooden train")>=1)||
                (craftedToys.get("Teddy bear")>=1&&craftedToys.get("Bicycle")>=1)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materials
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (!magic.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magic
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        craftedToys
                .entrySet()
                .stream()
                .filter(e->e.getValue()>=1)
                .forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }

    public static void getCraftToy(Deque<Integer> materials, Deque<Integer> magic, Map<String, Integer> craftedToys, String key) {
        craftedToys.put(key,craftedToys.get(key)+1);
        materials.pop();
        magic.poll();
    }
}
