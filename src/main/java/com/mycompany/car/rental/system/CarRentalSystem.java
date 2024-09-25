/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.car.rental.system;


/**
 *
 * @author Anisha.Amondi
 */
public class CarRentalSystem {

   public static void main(String[] args) {
        System.out.println("RentalObjectAgencyHanningtone");
        System.out.println("RentalObjectAgencyAnisha");
        System.out.println("RentalObjectAgencyDaniels");
        RentalAgency rentalAgency = new RentalAgency();

        // Add cars to the rental agency
        rentalAgency.addCar(new Car("Toyota", "Camry", "ABC-123", 50.0));
        rentalAgency.addCar(new Car("Honda", "Civic", "DEF-456", 45.0));
        

        // Create a customer object
        Customer customer = new Customer("John Doe", "123 Main St", "555-1234");

        // Rent a car
        rentalAgency.rentCar(customer, rentalAgency.getAvailableCars().get(0));

        // Return the car
        rentalAgency.returnCar(rentalAgency.getRentedCars().get(0));
    }
}
