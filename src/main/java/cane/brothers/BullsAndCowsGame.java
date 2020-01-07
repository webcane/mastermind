package cane.brothers;

import console.TextDevice;
import console.TextDevices;

/**
 * Created by cane
 */
public class BullsAndCowsGame implements IGame {

    private final TextDevice io;
    private final GameNumber secret;

    /**
     * Constructor
     *
     * @param secret
     * @param io
     */
    public BullsAndCowsGame(GameNumber secret, TextDevice io) {
        this.secret = secret;
        this.io = io;
    }

    private static void printScore(TextDevice io, GuessResult result) {
        //console.printf("Score %1$d\n", num);
        //console.printf("Bulls=%1$d Cows=%2$d\n", bulls, cows);
        io.printf("How many bulls and cows?%n");
        io.printf("%1$d  %2$d%n", result.getBulls(), result.getCows());
    }

    public static void main(String[] args) {
        new BullsAndCowsGame(new GameNumber(), TextDevices.defaultTextDevice()).play();
    }

    public void play() {
        io.printf("Bulls and Cows%n");
        io.printf("==============%n");

        do {
            GuessNumber guess = readGuess(io, secret.getLength());
            GuessResult result = secret.match(guess);

            printScore(io, result);
            if (result.isWin()) {
                io.printf("The answer is %s", guess);
                break;
            }
        } while (true);
    }

    private GuessNumber readGuess(TextDevice io, int length) {
        do {
            String input = io.readLine();
            checkForExit(input);

            io.printf("My guess is %s%n", input);
            GuessNumber guess = new GuessNumber(input, length);
            if (guess.isValid()) return guess;
        } while (true);
    }

    private void checkForExit(String input) {
        if ("quit".equalsIgnoreCase(input) || "exit".equalsIgnoreCase(input)) {
            System.exit(0);
        }
    }
}
