package com.upgrad.springboottesting.unit;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoanCalculatorTest {

    // Never share data across tests
    private LoanCalculator loanCalculator;

    @BeforeEach
    void setUp() {
        loanCalculator = new LoanCalculator();
    }

    // Names should be self explanatory
    @Test
    void shouldReturnZeroWhenAmountIsZero() {
        double interest = loanCalculator.calculateInterest(0, 12, 12);

        double expectedInterest = 0;
        assertEquals(expectedInterest, interest);
    }

    @Test
    void shouldReturnZeroWhenMonthIsZero() {
        double interest = loanCalculator.calculateInterest(10000, 0, 12);

        double expectedInterest = 0;
        assertEquals(expectedInterest, interest);
    }

    @Test
    void shouldReturnZeroWhenRateIsZero() {
        double interest = loanCalculator.calculateInterest(10000, 10, 0);

        double expectedInterest = 0;
        assertEquals(expectedInterest, interest);
    }

    // use parameterized test
    @ParameterizedTest
    @MethodSource("zeroInterestParameters")
    void shouldReturnZeroInterest(double amount, double months, double interestRate) {
        double interest = loanCalculator.calculateInterest(amount, months, interestRate);

        assertEquals(0, interest);
        // Hamcrest
        //assertThat(interest, is(0));
    }

    public static Stream<Arguments> zeroInterestParameters() {
        return Stream.of(Arguments.of(0, 12, 12),
                Arguments.of(10000, 0, 12), Arguments.of(10000, 10, 0));
    }

    @Test
    void shouldThrowExceptionForNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> loanCalculator.calculateInterest(-100, 12, 12));
    }
}