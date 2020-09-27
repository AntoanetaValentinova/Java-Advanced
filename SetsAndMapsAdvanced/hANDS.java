import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class hANDS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[0];
            String [] deck = tokens[1].split(",\\s+");
            players.putIfAbsent(name,new LinkedHashSet<>());
            for (int i = 0; i <deck.length ; i++) {
                players.get(name).add(deck[i]);
            }
            input=scan.nextLine();
        }
        Map<String,Integer> scores=new LinkedHashMap<>();
        for (Map.Entry<String,LinkedHashSet<String>> entry:players.entrySet()) {
            String name=entry.getKey();
            LinkedHashSet<String> cards=entry.getValue();
            int sum=0;
            for (String card:cards) {
                String power = card.substring(0,card.length()-1);
                String type = card.substring(card.length()-1);
                int currentValue = 0;
                if (power.equals("2")||power.equals("3")||power.equals("4")||power.equals("5")||power.equals("6")||power.equals("7")||
                        power.equals("8")||power.equals("9")||power.equals("10")) {
                    int powerInt = Integer.parseInt(power);
                    if (type.equals("S")) {
                        currentValue = powerInt * 4;
                    } else if (type.equals("H")) {
                        currentValue = powerInt * 3;
                    } else if (type.equals("D")) {
                        currentValue = powerInt * 2;
                    } else if (type.equals("C")) {
                        currentValue = powerInt * 1;
                    }
                } else if (power.equals("J")) {
                    int powerInt = 11;
                    if (type.equals("S")) {
                        currentValue = powerInt * 4;
                    } else if (type.equals("H")) {
                        currentValue = powerInt * 3;
                    } else if (type.equals("D")) {
                        currentValue = powerInt * 2;
                    } else if (type.equals("C")) {
                        currentValue = powerInt * 1;
                    }
                } else if (power.equals("Q")) {
                    int powerInt = 12;
                    if (type.equals("S")) {
                        currentValue = powerInt * 4;
                    } else if (type.equals("H")) {
                        currentValue = powerInt * 3;
                    } else if (type.equals("D")) {
                        currentValue = powerInt * 2;
                    } else if (type.equals("C")) {
                        currentValue = powerInt * 1;
                    }
                } else if (power.equals("K")) {
                    int powerInt = 13;
                    if (type.equals("S")) {
                        currentValue = powerInt * 4;
                    } else if (type.equals("H")) {
                        currentValue = powerInt * 3;
                    } else if (type.equals("D")) {
                        currentValue = powerInt * 2;
                    } else if (type.equals("C")) {
                        currentValue = powerInt * 1;
                    }
                } else if (power.equals("A")) {
                    int powerInt = 14;
                    if (type.equals("S")) {
                        currentValue = powerInt * 4;
                    } else if (type.equals("H")) {
                        currentValue = powerInt * 3;
                    } else if (type.equals("D")) {
                        currentValue = powerInt * 2;
                    } else if (type.equals("C")) {
                        currentValue = powerInt * 1;
                    }
                }
                sum += currentValue;
            }
            scores.putIfAbsent(name,0);
            scores.put(name,scores.get(name)+sum);
        }
        scores
                .entrySet()
                .stream()
                .forEach(p -> System.out.printf("%s: %d%n", p.getKey(), p.getValue()));
    }
}
