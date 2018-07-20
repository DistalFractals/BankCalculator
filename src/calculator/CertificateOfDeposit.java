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
public final class CertificateOfDeposit extends Account {

    public CertificateOfDeposit(String accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period, int lengthToMature) {
        String basicInitializationString = basicSetup(accountNumber, initialBalance, interestRate, period);
        this.setLengthToMature(lengthToMature);
        String initializationMessage = "Created: certificate of deposit | " + basicInitializationString;
        initializationMessage += "\n Account mature in: " + lengthToMature + " months";
        Banker.displayInitialization(initializationMessage);
    }

    /**
     * @return the lengthToMature
     */
    public int getLengthToMature() {
        return lengthToMature;
    }

    /**
     * @param lengthToMature the lengthToMature to set
     */
    public void setLengthToMature(int lengthToMature) {
        this.lengthToMature = lengthToMature;
    }
    private int lengthToMature;
}
