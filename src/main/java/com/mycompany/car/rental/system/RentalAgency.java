package com.mycompany.car.rental.system;


import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anisha.Amondi
 */
public class RentalAgency {
     private List<Car> availableCars;
    private List<Car> rentedCars;
    private List<Customer> customers; // Added Customer list

    // Constructor
    public RentalAgency() {
        availableCars = new ArrayList<>();
        rentedCars = new ArrayList<>();
        customers = new ArrayList<>(); // Initialize customer list
    }

    // Methods
    public void addCar(Car car) {
        availableCars.add(car);
    }

    public void rentCar(Customer customer, Car car) {
        if (!car.isRented()) {
            rentedCars.add(car);
            availableCars.remove(car);
            car.rent();
        
        } else {
            System.out.println("Car is already rented.");
        }
    }

    public void returnCar(Car car) {
        if (car.isRented()) {
            rentedCars.remove(car);
            availableCars.add(car);
            car.returnCar();
            
        } else {
            System.out.println("Car is not currently rented.");
        }
    }

    // Getter methods for encapsulation
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
