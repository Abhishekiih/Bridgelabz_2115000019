import java.util.*;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private double loanAmount;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    public void applyForLoan(double amount) {
        if (amount > 0) {
            loanAmount = amount;
        }
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV123", "John Doe", 5000);
        BankAccount current = new CurrentAccount("CUR456", "Jane Smith", 10000);

        displayAccountDetails(savings);
        displayAccountDetails(current);
    }

    public static void displayAccountDetails(BankAccount account) {
        double interest = account.calculateInterest();
        System.out.println("Account Holder: " + account.getHolderName() + ", Interest Earned: " + interest);
    }
}
