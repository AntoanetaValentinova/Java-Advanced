import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        LinkedHashSet<String> cars = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] currentCar = input.split(",\\s+");
            String command = currentCar[0];
            String carNumber = currentCar[1];
            if (command.equals("IN")) {
                cars.add(carNumber);
            } else if (command.equals("OUT")) {
                cars.remove(carNumber);
            }

            input = scan.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
