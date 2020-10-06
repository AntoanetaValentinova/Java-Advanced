package Constructors;

public class Car {
    private String make;
    private String model;
    private int horsePower;

    public Car (String make,String model, int horsePower) {
        this(make,model);
        this.horsePower=horsePower;
    }

    public Car (String make,String model) {
        this(make);
        this.model=model;
    }

    public Car(String make) {
        this.make=make;
    }
    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.make,this.model!=null?this.model:"unknown", this.horsePower>0?this.horsePower:-1);
    }
}
