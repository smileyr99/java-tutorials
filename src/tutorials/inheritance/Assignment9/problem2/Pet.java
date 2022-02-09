package tutorials.inheritance.Assignment9.problem2;

abstract class Pet implements Comparable<Pet>{
    abstract void eat(int age);
    int age;

    public Pet(int age){
        this.age = age;
    }

    public int compareTo(Pet p){
        if (p.age < this.age) {
            return 1;
        } else if (p.age > this.age) {
            return -1;
        }
        return 0;
    }

}
