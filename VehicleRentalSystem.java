import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: 5% of rental rate";
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: 10% of rental rate";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR123", 1000);
        Vehicle bike = new Bike("BIKE456", 500);
        Vehicle truck = new Truck("TRUCK789", 2000);

        displayRentalDetails(car, 5);
        displayRentalDetails(bike, 3);
        displayRentalDetails(truck, 7);
    }

    public static void displayRentalDetails(Vehicle vehicle, int days) {
        double rentalCost = vehicle.calculateRentalCost(days);
        double insurance = (vehicle instanceof Insurable) ? ((Insurable) vehicle).calculateInsurance() : 0;
        double finalCost = rentalCost + insurance;
        System.out.println("Vehicle: " + vehicle.getType() + ", Rental Cost: " + rentalCost + ", Insurance: " + insurance + ", Final Cost: " + finalCost);
    }
}