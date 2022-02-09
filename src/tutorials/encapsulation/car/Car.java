package tutorials.encapsulation.car;

public class Car {
    private final String VIN;
    private final String make;
    private final int year;

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