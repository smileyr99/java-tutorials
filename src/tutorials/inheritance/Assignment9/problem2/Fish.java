package tutorials.inheritance.Assignment9.problem2;

public class Fish extends Pet {

    public Fish(int age) {
        super(age);
    }

    public String toString(){
        return "Fish";
    }

    @Override
    void eat(int age) {
        System.out.println("Fish->eat");
    }
}
