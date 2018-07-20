/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
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

    public static List<Account> accounts = new ArrayList<Account>();
    private static final BigDecimal DEFAULT_CHECKING_FEE = new BigDecimal("5");

    public static void main(String[] args) {
        promptUser();
        displayAccounts(accounts);
    }

    public static void promptUser() {
        int makingAccounts;
        int currentAccountNumber = 0;
        do {
            String savingsOption = "Savings";
            String checkingOption = "Checking";
            String certificateOfDepositOption = "Certificate of Deposit";
            String[] accountOptions = {savingsOption, checkingOption, certificateOfDepositOption};
            int accountDecision = JOptionPane.showOptionDialog(null, "What account would you like to create?", "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, accountOptions, savingsOption);
            String initialBalanceString = JOptionPane.showInputDialog(null, "Enter initial balance.");
            BigDecimal initialBalance = new BigDecimal(initialBalanceString);
            String interestRateString = JOptionPane.showInputDialog(null, "Enter the decimal monthly interest rate for the account");
            BigDecimal interestRate = new BigDecimal(interestRateString);
            String numberOfPeriodsString = JOptionPane.showInputDialog(null, "How many periods should be calculated?");
            int numberOfPeriods = Integer.valueOf(numberOfPeriodsString);

            Account currentAccount;
            try {
                currentAccount = createAccount(accountDecision, currentAccountNumber, initialBalance, interestRate, numberOfPeriods);
                accounts.add(currentAccount);
            } catch (Exception ex) {
                Logger.getLogger(Banker.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("The account type specified does not exist.");
            }
            makingAccounts = JOptionPane.showConfirmDialog(null, "Would you like to continue making accounts?");
            currentAccountNumber++;
            
        } while (makingAccounts == JOptionPane.YES_OPTION);
    }

    public static void displayAccount(Account account) {
        System.out.println(account);
    }

    private static void displayAccounts(List<Account> accounts) {
        accounts.forEach((account) -> {
            account.calculate();

        });
    }

    private static Account createAccount(int accountDecision, int accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period) throws Exception {
        switch (accountDecision) {
            case 0:
                return new Savings(accountNumber, initialBalance, interestRate, period);
            case 1:
                int firstCheckNumber;
                String firstCheckNumberString = JOptionPane.showInputDialog(null, "What is the first check number?");
                firstCheckNumber = Integer.parseInt(firstCheckNumberString);
                return new Checking(accountNumber, initialBalance, interestRate, period, firstCheckNumber, DEFAULT_CHECKING_FEE);
            case 2:
                int lengthUntilMature;
                String lengthUntilMatureString = JOptionPane.showInputDialog(null, "How many months before the account is mature?");
                lengthUntilMature = Integer.parseInt(lengthUntilMatureString);
                return new CertificateOfDeposit(accountNumber, initialBalance, interestRate, period, lengthUntilMature);
            default:
                throw new Exception("Unknown account type");
        }
    }

    static void printSeparator(Account account) {
        for (int i = 0; i < account.toString().length() - 1; i++) {
            System.out.print("-");

        }
        System.out.println("-");
    }

    static void displayInitialization(String initializationString) {
        System.out.println(initializationString);
    }
}
