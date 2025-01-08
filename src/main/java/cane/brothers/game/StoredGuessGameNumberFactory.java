package cane.brothers.game;

import java.util.LinkedList;

public class StoredGuessGameNumberFactory extends GuessGameNumberFactory implements IStoredGuessGameFactory {

    private final LinkedList<IGuessTurn> turns;


    /**
     * Constructor
     *
     * @param secretAnswer not null secret
     */
    public StoredGuessGameNumberFactory(int[] secretAnswer) throws GuessComplexityException {
        super(secretAnswer.length);
        this.secret = new SecretNumber(new AnswerNumberProvider(secretAnswer));
        this.turns = new LinkedList<>();
    }

    @Override
    protected void processTurn() {
        turns.add(super.guessTurn);
    }

    @Override
    public LinkedList<IGuessTurn> getTurns() {
        return turns;
    }
}
