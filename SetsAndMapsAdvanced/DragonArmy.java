import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Map<String,Integer>> damages=new LinkedHashMap<>();
        Map<String, Map<String,Integer>> healths=new LinkedHashMap<>();
        Map<String, Map<String,Integer>> armors=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage=0;
            int health=0;
            int armor=0;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            } else {
                damage = 45;
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            } else {
                health = 250;
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            } else {
                armor = 10;
            }
            healths.putIfAbsent(type,new TreeMap<>());
            healths.get(type).put(name,health);
            damages.putIfAbsent(type,new TreeMap<>());
            damages.get(type).put(name,damage);
            armors.putIfAbsent(type, new TreeMap<>());
            armors.get(type).put(name,armor);
        }

        Map<String,Double> avgHealth=getAverage(healths);
        Map<String,Double> avgDamage=getAverage(damages);
        Map<String,Double> avgArmor=getAverage(armors);

        healths
                .entrySet()
                .stream()
                .forEach(t-> {
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n",t.getKey(),avgDamage.get(t.getKey()),avgHealth.get(t.getKey()),avgArmor.get(t.getKey()));
                        t.getValue()
                                .entrySet()
                                .stream()
                                .forEach(d->{
                                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",d.getKey(),damages.get(t.getKey()).get(d.getKey())
                                    ,d.getValue(),armors.get(t.getKey()).get(d.getKey()));
                                });

                });
    }

    private static Map<String,Double> getAverage(Map<String, Map<String, Integer>> map) {
        Map<String,Double> average=new LinkedHashMap<>();
        for (Map.Entry<String,Map<String,Integer>> entry:map.entrySet()) {
            double avg=entry.getValue().values().stream().mapToDouble(e->e).average().getAsDouble();
            average.put(entry.getKey(),avg);
        }
        return  average;
    }
}
