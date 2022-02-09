package tutorials.stack;

import java.util.Scanner;
import java.util.Stack;

public class BaekJ4949 {

    static String f(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || !stack.peek().equals('(')) {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.empty() || !stack.peek().equals('[')) {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        while (true) {
            str = scanner.nextLine();

            if (str.equals(".")) {
                break;
            }
            System.out.println(f(str));
        }
    }
}
