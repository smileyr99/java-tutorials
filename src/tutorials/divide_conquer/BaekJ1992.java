package tutorials.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJ1992 {
    static int[][] img;
    public static StringBuilder sb = new StringBuilder();
    static int white = 0, blue = 0;

    static void QuadTree(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (img[i][j] != img[y][x]) {
                    sb.append('(');
                    QuadTree(n / 2, y, x);
                    QuadTree(n / 2, y, x + n / 2);
                    QuadTree(n / 2, y + n / 2, x);
                    QuadTree(n / 2, y + n / 2, x + n / 2);
                    sb.append(')');
                    return;
                }
            }
        }

        if (img[y][x] == 0) {
            sb.append('0');
        } else {
            sb.append('1');
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        QuadTree(N, 0, 0);
        System.out.println(sb);

    }
}