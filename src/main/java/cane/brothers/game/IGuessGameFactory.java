package cane.brothers.game;

public interface IGuessGameFactory extends IGameNumber {

    IGuessTurn makeTurn(String number) throws GuessTurnException;

}
