package cane.brothers.game;

class GuessTurn implements IGuessTurn {

    private final IGuessNumber guess;
    private final int bulls;
    private final int cows;

    public GuessTurn(IGuessNumber guess, IGuessResult guessResult) {
        this.guess = guess;
        this.bulls = guessResult.bulls();
        this.cows = guessResult.cows();
    }

    @Override
    public int getComplexity() {
        return this.guess.getComplexity();
    }

    @Override
    public boolean isValid() {
        return this.guess.isValid() && this.bulls + this.cows <= getComplexity();
    }

    @Override
    public int bulls() {
        return this.bulls;
    }

    @Override
    public int cows() {
        return this.cows;
    }

    @Override
    public boolean isWin() {
        return bulls == getComplexity();
    }

    @Override
    public String toString() {
        return String.format("bulls=%d, cows=%d", bulls, cows);
    }
}
