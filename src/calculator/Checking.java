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
    public Checking(double initialBalance, double interestRate, int period, int firstCheckNumber, double monthlyFee){
        basicSetup(initialBalance, interestRate, period);
        this.setCheckNumber(firstCheckNumber);
        this.setMonthlyFee(monthlyFee);
    }
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
