package code.javalampa.models;

import java.util.ArrayList;

public class PersonRegister {
    ArrayList<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
        System.out.println("Person removed");
    }

    public Person findPerson(String identificationNumber) {
        for (Person person : persons) {
            if (person.getIdentificationNumber().equals(identificationNumber)) {
                return person;
            }
        }
        return null;
    }

    public BankAccount findAccount(String accountNumber) {
        for (Person person : persons) {
            for (BankAccount account : person.getAccounts()) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
        }

        return null;
    }

    public double calculateTotalBalance() {
        double totalBalance = 0;
        for (Person i : persons) {
            totalBalance += i.calculateTotalBalance();
        }
        return totalBalance;
    }

}
