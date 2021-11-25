package com.upgrad.springboottesting.unit;

public class LoanCalculator {

    public double calculateInterest(double amount, double months, double interestRate){
        double monthInterestRate = interestRate/12;
        if(amount < 0 || interestRate < 0){
            throw new IllegalArgumentException();
        }
        return amount * monthInterestRate * months;
    }
}
