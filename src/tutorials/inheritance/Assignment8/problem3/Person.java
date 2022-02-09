package tutorials.inheritance.Assignment8.problem3;

public class Person {
    protected String name;
    protected String address;
    protected String phoneNum;
    protected String email;

    protected Person(String name, String address, String phoneNum, String email) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String toString() {
        return getClass().getName() + "\n-" + name + "-\nAddress : " + address + "\nPhone number : " + phoneNum + "\nEmail address : " + email;
    }
}
