package cane.brothers.game;

import java.util.LinkedList;

public class StoredGuessGameNumberFactory extends GuessGameNumberFactory implements IStoredGuessGameFactory {

    private final LinkedList<IGuessTurn> turns = new LinkedList<>();


    public StoredGuessGameNumberFactory(int complexity) throws GuessComplexityException {
        super(complexity);
    }

    /**
     * Constructor
     *
     * @param secretAnswer not null secret
     */
    public StoredGuessGameNumberFactory(int[] secretAnswer) throws GuessComplexityException {
        this(secretAnswer.length);
        this.secret = new SecretNumber(new AnswerNumberProvider(secretAnswer));
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
