package model;

public class Car {
    private String VIN;
    private String make;
    private String model;
    private int year;
    
    public Car(String vIN, String make, String model, int year) {
        VIN = vIN;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void setVIN(String vIN) {
        VIN = vIN;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getVIN() {
        return VIN;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }

    public void printInfo() {
        System.out.println("VIN: " + VIN);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}
