/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Owner
 */
public abstract class Account {

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
    public double getPrincipal() {
        return principal;
    }

    public String basicSetup(int accountNumber, double initialBalance, double interestRate, int period) {
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
    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
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

    protected double principal;
    //rate is per month
    protected double rate;
    //period is a number of months
    protected int period;
    protected double interestEarned;

    public void calculate() {
        for (currentPeriod = 0; currentPeriod < period; currentPeriod++) {
            interestEarned = principal * rate;
            principal = interestEarned + principal;
            Banker.displayAccount(this);
        }
        Banker.printSeparator(this);
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + " | Period number: " + currentPeriod + " | Interest earned: " + interestEarned + " | Balance: " + principal;
    }

}
