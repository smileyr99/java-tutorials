package tutorials.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJ1780 {
    static int[][] img;
    static int a = 0, b = 0, c = 0;

    static void QuadTree(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (img[i][j] != img[y][x]) {
                    QuadTree(n / 3, y, x);
                    QuadTree(n / 3, y, x + n / 3);
                    QuadTree(n / 3, y, x + 2 * n / 3);
                    QuadTree(n / 3, y + n / 3, x);
                    QuadTree(n / 3, y + n / 3, x + n / 3);
                    QuadTree(n / 3, y + n / 3, x + 2 * n / 3);
                    QuadTree(n / 3, y + 2 * n / 3, x);
                    QuadTree(n / 3, y + 2 * n / 3, x + n / 3);
                    QuadTree(n / 3, y + 2 * n / 3, x + 2 * n / 3);

                    return;
                }
            }
        }

        if (img[y][x] == -1) {
            a++;
        } else if (img[y][x] == 0) {
            b++;
        } else {
            c++;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                img[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        QuadTree(N, 0, 0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}