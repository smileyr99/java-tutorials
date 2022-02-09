package tutorials.inheritance.Assignment9.problem3;

import java.io.IOException;
import java.util.Scanner;

public class FractionCalculator {

    public static Rational fraction(String s) {
        String st[] = s.split("/");
        return new Rational(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String s = scan.nextLine();
            System.out.println("Enter a math problem containing fractions: " + s);
            String exp[] = s.split(" ");
            Rational oper1 = fraction(exp[0]);
            Rational oper2 = fraction(exp[2]);

            if (exp[1].equals("+")) {
                oper1 = oper1.add(oper2);
            } else if (exp[1].equals("-")) {
                oper1 = oper1.sub(oper2);
            } else if (exp[1].equals("*")) {
                oper1 = oper1.mul(oper2);
            } else {
                oper1 = oper1.div(oper2);
            }
            System.out.println(s + " = " + oper1 + "\n");
        }
    }
}
