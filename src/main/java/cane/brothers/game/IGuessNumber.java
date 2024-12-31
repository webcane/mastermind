package cane.brothers.game;

public interface IGuessNumber extends IGameNumber {

    int[] getDigits();

    boolean isValid();
}
