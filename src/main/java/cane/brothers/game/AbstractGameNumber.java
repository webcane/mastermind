package cane.brothers.game;

abstract class AbstractGameNumber implements IGameNumber {

    private final int length;

    public AbstractGameNumber(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }
}
