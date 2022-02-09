package tutorials.inheritance.Assignment8.problem1;

class Location{
    double  x;
    double  y;

    public Location(double  x, double  y){
        this.x = x;
        this.y = y;
    }

    public double  getX() {
        return x;
    }

    public double  getY() {
        return y;
    }

    public void translate(double dx, double dy){
        x = x + dx;
        y = y + dy;
    }

}

class Box{
    double x;
    double y;
    double w;
    double h;

    public Box(double x, double y, double w, double h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public String toString(){
        return "x: " + x + "y: " + y + "w: " + w + "h: " + h;
    }
}

public class Circle implements Shape {
    Location center;
    double radius;

    public Circle(Location center, double radius){
        this.center = center;
        this.radius = radius;
    }

    public Circle (double x, double y, double radius) {
        center = new Location(x, y);
        this.radius = radius;
    }

    public double circumference () {
        return 2 * Math.PI * radius;
    }

    @Override
    public void translate(double dx, double dy) {
       center.translate(dx, dy);
    }

    @Override
    public void scale(double factor) {
        radius = radius * factor;
    }

    @Override
    public Box boundingBox() {
        return (new Box(center.getX() - radius, center.getY() - radius,
                2.0 * radius, 2.0 * radius));
    }
}


