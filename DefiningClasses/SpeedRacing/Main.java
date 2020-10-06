package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        Map<String,Car> cars=new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            //<Model> <FuelAmount> <FuelCostFor1km
            String [] input=scan.nextLine().split("\\s+");
            String model=input[0];
            double fuelAmount= Double.parseDouble(input[1]);
            double fuelCostFor1Km= Double.parseDouble(input[2]);
            cars.put(model,new Car(model,fuelAmount,fuelCostFor1Km));
        }

        String input=scan.nextLine();

        while(!input.equals("End")) {
            String [] tokens=input.split("\\s+");
            String carModel=tokens[1];
            double amountOfKm=Double.parseDouble(tokens[2]);
            if (!cars.get(carModel).canDrive(amountOfKm)) {
                System.out.println("Insufficient fuel for the drive");
            }
            input=scan.nextLine();
        }

        cars
                .values()
                .stream()
                .forEach(car-> System.out.println(car));
    }
}
