package cane.brothers.game;

public class GuessComplexityException extends Exception {

    GuessComplexityException() {
        super("Complexity must be between 1 and 9");
    }
}
