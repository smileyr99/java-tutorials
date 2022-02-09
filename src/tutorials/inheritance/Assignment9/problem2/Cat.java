package tutorials.inheritance.Assignment9.problem2;

public class Cat extends Pet implements NoiseMaker{

    public Cat(int age) {
        super(age);
    }

    public String toString(){
        return "Cat";
    }

    @Override
    void eat(int age) {
        System.out.println("Cat->eat");
    }

    @Override
    public void makeNoise() {
        System.out.println("Cat->makeNoise");
    }
}
