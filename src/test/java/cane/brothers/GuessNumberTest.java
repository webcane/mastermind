package cane.brothers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by cane
 */
public class GuessNumberTest extends Assert {

    @Test
    public void test_isGuess() {
        boolean result = GuessNumber.isGuess("1234", 4);
        boolean expected = true;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("1111", 4);
        expected = false;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("0123", 4);
        expected = true;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("ABCD", 4);
        expected = false;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("10000", 4);
        expected = false;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("1234", 3);
        expected = false;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("12345", 5);
        expected = true;
        assertEquals(expected, result);

        result = GuessNumber.isGuess("12345", 4);
        expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void test_parseGuess() {
        GuessNumber guess = new GuessNumber("1234", 4);
        int[] expected = new int[]{1, 2, 3, 4};
        assertArrayEquals(expected, guess.getDigits());

        guess = new GuessNumber("12345", 4);
        assertFalse(Arrays.equals(expected, guess.getDigits()));

        guess = new GuessNumber("01234", 5);
        expected = new int[]{0, 1, 2, 3, 4};
        assertArrayEquals(expected, guess.getDigits());
    }
}
