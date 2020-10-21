package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic (int capacity) {
        this.capacity=capacity;
        this.data=new ArrayList<>();
    }

    public void add (Pet pet) {
        if (this.data.size()<this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove (String name) {
        for (Pet datum : data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Pet getPet (String name, String owner) {
        for (Pet datum : data) {
            if (datum.getName().equals(name)&&datum.getOwner().equals(owner)) {
                return datum;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return  this.data
                .stream()
                .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .findFirst()
                .get();
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(datum.getName()+" "+datum.getOwner());
            sb.append(System.lineSeparator());
        }
        String output=sb.toString();
        return output;
    }
}
