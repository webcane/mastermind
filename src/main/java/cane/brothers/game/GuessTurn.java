package cane.brothers.game;

class GuessTurn implements IGuessTurn {

    private final IGuessNumber guess;
    private final IGuessResult guessResult;

    GuessTurn(IGuessNumber guess, IGuessResult guessResult) {
        this.guess = guess;
        this.guessResult = guessResult;
    }

    @Override
    public int complexity() {
        return this.guess.complexity();
    }

    @Override
    public int[] getDigits() {
        return this.guess.getDigits();
    }

    @Override
    public boolean isValid() {
        return this.guess.isValid() && this.guessResult.bulls() + this.guessResult.cows() <= complexity();
    }

    @Override
    public int bulls() {
        return this.guessResult.bulls();
    }

    @Override
    public int cows() {
        return this.guessResult.cows();
    }

    @Override
    public boolean isWin() {
        return guessResult.bulls() == complexity();
    }

    @Override
    public String toString() {
        return isWin() ? String.format("%s", guess) : String.format("%d bulls, %d cows", guessResult.bulls(), guessResult.cows());
    }
}
