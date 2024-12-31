package cane.brothers.game;

/**
 * Created by cane
 */
abstract class AbstractGuessNumber extends AbstractGameNumber implements IGuessNumber {

    protected int[] digits;

    public AbstractGuessNumber(int length) {
        super(length);
        this.digits = new int[length];
    }

    @Override
    public int[] getDigits() {
        return digits;
    }

    abstract protected void defineNumber();
}
