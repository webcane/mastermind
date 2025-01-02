package cane.brothers.game;

public interface IGameFactory extends IGameNumber {

    ISecretNumber getSecret();

    IGuessNumber getGuess(String number);

    IResultNumber getResult(IGuessNumber guess);
}
