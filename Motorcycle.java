/**
 * Motorcycle class extending Vehicle
 * Represents a motorcycle with engine size as a specific attribute
 * Demonstrates Inheritance and Polymorphism
 */
public class Motorcycle extends Vehicle {
    // Additional attribute
    private int engineSize; // in cc (cubic centimeters)

    /**
     * Parameterized constructor for Motorcycle
     * @param ownerName The owner's name
     * @param brand The vehicle brand
     * @param model The vehicle model
     * @param year The manufacturing year
     * @param engineSize Engine displacement in cubic centimeters
     */
    public Motorcycle(String ownerName, String brand, String model, int year, int engineSize) {
        super(ownerName, brand, model, year);
        this.engineSize = engineSize;
    }

    // Getter for engineSize
    public int getEngineSize() {
        return engineSize;
    }

    // Setter for engineSize
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    /**
     * Override displayInfo to show motorcycle-specific details
     * Demonstrates Polymorphism
     */
    @Override
    public void displayInfo() {
        System.out.println("========== MOTORCYCLE ==========");
        System.out.println("Owner: " + getOwnerName());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Engine Size: " + engineSize + " cc");
        System.out.println("================================\n");
    }
}
