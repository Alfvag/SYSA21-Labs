import java.util.ArrayList;

public class PersonRegister {
    ArrayList<Person> persons = new ArrayList<Person>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findPerson(String identificationNumber) {
        for (Person person : persons) {
            if (person.getIdentificationNumber().equals(identificationNumber)) {
                return person;
            }
        }
        return null;
    }

    public BankAccount findAccount(String identificationNumber, String accountNumber) {
        Person person = findPerson(identificationNumber);
        if (person != null) {
            return person.findAccount(accountNumber);
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
