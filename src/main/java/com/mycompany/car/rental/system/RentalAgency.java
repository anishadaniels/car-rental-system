package com.mycompany.car.rental.system;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> availableCars;
    private List<Car> rentedCars;
    private List<Customer> customers; // List of customers

    // Constructor
    public RentalAgency() {
        availableCars = new ArrayList<>();
        rentedCars = new ArrayList<>();
        customers = new ArrayList<>();
    }

    // Methods
    public void addCar(Car car) {
        availableCars.add(car);
    }

    public void rentCar(Customer customer, Car car) {
        if (!car.isRented()) {
            rentedCars.add(car);
            availableCars.remove(car);
            customers.add(customer); // Add customer to the list when they rent a car
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

    // Getter methods
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // New method to find a car rented by a specific customer
    public Car findCarRentedByCustomer(Customer customer) {
        for (Car car : rentedCars) {
            // For now, we assume a one-to-one relationship between customer and car (one customer rents one car at a time)
            if (customers.contains(customer)) {
                return car;
            }
        }
        return null; // Return null if no car is found for the customer
    }

    // Method to find a customer by phone number
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null; // Return null if no customer is found with this phone number
    }
}