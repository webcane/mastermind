package cane.brothers;

import console.TextDevice;
import console.TextDevices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cane.
 */
public class PlayerGame implements IGame {

    private static int count;
    private final TextDevice io;
    private final GameNumber secret;
    private List<AutoGuessNumber> pool = new ArrayList<>();

    /**
     * Constructor
     *
     * @param secret
     * @param io
     */
    public PlayerGame(GameNumber secret, TextDevice io) {
        this.secret = secret;
        this.io = io;
        fillPool();
    }

    public static void main(String[] args) {
        new PlayerGame(new GameNumber(), TextDevices.defaultTextDevice()).play();
    }

    private static void printScore(TextDevice io, GuessResult result) {
        //console.printf("Score %1$d\n", num);
        //console.printf("Bulls=%1$d Cows=%2$d\n", bulls, cows);
        io.printf("%1$d  %2$d%n", result.getBulls(), result.getCows());
    }

    @Override
    public void play() {
        io.printf("Bulls and Cows%n");
        io.printf("==============%n");
        io.printf("Secret number is %s%n", secret);

        do {
            AutoGuessNumber guess = guessNumber();
            io.printf("Guess #%d is %s from %d%n", count, guess, pool.size());

            GuessResult result = secret.match(guess);
            if (result != null) {
                printScore(io, result);

                if (result.isWin()) {
                    io.printf("The answer is %s%n", guess);
                    break;
                }

                clearPool(guess, result);
            } else {
                io.printf("No more variants%n");
                System.exit(0);
            }
        } while (true);
    }

    private void fillPool() {
        for (int i = 123; i < 9877; i++) {
            int[] arr = AutoGuessNumber.parseDigits(i, 4);

            if (GameNumber.isGuess(arr)) {
                pool.add(new AutoGuessNumber(i, 4));
            }
        }
    }

    private AutoGuessNumber guessNumber() {
        Random random = new Random();
        if (pool.size() > 0) {
            int number = random.nextInt(pool.size());
            count++;
            return pool.get(number);
        }
        return null;
    }

    private void clearPool(AutoGuessNumber guess, GuessResult guessResult) {
        pool.remove(guess);

        for (int i = 0; i < pool.size(); i++) {
            AutoGuessNumber g = pool.get(i);
            GuessResult gr = guess.match(g);

            if (!guessResult.equals(gr)) {
                pool.remove(g);
            }
        }
    }

}
