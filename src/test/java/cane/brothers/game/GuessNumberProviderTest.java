package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GuessNumberProviderTest {

    @Nested
    class TestGet {
        @ParameterizedTest
        @CsvSource({"1234,4",
                "0123,4",
                "1111,4",
                "ABCD,4",
                "10000,4",
                "12345,5"})
        void test_getRandomGuess(String input, String expected) {
            var guessProvider = new GuessNumberProvider(input, Integer.parseInt(expected));
            assertNotNull(guessProvider.get());
        }

        @Test
        void test_getRandomGuess_null() {
            var guessProvider = new GuessNumberProvider(null, 2);
            assertNull(guessProvider.get());
        }

        @Test
        void test_getRandomGuess_empty() {
            var guessProvider = new GuessNumberProvider("", 2);
            assertNotNull(guessProvider.get());
        }
    }
}