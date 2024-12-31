package cane.brothers.game;

public interface IGameFactory extends IGameNumber {

    IGuessNumber getGuess(String number);

    IResultNumber getResult(IGuessNumber guess);
}
