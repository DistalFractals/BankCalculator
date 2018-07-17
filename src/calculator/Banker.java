/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class Banker {

    public static void main(String[] args) {
        promptUser();
    }

    public static void promptUser() {
        String savingsOption = "Savings";
        String checkingOption = "Checking";
        String certificateOfDepositOption = "Certificate of Deposit";
        String[] accountOptions = {savingsOption, checkingOption, certificateOfDepositOption};
        int accountDecision = JOptionPane.showOptionDialog(null, "What account would you like to create?", "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, accountOptions, savingsOption);
        System.out.println(accountDecision);
        String initialBalance = JOptionPane.showInputDialog(null, "Enter initial balance.");
        String interestRate = JOptionPane.showInputDialog(null, "Ener the interest rate for the account");
        String numberOfPeriods = JOptionPane.showInputDialog(null, "How many periods should be calculated?");
        int firstCheckNumber;
        if (accountDecision == 1){
            String firstCheckNumberString = JOptionPane.showInputDialog(null, "What is the first check number?");
            firstCheckNumber = Integer.parseInt(firstCheckNumberString);
        }
        int lengthUntilMature;
        if (accountDecision == 2){
            String lengthUntilMatureString = JOptionPane.showInputDialog(null, "How many months before the account is mature?");
            lengthUntilMature = Integer.parseInt(lengthUntilMatureString);
        }
    }
}
