package cane.brothers.game;

class GuessNumberProvider implements IGuessNumberProvider {

    private final int complexity;
    private final String number;

    GuessNumberProvider(String number, int complexity) {
        this.number = number;
        this.complexity = complexity;
    }

    @Override
    public int[] get() {
        int[] arr = null;
        if (this.number != null) {

            arr = new int[this.number.length()];
            try {
                for (int i = 0; i < number.length(); i++) {
                    arr[i] = Integer.parseInt(number.charAt(i) + "");
                }
            } catch (NumberFormatException ex) {
            }
        }
        return arr;
    }

    @Override
    public int complexity() {
        return this.complexity;
    }
}
