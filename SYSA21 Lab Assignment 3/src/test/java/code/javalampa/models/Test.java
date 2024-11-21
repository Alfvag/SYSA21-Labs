package code.javalampa.models;

public class Test {
    public static void main(String[] args) {
        AppModel model = new AppModel();

        PersonRegister personRegister = model.getPersonRegister();
    
        Person person1 = new Person("123456-0001", "Foo Bar", 70);
        Person person2 = new Person("010101-1234", "Baz Qux", 30);

        personRegister.addPerson(person1);
        personRegister.addPerson(person2);
    
        BankAccount account1 = new BankAccount("987654321", 1000);
        BankAccount account2 = new BankAccount("123456789", 2000);
        BankAccount account3 = new BankAccount("0102030405", -1);
        BankAccount account4 = new BankAccount("111155556666", 4000);
    
        person1.addAccount(account1);
        person1.addAccount(account2);
    
        person2.addAccount(account3);
        person2.addAccount(account4);

        // Try to withdraw more than half the balance

        account2.withdraw(1500);
        System.out.println(account2.getBalance());

        // Try to withdraw if the balance is negative
        
        account3.withdraw(1000);


    }
}
