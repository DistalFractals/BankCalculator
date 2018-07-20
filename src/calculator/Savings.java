/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;

/**
 *
 * @author Owner
 */
public final class Savings extends Account{
    public Savings(String accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period){
        String basicInitializationString = basicSetup(accountNumber, initialBalance, interestRate, period);
        String initializationMessage = "Created: savings account | " + basicInitializationString;
        Banker.displayInitialization(initializationMessage);
    }

}
