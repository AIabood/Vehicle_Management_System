/**
 * Truck class extending Vehicle
 * Represents a truck with cargo capacity as a specific attribute
 * Demonstrates Inheritance and Polymorphism
 */
public class Truck extends Vehicle {
    // Additional attribute
    private double cargoCapacity; // in tons

    /**
     * Parameterized constructor for Truck
     * @param ownerName The owner's name
     * @param brand The vehicle brand
     * @param model The vehicle model
     * @param year The manufacturing year
     * @param cargoCapacity Maximum cargo capacity in tons
     */
    public Truck(String ownerName, String brand, String model, int year, double cargoCapacity) {
        super(ownerName, brand, model, year);
        this.cargoCapacity = cargoCapacity;
    }

    // Getter for cargoCapacity
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    // Setter for cargoCapacity
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Override displayInfo to show truck-specific details
     * Demonstrates Polymorphism
     */
    @Override
    public void displayInfo() {
        System.out.println("========== TRUCK ==========");
        System.out.println("Owner: " + getOwnerName());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
        System.out.println("===========================\n");
    }
}
