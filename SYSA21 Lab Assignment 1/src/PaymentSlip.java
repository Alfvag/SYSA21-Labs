import java.util.Scanner;

public class PaymentSlip {
    private String name = "";
    private double hourlyRate = 0.0;
    private double hoursWorked = 0.0;
    private double totalPay = 0.0;
    private double netPay = 0.0;

    public void calculateSalary() {
        this.totalPay = this.hourlyRate * this.hoursWorked;
    }

    public void calculateNetSalary() {
        this.netPay = this.totalPay * 0.7;
    }

    public void readInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the employees name?");

        String employeeName = scanner.nextLine();

        System.out.println("What is their hourly rate?");

        String hourlyRate = scanner.nextLine();

        System.out.println("How many hours did they work this month?");

        String hoursWorked = scanner.nextLine();

        this.hourlyRate = Double.parseDouble(hourlyRate);
        this.name = employeeName;
        this.hoursWorked = Double.parseDouble(hoursWorked);

    }

    public void generatePayslip() {
        System.out.println("--------------------------------");
        System.out.println("## PAYMENT INFORMATION ##");
        System.out.println("Name: " + this.name);
        System.out.println("Hourly rate: " + this.hourlyRate);
        System.out.println("Hours worked: " + this.hoursWorked + '\n');
        System.out.println("Salary before tax: " + this.totalPay);
        System.out.println("Salary after tax: " + this.netPay + '\n');
        System.out.println("If you have any questions regarding your salary, contact Bob");
        System.out.println("--------------------------------");
    }
}
