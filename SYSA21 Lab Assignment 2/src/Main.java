import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxSeats = 12;

        Passenger[] passengers = new Passenger[maxSeats];

        boolean shouldContinue = true;

        Scanner scanner = new Scanner(System.in);

        while (shouldContinue) {

            System.out.println("What would you like to do? Enter a number:");
            System.out.println("1. Add a passenger");
            System.out.println("2. Remove a passenger");
            System.out.println("3. Switch seats");
            System.out.println("4. Rename passenger");
            System.out.println("5. Count passengers");
            System.out.println("6. Print passenger manifest");
            System.out.println("7. Exit");
            System.out.print("Your selection: ");

            int selection = Integer.parseInt(scanner.nextLine());

            switch(selection) {
                case 1:
                    System.out.println("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter passenger age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    Passenger passenger = new Passenger(name, age);

                    for (int i = 0; i < maxSeats; i++) {
                        if (passengers[i] == null) {
                            passengers[i] = passenger;
                            break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Enter passenger name: ");
                    String nameToRemove = scanner.nextLine();

                    for (int i = 0; i < maxSeats; i++) {
                        if (passengers[i] != null && passengers[i].getName().equals(nameToRemove)) {
                            passengers[i] = null;
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("Enter passenger name: ");
                    String nameToSwitch = scanner.nextLine();
                    System.out.println("Enter new seat number: ");
                    int newSeat = Integer.parseInt(scanner.nextLine());

                    Passenger temp = passengers[newSeat - 1];

                    for (int i = 0; i < maxSeats; i++) {
                        if (passengers[i] != null && passengers[i].getName().equals(nameToSwitch)) {
                            passengers[newSeat - 1] = passengers[i];
                            passengers[i] = temp;
                            break;
                        }
                    }

                    break;
                case 4:
                    System.out.println("Enter seat number:");
                    int passengerToRename = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();

                    if (passengers[passengerToRename - 1] != null) {
                        passengers[passengerToRename - 1].setName(newName);
                    }

                    break;
                case 5:
                    int count = 0;
                    for (Passenger currentPassenger : passengers) {
                        if (currentPassenger != null) {
                            count++;
                        }
                    }

                    System.out.println("There are " + count + " passengers on the plane.");

                    break;
                case 6:
                    System.out.println("#### PASSENGER MANIFEST ####");
                    System.out.println("SkyBox Ltd.");
                    System.out.println("Seat  Name  Age");

                    for (int i = 0; i < maxSeats; i++) {
                        if (passengers[i] != null) {
                            System.out.println(String.valueOf(i + 1) + "     " + Objects.toString(passengers[i].getName()) + "  " + Objects.toString(passengers[i].getAge()));
                        } else {
                            System.out.println(String.valueOf(i + 1));
                        }
                    }

                    System.out.println("#### #### #### #### #### ####");

                    break;
                case 7:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

        }

        scanner.close();

    }
}