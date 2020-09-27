import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        LinkedHashMap<String, LinkedHashMap<String,Long>> countries=new LinkedHashMap<>();
        LinkedHashMap<String,Long> countryPopulation=new LinkedHashMap<>();
        while (!input.equals("report")) {
            String [] tokens=input.split("\\|");
            String city=tokens[0];
            String country=tokens[1];
            Long population= Long.parseLong(tokens[2]);
            countries.putIfAbsent(country,new LinkedHashMap<>());
            countries.get(country).put(city,population);
            countryPopulation.putIfAbsent(country,0L);
            countryPopulation.put(country,countryPopulation.get(country)+population);
            input=scan.nextLine();
        }


        countryPopulation
                .entrySet()
                .stream()
                .sorted((c1,c2)->c2.getValue().compareTo(c1.getValue()))
                .forEach(c->{
                    System.out.printf("%s (total population: %d)%n",c.getKey(),c.getValue());
                    countries.get(c.getKey())
                            .entrySet()
                            .stream()
                            .sorted((p1,p2)->p2.getValue().compareTo(p1.getValue()))
                            .forEach(city-> System.out.printf("=>%s: %d%n",city.getKey(),city.getValue()));
                            });

    }
}

