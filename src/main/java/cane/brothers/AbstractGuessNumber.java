package cane.brothers;

/**
 * Created by cane
 */
public abstract class AbstractGuessNumber {

    protected int[] digits;
    private int length;

    public AbstractGuessNumber(int length) {
        this.length = length;
        this.digits = new int[this.length];
    }

    public int[] getDigits() {
        return digits;
    }

    public int getLength() {
        return length;
    }
}
