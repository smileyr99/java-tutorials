package tutorials.inheritance.Assignment9.problem2;

public class Taxi extends Vehicle implements NoiseMaker{

    public Taxi(int price) {
        super(price);
    }

    public String toString(){
        return "Taxi";
    }

    @Override
    public void makeNoise() {
        System.out.println("Taxi->makeNoise");
    }

    @Override
    void move() {
        System.out.println("Taxi->move");
    }
}
