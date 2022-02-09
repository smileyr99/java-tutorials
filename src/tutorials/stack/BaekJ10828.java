package tutorials.stack;

import java.util.Scanner;

public class BaekJ10828 {
    static int N, size = 0;
    static int[] stack;

    static void push(int item) {
        if (size == N) {
            System.out.println("Overflow");
        }
        stack[size++] = item;
    }

    static int pop() {
        if (size == 0) {
            return -1;
        }else {
            int res = stack[size-1];
            size--;
            return res;
        }
    }

    static int size() {
        return size;
    }

    static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = scanner.nextInt();
        stack = new int[N];

        while (scanner.hasNext()) {
            String str = scanner.next();

            switch (str) {
                case "push":
                    push(scanner.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}