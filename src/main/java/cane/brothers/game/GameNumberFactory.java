package cane.brothers.game;

public class GameNumberFactory implements IGameFactory {

    private final int length;
    protected ISecretNumber secret;

    public GameNumberFactory(int length) {
        this.length = length;
        this.secret = new SecretNumber(this.length);
    }

    @Override
    public IGuessNumber getGuess(String number) {
        return new GuessNumber(number, this.length);
    }

    @Override
    public IResultNumber getResult(IGuessNumber guess) {
        return secret.match(guess);
    }

    @Override
    public int getLength() {
        return this.length;
    }
}
