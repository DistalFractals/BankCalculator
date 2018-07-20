/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Owner
 */
public abstract class Account {
    public static final int DECIMAL_PRECISION = 2;
    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    private int accountNumber;

    protected int currentPeriod;

    /**
     * @return the principal
     */
    public BigDecimal getPrincipal() {
        return principal;
    }

    public String basicSetup(int accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period) {
        this.setPrincipal(initialBalance);
        this.setRate(interestRate);
        this.setPeriod(period);
        this.setAccountNumber(accountNumber);
        String basicInitializationString = "with account number " + accountNumber + " has been created with an initial balance of " + initialBalance + " with a monthly interest rate of " + interestRate + " , and will gather interest for " + period + " months.";
        return basicInitializationString;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    /**
     * @return the rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * @return the period
     */
    public int getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    protected BigDecimal principal;
    //rate is per month
    protected BigDecimal rate;
    //period is a number of months
    protected int period;
    protected BigDecimal interestEarned;

    public void calculate() {
        for (currentPeriod = 0; currentPeriod < period; currentPeriod++) {
            interestEarned = principal.multiply(rate).setScale(DECIMAL_PRECISION, RoundingMode.DOWN);
            principal = interestEarned.add(principal);
            Banker.displayAccount(this);
        }
        Banker.printSeparator(this);
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + " | Period number: " + currentPeriod + " | Interest earned: " + interestEarned + " | Balance: " + principal;
    }

}
