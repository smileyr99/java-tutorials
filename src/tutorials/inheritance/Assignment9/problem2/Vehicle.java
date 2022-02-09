package tutorials.inheritance.Assignment9.problem2;

abstract class Vehicle implements Comparable<Vehicle>{
    int price;
    abstract void move();   //abstract method

    public Vehicle(int price) {
        this.price = price;
    }

    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o instanceof Vehicle){
            Vehicle vehicle = (Vehicle) o;
            return price == vehicle.price;
        }
        return false;
    }

    @Override
    public int compareTo(Vehicle v) {
        if (v.price < this.price) {
            return 1;
        } else if (v.price == this.price) {
            return 0;
        }
        return -1;
    }

}
