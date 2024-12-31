package cane.brothers.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by cane
 */
public class GuessNumberTest {

    @Nested
    class TestIsGuess {
        @DisplayName("Test GuessNumber.isGuess() for positive cases")
        @ParameterizedTest
        @CsvSource({"1234,4",
                "0123,4",
                "12345,5"})
        void test_isGuess_pos(String input, String expected) {
            GuessNumber guess = new GuessNumber(input, Integer.parseInt(expected));
            assertTrue(guess.isGuess());
        }

        @DisplayName("Test GuessNumber.isGuess() for negative cases")
        @ParameterizedTest
        @CsvSource({"1111,4",
                "ABCD,4",
                "10000,4",
                "1234,3",
                "12345,4"})
        void test_isGuess_neg(String input, String expected) {
            GuessNumber guess = new GuessNumber(input, Integer.parseInt(expected));
            assertFalse(guess.isGuess());
        }

        @DisplayName("Test GuessNumber.isGuess() for null and empty cases")
        @ParameterizedTest
        @NullAndEmptySource
        void test_isGuess_null(String input) {
            GuessNumber guess = new GuessNumber(input, 4);
            assertFalse(guess.isGuess());
        }
    }

    @Nested
    class TestParseGuess {
        @DisplayName("Test GuessNumber.parseGuess() for positive cases")
        @ParameterizedTest
        @ValueSource(strings = {"123", "1234", "0123", "01234"})
        void test_parseGuess_pos(String input) {
            GuessNumber guess = new GuessNumber(input, input.length());
            assertArrayEquals(toDigits(input), guess.getDigits());
        }

        @DisplayName("Test GuessNumber.parseGuess() for negative cases")
        @ParameterizedTest
        @CsvSource({"1234,3",
                "12345,4",
                "01234,6"})
        void test_parseGuess_(String input, String expected) {
            GuessNumber guess = new GuessNumber(input, Integer.parseInt(expected));
            assertFalse(Arrays.equals(toDigits(input), guess.getDigits()));
        }

        private int[] toDigits(String input) {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
