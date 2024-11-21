package code.javalampa.models;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance < 0) {
            System.out.println("Insufficient funds.");
            return;
        }

        if ((this.balance / 2) < amount) {
            System.out.println("Cannot withdraw more than half of the balance.");
            return;
        }

        this.balance -= amount;
    }
}
