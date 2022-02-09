package tutorials.maze.mazeRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeRecursion {
    static final int path = 0;
    static final int visited = 2;
    static final int blocked = 4;
    static int rn, cn;
    static int[][] maze;

    static boolean findPath(int y, int x) {
        if (maze[y][x] != path) {    //새로운 길이 아닐 경우
            return false;
        } else if (y == rn - 2 && x == cn - 2) {    //출구
            maze[y][x] = visited;
            return true;
        } else {
            maze[y][x] = visited;
            // 동서남북으로 이동
            if (findPath(y - 1, x) || findPath(y, x + 1) || findPath(y + 1, x) || findPath(y, x - 1)) {
                return true;
            }else{
                //동서남북으로 갈 길이 없으면
                maze[y][x] = blocked;
                return false;
            }
        }
    }

    static void printMap() {
        for (int y = 0; y < rn; y++) {
            for (int x = 0; x < cn; x++) {
                System.out.print(maze[y][x]);
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
        for (int i = 0; i < rn; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cn; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findPath(1, 1);
        printMap();
    }

}


