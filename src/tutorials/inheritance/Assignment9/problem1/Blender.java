package tutorials.inheritance.Assignment9.problem1;

public class Blender extends CookingAppliance{
    public void use(Object... appliances){
        System.out.println("Running blender at " + appliances[0] + " speed.");
    }
    public void clean(){
        System.out.println("Cleaning the blender.");
    }
}
