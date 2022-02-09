package tutorials.inheritance.Assignment8.problem1;

public class Triangle implements Shape {

    double base;
    double height;;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public void translate(double dx, double dy) {

    }

    @Override
    public void scale(double factor) {

    }

    @Override
    public Box boundingBox() {
        return null;
    }
}
