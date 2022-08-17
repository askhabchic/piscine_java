package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    public NumberWorker nw;

    @BeforeEach
    public void init() throws Exception {
        nw = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 11, 13})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 10, 12, 24, 36, 169})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -2, -10000, Integer.MIN_VALUE})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrows(NumberWorker.IllegalNumberException.class, () -> { nw.isPrime(number); });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void checkDigitsSum(int num, int sum) {
        Assertions.assertEquals(sum, nw.digitsSum(num));
    }
}
