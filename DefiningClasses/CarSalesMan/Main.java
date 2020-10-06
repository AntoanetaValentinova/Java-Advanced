package CarSalesMan;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scan.nextLine());

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            //"<Model> <Power> <Displacement> <Efficiency>".
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            Double power = Double.parseDouble(tokens[1]);
            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 3) {
                try {
                    double displacement = Double.parseDouble(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (tokens.length == 4) {
                double displacement = Double.parseDouble(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
            engines.put(model, engine);
        }

        int numberOfCars = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            //Model> <Engine> <Weight> <Color>
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            String engineModel = tokens[1];
            Car car = null;
            if (tokens.length == 2) {
                car = new Car(model, engines.get(engineModel));
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engines.get(engineModel), weight);
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    car = new Car(model, engines.get(engineModel), color);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engines.get(engineModel), weight, color);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngineModel().getModel() + ":");
            System.out.printf("Power: %.0f%n",car.getEngineModel().getPower());
            if (car.getEngineModel().getDisplacement() == 0) {
                System.out.println("Displacement: n/a");
            } else {
                System.out.printf("Displacement: %.0f%n",car.getEngineModel().getDisplacement());
            }
            System.out.printf("Efficiency: %s%n", car.getEngineModel().getEfficiency());
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
                System.out.println("Color: " + car.getColor());

        }
    }
}
