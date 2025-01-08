package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StoredGuessGameNumberFactoryTest {

    @Test
    void test_makeTurn() throws GuessTurnException, GuessComplexityException {
        var gameFactory = new StoredGuessGameNumberFactory(new int[] {1,2,3,4});
        var turn = gameFactory.makeTurn("1234");
        assertTrue(turn.isValid());
        assertTrue(turn.isWin());
        assertEquals(turn.bulls(), 4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "12345", "abc", "ABCD"})
    void test_makeTurn_ex(String input) throws GuessComplexityException {
        var gameFactory = new StoredGuessGameNumberFactory(new int[] {1,2,3,4});
        assertThrowsExactly(GuessTurnException.class,
                () -> gameFactory.makeTurn(input));
    }

    @Nested
    class TestTurns {
        @Test
        void test_turns() throws GuessTurnException, GuessComplexityException {
            var gameFactory = new StoredGuessGameNumberFactory(new int[] {7,1,4,3});

            gameFactory.makeTurn("1234");
            assertEquals(gameFactory.getTurns().size(), 1);

            gameFactory.makeTurn("3456");
            assertEquals(gameFactory.getTurns().size(), 2);
        }
    }
}