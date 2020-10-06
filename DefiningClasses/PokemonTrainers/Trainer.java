package PokemonTrainers;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon.
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer (String name) {
        this.name=name;
        this.numberOfBadges=0;
        this.pokemons=new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void isHaveElement(String element) {
        boolean isElement=false;
        for (int i = 0; i <this.pokemons.size() ; i++) {
            if (this.pokemons.get(i).getElement().equals(element)) {
                this.numberOfBadges+=1;
                isElement=true;
                break;
            }
        }
        if (!isElement) {
            for (int i = 0; i <this.pokemons.size() ; i++) {
                this.pokemons.get(i).setHealth(this.pokemons.get(i).getHealth()-10);
                if (this.pokemons.get(i).getHealth()<=0) {
                    this.pokemons.remove(i);
                    i--;
                }
            }
        }
    }

    @Override
    public String toString () {
        return  String.format("%s %d %d",this.name,this.numberOfBadges,this.pokemons.size());
    }
}
