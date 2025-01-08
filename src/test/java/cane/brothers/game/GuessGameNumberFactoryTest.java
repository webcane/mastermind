package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GuessGameNumberFactoryTest {

    @Test
    void test_makeTurn() throws GuessTurnException, GuessComplexityException {
        var gameFactory = new GuessGameNumberFactory(4);
        var turn = gameFactory.makeTurn("1234");
        assertTrue(turn.isValid());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "12345", "abc", "ABCD"})
    void test_makeTurn_ex(String input) throws GuessComplexityException {
        var gameFactory = new GuessGameNumberFactory(4);
        assertThrowsExactly(GuessTurnException.class,
                () -> gameFactory.makeTurn(input));
    }

    @Nested
    class TestGuessComplexityException {

        @ParameterizedTest
        @ValueSource(ints = {1, 4, 8, 9})
        void test_complexity_pos(int input) throws GuessComplexityException {
            var gameFactory = new GuessGameNumberFactory(input);
            assertNotNull(gameFactory);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 10})
        void test_complexity_neg(int input) {
            assertThrowsExactly(GuessComplexityException.class, () -> new GuessGameNumberFactory(input));
        }
    }
}