package com.mycompany.car.rental.system;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anisha.Amondi
 */
public class Car {
    // Since in this scope of the project, went be changing these values, let's just declare them as constants
    private final String make;
    private final String model;
    private final String licensePlate;
    private final double rentalPricePerDay;
    private boolean isRented;

    // Constructor
    public Car(String make, String model, String licensePlate, double rentalPricePerDay) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isRented = false;
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }

    public void returnCar() {
        isRented = false;
    }
    
}
