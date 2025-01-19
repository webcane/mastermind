package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by cane
 */
class SecretNumberTest {

    @Nested
    class TestDefineRandomNumber {
        @Test
        public void test_defineNumber() {
            SecretNumber secret = new SecretNumber(new SecretNumberProvider(4));
            var result = secret.defineNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            assertEquals(result.length, 4);
        }

        @Test
        public void test_defineNumber_neg() {
            SecretNumber secret = new SecretNumber(new SecretNumberProvider(4));
            var result = secret.defineNumber(new AnswerNumberProvider(new int[]{1, 1, 1, 1}));
            assertNull(result);
        }
    }

    @Nested
    class TestBulls {
        @Test
        public void test_match_all_bulls() {
            ISecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            var result = secret.match(guess);
            assertEquals(result.bulls(), 4);
        }

        @Test
        public void test_match_no_bulls() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{9, 8, 7, 6}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            var result = secret.match(guess);
            assertEquals(result.bulls(), 0);
        }
    }

    @Nested
    class TestCows {
        @Test
        public void test_match_all_cows() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{1, 2, 3, 4}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("4321", 4));
            var result = secret.match(guess);
            assertEquals(result.cows(), 4);
        }

        @Test
        public void test_match_no_cows() {
            SecretNumber secret = new SecretNumber(new AnswerNumberProvider(new int[]{9, 8, 7, 6}));
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider("1234", 4));
            var result = secret.match(guess);
            assertEquals(result.cows(), 0);
        }
    }
}
