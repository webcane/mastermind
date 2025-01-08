package cane.brothers.game;

public class AnswerNumberProvider implements IGuessNumberProvider {

    private final int[] answer;

    public AnswerNumberProvider(int[] answer) {
        this.answer = answer;
    }

    @Override
    public int[] get() {
        return this.answer;
    }

    @Override
    public int getComplexity() {
        return this.answer.length;
    }
}
