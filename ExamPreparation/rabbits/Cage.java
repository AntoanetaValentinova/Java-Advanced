package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                this.data.remove(rabbit);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                this.data.remove(rabbit);
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        ArrayList<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                rabbits.add(rabbit);
            }
        }
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at " + this.name + ":").append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
