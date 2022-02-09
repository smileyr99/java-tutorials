package tutorials.inheritance.Assignment8.problem2;

public class Jet {
    String manufacturer;
    String model;
    int year;
    String owner;
    double grossWeightEmpty;
    double lastOverhaul;
    int numOverhauls;
    double maxRecommendedFlightHours;

    String name; // toSell

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Jet(String manufacturer, String model, int year, String owner, double grossWeightEmpty, double maxRecommendedFlightHours) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.owner = owner;
        this.grossWeightEmpty = grossWeightEmpty;
        this.lastOverhaul = 0;
        this.numOverhauls = 0;
        this.maxRecommendedFlightHours = maxRecommendedFlightHours;
    }

    public String getModel() {
        return model;
    }

    public double getGrossWeightEmpty() {
        return grossWeightEmpty;
    }

    public double getLastOverhaul() {
        return lastOverhaul;
    }

    public int getNumOverhauls() {
        return numOverhauls;
    }

    public double getMaxRecommendedFlightHours() {
        return maxRecommendedFlightHours;
    }

    public double timeTillOverhaul() {
        return getMaxRecommendedFlightHours() - getLastOverhaul();
    }

    public void fly(int hour) {
        lastOverhaul += hour;
    }

    public boolean needsOverhaul() {
        boolean result = false;
        if (timeTillOverhaul() < 100) {
            numOverhauls++;
            result = true;
        }
        return result;
    }

    public boolean isAging() {
        boolean result = false;
        int age = 2020 - year;
        if (age >= 15 || getNumOverhauls() >= 20) {
            result = true;
        }
        return result;
    }

    public String toString() {
        String s = "\nManufacturer: " + this.manufacturer +
                "\nModel: " + model + "\nYear: " + year + "\nOwner: " +
                owner + "\nGross Weight Empty: " + grossWeightEmpty +
                "\nAging:" + this.isAging() + "\nNeeds Overhaul:" + this.needsOverhaul();
        return s;
    }

    public static void main(String args[]) {
        Jet j1 = new Jet("Boeing", "747", 2003, "Asiana", 404548, 200);
        Jet j2 = new Jet("Lockheed", "DC-10", 2010, "US Air Force", 745, 300);

        j1.fly(50);
        j2.fly(220);
        System.out.println(j1);
        System.out.println(j2);
        System.out.println();
    }
}