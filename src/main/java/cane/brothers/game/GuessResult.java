package cane.brothers.game;

/**
 * Created by cane.
 */
class GuessResult extends AbstractGameNumber implements IResultNumber {

    private final int bulls;
    private final int cows;

    GuessResult(int length, int bulls, int cows) {
        super(length);
        if (bulls + cows > length) {
            throw new IllegalArgumentException("Incorrect integrity of the result guess");
        }
        this.bulls = bulls;
        this.cows = cows;
    }

    @Override
    public int getBulls() {
        return bulls;
    }

    @Override
    public int getCows() {
        return cows;
    }

    @Override
    public boolean isWin() {
        return (bulls == getLength());
    }

    @Override
    public String toString() {
        return String.format("GuessResult {bulls=%d, cows=%d}", bulls, cows);
    }
}
