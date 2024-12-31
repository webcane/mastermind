package cane.brothers.game;

import console.TextDevice;
import console.TextDevices;

/**
 * Created by cane
 */
public class BullsAndCowsGame implements IGame {

    private final TextDevice io;
    private final IGameFactory gameFactory;

    /**
     * Constructor
     *
     * @param gameFactory game factory
     * @param io text device
     */
    public BullsAndCowsGame(IGameFactory gameFactory, TextDevice io) {
        this.gameFactory = gameFactory;
        this.io = io;
    }

    private static void printScore(TextDevice io, IResultNumber result) {
        io.printf("How many bulls and cows?%n");
        io.printf("%1$d  %2$d%n", result.getBulls(), result.getCows());
    }

    public static void main(String[] args) {
        new BullsAndCowsGame(new GameNumberFactory(4), TextDevices.defaultTextDevice()).play();
    }

    public void play() {
        io.printf("Bulls and Cows%n");
        io.printf("==============%n");
        io.printf("Enter a %d digit number%n", gameFactory.getLength());

        do {
            IGuessNumber guess = readGuess(io);
            IResultNumber result = gameFactory.getResult(guess);

            printScore(io, result);
            if (result.isWin()) {
                io.printf("The answer is %s%n", guess);
                break;
            }
        } while (true);
    }

    private IGuessNumber readGuess(TextDevice io) {
        do {
            String input = io.readLine();
            checkForExit(input);

            io.printf("My guess is %s%n", input);
            IGuessNumber guess = this.gameFactory.getGuess(input);
            if (guess.isValid()) return guess;
        } while (true);
    }

    private void checkForExit(String input) {
        if ("quit".equalsIgnoreCase(input) || "exit".equalsIgnoreCase(input)) {
            System.exit(0);
        }
    }
}
