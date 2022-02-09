package tutorials.inheritance.Assignment8.problem1;

public class Rectangle implements Shape {

    double width;
    double height;;

    public Rectangle(double width, double height){
        this.width = width;
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