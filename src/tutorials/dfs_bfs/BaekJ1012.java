package tutorials.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int r;
    int c;

    Location(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BaekJ1012 {
    static int M;
    static int N;
    static int K;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    static void bfs(int r, int c) {
        Queue<Location> queue = new LinkedList<>();
        Location v = new Location(r, c);
        queue.add(v);
        visited[v.r][v.c] = true;


        while (!queue.isEmpty()) {
            Location l = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = l.r + dr[i];
                int nc = l.c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
                    if (map[nr][nc] == 1 && !visited[nr][nc]) {
                        Location nl = new Location(nr,nc);
                        queue.add(nl);
                        visited[nl.r][nl.c] = true;

                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];


            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }


            int cnt = 0; //구역의 수

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}