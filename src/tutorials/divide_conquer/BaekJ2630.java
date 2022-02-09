package tutorials.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJ2630 {
    static int[][] paper;
    static int white = 0, blue = 0;

    static void divide(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (paper[i][j] != paper[y][x]) {
                    divide(n / 2, y, x);
                    divide(n / 2, y + n / 2, x);
                    divide(n / 2, y, x + n / 2);
                    divide(n / 2, y + n / 2, x + n / 2);
                    return ;
                }
            }
        }

        if(paper[y][x] == 0){
            white++;
        }else{
            blue++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
}