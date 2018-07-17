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
public class Account {
    
    /**
     * @return the principal
     */
    public double getPrincipal() {
        return principal;
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
        for(int i=0; i<period; i++){
            interestEarned = principal * rate;
            principal = interestEarned + principal;
            Banker.displayAccount(this);
        }
        
    }
    @Override
    public String toString(){
        return "Period number: " + period + " | Interest earned: " + interestEarned + " | Balance: " + principal;
    }
        
}
