package tutorials.inheritance.Assignment8.problem3;

public class Student extends Person {

    static final int freshman = 1;
    static final int sophomore = 2;
    static final int junior = 3;
    static final int senior = 4;
    String grade;

    public Student(String name, String address, String phoneNum, String email, int gradeNum) {
        super(name, address, phoneNum, email);
        if (gradeNum == 1) {
            grade = "freshman";
        }
        if (gradeNum == 2) {
            grade = "sophomore";
        }
        if (gradeNum == 3) {
            grade = "junior";
        }
        if (gradeNum == 4) {
            grade = "Senior";
        }
    }

    public String toString() {
        return super.toString() + "\nStatus : " + grade;
    }
}
