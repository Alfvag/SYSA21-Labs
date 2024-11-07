public class Test {
    public static void main(String[] args) {
        PersonRegister personRegister = new PersonRegister();
        Person person1 = new Person("123456-123A", "John Doe", 30);
        Person person2 = new Person("654321-321B", "Jane Doe", 25);
        personRegister.addPerson(person1);
        personRegister.addPerson(person2);
        BankAccount account1 = new BankAccount("FI123456789", 1000);
        BankAccount account2 = new BankAccount("FI987654321", 2000);
        person1.addAccount(account1);
        person2.addAccount(account2);
        System.out.println(personRegister.calculateTotalBalance());
    }
}
