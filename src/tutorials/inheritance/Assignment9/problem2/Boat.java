package tutorials.inheritance.Assignment9.problem2;

public class Boat extends Vehicle{

    public Boat(int price) {
        super(price);
    }

    public String toString(){
        return "Boat";
    }

    @Override
    void move() {
        System.out.println("Boat->move");
    }
}
