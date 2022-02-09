package tutorials.encapsulation.circle;

public class Student {
    private String studentID;
    private String studentName;
    private double sub1;
    private double sub2;
    private double sub3;

    public Student(String studentID, String studentName, double sub1, double sub2, double sub3) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public double total() {
        return sub1 + sub2 + sub3;
    }

    public double avg() {
        return Math.round((total() / 3) * 100) / 100d;
    }

    public String showName() {
        return studentName;
    }

    public char grade() {
        if (avg() >= 90) {
            return 'A';
        } else if (avg() >= 80 && avg() < 90) {
            return 'B';
        } else if (avg() >= 70 && avg() < 80) {
            return 'C';
        } else if (avg() >= 60 && avg() < 70) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printInfo() {
        System.out.println("-----------------------");
        System.out.println("학생이름 : " + showName());
        System.out.println("총점 : " + total());
        System.out.println("총점 : " + avg());
        System.out.println("학점 : " + grade());
    }


    public static void main(String[] args) {
        Student[] stu = new Student[3];
        stu[0] = new Student("000", "비둘기", 100, 80, 95);
        stu[1] = new Student("001", "고양이", 96, 88, 82);
        stu[2] = new Student("002", "강아지", 70, 68, 55);

        for (int i = 0; i < stu.length; i++) {
            stu[i].printInfo();
        }
        for (Student student:stu) {
            student.printInfo();
        }
    }
}
