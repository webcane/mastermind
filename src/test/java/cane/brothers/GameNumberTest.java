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
}
