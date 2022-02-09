package tutorials.recursion;

import java.util.Scanner;

public class BaeckJ11729 {
    static  StringBuilder sb = new StringBuilder();

    static int f(int start, int mid, int end, int n) {
        if(n==0){
            return 0;
        }
        int prev = f(start, end, mid, n-1);
        sb.append(start).append(" ").append(end).append("\n");
        int next = f(mid, start, end, n-1);

        return prev+1+next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(f(1,2,3, n));
        System.out.print(sb.toString());
    }
}