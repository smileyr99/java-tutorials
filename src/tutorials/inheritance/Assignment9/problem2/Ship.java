package tutorials.inheritance.Assignment9.problem2;

public class Ship extends Boat{

    public Ship(int price) {
        super(price);
    }

    public void dropAnchor(){
        System.out.println("Ship->dropAnchor");
    }

    public String toString(){
        return "Ship";
    }

    @Override
    void move() {
        System.out.println("Ship->move");
    }
}
