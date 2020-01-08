package cane.brothers;

import console.TextDevice;
import console.TextDevices;
import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cane
 */
public class PlayerGameTest extends Assert {

    @Test
    public void test_BullsAndCows_game() {
        final int[] answer = new int[]{1, 9, 2, 4};

        GameNumber secret = new GameNumber() {
            @Override
            protected void defineNumber() {
                this.digits = answer;
            }
        };
        PrintWriter writer = new PrintWriter(System.out, true);

        TextDevice fake = TextDevices.characterDevice(null, writer);
        PlayerGame game = new PlayerGame(secret, fake);

        game.play();
    }


    @Test
    public void test_asd() {
        List<AutoGuessNumber> pool = new ArrayList<>();
        Random random = new Random();
        int number = random.nextInt(pool.size());
        assertNull(pool.get(number));
    }
}