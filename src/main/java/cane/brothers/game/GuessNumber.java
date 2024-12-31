package cane.brothers.game;

/**
 * Created by cane.
 */
class GuessNumber extends AbstractGuessNumber implements IGuessNumber {

    private boolean valid;
    private final String number;

    /**
     * Constructor
     *
     * @param number not null number string
     * @param length game number length
     */
    GuessNumber(String number, int length) {
        super(length);
        this.number = number;
        defineNumber();
    }

    @Override
    protected void defineNumber() {
        if (valid = isGuess()) {
            parseGuess();
        }
    }

    /**
     * @return boolean
     */
    boolean isGuess() {
        // only {max} unique digits is allowed
        return number != null && number.matches("^(?!.*(.).*\\1)\\d{" + getLength() + "}$");
    }

    protected void parseGuess() {
        try {
            for (int i = 0; i < number.length(); i++) {
                digits[i] = Integer.parseInt(number.charAt(i) + "");
            }
        } catch (NumberFormatException ex) {
            this.valid = false;
        }
    }

    /**
     * @return true if the guess valid formatted
     */
    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return this.number;
    }
}
