package tutorials.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJ18258 {
    static int N;
    static int front = -1;
    static int back = -1;
    static int[] queue;

    static void push(int n) {
        queue[++back] = n;
    }

    static int pop() {
        if (back > front) {
            return queue[++front];
        } else {
            return -1;
        }
    }

    static int empty() {
        if (size() <= 0) {
            return 1;
        }
        return 0;
    }

    static int size() {
        return back - front;
    }

    static int front() {
        if (size() <= 0) {
            return -1;
        }
        return queue[front + 1];
    }

    static int back() {
        if (size() <= 0) {
            return -1;
        }
        return queue[back];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        queue = new int[N];

        String input;
        while ((input = br.readLine()) != null) {
            String[] s = input.split(" ");
            switch (s[0]) {
                case "push":
                    push(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }
        br.close();
        System.out.print(sb);

    }
}
