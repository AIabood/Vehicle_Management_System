/**
 * Main class demonstrating the Vehicle Management System
 * Shows all OOP principles: Abstraction, Inheritance, Encapsulation, and Polymorphism
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("   VEHICLE MANAGEMENT SYSTEM DEMONSTRATION");
        System.out.println("===============================================\n");

        // Create a Garage instance
        Garage garage = new Garage();

        // Create various vehicle instances - Demonstrating Polymorphism
        System.out.println(">>> CREATING VEHICLES <<<\n");

        Car car1 = new Car("John Smith", "Toyota", "Camry", 2022, 5);
        Car car2 = new Car("Emma Johnson", "Honda", "Civic", 2021, 5);

        Truck truck1 = new Truck("Michael Brown", "Volvo", "FH16", 2020, 25.5);
        Truck truck2 = new Truck("David Lee", "Scania", "R440", 2019, 20.0);

        Motorcycle bike1 = new Motorcycle("Sarah Wilson", "Harley-Davidson", "Street 750", 2023, 750);
        Motorcycle bike2 = new Motorcycle("James Taylor", "Yamaha", "YZF-R1", 2022, 998);

        // Add vehicles to the garage
        System.out.println(">>> ADDING VEHICLES TO GARAGE <<<\n");
        garage.addVehicle(car1);
        garage.addVehicle(car2);
        garage.addVehicle(truck1);
        garage.addVehicle(truck2);
        garage.addVehicle(bike1);
        garage.addVehicle(bike2);

        // Display all vehicles - Polymorphism in action
        garage.displayVehicles();

        // Display specific vehicle details
        System.out.println(">>> DISPLAYING SPECIFIC VEHICLE DETAILS <<<");
        garage.displayVehicleDetails("John Smith");
        garage.displayVehicleDetails("Michael Brown");
        garage.displayVehicleDetails("Sarah Wilson");

        // Update a vehicle
        System.out.println(">>> UPDATING VEHICLE DETAILS <<<\n");
        garage.updateVehicle("Emma Johnson", "Emily Johnson", "Honda", "Accord", 2023);
        garage.displayVehicleDetails("Emily Johnson");

        // Remove a vehicle
        System.out.println(">>> REMOVING A VEHICLE <<<\n");
        garage.removeVehicle("David Lee");
        System.out.println("Updated garage count: " + garage.getCount() + " vehicles\n");

        // Display updated vehicle list
        System.out.println(">>> FINAL GARAGE STATE <<<");
        garage.displayVehicles();

        // Demonstrate attempted operations on non-existent vehicles
        System.out.println(">>> TESTING ERROR HANDLING <<<\n");
        garage.displayVehicleDetails("NonExistent Owner");
        garage.removeVehicle("NonExistent Owner");
        garage.updateVehicle("NonExistent Owner", "New Owner", "Brand", "Model", 2024);

        System.out.println("===============================================");
        System.out.println("   END OF DEMONSTRATION");
        System.out.println("===============================================");
    }
}
