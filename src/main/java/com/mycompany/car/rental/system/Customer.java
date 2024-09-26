package com.mycompany.car.rental.system;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anisha.Amondi
 */
public class Customer {
    // Same thing, we are not changing these values so we declare them as constants
    private final String name;
    private final String residenceCity;
    private String phoneNumber;

    // Our little facncy Constructor
    public Customer(String name, String residenceCity, String phoneNumber) {
        this.name = name;
        this.residenceCity = residenceCity;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    // Get name of Customer.
    public String getName() {
        return name;
    }
    // Get residenceCity of the customer
    public String getResidenceCity() {
        return residenceCity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
