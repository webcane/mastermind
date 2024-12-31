package cane.brothers.game;

public class StoredGameNumberFactory extends GameNumberFactory {

    public StoredGameNumberFactory(int[] answer) {
        super(answer.length);
        this.secret = new SecretNumber(getLength()) {
            @Override
            protected void defineNumber() {
                this.digits = answer;
            }
        };
    }
}
