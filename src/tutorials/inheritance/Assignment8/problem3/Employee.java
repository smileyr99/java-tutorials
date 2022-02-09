package tutorials.inheritance.Assignment8.problem3;

public class Employee extends Person {
    String office;
    double salary;
    String dateHired;

    public Employee(String name, String address, String phoneNum, String email,
                    String office, double salary, String dateHired) {
        super(name, address, phoneNum, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String toString() {
        return super.toString() + "\nOffice Number : " + office + "\nSalary : " + salary + "\nhiredate : " + dateHired;
    }
}
