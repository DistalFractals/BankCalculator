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
public class CertificateOfDeposit extends Account {

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
