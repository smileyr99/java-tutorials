package tutorials.encapsulation.game;

/**
 * This class represents the Odd-Even game
 */

public class Game {

    // **** Instance variables
    private Player p1;
    private Player p2;


    /* this version of the game constructor is for Part 1
     * it takes no parameters */
    public Game() {
        p1 = new Player(true, 0.5);
        p2 = new Player(false, 0.5);
    }

    /* this version of the game constructor is for Part 2
     * It requires two doubles as parameters. You will use
     * these to set the initial thresholds for you computer players */
    public Game(double t1, double t2) {
        p1 = new Player(false, t1);
        p2 = new Player(false, t2);
    }

    /* this version of the play method is for Part 1
     * It takes no parameters and should play one interactive
     * version of the game */
    public void play() {
        int sum = p1.play() + p2.play();
        if (sum % 2 != 0) {
            p1.setScore(p1.getScore() + sum);
            p2.setScore(p2.getScore() - sum);
        } else {
            p1.setScore(p1.getScore() - sum);
            p2.setScore(p2.getScore() + sum);
        }
    }

    /**
     * this version of the play method is for Part 2
     * It takes a single int as a parameter which is the
     * number of computer vs. computer games that should be played
     */
    public void play(int games) {
        for (int i = 0; i < games; i++) {
            play();
        }
    }

    /* this method should return the current score (number of tokens)
     * that player 1 has */
    public int getP1Score() {
        return p1.getScore();
    }

    /* this method should return the current score (number of tokens)
     * that player 2 has */
    public int getP2Score() {
        return p2.getScore();
    }


    // you may or may not want more methods here:


}