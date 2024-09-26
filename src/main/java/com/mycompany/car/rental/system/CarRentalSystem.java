import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalAgency rentalAgency = new RentalAgency();

        rentalAgency.addCar(new Car("Toyota", "Camry", "ABC-123", 50.0));
        rentalAgency.addCar(new Car("Honda", "Civic", "DEF-456", 45.0));
        rentalAgency.addCar(new Car("Subaru", "Legacy", "GHI-789", 40.0));
        rentalAgency.addCar(new Car("Mercedes Benz", "AMG 63", "JKL-012", 60.0));

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Choose an option:");
            System.out.println("1. Rent Car");
            System.out.println("2. Return Car");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    // Rent a car
                    System.out.print("Enter the car model you want to rent: ");
                    String modelToRent = scanner.nextLine();

                    Car carToRent = rentalAgency.findAvailableCar(modelToRent);
                    if (carToRent != null) {
                        System.out.print("Enter your name: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Enter your address: ");
                        String customerAddress = scanner.nextLine();
                        System.out.print("Enter your phone number: ");
                        String customerPhoneNumber = scanner.nextLine();

                        Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);
                        rentalAgency.rentCar(customer, carToRent);
                    } else {
                        System.out.println("Car not found or not available.");
                    }
                    break;

                case 2:
                    // Return a car
                    System.out.print("Enter the car model you want to return: ");
                    String modelToReturn = scanner.nextLine();

                    Car carToReturn = rentalAgency.findRentedCar(modelToReturn);
                    if (carToReturn != null) {
                        rentalAgency.returnCar(carToReturn);
                    } else {
                        System.out.println("Car not found in your rentals.");
                    }
                    break;

                case 3:
                    // Exit
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
}
