package cane.brothers.game;

import console.TextDevice;
import console.TextDevices;

/**
 * Created by cane
 */
class BullsAndCowsGame implements IGame {

    private final TextDevice io;
    private final IGuessGameFactory gameFactory;

    /**
     * Constructor
     *
     * @param gameFactory game factory
     * @param io          text device
     */
    BullsAndCowsGame(IGuessGameFactory gameFactory, TextDevice io) {
        this.gameFactory = gameFactory;
        this.io = io;
    }


    public static void main(String[] args) {
        try {
            new BullsAndCowsGame(new StoredGuessGameNumberFactory(4), TextDevices.defaultTextDevice()).play();
        } catch (GuessComplexityException e) {
            System.err.println(e.getMessage());
        }
    }

    public void play() {
        io.printf("Bulls and Cows%n");
        io.printf("==============%n");
        io.printf("Enter a %d digit number: ", gameFactory.complexity());

        do {
            IGuessTurn guessTurn = makeTurn();
            printTurn(guessTurn);
            if (guessTurn.isWin()) {
                io.printf("Win answer is %s%n", guessTurn);
                break;
            }
            io.printf("Make another guess: ");
        } while (true);
    }

    private IGuessTurn makeTurn() {
        do {
            String input = io.readLine();
            checkForExit(input);

            try {
                IGuessTurn guessTurn = gameFactory.makeTurn(input);
                if (guessTurn.isValid()) return guessTurn;
            } catch (GuessTurnException ex) {
                io.printf("%s%n", ex.getMessage());
            }
        } while (true);
    }

    private void printTurn(IGuessTurn guessTurn) {
        io.printf("%1$s%n", guessTurn);
    }

    private void checkForExit(String input) {
        if ("quit".equalsIgnoreCase(input) || "exit".equalsIgnoreCase(input)) {
            System.exit(0);
        }
    }
}
