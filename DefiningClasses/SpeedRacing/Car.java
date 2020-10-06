package SpeedRacing;

public class Car {
    // Model, fuel amount, fuel cost for 1 kilometer and distance traveled
    private String model;
    private double fuelAmount;
    private double fuelCost1Km;
    private double distance;

    public Car (String model,double fuelAmount,double fuelCost1Km) {
        this.model=model;
        this.fuelAmount=fuelAmount;
        this.fuelCost1Km=fuelCost1Km;
        this.distance=0;
    }

    public boolean canDrive(double amountOfKm) {
        double neededFuel=this.fuelCost1Km*amountOfKm;
        if (neededFuel<=fuelAmount) {
            this.fuelAmount=fuelAmount-neededFuel;
            this.distance=distance+amountOfKm;
            return true;
        }
        return false;
    }

    @Override
    public String toString () {
        return String.format("%s %.2f %.0f",this.model,this.fuelAmount,this.distance);
    }
}
