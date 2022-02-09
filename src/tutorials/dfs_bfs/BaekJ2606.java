package tutorials.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BaekJ2606 {
    static int n;
    static int m;
    static int v;
    static int cnt = 0;
    static int[][] arr;
    static boolean[] visited;

    static void dfs(int k) {
        visited[k] = true;

        for (int i = 1; i <= n; i++) {
            if (arr[k][i] == 1 && !visited[i]) {
                dfs(i);
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        v = 1;
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        LinkedList[] a = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new LinkedList<Integer>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
            a[x].add(y);
            a[y].add(x);
        }

        br.close();

        dfs(1);
        System.out.println(cnt);
    }
}