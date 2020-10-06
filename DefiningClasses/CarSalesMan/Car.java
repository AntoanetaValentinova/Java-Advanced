package CarSalesMan;

public class Car {
    //model, engine, weight and color
    private String model;
    private Engine engineModel;
    //optional
    private int weight;
    private String color;

    public Car (String model, Engine engineModel, int weight,String color) {
        this(model,engineModel,color);
        this.weight=weight;
    }

    public Car (String model, Engine engineModel, String color) {
        this(model,engineModel);
        this.color=color;
    }

    public Car (String model, Engine engineModel, int weight) {
        this(model,engineModel);
        this.weight=weight;
        this.color="n/a";
    }

    public Car (String model, Engine engineModel) {
        this.model=model;
        this.engineModel=engineModel;
        this.color="n/a";
    }

    public String getModel() {
        return model;
    }

    public Engine getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
