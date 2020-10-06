package PokemonTrainers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Map<String,Trainer> trainers=new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String [] tokens=input.split("\\s+");
            String trainerName=tokens[0];
            String pokemonName=tokens[1];
            String pokemonElement=tokens[2];
            int pokemonHealth= Integer.parseInt(tokens[3]);
            Pokemon pokemon=new Pokemon(pokemonName,pokemonElement,pokemonHealth);
            Trainer trainer=new Trainer(trainerName);
            trainers.putIfAbsent(trainerName,trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);
            input=scan.nextLine();
        }

        String element=scan.nextLine();

        while (!element.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                trainer.isHaveElement(element);
            }
            element=scan.nextLine();
        }

        trainers
                .values()
                .stream()
                .sorted((t1,t2)->Integer.compare(t2.getNumberOfBadges(),t1.getNumberOfBadges()))
                .forEach(trainer-> System.out.println(trainer));
    }
}
