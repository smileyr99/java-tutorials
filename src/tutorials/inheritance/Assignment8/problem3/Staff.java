package tutorials.inheritance.Assignment8.problem3;

public class Staff extends Employee {

    String title;

    public Staff(String name, String address, String phoneNum, String email,
                 String office, double salary, String dateHired, String title) {
        super(name, address, phoneNum, email, office, salary, dateHired);
        this.title = title;
    }

    public String toString(){
        return super.toString() + "\ntitle : " + title;
    }
}
