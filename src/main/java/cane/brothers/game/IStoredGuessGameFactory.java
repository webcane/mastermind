package cane.brothers.game;

import java.util.LinkedList;

public interface IStoredGuessGameFactory extends IGuessGameFactory, IGameNumber {

    LinkedList<IGuessTurn> getTurns();
}
