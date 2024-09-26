import com.mycompany.car.rental.system.Car;
import com.mycompany.car.rental.system.Customer;
import com.mycompany.car.rental.system.RentalAgency;
import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalAgency rentalAgency = new RentalAgency();

        // Creating cars
        rentalAgency.addCar(new Car("Toyota", "Camry", "ABC-123", 50.0));
        rentalAgency.addCar(new Car("Honda", "Civic", "DEF-456", 45.0));
        rentalAgency.addCar(new Car("Subaru", "Legacy", "GHI-789", 40.0));
        rentalAgency.addCar(new Car("Mercedes Benz", "AMG 63", "JKL-012", 60.0));

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    rentCar(scanner, rentalAgency);
                    break;

                case 2:
                    returnCar(scanner, rentalAgency);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    keepRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void rentCar(Scanner scanner, RentalAgency rentalAgency) {
        // List available cars
        System.out.println("\nAvailable cars to rent:");
        for (int i = 0; i < rentalAgency.getAvailableCars().size(); i++) {
            Car car = rentalAgency.getAvailableCars().get(i);
            System.out.println((i + 1) + ". " + car.getMake() + " " + car.getModel() + " (" + car.getLicensePlate() + ") - $" + car.getRentalPricePerDay() + " per day");
        }

        System.out.println((rentalAgency.getAvailableCars().size() + 1) + ". Exit");

        System.out.print("\nSelect the car you want to rent: ");
        int carChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (carChoice == rentalAgency.getAvailableCars().size() + 1) {
            System.out.println("Exiting...");
            return; // Return to the main menu
        }

        if (carChoice > 0 && carChoice <= rentalAgency.getAvailableCars().size()) {
            Car carToRent = rentalAgency.getAvailableCars().get(carChoice - 1);

            System.out.print("Enter your name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter your city: ");
            String customerCity = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String customerPhoneNumber = scanner.nextLine();

            Customer customer = new Customer(customerName, customerCity, customerPhoneNumber);
            rentalAgency.rentCar(customer, carToRent);

            System.out.println("\n" + customerName + " has rented the car: " + carToRent.getMake() + " " + carToRent.getModel() + " (" + carToRent.getLicensePlate() + ")");
        } else {
            System.out.println("Invalid car selection.");
        }
    }

    private static void returnCar(Scanner scanner, RentalAgency rentalAgency) {
        System.out.print("\nEnter your phone number: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = rentalAgency.findCustomerByPhoneNumber(phoneNumber);
        if (customer == null) {
            System.out.println("No rental record found for this phone number.");
            return;
        }

        Car rentedCar = rentalAgency.findCarRentedByCustomer(customer);
        if (rentedCar == null) {
            System.out.println("No car rented under this phone number.");
            return;
        }

        System.out.println("\nYou have rented the following car:");
        System.out.println(rentedCar.getMake() + " " + rentedCar.getModel() + " (" + rentedCar.getLicensePlate() + ")");
        System.out.print("Do you want to return this car? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            rentalAgency.returnCar(rentedCar);
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Return process canceled.");
        }
    }
}