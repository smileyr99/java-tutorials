package tutorials.inheritance.Assignment8.problem3;

public class University {
    public static void main(String[] args){

        Person p=new Person("Grace","korea","23245671","Grace232@naver.com");
        Person s=new Student("Sam","USA","24563983","Sam234@gmail.com",4);
        Person e=new Employee("John","Canada","90481256","John904@daum.net","Info",50000, "20170611");
        Person f=new Faculty("Harry","UK","98013231","Harry98@gmail.com","caps",60000,"20191230", "9.00am-7.00pm","Manager");
        Person st=new Staff("Sally","japan","11538809","SS11@yahoo.com","IBM",30000,"20210305", "??");

        System.out.println(p.toString()+"\n");
        System.out.println(s.toString()+"\n");
        System.out.println(e.toString()+"\n");
        System.out.println(f.toString()+"\n");
        System.out.println(st.toString()+"\n");
    }

}
