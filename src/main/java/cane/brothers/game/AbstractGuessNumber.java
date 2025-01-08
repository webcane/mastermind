package cane.brothers.game;

import java.util.Arrays;

/**
 * Created by cane
 */
abstract class AbstractGuessNumber implements IGuessNumber {

    protected int[] digits;

    protected IGuessNumberProvider numberProvider;

    public AbstractGuessNumber(IGuessNumberProvider numberProvider) {
        this.numberProvider = numberProvider;
        defineNumber();
    }

    protected void defineNumber() {
        this.digits = numberProvider.get();
    }

    @Override
    public int[] getDigits() {
        return digits;
    }

    /**
     * only unique digits are allowed
     *
     * @return boolean
     */
    @Override
    public boolean isValid() {
        return isGuess() && this.digits != null && this.digits.length == getComplexity();
    }

    protected boolean isGuess() {
        return isUnique(this.digits) && isAllDigits(this.digits);
    }

    static boolean isAllDigits(int[] array) {
        if (array == null || array.length < 1)
            return false;

        for (int j : array) {
            char digit = (char) (j + '0');

            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(int[] array) {
        if (array == null || array.length < 1)
            return false;

        for (int j = 0; j < array.length; j++) {
            int a = array[j];

            for (int i = 0; i < j; i++) {
                if (a == array[i]) {
                    // seen this int before
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.digits);
    }

    @Override
    public int getComplexity() {
        return this.numberProvider.getComplexity();
    }
}
