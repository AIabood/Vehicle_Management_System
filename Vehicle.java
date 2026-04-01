/**
 * Abstract base class representing a generic Vehicle
 * Demonstrates Abstraction and serves as the base for inheritance hierarchy
 */
public abstract class Vehicle {
    // Private attributes - Encapsulation
    private String ownerName;
    private String brand;
    private String model;
    private int year;

    /**
     * Parameterized constructor for Vehicle
     * @param ownerName The owner's name
     * @param brand The vehicle brand
     * @param model The vehicle model
     * @param year The manufacturing year
     */
    public Vehicle(String ownerName, String brand, String model, int year) {
        this.ownerName = ownerName;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters - Encapsulation
    public String getOwnerName() {
        return ownerName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Setters - Encapsulation
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Abstract method to display vehicle information
     * Must be implemented by subclasses - Polymorphism
     */
    public abstract void displayInfo();
}
