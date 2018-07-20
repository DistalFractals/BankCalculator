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
public class CertificateOfDeposit extends Account {

    public CertificateOfDeposit(int accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period, int lengthToMature) {
        basicSetup(accountNumber, initialBalance, interestRate, period);
        this.setLengthToMature(lengthToMature);
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
