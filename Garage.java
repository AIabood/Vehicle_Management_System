/**
 * Garage class managing a collection of vehicles
 * Demonstrates aggregation and collection management
 * One Garage holds up to 100 vehicles (one-to-many relationship)
 */
public class Garage {
    private static final int MAX_VEHICLES = 100;
    private Vehicle[] vehicles;
    private int count; // Current number of vehicles in the garage

    /**
     * Constructor for Garage
     * Initializes the vehicle array and count
     */
    public Garage() {
        this.vehicles = new Vehicle[MAX_VEHICLES];
        this.count = 0;
    }

    /**
     * Getter for count
     * @return The number of vehicles currently in the garage
     */
    public int getCount() {
        return count;
    }

    /**
     * Adds a new vehicle to the garage
     * @param vehicle The vehicle to add
     * @return true if vehicle was added successfully, false if garage is full
     */
    public boolean addVehicle(Vehicle vehicle) {
        if (count >= MAX_VEHICLES) {
            System.out.println("Garage is full! Cannot add more vehicles.");
            return false;
        }
        vehicles[count] = vehicle;
        count++;
        System.out.println("Vehicle added successfully!");
        return true;
    }

    /**
     * Updates a vehicle's details by matching the current owner name
     * @param currentOwner The current owner name to search for
     * @param newOwner The new owner name
     * @param brand The new brand
     * @param model The new model
     * @param year The new year
     * @return true if vehicle was updated, false if owner not found
     */
    public boolean updateVehicle(String currentOwner, String newOwner, String brand, String model, int year) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getOwnerName().equalsIgnoreCase(currentOwner)) {
                vehicles[i].setOwnerName(newOwner);
                vehicles[i].setBrand(brand);
                vehicles[i].setModel(model);
                vehicles[i].setYear(year);
                System.out.println("Vehicle updated successfully!");
                return true;
            }
        }
        System.out.println("Vehicle with owner name '" + currentOwner + "' not found!");
        return false;
    }

    /**
     * Removes a vehicle from the garage by owner name
     * @param ownerName The owner name of the vehicle to remove
     * @return true if vehicle was removed, false if owner not found
     */
    public boolean removeVehicle(String ownerName) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getOwnerName().equalsIgnoreCase(ownerName)) {
                // Shift remaining vehicles to fill the gap
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                System.out.println("Vehicle removed successfully!");
                return true;
            }
        }
        System.out.println("Vehicle with owner name '" + ownerName + "' not found!");
        return false;
    }

    /**
     * Displays all vehicles currently in the garage
     */
    public void displayVehicles() {
        if (count == 0) {
            System.out.println("The garage is empty!\n");
            return;
        }

        System.out.println("\n================== ALL VEHICLES IN GARAGE ==================");
        System.out.println("Total Vehicles: " + count);
        System.out.println("=========================================================\n");

        for (int i = 0; i < count; i++) {
            System.out.println("Vehicle " + (i + 1) + ":");
            vehicles[i].displayInfo();
        }
    }

    /**
     * Displays details of a specific vehicle by owner name
     * @param ownerName The owner name to search for
     */
    public void displayVehicleDetails(String ownerName) {
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getOwnerName().equalsIgnoreCase(ownerName)) {
                System.out.println("\n======= VEHICLE DETAILS FOR " + ownerName.toUpperCase() + " =======");
                vehicles[i].displayInfo();
                return;
            }
        }
        System.out.println("Vehicle with owner name '" + ownerName + "' not found!\n");
    }
}
