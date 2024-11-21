package code.javalampa.models;

import java.util.ArrayList;
import code.javalampa.controllers.*;

public class Person {
    private String identificationNumber;
    private String name;
    private int age;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public Person(String identificationNumber, String name, int age) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<BankAccount>();
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<BankAccount> getAccounts() {
        return this.accounts;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAccount(BankAccount account) {
        if (this.age < 18) {
            System.out.println("Person is under 18 years old, cannot add account.");
            return;
        }

        if (this.accounts.size() >= 3) {
            System.out.println("Person already has 3 accounts, cannot add more.");
            return;
        }

        accounts.add(account);
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }

        return null;
    }

    public double calculateTotalBalance() {
        double totalBalance = 0;

        for (BankAccount bankAccount : accounts) {
            totalBalance += bankAccount.getBalance();
        }
        
        return totalBalance;
    }
}
