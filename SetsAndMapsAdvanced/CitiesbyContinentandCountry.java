import java.util.*;

public class CitiesbyContinentandCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> continents=new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            String [] currentInput=scan.nextLine().split("\\s+");
            String continent=currentInput[0];
            String country=currentInput[1];
            String city=currentInput[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        continents
                .entrySet()
                .stream()
                .forEach(continent-> {
                    System.out.println(continent.getKey()+":");
                    continent
                            .getValue()
                            .entrySet()
                            .stream()
                            .forEach(country->{
                                System.out.print("  "+country.getKey()+" -> ");
                                System.out.println(String.join(", ",country.getValue()));
                            });
                });
    }
}
