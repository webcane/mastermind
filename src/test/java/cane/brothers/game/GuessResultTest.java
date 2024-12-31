package cane.brothers.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {

    @Test
    void test_isWin_pos() {
        int length = 4;
        GuessResult result = new GuessResult(length, length, 0);
        assertTrue(result.isWin());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void test_isWin_negative(int input) {
        int length = 4;
        GuessResult result = new GuessResult(length, input, length - input);
        assertFalse(result.isWin());
    }

    @Test
    void test_guessResultIntegrity() {
        assertThrowsExactly(IllegalArgumentException.class,
                () -> new GuessResult(4, 4, 1));
    }
}