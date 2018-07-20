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
public class Checking extends Account {

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
    public Checking(int accountNumber, double initialBalance, double interestRate, int period, int firstCheckNumber, double monthlyFee){
        String basicInitializationString = basicSetup(accountNumber, initialBalance, interestRate, period);
        this.setCheckNumber(firstCheckNumber);
        this.setMonthlyFee(monthlyFee);
        String initializationString = "A checking account " + basicInitializationString;
        initializationString += " This account has a monthly fee of " + monthlyFee;
        initializationString+= ". Checks for this account will start with number " + firstCheckNumber;
        this.setInitializationString(initializationString);
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
    public double getMonthlyFee() {
        return monthlyFee;
    }

    /**
     * @param monthlyFee the monthlyFee to set
     */
    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    private int checkNumber;
    private double monthlyFee;

    @Override
    public void calculate() {
        for (currentPeriod = 0; currentPeriod < period; currentPeriod++) {
            interestEarned = principal * rate;
            principal = interestEarned + principal;
            principal = principal - monthlyFee;
            Banker.displayAccount(this);
        }

    }
}
