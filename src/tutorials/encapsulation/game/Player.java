package tutorials.encapsulation.game;

/*
 * This class represents a computer
 * player in the Odd-Even game
 */

import java.util.Random; // import Random to create a random number
import java.util.Scanner;


public class Player {
    private double t;
    private int score;
    private boolean isHuman;

    public Player(boolean isHuman, double threshold) {
        t = threshold;
        score = 0;
        this.isHuman = isHuman;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int play() {
        if (isHuman) {
             return playHuman();
        } else {
            return playComputer();
        }
    }

    private int playHuman() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private int playComputer() {
        int result = 1;
        Random random = new Random();
        double randomNum = random.nextDouble();

        if (randomNum > t) {
            result = 2;
        }
        return result;
    }

    // If the number is greater than t,
    // the computer will declare “two” if the random number is less than t the computer will declare "one".

}