package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size()<this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data
                .stream()
                .sorted((p1,p2)->Double.compare(p2.getWeight(),p1.getWeight()))
                .findFirst()
                .get();
    }

    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb=new StringBuilder();
        sb.append(this.color+" bag contains:").append(System.lineSeparator());
        for (Present present : data) {
            sb.append(present).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
