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
public final class Checking extends Account {

    /**
     * @return the initializationString
     */
    public String getInitializationString() {
        return initializationString;
    }

    /**
     * @param initializationString the initializationString to set
     */
    public void setInitializationString(String initializationString) {
        this.initializationString = initializationString;
    }

    public Checking(String accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period, int firstCheckNumber, BigDecimal monthlyFee) {
        String basicInitializationString = basicSetup(accountNumber, initialBalance, interestRate, period);
        this.setCheckNumber(firstCheckNumber);
        this.setMonthlyFee(monthlyFee);
        String initializationString = "Created: checking acount | " + basicInitializationString;
        initializationString += "\nMonthly fee: $" + monthlyFee;
        initializationString += " | Check numbers begin with: " + firstCheckNumber;
        this.setInitializationString(initializationString);
        Banker.displayInitialization(initializationString);

    }
    private String initializationString;

    /**
     * @return the checkNumber
     */
    public int getCheckNumber() {
        return checkNumber;
    }

    /**
     * @param checkNumber the checkNumber to set
     */
    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    /**
     * @return the monthlyFee
     */
    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    /**
     * @param monthlyFee the monthlyFee to set
     */
    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    private int checkNumber;
    private BigDecimal monthlyFee;

    @Override
    public void calculate() {
        for (currentPeriod = 0; currentPeriod < period; currentPeriod++) {
            if (principal.compareTo(new BigDecimal("0")) == -1) {
                Banker.closeAccount(this);
                return;
            }
            interestEarned = principal.multiply(rate).setScale(DECIMAL_PRECISION, RoundingMode.DOWN);
            principal = interestEarned.add(principal);
            principal = principal.subtract(monthlyFee);
            Banker.displayAccount(this);
        }
        Banker.printSeparator(this);

    }
}
