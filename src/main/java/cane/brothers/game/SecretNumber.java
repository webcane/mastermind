package cane.brothers.game;

/**
 * Created by cane.
 */
class SecretNumber extends AbstractGuessNumber implements ISecretNumber {

    SecretNumber(IGuessNumberProvider numberProvider) {
        super(numberProvider);
    }

    @Override
    protected int[] defineNumber(IGuessNumberProvider numberProvider) {
        int fuse = 10;
        int[] temp;
        do {
            temp = numberProvider.get();
        } while (!isGuess(temp) && --fuse > 0);
        return fuse == 0 ? null: temp;
    }

    @Override
    public IGuessResult match(IGuessNumber guessable) {
        int bulls = 0;
        int cows = 0;

        if (guessable != null) {
            for (int i = 0; i < this.complexity(); i++) {
                for (int j = 0; j < guessable.complexity(); j++) {

                    if (getDigits()[i] == guessable.getDigits()[j]) {
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
