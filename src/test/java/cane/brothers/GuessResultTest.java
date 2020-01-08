package cane.brothers;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cane.
 */
public class GuessResultTest extends Assert {

    @Test
    public void test_Equals() {
        GuessResult result1 = new GuessResult(4, 0, 0);
        GuessResult result2 = new GuessResult(4, 0, 0);
        assertTrue(result1.equals(result2));

        GuessResult result3 = new GuessResult(4, 1, 2);
        assertFalse(result1.equals(result3));
    }
}