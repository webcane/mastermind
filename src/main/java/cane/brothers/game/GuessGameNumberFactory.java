package cane.brothers.game;

public class GuessGameNumberFactory implements IGuessGameFactory, IGameNumber {

    private int complexity;
    protected ISecretNumber secret;
    protected IGuessNumber guess;
    protected IGuessTurn guessTurn;

    public GuessGameNumberFactory(int complexity) throws GuessComplexityException {
        setComplexity(complexity);
        this.secret = new SecretNumber(new SecretNumberProvider(complexity));
    }

    @Override
    public IGuessTurn makeTurn(String number) throws GuessTurnException {
        if (number == null || number.length() != complexity()) {
            throw new GuessTurnException("Guess length must be: " + complexity());
        }

        guess = new GuessNumber(new GuessNumberProvider(number, complexity()));
        if (guess.isValid()) {

            var result = secret.match(guess);
            guessTurn = new GuessTurn(guess, result);

            if (guessTurn.isValid()) {
                processTurn();
                return guessTurn;
            } else {
                throw new GuessTurnException("Incorrect integrity of the guess result");
            }
        } else {
            throw new GuessTurnException("Invalid guess format. Try again");
        }
    }

    @Override
    public int complexity() {
        return complexity;
    }

    private void setComplexity(int complexity) throws GuessComplexityException {
        if (complexity < 1 || complexity > 9) {
            throw new GuessComplexityException();
        }
        this.complexity = complexity;
    }

    protected void processTurn() {
    }

}
