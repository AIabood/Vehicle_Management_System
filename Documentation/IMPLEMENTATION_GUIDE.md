# Vehicle Management System - Implementation Guide

## Project Structure

```
UML/
├── Vehicle.java              (Abstract Base Class)
├── Car.java                  (Subclass)
├── Truck.java                (Subclass)
├── Motorcycle.java           (Subclass)
├── Garage.java               (Collection Manager)
├── Main.java                 (Demo/Test Class)
├── DOCUMENTATION.md          (System Documentation)
├── UML_DIAGRAM.md            (UML Class Diagram)
└── IMPLEMENTATION_GUIDE.md   (This File)
```

## Files and Their Responsibilities

### 1. **Vehicle.java** - Abstract Base Class
**Responsibility:** Define the common interface and shared functionality for all vehicle types

**Key Concepts:**
- Abstract class cannot be instantiated directly
- Defines contract for all subclasses to implement `displayInfo()`
- Provides common attributes: ownerName, brand, model, year
- Demonstrates **Abstraction** and **Encapsulation**

### 2. **Car.java** - Car Subclass
**Responsibility:** Represent a car vehicle with seating capacity

**Key Concepts:**
- Extends Vehicle class
- Adds seatingCapacity attribute
- Overrides displayInfo() for car-specific details
- Demonstrates **Inheritance** and **Polymorphism**

### 3. **Truck.java** - Truck Subclass
**Responsibility:** Represent a truck vehicle with cargo capacity

**Key Concepts:**
- Extends Vehicle class
- Adds cargoCapacity attribute (in tons)
- Overrides displayInfo() for truck-specific details
- Demonstrates **Inheritance** and **Polymorphism**

### 4. **Motorcycle.java** - Motorcycle Subclass
**Responsibility:** Represent a motorcycle vehicle with engine size

**Key Concepts:**
- Extends Vehicle class
- Adds engineSize attribute (in cubic centimeters)
- Overrides displayInfo() for motorcycle-specific details
- Demonstrates **Inheritance** and **Polymorphism**

### 5. **Garage.java** - Collection Manager
**Responsibility:** Manage a collection of vehicles with CRUD operations

**Key Operations:**
- **Create:** addVehicle() - Add vehicles to the garage
- **Read:** displayVehicles(), displayVehicleDetails() - View vehicles
- **Update:** updateVehicle() - Modify vehicle details
- **Delete:** removeVehicle() - Remove vehicles from garage

**Key Features:**
- Maximum capacity: 100 vehicles
- Array-based storage using Vehicle[]
- Maintains count of stored vehicles
- Demonstrates **Aggregation**

### 6. **Main.java** - Demo/Test Application
**Responsibility:** Demonstrate all system features and functionality

**Shows:**
- Creating instances of all vehicle types
- Adding vehicles to garage
- Displaying vehicles with polymorphic displayInfo()
- Searching and updating vehicles
- Removing vehicles
- Error handling for non-existent vehicles

## Compilation Instructions

### Step 1: Open Terminal/Command Prompt
Navigate to the UML directory where all Java files are located.

```bash
cd c:\Users\LENOVO\OneDrive\Desktop\UML
```

### Step 2: Compile All Java Files
Compile all source files in the correct order (base class first):

```bash
javac Vehicle.java
javac Car.java Truck.java Motorcycle.java
javac Garage.java
javac Main.java
```

Or compile all at once:

```bash
javac *.java
```

**Expected Output:** No output means successful compilation. Class files (.class) will be generated.

### Step 3: Run the Application

```bash
java Main
```

## Expected Output

When you run the Main class, you should see:

```
===============================================
   VEHICLE MANAGEMENT SYSTEM DEMONSTRATION
===============================================

>>> CREATING VEHICLES <<<

>>> ADDING VEHICLES TO GARAGE <<<

Vehicle added successfully!
Vehicle added successfully!
Vehicle added successfully!
Vehicle added successfully!
Vehicle added successfully!
Vehicle added successfully!

================== ALL VEHICLES IN GARAGE ==================
Total Vehicles: 6
=========================================================

Vehicle 1:
========== CAR ==========
Owner: John Smith
Brand: Toyota
Model: Camry
Year: 2022
Seating Capacity: 5 seats
========================

Vehicle 2:
========== CAR ==========
Owner: Emma Johnson
Brand: Honda
Model: Civic
Year: 2021
Seating Capacity: 5 seats
========================

... (and so on for all vehicles)
```

## Testing the System

### Test 1: Adding Vehicles
```java
Car car = new Car("John Doe", "Toyota", "Corolla", 2023, 5);
garage.addVehicle(car);  // Should print: Vehicle added successfully!
```

### Test 2: Displaying All Vehicles
```java
garage.displayVehicles();  // Shows all vehicles with their specific details
```

### Test 3: Searching by Owner Name
```java
garage.displayVehicleDetails("John Doe");  // Shows specific vehicle
```

### Test 4: Updating Vehicle
```java
garage.updateVehicle("John Doe", "Jane Doe", "Toyota", "Corolla", 2024);
// Should print: Vehicle updated successfully!
```

### Test 5: Removing Vehicle
```java
garage.removeVehicle("Jane Doe");  // Should print: Vehicle removed successfully!
```

### Test 6: Testing Error Handling
```java
garage.displayVehicleDetails("NonExistent");  // Should print: not found message
garage.removeVehicle("NonExistent");          // Should print: not found message
```

### Test 7: Garage Capacity
```java
// Add 100 vehicles to test maximum capacity
// Attempting to add 101st vehicle should fail
```

## OOP Principles in Practice

### 1. **Abstraction**
```java
// Cannot instantiate abstract class
// Vehicle v = new Vehicle();  // COMPILER ERROR

// Must use subclass
Vehicle car = new Car("Owner", "Brand", "Model", 2023, 5);  // OK
```

### 2. **Inheritance**
```java
// Car inherits all methods and attributes from Vehicle
Car car = new Car("John", "Toyota", "Camry", 2022, 5);
System.out.println(car.getOwnerName());  // Inherited method
System.out.println(car.getSeatingCapacity());  // Own method
```

### 3. **Encapsulation**
```java
// Cannot access private attributes directly
// car.ownerName = "Jane";  // COMPILER ERROR

// Must use setters
car.setOwnerName("Jane");  // OK
String name = car.getOwnerName();  // OK
```

### 4. **Polymorphism**
```java
// Different implementations of displayInfo() are called
Vehicle car = new Car("John", "Toyota", "Camry", 2022, 5);
Vehicle truck = new Truck("Michael", "Volvo", "FH16", 2020, 25.5);
Vehicle bike = new Motorcycle("Sarah", "Harley", "Street 750", 2023, 750);

// Each calls its own displayInfo() implementation
car.displayInfo();    // Shows car details
truck.displayInfo();  // Shows truck details
bike.displayInfo();   // Shows motorcycle details
```

## Common Issues and Solutions

### Issue 1: "Cannot instantiate abstract class Vehicle"
**Cause:** Trying to create a Vehicle object directly
**Solution:** Create an instance of a subclass (Car, Truck, or Motorcycle)

```java
// Wrong
Vehicle v = new Vehicle("John", "Brand", "Model", 2023);  // ERROR

// Correct
Vehicle v = new Car("John", "Toyota", "Camry", 2023, 5);  // OK
```

### Issue 2: "Garage is full"
**Cause:** Attempting to add more than 100 vehicles
**Solution:** Remove some vehicles or increase MAX_VEHICLES constant

```java
// Check if garage is full before adding
if (garage.getCount() < 100) {
    garage.addVehicle(vehicle);
}
```

### Issue 3: "Vehicle with owner name 'X' not found"
**Cause:** Owner name doesn't exist in garage
**Solution:** Check the exact owner name (note: search is case-insensitive)

```java
// Owner name must match exactly
garage.displayVehicleDetails("john smith");  // Works even though added as "John Smith"
```

## Creating Custom Vehicles

### Adding a New Vehicle Type: Bus

```java
public class Bus extends Vehicle {
    private int capacity;
    private int numberOfDoors;

    public Bus(String ownerName, String brand, String model, int year, 
               int capacity, int numberOfDoors) {
        super(ownerName, brand, model, year);
        this.capacity = capacity;
        this.numberOfDoors = numberOfDoors;
    }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    
    public int getNumberOfDoors() { return numberOfDoors; }
    public void setNumberOfDoors(int numberOfDoors) { this.numberOfDoors = numberOfDoors; }

    @Override
    public void displayInfo() {
        System.out.println("========== BUS ==========");
        System.out.println("Owner: " + getOwnerName());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Capacity: " + capacity + " passengers");
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("========================\n");
    }
}
```

## Performance Characteristics

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| addVehicle() | O(1) | O(1) |
| removeVehicle() | O(n) | O(1) |
| updateVehicle() | O(n) | O(1) |
| displayVehicles() | O(n) | O(1) |
| displayVehicleDetails() | O(n) | O(1) |

*n = number of vehicles in garage*

## Best Practices Followed

✅ **Single Responsibility Principle:** Each class has one clear purpose  
✅ **DRY (Don't Repeat Yourself):** Common code in base Vehicle class  
✅ **Proper Encapsulation:** Private attributes with public accessors  
✅ **Clear Naming:** Method and variable names clearly describe purpose  
✅ **Error Handling:** Methods return status or throw appropriate messages  
✅ **Code Documentation:** Javadoc comments explain purpose and usage  
✅ **Consistent Style:** Follows Java naming conventions (camelCase)  
✅ **Modular Design:** Easy to extend with new vehicle types  

## Running Unit Tests (Advanced)

You can create a test class to verify functionality:

```java
public class VehicleManagementTest {
    public static void main(String[] args) {
        Garage garage = new Garage();
        
        // Test 1: Add vehicle
        Car car = new Car("Test Owner", "Toyota", "Camry", 2023, 5);
        assert garage.addVehicle(car) : "Failed to add vehicle";
        assert garage.getCount() == 1 : "Count should be 1";
        
        // Test 2: Remove vehicle
        assert garage.removeVehicle("Test Owner") : "Failed to remove vehicle";
        assert garage.getCount() == 0 : "Count should be 0";
        
        // Test 3: Update non-existent vehicle
        assert !garage.updateVehicle("NonExistent", "New", "Brand", "Model", 2024) : 
            "Should fail for non-existent vehicle";
        
        System.out.println("All tests passed!");
    }
}
```

## Troubleshooting

**Problem:** Class files not found when running
**Solution:** Ensure you're in the correct directory with .class files

**Problem:** "public class X is public, should be declared in a file named X.java"
**Solution:** Verify file names match class names exactly

**Problem:** Compilation errors on Linux/Mac
**Solution:** Use forward slashes in paths: `/Users/...` instead of backslashes

## Next Steps

1. Study the source code to understand the class relationships
2. Modify the Main.java to add your own test cases
3. Create additional vehicle types extending Vehicle
4. Implement sorting functionality in Garage
5. Add persistence (file I/O) to save/load garage state
6. Develop a GUI using Swing or JavaFX
