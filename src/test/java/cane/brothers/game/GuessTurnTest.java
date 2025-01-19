package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTurnTest {

    @Nested
    class TestComplexity {
        @Test
        void test_getComplexity() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertEquals(result.complexity(), 4);
        }
    }

    @Nested
    class TestIsValid {
        @Test
        void test_isValid() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertTrue(result.isValid());
        }

        @Test
        void test_isValid_neg() {
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            IGuessResult guessResult = new GuessResult(4, 1);
            var result = new GuessTurn(guess, guessResult);
            assertFalse(result.isValid());
        }
    }

    @Nested
    class TestGetBulls {
        @Test
        void test_bulls() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertEquals(result.bulls(), 4);
        }
    }

    @Nested
    class TestGetCows {
        @Test
        void test_cows() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("4321", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertEquals(result.cows(), 4);
        }
    }

    @Nested
    class TestIsWin {
        @Test
        void test_isWin_pos() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertTrue(result.isWin());
        }

        @Test
        void test_isWin_neg() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("4321", 4));
            IGuessResult guessResult = secret.match(guess);
            var result = new GuessTurn(guess, guessResult);
            assertFalse(result.isWin());
        }
    }
}