package cane.brothers.game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SecretNumberProviderTest {

    @Nested
    class TestGet {
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 4, 5})
        void test_getRandomGuess(int input) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(input);
            assertNotNull(secretProvider.get());
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1})
        void test_getRandomGuess_neg(int input) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(input);
            assertNull(secretProvider.get());
        }
    }

    @Nested
    class TestParseGuess {
        @ParameterizedTest
        @CsvSource({"1,4", "2,12", "3,123", "4,1234", "5,12345", "8,12345678"})
        void test_parseGuess(int input, int expected) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(input);
            var result = secretProvider.parseGuess(expected);
            assertEquals(result.length, input);
        }

        @Test
        void test_parseGuess_neg() {
            SecretNumberProvider secretProvider = new SecretNumberProvider(0);
            var result = secretProvider.parseGuess(0);
            assertNull(result);
        }
    }

    @Nested
    class TestMinMax {
        @ParameterizedTest
        @CsvSource({"1,0", "2,1", "3,12", "4,123", "5,1234", "8,1234567", "9,12345678"})
        void test_getMinNumber(String input, String expected) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(Integer.parseInt(input));
            var result = secretProvider.getMinNumber();
            assertEquals(Integer.parseInt(expected), result);
        }

        @ParameterizedTest
        @CsvSource({"1,10", "2,100", "3,1000", "4,10000", "5,100000", "8,100000000", "9,1000000000"})
        void test_getMaxNumber(String input, String expected) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(Integer.parseInt(input));
            var result = secretProvider.getMaxNumber();
            assertEquals(Integer.parseInt(expected), result);
        }

        @ParameterizedTest
        @CsvSource({"1,10", "2,99", "3,988", "4,9877", "5,98766", "8,98765433", "9,987654322"})
        void test_getMaxMinNumber(String input, String expected) {
            SecretNumberProvider secretProvider = new SecretNumberProvider(Integer.parseInt(input));
            var result = secretProvider.getMaxNumber() - secretProvider.getMinNumber();
            assertEquals(Integer.parseInt(expected), result);
        }
    }
}