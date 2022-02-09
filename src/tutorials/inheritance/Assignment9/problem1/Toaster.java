package tutorials.inheritance.Assignment9.problem1;

public class Toaster extends CookingAppliance {
    public void use(Object... appliances){
        System.out.println("Toasting food on " + appliances[0] + " setting at " + appliances[1] + " temperature.");
    }
    public void clean(){
        System.out.println("Cleaning the toaster.");
    }
}
