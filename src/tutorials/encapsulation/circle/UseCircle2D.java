package tutorials.encapsulation.circle;

public class UseCircle2D {
    public static void main(String[] args) {
        Circle2D a = new Circle2D(2.5, 3.5, 5.5);
        Circle2D b = new Circle2D();
        System.out.println(a.getArea());
        System.out.println(b.getArea());
        System.out.println(Circle2D.distance(2,1,6,4));
        System.out.println(a.contains(2, 2.3));
        System.out.println(a.contains(new Circle2D(3, 3, 3)));
    }
}
