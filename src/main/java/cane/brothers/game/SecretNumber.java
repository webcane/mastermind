package cane.brothers.game;

/**
 * Created by cane.
 */
class SecretNumber extends AbstractGuessNumber implements ISecretNumber {

    SecretNumber(IGuessNumberProvider numberProvider) {
        super(numberProvider);
    }

    @Override
    protected void defineNumber() {
        int fuse = 5;
        do {
            this.digits = numberProvider.get();
        } while (!isGuess() && --fuse > 0);
    }

    @Override
    public IGuessResult match(IGuessNumber guessable) {
        int bulls = 0;
        int cows = 0;

        if (guessable != null) {
            for (int i = 0; i < this.getComplexity(); i++) {
                for (int j = 0; j < guessable.getComplexity(); j++) {

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

        return new GuessResult(bulls, cows);
    }
}
