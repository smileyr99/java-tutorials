package tutorials.inheritance.Assignment8.problem3;

public class Faculty extends Employee {

    String officeHours;
    String rank;

    public Faculty(String name, String address, String phoneNum, String email,
                   String office, double salary, String dateHired, String officeHours, String rank) {

        super(name, address, phoneNum, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String toString() {
        return super.toString() + "\nOffice Hours : " + officeHours + "\nRank : " + rank;
    }

}
