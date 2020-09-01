package homework.riddle_game;

import design_patterns.template_method.Game;
import design_patterns.template_method.Pair;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Evgeny Borisov
 */
public class RiddleGame implements Game {

    private final int maxLimit;
    private int secretNum;
    private final int MAX_SCORE = 1000;
    private final String playerName;

    private static final Map<String, Integer> playersScore = new HashMap<>();

    public RiddleGame(int max, String name) {
        maxLimit = max;
        playerName = name;
        playersScore.put(name, MAX_SCORE);
    }

    @Override
    public void play() {
        prepareGame();
        gameStart();
        gamePlay();
        gameEnd();
    }

    private void gamePlay() {
        boolean isGameEnded = false;

        while (!isGameEnded) {
            int predictedNum = makeMove();

            updateScore(predictedNum);

            if (predictedNum == secretNum) {
                isGameEnded = true;
            } else if (predictedNum > secretNum) {
                System.out.println(predictedNum + " is greater than hidden number. Try ones again!");
            } else {
                System.out.println(predictedNum + " is less than hidden number. Try ones again!");
            }
        }
    }

    private void gameStart() {
        System.out.println("Hello " + playerName + "!");
    }

    private void gameEnd() {
        System.out.println(playerName + " you win with score " +
                playersScore.get(playerName) + ", congratulations!");
    }

    private void updateScore(int predictedNumber) {
        int diff = Math.abs(predictedNumber - secretNum);
        playersScore.merge(playerName, MAX_SCORE, (x, y) -> x - diff);
    }

    private void prepareGame() {
        secretNum = ThreadLocalRandom.current().nextInt(0, maxLimit + 1);
    }

    private int makeMove() {
        return Integer.parseInt(JOptionPane.showInputDialog("Input your number"));
    }

    public static void printResults() {
        System.out.println("\nFULL TABLE WITH RESULTS:");

        playersScore.forEach((x, y) -> {
            System.out.println("Player " + x + ". Score = " + y);
        });
    }
}
