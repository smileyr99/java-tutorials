package tutorials.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJ11866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int N = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append('<');
        while (queue.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append('>');
        System.out.println(sb);
    }
}