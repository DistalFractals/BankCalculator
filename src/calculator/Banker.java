/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class Banker {

    public static List<Account> accounts = new ArrayList();
    private static final double DEFAULT_CHECKING_FEE = 5;

    public static void main(String[] args) {
        promptUser();
        displayAccounts();
    }

    public static void promptUser() {
        int makingAccounts;
        do {
            String savingsOption = "Savings";
            String checkingOption = "Checking";
            String certificateOfDepositOption = "Certificate of Deposit";
            String[] accountOptions = {savingsOption, checkingOption, certificateOfDepositOption};
            int accountDecision = JOptionPane.showOptionDialog(null, "What account would you like to create?", "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, accountOptions, savingsOption);
            System.out.println(accountDecision);
            String initialBalanceString = JOptionPane.showInputDialog(null, "Enter initial balance.");
            double initialBalance = Double.valueOf(initialBalanceString);
            String interestRateString = JOptionPane.showInputDialog(null, "Ener the interest rate for the account");
            double interestRate = Double.valueOf(interestRateString);
            String numberOfPeriodsString = JOptionPane.showInputDialog(null, "How many periods should be calculated?");
            int numberOfPeriods = Integer.valueOf(numberOfPeriodsString);

            Account currentAccount;
            try {
                currentAccount = createAccount(accountDecision, initialBalance, interestRate);
                accounts.add(currentAccount);
            } catch (Exception ex) {
                Logger.getLogger(Banker.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("The account type specified does not exist.");
            }
            makingAccounts = JOptionPane.showConfirmDialog(null, "Would you like to continue making accounts?");
        } while (makingAccounts == JOptionPane.YES_OPTION);
    }

    public static void displayAccount(Account account) {
        System.out.println(account);
    }

    private static void displayAccounts() {
        accounts.forEach((account) -> {
            account.calculate();
        });
    }

    private static Account createAccount(int accountDecision, double initialBalance, double interestRate) throws Exception {
        switch (accountDecision) {
            case 0:
                return new Savings(initialBalance, interestRate);
            case 1:
                int firstCheckNumber;
                String firstCheckNumberString = JOptionPane.showInputDialog(null, "What is the first check number?");
                firstCheckNumber = Integer.parseInt(firstCheckNumberString);
                return new Checking(initialBalance, interestRate, firstCheckNumber, DEFAULT_CHECKING_FEE);
            case 2:
                int lengthUntilMature;
                String lengthUntilMatureString = JOptionPane.showInputDialog(null, "How many months before the account is mature?");
                lengthUntilMature = Integer.parseInt(lengthUntilMatureString);
                return new CertificateOfDeposit(initialBalance, interestRate, lengthUntilMature);
            default:
                throw new Exception("Unknown account type");
        }
    }
}
