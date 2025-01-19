package cane.brothers.game;

class AnswerNumberProvider implements IGuessNumberProvider {

    private final int[] answer;

    AnswerNumberProvider(int[] answer) {
        this.answer = answer;
    }

    @Override
    public int[] get() {
        return this.answer;
    }

    @Override
    public int complexity() {
        return this.answer.length;
    }
}
