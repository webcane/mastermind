package cane.brothers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cane
 */
public class AutoGuessNumberTest extends Assert {

    @Test
    public void test_parseDigits() {
        AutoGuessNumber guess = new AutoGuessNumber(1234, 4);
        int[] expected = new int[]{1, 2, 3, 4};
        assertArrayEquals(expected, guess.getDigits());

        int arr[] = AutoGuessNumber.parseDigits(123, 4);
        assertEquals(arr.length, 4);
    }
}
