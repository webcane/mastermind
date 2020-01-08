package cane.brothers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cane
 */
public class GameNumberTest extends Assert {

    @Test
    public void test_parseDigits() {
        int[] result = GameNumber.parseDigits(1234, 4);
        int[] expected = new int[]{1, 2, 3, 4};
        assertArrayEquals(expected, result);
    }

    @Test
    public void test_isUnique() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = GameNumber.isUnique(data);
        assertTrue(result);

        data = new int[]{6, 1, 3, 6};
        result = GameNumber.isUnique(data);
        assertFalse(result);
    }

    @Test
    public void test_isAllDigits() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = GameNumber.isAllDigits(data);
        assertTrue(result);

        data = new int[]{11, 12, 13, 14};
        result = GameNumber.isAllDigits(data);
        assertFalse(result);

        data = new int[]{1, 2, 3, 0xA};
        result = GameNumber.isAllDigits(data);
        assertFalse(result);
    }

    @Test
    public void test_isGuess() {
        int[] data = new int[]{1, 2, 3, 4};
        boolean result = GameNumber.isGuess(data);
        assertTrue(result);

        result = GameNumber.isGuess(null);
        assertFalse(result);
    }

}
