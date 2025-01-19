package cane.brothers.game;

import java.util.Arrays;

/**
 * Created by cane
 */
abstract class AbstractGuessNumber implements IGuessNumber {

    private final int[] digits;

    private final int complexity;

    AbstractGuessNumber(IGuessNumberProvider numberProvider) {
        this.digits = defineNumber(numberProvider);
        this.complexity = numberProvider.complexity();
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

    protected int[] defineNumber(IGuessNumberProvider numberProvider) {
        return numberProvider.get();
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
        return this.digits != null && this.digits.length == complexity() && isGuess(this.digits);
    }

    protected boolean isGuess(int[] array) {
        return isUnique(array) && isAllDigits(array) && array[0] > 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.digits);
    }

    @Override
    public int complexity() {
        return this.complexity;
    }
}
