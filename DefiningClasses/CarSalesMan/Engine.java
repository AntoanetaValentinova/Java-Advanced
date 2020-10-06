package CarSalesMan;

public class Engine {
    //model, power, displacement and efficiency
    private String model;
    private double power;
    //optional
    private double displacement;
    private String efficiency;

    public Engine (String model, double power,double displacement,String efficiency) {
        this(model,power,displacement);
        this.efficiency=efficiency;
    }

    public Engine (String model, double power,String efficiency) {
        this(model,power);
        this.efficiency=efficiency;
    }

    public Engine (String model, double power,double displacement) {
        this(model,power);
        this.displacement=displacement;
        this.efficiency="n/a";
    }

    public Engine (String model, double power) {
        this.model=model;
        this.power=power;
        this.efficiency="n/a";
    }

    public String getModel() {
        return model;
    }

    public double getDisplacement() {
        return displacement;
    }

    public double getPower() {
        return power;
    }

    public String getEfficiency() {
        return efficiency;
    }
}
