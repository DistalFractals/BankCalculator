/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Owner
 */
public class Banker {

    private static final String IDENTIFIER_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final BigDecimal MAX_INTEREST = new BigDecimal("25");
    public static final String TRIM_REGEX = "[^0-9.]";
    private static final List<Account> ACCOUNTS = new ArrayList<Account>();
    private static final BigDecimal DEFAULT_CHECKING_FEE = new BigDecimal("5");

    public static void main(String[] args) {
        promptUser();
        displayAccounts(ACCOUNTS);
    }

    public static void promptUser() {
        int makingAccounts;
        do {
            String savingsOption = "Savings";
            String checkingOption = "Checking";
            String certificateOfDepositOption = "Certificate of Deposit";
            String enterBalanceString = "Enter the inital balance for the account";
            String enterRateString = "Enter the yearly interest rate for the account";
            String enterPeriodsString = "Enter the number of periods to calculate";
            String[] accountOptions = {savingsOption, checkingOption, certificateOfDepositOption};
            int accountDecision = JOptionPane.showOptionDialog(null, "What account would you like to create?", "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, accountOptions, savingsOption);
            BigDecimal initialBalance = getBigDecimal(enterBalanceString);
            BigDecimal interestRate = getInterestRate(enterRateString);
            int numberOfPeriods = getInt(enterPeriodsString);

            Account currentAccount;
            try {
                String currentAccountNumber = getUniqueIdentifier();
                currentAccount = createAccount(accountDecision, currentAccountNumber, initialBalance, interestRate, numberOfPeriods);
                ACCOUNTS.add(currentAccount);
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

    private static void displayAccounts(List<Account> accounts) {
        accounts.forEach((account) -> {
            account.calculate();

        });
    }

    private static Account createAccount(int accountDecision, String accountNumber, BigDecimal initialBalance, BigDecimal interestRate, int period) throws Exception {
        switch (accountDecision) {
            case 0:
                return new Savings(accountNumber, initialBalance, interestRate, period);
            case 1:
                int firstCheckNumber;
                String checkNumberMessage = ("What is the first check number?");
                firstCheckNumber = getInt(checkNumberMessage);
                return new Checking(accountNumber, initialBalance, interestRate, period, firstCheckNumber, DEFAULT_CHECKING_FEE);
            case 2:
                int lengthUntilMature;
                String periodsMessage = "Please enter the number of periods until the account is mature.";
                lengthUntilMature = getInt(periodsMessage);
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

    static void printSeparator(String string) {
        int begin = string.lastIndexOf("\n");
        int end = string.length();
        int dashNumber = end - begin - 2;
        for (int i = 0; i < dashNumber; i++) {
            System.out.print("-");
        }
        System.out.println("-");
    }

    static void displayInitialization(String initializationString) {
        System.out.println(initializationString);
        printSeparator(initializationString);
    }

    public static BigDecimal getBigDecimal(String message) {
        BigDecimal cleanBalance;
        String errorMessage = "The input was invalid, please try again. Enter only a number.";
        String numberString = JOptionPane.showInputDialog(message);
        if (numberString == null) {
            allowExit();
        }
        try {
            cleanBalance = new BigDecimal((numberString).replaceAll(TRIM_REGEX, ""));
        } catch (Exception e) {
            cleanBalance = getBigDecimal(errorMessage);
        }
        return cleanBalance;
    }

    public static BigDecimal getInterestRate(String message) {
        String errorMessage = "Please enter an interest rate less than or equal to 25 percent";
        BigDecimal preRate = getBigDecimal(message);
        if (preRate.compareTo(MAX_INTEREST) != -1) {
            getBigDecimal(errorMessage);
        }
        BigDecimal rate = preRate.divide(new BigDecimal("1200"), 5, RoundingMode.DOWN);
        return rate;
    }

    public static int getInt(String message) {
        int cleanOutput;
        String errorMessage = "Invalid input, please try again. \nMake sure to enter a whole number.";
        String numberString = JOptionPane.showInputDialog(message);
        if (numberString == null) {
            allowExit();
        }
        try {
            String trimmedInput = numberString.replaceAll(TRIM_REGEX, "");
            cleanOutput = Integer.parseInt(trimmedInput);
        } catch (Exception e) {
            cleanOutput = getInt(errorMessage);
        }
        return cleanOutput;
    }

    public static String getUniqueIdentifier() {
        String uniqueIdentifier = "";
        Random randomGenerator = new Random();
        for (int i = 0; i < 8; i++) {
            int addedCharacterLocation = randomGenerator.nextInt(IDENTIFIER_CHARS.length());
            char addedCharacter = (IDENTIFIER_CHARS.charAt(addedCharacterLocation));
            uniqueIdentifier += addedCharacter;
        }
        for (Account account : ACCOUNTS) {
            if (uniqueIdentifier.equals(account.getUniqueIdentifier())) {
                uniqueIdentifier = getUniqueIdentifier();
            }
        }
        return uniqueIdentifier;
    }

    private static void allowExit() {
        int continueDecision;
        String continueMessage = "Press yes if you would like to continue the program. \nOtherwise, select no or cancel or close this message and exit the program.";
        continueDecision = JOptionPane.showConfirmDialog(null, continueMessage);
        if (continueDecision != JOptionPane.OK_OPTION) {
            System.out.println("The user wished to close the program before its completion, exiting.");
            System.exit(0);
        }
    }

    static void closeAccount(Account account) {
        String accountClosedMessage = "Account number " + account.getUniqueIdentifier() + " closed due to negative balance.";
        System.out.println(accountClosedMessage);
    }
}
