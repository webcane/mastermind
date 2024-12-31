package cane.brothers.game;

public interface ISecretNumber extends IGuessNumber {

    IResultNumber match(IGuessNumber guessable);
}
