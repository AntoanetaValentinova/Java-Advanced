package PokemonTrainers;

public class Pokemon {
    //a name, an element and health
    private String name;
    private String element;
    private int health;

    public Pokemon (String name, String element,int health) {
        this.name=name;
        this.element=element;
        this.health=health;
    }

    public String getElement() {
        return element;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
