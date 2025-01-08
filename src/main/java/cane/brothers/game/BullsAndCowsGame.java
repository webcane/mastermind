package cane.brothers.game;

import console.TextDevice;
import console.TextDevices;

/**
 * Created by cane
 */
public class BullsAndCowsGame implements IGame {

    private final TextDevice io;
    private final IGuessGameFactory gameFactory;

    /**
     * Constructor
     *
     * @param gameFactory game factory
     * @param io          text device
     */
    public BullsAndCowsGame(IGuessGameFactory gameFactory, TextDevice io) {
        this.gameFactory = gameFactory;
        this.io = io;
    }


    public static void main(String[] args) {
        try {
            new BullsAndCowsGame(new GuessGameNumberFactory(8), TextDevices.defaultTextDevice()).play();
        } catch (GuessComplexityException e) {
            System.err.println(e.getMessage());
        }
    }

    public void play() {
        io.printf("Bulls and Cows%n");
        io.printf("==============%n");
        io.printf("Enter a %d digit number%n", gameFactory.getComplexity());

        do {
            IGuessTurn guessTurn = makeTurn();
            printTurn(guessTurn);
            if (guessTurn.isWin()) {
                io.printf("The answer is %s%n", guessTurn);
                break;
            }
        } while (true);
    }

    private IGuessTurn makeTurn() {
        do {
            String input = io.readLine();
            checkForExit(input);

            io.printf("My guess is %s%n", input);
            try {
                IGuessTurn guessTurn = gameFactory.makeTurn(input);
                if (guessTurn.isValid()) return guessTurn;
            } catch (GuessTurnException ex) {
                io.printf("%s%n", ex.getMessage());
            }
        } while (true);
    }

    private void printTurn(IGuessTurn guessTurn) {
        // io.printf("How many bulls and cows?%n");
        io.printf("%1$d  %2$d%n", guessTurn.bulls(), guessTurn.cows());
    }

    private void checkForExit(String input) {
        if ("quit".equalsIgnoreCase(input) || "exit".equalsIgnoreCase(input)) {
            System.exit(0);
        }
    }
}
