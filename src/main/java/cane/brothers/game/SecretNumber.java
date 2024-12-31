package cane.brothers.game;

import java.util.Random;

/**
 * Created by cane.
 */
class SecretNumber extends AbstractGuessNumber implements ISecretNumber {


    SecretNumber(int length) {
        super(length);
        defineNumber();
    }

    /**
     * only unique digits are allowed
     *
     * @param digits number
     * @return boolean
     */
    static boolean isGuess(int[] digits) {
        return (digits != null && isUnique(digits) && isAllDigits(digits));
    }

    static boolean isAllDigits(int[] array) {
        for (int j : array) {
            char digit = (char) (j + '0');

            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(int[] array) {
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

    static int[] parseDigits(int number, int length) {
        int[] arr = new int[length];
        int temp = number;
        for (int i = length - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp /= 10;
        }
        return arr;
    }

    @Override
    protected void defineNumber() {
        digits = generateRandom();
    }

    @Override
    public IResultNumber match(IGuessNumber guessable) {
        int bulls = 0;
        int cows = 0;

        if (guessable != null) {
            for (int i = 0; i < this.getLength(); i++) {
                for (int j = 0; j < guessable.getLength(); j++) {

                    if (digits[i] == guessable.getDigits()[j]) {
                        if (i == j) {
                            bulls++;
                        } else {
                            cows++;
                        }
                    }
                }
            }
        }
        return new GuessResult(getLength(), bulls, cows);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    private int[] generateRandom() {
        int[] arr;
        do {
            Random random = new Random();
            int number = random.nextInt(9877) + 123;
            arr = parseDigits(number, getLength());
        } while (!isGuess(arr));
        return arr;
    }
}
