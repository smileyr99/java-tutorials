package tutorials.encapsulation.game;

import java.util.Scanner;

/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that adavantage.
 */


public class Simulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 1000;
        double k = 0.1;

        int p1WIn, p2Win, tie;

        for (int i = 0; i < cnt; i++) {
            p1WIn = 0;
            p2Win = 0;
            tie = 0;
            for (double t1 = 0.0; t1 < 1.0; t1 += k) {
                for (double t2 = 0.0; t2 < 1.0; t2 += k) {
                    Game g = new Game(t1, t2);
                    g.play(1000);
                    if (g.getP1Score() > g.getP2Score()) {
                        p1WIn++;
                    } else if (g.getP1Score() < g.getP2Score()) {
                        p2Win++;
                    } else {
                        tie++;
                    }
                }
            }
            System.out.printf("p1Win: %d, p2Win: %d, tie: %d\n", p1WIn, p2Win, tie);
        }

    }
}