package tutorials.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJ1260 {
    static int n;
    static int m;
    static int v;
    static int[][] arr;
    static boolean[] visited;

    static void dfs(int k) {
        visited[k] = true;
        System.out.print(k + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[k][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while (!queue.isEmpty()) {
            int k = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (arr[k][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        LinkedList[] a = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new LinkedList<Integer>();
        }

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

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs();
    }
}