package cane.brothers.game;

import java.util.Random;

public class SecretNumberProvider implements IGuessNumberProvider {

    private final int complexity;

    private int number;

    public SecretNumberProvider(int complexity) {
        this.complexity = complexity;
    }

    @Override
    public int[] get() {
        Random random = new Random();
        var min = getMinNumber();
        this.number = random.nextInt(getMaxNumber() - min) + min;
        return parseGuess();
    }

    protected int getMinNumber() {
        int min = 0;
        for (int i = 0; i < complexity; i++) {
            min = min * 10 + i;
        }
        return min;
    }

    protected int getMaxNumber() {
        int max = 1;
        for (int i = 1; i <= complexity; i++) {
            max = max * 10;
        }
        return max;
    }

    int[] parseGuess() {
        int[] arr = null;
        if (this.complexity > 0) {
            arr = new int[this.complexity];
            int temp = this.number;
            for (int i = this.complexity - 1; i >= 0; i--) {
                arr[i] = temp % 10;
                temp /= 10;
            }
        }
        return arr;
    }

    @Override
    public int getComplexity() {
        return this.complexity;
    }
}
