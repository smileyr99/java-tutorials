package tutorials.encapsulation.car;

public class Car {
    private String VIN;
    private String make;
    private int year;

    public Car(String VIN, String make, int year) {
        this.VIN = VIN;
        this.make = make;
        this.year = year;
    }

    public String getVIN() {
        return VIN;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }
}