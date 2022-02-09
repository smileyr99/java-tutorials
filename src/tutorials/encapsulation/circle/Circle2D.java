package tutorials.encapsulation.circle;

public class Circle2D {

    double x;
    double y;
    double radius;

    public Circle2D() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() { return x; }

    public double getY() {
        return this.y;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public boolean contains(double x, double y) {
        return Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2)) <= radius;
    }

    public boolean contains(Circle2D circle) {
        return Math.sqrt(Math.pow((circle.getX() - x), 2) + Math.pow((circle.getY()), 2))
                <= Math.abs(radius - circle.getRadius());
    }
}

