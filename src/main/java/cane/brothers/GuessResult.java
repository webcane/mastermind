package cane.brothers;

/**
 * Created by cane.
 */
public class GuessResult {

    private static int guessNum = 0;
    private int bulls;
    private int cows;
    private int length;

    public GuessResult(int length, int bulls, int cows) {
        this.length = length;
        this.bulls = bulls;
        this.cows = cows;
        guessNum++;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public boolean isWin() {
        return (bulls == length);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GuessResult {");
        sb.append("bulls=").append(bulls);
        sb.append(", cows=").append(cows);
        sb.append('}');
        return sb.toString();
    }

    /**
     * @return serial number
     */
    public int getId() {
        return guessNum;
    }
}
