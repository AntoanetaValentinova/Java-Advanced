import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();
        Pattern pattern=Pattern.compile("(?<artist>[A-Za-z ]+) @(?<place>[A-Za-z ]+) (?<ticketPrice>[\\d]+) (?<ticketCount>[\\d]+)");

        Map <String, Map<String,Integer>> venues = new LinkedHashMap<>();
        while (!input.equals("End")) {
            Matcher matcher=pattern.matcher(input);
            if (matcher.find()) {
                String artist=matcher.group("artist");
                String place=matcher.group("place");
                int ticketPrice= Integer.parseInt(matcher.group("ticketPrice"));
                int ticketsCount= Integer.parseInt(matcher.group("ticketCount"));
                int money=ticketPrice*ticketsCount;
                venues.putIfAbsent(place,new LinkedHashMap<>());
                venues.get(place).putIfAbsent(artist,0);
                venues.get(place).put(artist,venues.get(place).get(artist)+money);
            }
            input=scan.nextLine();
        }

        venues
                .entrySet()
                .stream()
                .forEach(p->{
                    System.out.println(p.getKey());
                    p.getValue()
                            .entrySet()
                            .stream()
                            .sorted((m1,m2)->m2.getValue().compareTo(m1.getValue()))
                            .forEach(s-> System.out.printf("#  %s -> %d%n",s.getKey(),s.getValue()));
                });
    }
}
