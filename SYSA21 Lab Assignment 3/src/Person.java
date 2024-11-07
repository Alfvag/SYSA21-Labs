import java.util.ArrayList;

public class Person {
    private String identificationNumber;
    private String name;
    private int age;
    private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    //TODO Hur koppla samman person och bankkonto? Se UML-diagrammet i instruktionen.

    public Person(String identificationNumber, String name, int age) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.age = age;
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
        // Add account to person
    }

    public BankAccount findAccount(String accountNumber) {
        // Find account by account number
    }

    public double calculateTotalBalance() {
        // Get balance of account
    }
}
