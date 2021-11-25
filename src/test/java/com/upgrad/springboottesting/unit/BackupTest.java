package com.upgrad.springboottesting.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackupTest {

    private LoanCalculator loanCalculator;

    @BeforeEach
    void setUp() {
        loanCalculator = new LoanCalculator();
        // Object initialization
        // varaible assigment
        // Data into database
        // clean up the database
        // MQ connection
    }

    @Test
    void shouldReturnZeroWhenAmountIsZero() {
        double interest = loanCalculator.calculateInterest(0, 12, 12);
        assertThat(interest, is(0));
    }

    @Test
    void shouldReturnZeroWhenInterestRateIsZero() {
        double interest = loanCalculator.calculateInterest(10000, 12, 0);
        assertThat(interest, is(0.0));
    }

    @Test
    void shouldReturnInterestForGivenAmountMonthAndInterestRateFor10000() {
        double interest = loanCalculator.calculateInterest(10000, 1, 0.12);
        assertThat(interest, is(100.0));
    }

    @Test
    void shouldReturnInterestForGivenAmountMonthAndInterestRateFor20000() {
        double interest = loanCalculator.calculateInterest(20000, 1, 0.12);
        assertThat(interest, is(200.0));
    }

    @Test
    void shouldReturnInterestForGivenAmountMonthAndInterestRateFor30000() {
        double interest = loanCalculator.calculateInterest(30000, 1, 0.12);
        assertThat(interest, is(300.0));
    }

    @ParameterizedTest
    @MethodSource("anyMethodName")
    void shouldReturnInterestForGivenAmountMonthAndInterestRate(double amount, double month, double rate, double expectedInterest) {
        double interest = loanCalculator.calculateInterest(amount, month, rate);
        assertThat(interest, is(expectedInterest));
    }


    public static Stream<Arguments> anyMethodName(){
        return Stream.of(Arguments.of(10000, 1, 0.12, 100.0),
                Arguments.of(20000, 1, 0.12, 200.0),
                Arguments.of(30000, 1, 0.12, 300.0));
    }
}