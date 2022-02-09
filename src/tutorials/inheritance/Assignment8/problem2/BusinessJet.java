package tutorials.inheritance.Assignment8.problem2;

public class BusinessJet extends Jet implements Comparable<BusinessJet> {

    private int numPassengers;
    private boolean transOceanCertified;

    public boolean isHighClass() {
        if (this.numPassengers >= 40 && this.transOceanCertified) {
            return true;
        }
        return false;
    }

    public BusinessJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
                       int maxRecommendedFlightHours, int numPassengers, boolean transOceanCertified) {
        super(manufacturer, model, year, owner, grossWeightEmpty, maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.transOceanCertified = transOceanCertified;
    }

    @Override
    public String toString() {
        String s = "\nManufacturer: " + this.manufacturer +
                "\nModel: " + model + "\nYear: " + year + "\nOwner: " +
                owner + "\nGross Weight Empty: " + grossWeightEmpty +
                "\nAging:" + this.isAging() + "\nNeeds Overhaul:" + this.needsOverhaul() +
                "\nnumPassengers: " + this.numPassengers + "\ntransOceanCertified: " + this.transOceanCertified;
        return s;
    }

    @Override
    public int compareTo(BusinessJet b) {
        if (b.numPassengers < this.numPassengers) {
            return 1;
        } else if (b.numPassengers == this.numPassengers) {
            return 0;
        }
        return -1;
    }

    public static void main(String args[]) {
        BusinessJet b1 = new BusinessJet("Boeing", "747", 2003, "Asiana", 404548, 200, 50, false);
        BusinessJet b2 = new BusinessJet("Lockheed", "DC-10", 2015, "US Air Force", 745, 300, 200, true);

        b1.fly(50);
        b2.fly(220);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println();
        b1.compareTo(b2);

        if (b1.compareTo(b2) < 0) {
            System.out.println("Status of " + b2.model + " is better than "+ b1.model);
        }else if(b1.compareTo(b2) == 0){
            System.out.println("Status of " + b2.model + " is same as "+ b1.model);

        }else{
            System.out.println("Status of " + b1.model + " is same as "+ b2.model);
        }
    }


}