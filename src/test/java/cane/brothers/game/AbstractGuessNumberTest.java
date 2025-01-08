package cane.brothers.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AbstractGuessNumberTest {

    @Nested
    class TestIsValid {
        @DisplayName("Test GuessNumber.isValid() for null and empty cases")
        @ParameterizedTest
        @NullAndEmptySource
        void test_isValid_null(String input) {
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, 4));
            assertFalse(guess.isValid());
        }

        @DisplayName("Test GuessNumber.isValid() for negative cases")
        @ParameterizedTest
        @CsvSource({"1111,4",
                "ABCD,4",
                "10000,4",
                "1234,3",
                "12345,4",
                "01234,6"})
        void test_isValid_neg(String input, String expected) {
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, Integer.parseInt(expected)));
            assertFalse(guess.isValid());
        }

        @DisplayName("Test GuessNumber.isValid() for positive cases")
        @ParameterizedTest
        @CsvSource({"123,3",
                "1234,4",
                "0123,4",
                "12345,5",
                "12345678,8"})
        void test_isValid_pos(String input, String expected) {
            IGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, Integer.parseInt(expected)));
            assertTrue(guess.isValid());
        }
    }

    @Nested
    class TestIsGuess {

        @DisplayName("Test GuessNumber.isGuess() for null and empty cases")
        @ParameterizedTest
        @NullAndEmptySource
        void test_isGuess_null(String input) {
            AbstractGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, 4));
            assertFalse(guess.isGuess());
        }

        @DisplayName("Test GuessNumber.isGuess() for positive cases")
        @ParameterizedTest
        @CsvSource({"1234,4",
                "0123,4",
                "12345,5"})
        void test_isGuess_pos(String input, String expected) {
            AbstractGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, Integer.parseInt(expected)));
            assertTrue(guess.isGuess());
        }

        @DisplayName("Test GuessNumber.isGuess() for negative cases")
        @ParameterizedTest
        @CsvSource({"1111,4",
                "ABCD,4",
                "10000,4"})
        void test_isGuess_neg(String input, String expected) {
            AbstractGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, Integer.parseInt(expected)));
            assertFalse(guess.isGuess());
        }
    }

    @Nested
    class TestIsAllDigits {
        @DisplayName("Test AbstractGuessNumber.isAllDigits() for positive cases")
        @Test
        void test_isAllDigits_pos() {
            assertTrue(AbstractGuessNumber.isAllDigits(new int[]{1, 9, 2, 4}));
            assertTrue(AbstractGuessNumber.isAllDigits(new int[]{1, 1, 1, 1}));
            assertTrue(AbstractGuessNumber.isAllDigits(new int[]{0, 0, 0, 0}));
        }

        @DisplayName("Test AbstractGuessNumber.isAllDigits() for negative cases")
        @Test
        void test_isAllDigits_neg() {
            assertFalse(AbstractGuessNumber.isAllDigits(new int[]{-1, 0, 0, 0}));
            assertFalse(AbstractGuessNumber.isAllDigits(new int[]{11, 12, 13, 14}));
            assertFalse(AbstractGuessNumber.isAllDigits(new int[]{'a', 'b', 'c', 'd'}));
        }
    }

    @Nested
    class TestIsUnique {
        @DisplayName("Test AbstractGuessNumber.isUnique() for positive cases")
        @Test
        void test_isUnique_pos() {
            assertTrue(AbstractGuessNumber.isUnique(new int[]{1, 9, 2, 4}));
            assertTrue(AbstractGuessNumber.isUnique(new int[]{0, 1, 2}));
        }

        @DisplayName("Test AbstractGuessNumber.isUnique() for negative cases")
        @Test
        void test_isUnique_neg() {
            assertFalse(AbstractGuessNumber.isUnique(new int[]{1, 1, 1, 1}));
            assertFalse(AbstractGuessNumber.isUnique(new int[]{1, 2, 1}));
        }
    }

    @Nested
    class TestGetDigits {
        @DisplayName("Test GuessNumber.getDigits() for positive cases")
        @ParameterizedTest
        @CsvSource({"123,3",
                "1234,3",
                "1234,4",
                "0123,4",
                "12345,4",
                "01234,5",
                "01234,6"})
        void test_getDigits(String input, String expected) {
            AbstractGuessNumber guess = new GuessNumber(new GuessNumberProvider(input, Integer.parseInt(expected)));
            assertArrayEquals(toDigits(input), guess.getDigits());
        }

        private int[] toDigits(String input) {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}