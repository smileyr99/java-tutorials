package tutorials.inheritance.Assignment8.problem2;

public class PassengerJet extends Jet{
    private int numPassengers;
    private int numEngines;
    private boolean hasAutopilot;

    public PassengerJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
                        double maxRecommendedFlightHours, int numPassengers, int numEngines, boolean hasAutopilot) {
        super(manufacturer, model, year, owner, grossWeightEmpty, maxRecommendedFlightHours);
        this.numPassengers = numPassengers;
        this.numEngines = numEngines;
        this.hasAutopilot = hasAutopilot;
    }

    public boolean isHardToFly() {
        return !this.hasAutopilot;
    }

    public boolean needsLongRunway() {
        return super.getGrossWeightEmpty() > 230000;
    }

    @Override
    public String toString() {
        String s = "\nManufacturer: " + this.manufacturer +
                "\nModel: " + model + "\nYear: " + year + "\nOwner: " +
                owner + "\nGross Weight Empty: " + grossWeightEmpty +
                "\nAging:" + this.isAging() + "\nNeeds Overhaul:" + this.needsOverhaul() +
                "\nnumPassengers: " + this.numPassengers + "\nnumEngines: " + this.numEngines +
                "\nhasAutopilot: " + this.hasAutopilot;
        return s;
    }

    public int compareTo(PassengerJet p) {
        if(p.hasAutopilot == this.hasAutopilot){
            return 0;
        }else if(p.hasAutopilot){
            return 1;
        }else{
            return -1;
        }

    }

    public static void main(String args[]){
        PassengerJet p1  = new PassengerJet("Boeing", "747", 2003, "Asiana", 404548, 200, 50, 2, false);
        PassengerJet p2  = new PassengerJet("Lockheed", "DC-10", 2015, "US Air Force", 745, 300, 200, 4, true );

        p1.fly(50);
        p2.fly(220);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();
        p1.compareTo(p2);

        if (p1.compareTo(p2) > 0) {
            System.out.println("Status of " + p2.model + " is better than "+ p1.model);
        }else if(p1.compareTo(p2) == 0){
            System.out.println("Status of " + p2.model + " is same as "+ p1.model);

        }else{
            System.out.println("Status of " + p1.model + "  is same as "+ p2.model);
        }
    }

}
