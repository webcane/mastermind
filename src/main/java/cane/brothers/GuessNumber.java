package cane.brothers;

/**
 * Created by cane.
 */
public class GuessNumber extends AbstractGuessNumber {

    private boolean valid;
    private String number;

    /**
     * Constructor
     *
     * @param number not null number string
     * @param lenght game number length
     */
    public GuessNumber(String number, int lenght) {
        super(number.length());
        this.number = number;

        if (valid = isGuess(number, lenght)) {
            parseGuess(number, this.digits);
        }
    }

    /**
     * @param text
     * @param max  number of digits
     * @return
     */
    public static boolean isGuess(String text, int max) {
        // only {max} unique digits is allowed
        return text.matches("^(?!.*(.).*\\1)\\d{" + max + "}$");
    }

    protected void parseGuess(String text, int[] digits) {
        //int[] digits = new int[text.length()];
        try {
            for (int i = 0; i < text.length(); i++) {
                digits[i] = Integer.parseInt(text.charAt(i) + "");
            }
        } catch (NumberFormatException ex) {
            this.valid = false;
        }
    }

    /**
     * @return true if the guess valid formatted
     */
    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return this.number;
    }
}
