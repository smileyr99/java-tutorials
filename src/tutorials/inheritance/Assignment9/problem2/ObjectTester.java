package tutorials.inheritance.Assignment9.problem2;

public class ObjectTester {
    public static void main(String[] args) {
        Pet p1 = new Cat(5);
        p1.eat(10);
        ((Cat)p1).makeNoise();
        Pet p2 = new Fish(4);
        p2.eat(5);
        if (p1.compareTo(p2) > 0) {
            System.out.println(((Cat) p1).toString() + "'s age is greater than " + p2.toString()+ "'s");
        }else if(p1.compareTo(p2) == 0){
            System.out.println(((Cat) p1).toString() + "'s age is same as " + p2.toString()+ "'s");
        }else{
            System.out.println(((Cat) p1).toString() + "'s age is less than " + p2.toString()+ "'s");
        }

        Vehicle v = new Ship(1200);
        v.move();
        ((Boat)v).move(); // notice which version of move is called
        ((Ship)v).dropAnchor();
        Taxi t = new Taxi(1800);
        t.makeNoise();
        t.move();
        if (t.compareTo(v) > 0) {
            System.out.println(((Taxi) t).toString() + " is greater than " + v.toString());
        }else if(t.compareTo(v) == 0){
            System.out.println(((Taxi) t).toString() + " is same as " + v.toString());
        }else{
            System.out.println(((Taxi) t).toString() + " is less than " + v.toString());
        }

        NoiseMaker n1 = new Cat(3);
        n1.makeNoise();
        NoiseMaker n2 = new Taxi(500);
        n2.makeNoise();

        System.out.println(p1.compareTo(p2));
        System.out.println(v.compareTo(t));
        System.out.println(v.equals(p1));

    }
}
