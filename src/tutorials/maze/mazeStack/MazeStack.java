package tutorials.maze.mazeStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Location {
    public int x;
    public int y;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class MazeStack<rn> {
    static int rn, cn, currentPosition = -1;
    static int[][] maze;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Location[] stack;

    static void push(Location l) {
        currentPosition++;
        stack[currentPosition] = l;
    }

    static boolean isEmpty() {
        return currentPosition < 0;
    }

    static void pop() {
        if (!isEmpty()) {
            currentPosition--;
        }
    }

    static Location top() {
        if (!isEmpty()) {
            return stack[currentPosition];
        } else {
            Location dummy = new Location(-1, -1);
            return dummy;
        }
    }

    static void findPath() {
        Stack<Location> stack = new Stack<>();
        stack.peek();
        Location start = new Location(1, 1);
        Location end = new Location(rn - 2, cn - 2);

        push(start);


        while (!isEmpty()) {
            Location current = top();
            maze[current.y][current.x] = 2;

            if (current.y == end.y && current.x == end.x) {
                break;
            }

            boolean canGo = false;

            for (int i = 0; i < 4; i++) {
                Location next = new Location(current.y + dy[i], current.x + dx[i]);
                if (maze[next.y][next.x] == 0) {
                    push(next);
                    canGo = true;
                    break;
                }
            }

            if (!canGo) {
                maze[current.y][current.x] = 0;
                pop();
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
        stack = new Location[rn * cn];
        maze = new int[rn][cn];
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


