package cane.brothers.game;

public interface IGuessTurn extends IGuessResult, IGameNumber {

    boolean isWin();

    boolean isValid();
}
