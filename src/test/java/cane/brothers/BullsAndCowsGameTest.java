package cane.brothers;

import console.TextDevice;
import console.TextDevices;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by cane
 */
public class BullsAndCowsGameTest extends Assert {

    @Test
    public void test_BullsAndCows_game() {
        final int[] answer = new int[]{1, 9, 2, 4};
        final String input = "qwerty\n1234\n1253\n1624\n1724\n1824\n1924\n";

        GameNumber secret = new GameNumber() {
            @Override
            protected void defineNumber() {
                this.digits = answer;
            }
        };
        BufferedReader reader = new BufferedReader(new StringReader(input));
        PrintWriter writer = new PrintWriter(System.out, true);

        TextDevice fake = TextDevices.characterDevice(reader, writer);
        BullsAndCowsGame game = new BullsAndCowsGame(secret, fake);

        game.play();
    }
}