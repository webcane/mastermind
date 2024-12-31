package cane.brothers.game;

import console.TextDevice;
import console.TextDevices;
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by cane
 */
public class BullsAndCowsGameTest {

    @Test
    public void test_BullsAndCows_game() {
        final String input = "qwerty\n1234\n1253\n1624\n1724\n1824\n1924\n";

        IGameFactory gameFactory = new StoredGameNumberFactory(new int[]{1, 9, 2, 4});
        BufferedReader reader = new BufferedReader(new StringReader(input));
        PrintWriter writer = new PrintWriter(System.out, true);

        TextDevice fake = TextDevices.characterDevice(reader, writer);
        IGame game = new BullsAndCowsGame(gameFactory, fake);

        game.play();
    }
}