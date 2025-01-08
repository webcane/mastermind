package cane.brothers.game;

public interface ISecretNumber extends IGuessNumber {

    IGuessResult match(IGuessNumber guessable);
}
