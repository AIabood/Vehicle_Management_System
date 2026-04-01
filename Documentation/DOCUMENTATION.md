# Vehicle Management System - Documentation

## Overview
The Vehicle Management System is a comprehensive object-oriented design that demonstrates key OOP principles through a practical vehicle management application. The system allows users to manage a collection of various vehicle types within a garage.

## System Architecture

### Class Hierarchy

```
Vehicle (Abstract Base Class)
    ├── Car
    ├── Truck
    └── Motorcycle

Garage (Manager/Collection Class)
```

## Class Descriptions

### 1. **Vehicle** (Abstract Base Class)
**Purpose:** Represents the general concept of a vehicle  
**Access Modifier:** public abstract  
**Scope:** Package-wide base for all vehicle types

#### Attributes:
- `ownerName: String` - The vehicle owner's name
- `brand: String` - The vehicle manufacturer brand
- `model: String` - The specific vehicle model
- `year: int` - The manufacturing year

#### Methods:
- `Vehicle(String ownerName, String brand, String model, int year)` - Parameterized constructor
- `getOwnerName(): String` - Retrieves owner name
- `setOwnerName(String ownerName): void` - Sets owner name
- `getBrand(): String` - Retrieves brand
- `setBrand(String brand): void` - Sets brand
- `getModel(): String` - Retrieves model
- `setModel(String model): void` - Sets model
- `getYear(): int` - Retrieves year
- `setYear(int year): void` - Sets year
- `displayInfo(): void` - Abstract method for displaying vehicle information

**OOP Principles Demonstrated:**
- **Abstraction:** The class is abstract, forcing subclasses to implement `displayInfo()`
- **Encapsulation:** All attributes are private with public getters/setters

---

### 2. **Car** (Extends Vehicle)
**Purpose:** Represents a car vehicle with seating capacity

#### Additional Attributes:
- `seatingCapacity: int` - Number of seats in the car

#### Additional Methods:
- `Car(String ownerName, String brand, String model, int year, int seatingCapacity)` - Constructor
- `getSeatingCapacity(): int` - Retrieves seating capacity
- `setSeatingCapacity(int seatingCapacity): void` - Sets seating capacity
- `displayInfo(): void` - Overridden method showing car-specific details

**OOP Principles Demonstrated:**
- **Inheritance:** Extends Vehicle class
- **Polymorphism:** Overrides `displayInfo()` to display car-specific information

---

### 3. **Truck** (Extends Vehicle)
**Purpose:** Represents a truck vehicle with cargo capacity

#### Additional Attributes:
- `cargoCapacity: double` - Maximum cargo capacity in tons

#### Additional Methods:
- `Truck(String ownerName, String brand, String model, int year, double cargoCapacity)` - Constructor
- `getCargoCapacity(): double` - Retrieves cargo capacity
- `setCargoCapacity(double cargoCapacity): void` - Sets cargo capacity
- `displayInfo(): void` - Overridden method showing truck-specific details

**OOP Principles Demonstrated:**
- **Inheritance:** Extends Vehicle class
- **Polymorphism:** Overrides `displayInfo()` to display truck-specific information
- **Specialization:** Adds domain-specific functionality (cargo management)

---

### 4. **Motorcycle** (Extends Vehicle)
**Purpose:** Represents a motorcycle vehicle with engine size

#### Additional Attributes:
- `engineSize: int` - Engine displacement in cubic centimeters (cc)

#### Additional Methods:
- `Motorcycle(String ownerName, String brand, String model, int year, int engineSize)` - Constructor
- `getEngineSize(): int` - Retrieves engine size
- `setEngineSize(int engineSize): void` - Sets engine size
- `displayInfo(): void` - Overridden method showing motorcycle-specific details

**OOP Principles Demonstrated:**
- **Inheritance:** Extends Vehicle class
- **Polymorphism:** Overrides `displayInfo()` to display motorcycle-specific information
- **Specialization:** Adds domain-specific functionality (engine size)

---

### 5. **Garage** (Collection Manager)
**Purpose:** Manages a collection of vehicles with one-to-many relationship  
**Maximum Capacity:** 100 vehicles

#### Attributes:
- `vehicles: Vehicle[]` - Array of Vehicle objects
- `count: int` - Current number of vehicles in the garage
- `MAX_VEHICLES: int = 100` - Constant for maximum garage capacity

#### Methods:
- `Garage()` - Constructor initializing empty garage
- `getCount(): int` - Returns the number of vehicles in the garage
- `addVehicle(Vehicle vehicle): boolean` - Adds a vehicle to the garage
  - Returns `true` if successful
  - Returns `false` if garage is full
  
- `updateVehicle(String currentOwner, String newOwner, String brand, String model, int year): boolean` - Updates vehicle details
  - Searches by current owner name
  - Returns `true` if found and updated
  - Returns `false` if owner not found
  
- `removeVehicle(String ownerName): boolean` - Removes a vehicle by owner name
  - Returns `true` if successful
  - Returns `false` if owner not found
  
- `displayVehicles(): void` - Displays all vehicles in the garage
  
- `displayVehicleDetails(String ownerName): void` - Displays details of a specific vehicle

**OOP Principles Demonstrated:**
- **Aggregation:** Contains Vehicle objects in a one-to-many relationship
- **Polymorphism:** Works with the Vehicle interface, can handle any subclass type

---

## OOP Principles Demonstrated

### 1. **Abstraction**
- The `Vehicle` class is abstract, defining a contract for all vehicle types
- The abstract method `displayInfo()` forces each subclass to provide its own implementation
- Users don't need to know the implementation details of how each vehicle displays info

### 2. **Inheritance**
- `Car`, `Truck`, and `Motorcycle` inherit from `Vehicle`
- Each subclass extends the base functionality with specialized attributes and methods
- Code reusability is achieved through shared base class functionality

### 3. **Encapsulation**
- All attributes are declared as `private` in all classes
- Public getter and setter methods provide controlled access to attributes
- Internal implementation details are hidden from external users
- The `Garage` class maintains its own state (vehicles and count) with controlled access

### 4. **Polymorphism**
- The `displayInfo()` method is overridden in each subclass
- Each subclass provides its own execution of the method
- The `Garage` can call `displayInfo()` on Vehicle references without knowing the actual type
- Runtime binding ensures the correct method is executed based on the actual object type

---

## Design Patterns Used

### 1. **Array-based Collection Pattern**
- Uses an array to store vehicles with a count variable
- Provides bounded collection (max 100 vehicles)

### 2. **Linear Search Pattern**
- Used in `updateVehicle()`, `removeVehicle()`, and `displayVehicleDetails()`
- Searches by owner name to locate specific vehicles

### 3. **Shift Operation Pattern**
- Used in `removeVehicle()` to maintain array continuity when removing elements

---

## Usage Example

```java
// Create a garage
Garage garage = new Garage();

// Create vehicles
Car car = new Car("John Smith", "Toyota", "Camry", 2022, 5);
Truck truck = new Truck("Michael Brown", "Volvo", "FH16", 2020, 25.5);
Motorcycle bike = new Motorcycle("Sarah Wilson", "Harley-Davidson", "Street 750", 2023, 750);

// Add vehicles
garage.addVehicle(car);
garage.addVehicle(truck);
garage.addVehicle(bike);

// Display all vehicles
garage.displayVehicles();

// Display specific vehicle
garage.displayVehicleDetails("John Smith");

// Update vehicle
garage.updateVehicle("John Smith", "Jane Smith", "Toyota", "Camry", 2023);

// Remove vehicle
garage.removeVehicle("Michael Brown");
```

---

## Key Features

✅ **Modularity:** Each class has a single, well-defined responsibility  
✅ **Extensibility:** New vehicle types can be easily added by extending Vehicle class  
✅ **Reusability:** Base Vehicle class eliminates code duplication  
✅ **Type Safety:** Abstract base class ensures all vehicles have required methods  
✅ **Collection Management:** Garage provides centralized vehicle management  
✅ **Error Handling:** Methods return boolean values to indicate success/failure  
✅ **User-Friendly Output:** Formatted display methods for easy information retrieval  

---

## Possible Future Enhancements

1. Implement a vehicle search method by brand or year
2. Add sorting functionality (by owner name, year, etc.)
3. Implement a file persistence system (save/load garage)
4. Add a rental tracking system
5. Implement a maintenance history for each vehicle
6. Add vehicle pricing and valuation
7. Implement a user authentication system
8. Add advanced filtering and querying capabilities
9. Integrate with a database system
10. Create a GUI application using Swing or JavaFX

---

## Running the System

To compile and run:

```bash
javac Vehicle.java Car.java Truck.java Motorcycle.java Garage.java Main.java
java Main
```

The `Main.java` class contains a comprehensive demonstration of all system features.
