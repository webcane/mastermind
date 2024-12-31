package cane.brothers.game;

public interface IResultNumber extends IGameNumber {
    int getBulls();

    int getCows();

    boolean isWin();
}
