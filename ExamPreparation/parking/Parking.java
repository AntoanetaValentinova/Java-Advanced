package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
        private List<Car> data;
        private String type;
        private int capacity;

    public Parking(String type, int capacity) {
        this.data=new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.data.size()<this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (this.data.isEmpty()) {
            return null;
        }
        return this.data.stream()
                .sorted((c1,c2)->Integer.compare(c2.getYear(),c1.getYear()))
                .findFirst()
                .get();
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer)&&car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append("The cars are parked in "+this.type+":");
        sb.append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
