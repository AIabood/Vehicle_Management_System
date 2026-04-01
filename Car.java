/**
 * Car class extending Vehicle
 * Represents a car with seating capacity as a specific attribute
 * Demonstrates Inheritance and Polymorphism
 */
public class Car extends Vehicle {
    // Additional attribute
    private int seatingCapacity;

    /**
     * Parameterized constructor for Car
     * @param ownerName The owner's name
     * @param brand The vehicle brand
     * @param model The vehicle model
     * @param year The manufacturing year
     * @param seatingCapacity Number of seats in the car
     */
    public Car(String ownerName, String brand, String model, int year, int seatingCapacity) {
        super(ownerName, brand, model, year);
        this.seatingCapacity = seatingCapacity;
    }

    // Getter for seatingCapacity
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    // Setter for seatingCapacity
    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    /**
     * Override displayInfo to show car-specific details
     * Demonstrates Polymorphism
     */
    @Override
    public void displayInfo() {
        System.out.println("========== CAR ==========");
        System.out.println("Owner: " + getOwnerName());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Seating Capacity: " + seatingCapacity + " seats");
        System.out.println("========================\n");
    }
}
