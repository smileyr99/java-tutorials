package tutorials.maze.mazeQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    public int x;
    public int y;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class MazeQueue {
    static int rn, cn;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void findPath() {
        Queue<Location> queue = new LinkedList<Location>();
        Location start = new Location(1, 1);
        Location end = new Location(rn - 2, cn - 2);

        queue.add(start);
        maze[start.y][start.x] = 2;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.y == end.y && current.x == end.x) {
                while (maze[current.y][current.x] != 2){
                    for (int i = 0; i < 4; i++) {
                        Location path = new Location(current.y + dy[i], current.x + dx[i]);
                        if (maze[current.y][current.x] - 1 == maze[path.y][path.x]) {
                            maze[current.y][current.x] = -1;
                            current = path;
                            break;
                        }
                    }
                }
                maze[current.y][current.x] = -1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                Location next = new Location(current.y + dy[i], current.x + dx[i]);
                //이미 방문했던 점이거나 벽
                if (visited[next.y][next.x] || maze[next.y][next.x] != 0) {
                    continue;
                }
                queue.add(new Location(next.y, next.x));
                maze[next.y][next.x] = maze[current.y][current.x] + 1;
                visited[next.y][next.x] = true;
            }
        }
    }

    static void printMap() {
        for (int y = 0; y < rn; y++) {
            for (int x = 0; x < cn; x++) {
                if(maze[y][x] == 1){
                    System.out.print(1);
                }else if(maze[y][x] == -1){
                    System.out.print(2);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rn = Integer.parseInt(st.nextToken());
        cn = Integer.parseInt(st.nextToken());

        maze = new int[rn][cn];
        visited = new boolean[rn][cn];

        for (int i = 0; i < rn; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cn; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findPath();
        printMap();
    }
}
