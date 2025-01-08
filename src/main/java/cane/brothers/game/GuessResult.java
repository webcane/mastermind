package cane.brothers.game;

/**
 * Created by cane.
 */
record GuessResult(int bulls, int cows) implements IGuessResult {

    @Override
    public String toString() {
        return String.format("bulls=%d, cows=%d", bulls, cows);
    }
}
