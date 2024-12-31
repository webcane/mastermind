package cane.brothers.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by cane
 */
public class SecretNumberTest {

    @Test
    public void test_parseDigits() {
        int[] result = SecretNumber.parseDigits(1234, 4);
        int[] expected = new int[]{1, 2, 3, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_isUnique() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = SecretNumber.isUnique(data);
        assertTrue(result);

        data = new int[]{6, 1, 3, 6};
        result = SecretNumber.isUnique(data);
        assertFalse(result);
    }

    @Test
    public void test_isAllDigits() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = SecretNumber.isAllDigits(data);
        assertTrue(result);

        data = new int[]{11, 12, 13, 14};
        result = SecretNumber.isAllDigits(data);
        assertFalse(result);

        data = new int[]{1, 2, 3, 0xA};
        result = SecretNumber.isAllDigits(data);
        assertFalse(result);
    }

    @Test
    public void test_isGuess() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = SecretNumber.isGuess(data);
        assertTrue(result);

        result = SecretNumber.isGuess(null);
        assertFalse(result);
    }

}
