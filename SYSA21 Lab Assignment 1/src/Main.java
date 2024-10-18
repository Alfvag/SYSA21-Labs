public class Main {
    public static void main(String[] args) {
        PaymentSlip test = new PaymentSlip();
        test.readInput();
        test.calculateSalary();
        test.calculateNetSalary();
        test.generatePayslip();
    }
}