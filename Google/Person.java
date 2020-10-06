package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person (String name) {
        this.name=name;
        this.pokemons=new ArrayList<>();
        this.parents=new ArrayList<>();
        this.children=new ArrayList<>();
    }



    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void print () {
        System.out.println(this.name);
        if (this.company!=null) {
            System.out.printf("Company:%n%s%n",this.company);
        } else {
            System.out.println("Company:");
        }
        if (this.car!=null) {
            System.out.printf("Car:%n%s%n",this.car);
        } else {
            System.out.println("Car:");
        }
        if (this.pokemons.isEmpty()) {
            System.out.println("Pokemon:");
        } else {
            System.out.println("Pokemon:");
            for (int i = 0; i <this.pokemons.size() ; i++) {
                System.out.println(this.pokemons.get(i));
            }
        }
        if (this.parents.isEmpty()) {
            System.out.println("Parents:");
        } else {
            System.out.println("Parents:");
            for (int i = 0; i <this.parents.size() ; i++) {
                System.out.println(this.parents.get(i));
            }
        }
        if (this.children.isEmpty()) {
            System.out.println("Children:");
        } else {
            System.out.println("Children:");
            for (int i = 0; i <this.children.size() ; i++) {
                System.out.println(this.children.get(i));
            }
        }
    }
}
