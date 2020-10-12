package Google;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String,Person> persons=new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name=tokens[0];
            String parameter = tokens[1];
            persons.putIfAbsent(name,new Person(name));
            switch (parameter) {
                case "company":
                    String companyName=tokens[2];
                    String department=tokens[3];
                    double salary= Double.parseDouble(tokens[4]);
                    Company company=new Company(companyName,department,salary);
                    persons.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName=tokens[2];
                    String pokemonType=tokens[3];
                    Pokemon pokemon=new Pokemon(pokemonName,pokemonType);
                    persons.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName=tokens[2];
                    String parentBDay=tokens[3];
                    Parent parent=new Parent (parentName,parentBDay);
                    persons.get(name).getParents().add(parent);
                    break;
                case "children":
                    String childName=tokens[2];
                    String childBDay=tokens[3];
                    Child child=new Child (childName,childBDay);
                    persons.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model=tokens[2];
                    int speed= Integer.parseInt(tokens[3]);
                    Car car=new Car (model,speed);
                    persons.get(name).setCar(car);
                    break;
            }
            input = scan.nextLine();
        }

        String name=scan.nextLine();
        persons.get(name).print();
    }
}
