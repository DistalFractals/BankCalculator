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
public class Savings extends Account{
    public Savings(int accountNumber, double initialBalance, double interestRate, int period){
        basicSetup(accountNumber, initialBalance, interestRate, period);
    }
}
