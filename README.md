# Vehicle Management System - README

## 🚗 Project Overview

A comprehensive **Object-Oriented Vehicle Management System** implemented in Java, demonstrating core OOP principles through a practical vehicle parking garage application. The system allows management of different vehicle types (Cars, Trucks, and Motorcycles) within a centralized garage.

## ✨ Key Features

- **Abstract Base Class:** Vehicle class provides common interface for all vehicle types
- **Inheritance:** Three specialized vehicle classes extend Vehicle
- **Polymorphism:** Each vehicle type provides its own implementation of `displayInfo()`
- **Encapsulation:** Private attributes with public getters/setters ensure data protection
- **Collection Management:** Garage manages up to 100 vehicles with CRUD operations
- **User-Friendly Display:** Formatted output for easy information visualization
- **Error Handling:** Robust error messages for invalid operations

## 📋 System Components

### Classes

| Class | Type | Purpose |
|-------|------|---------|
| `Vehicle` | Abstract | Base class defining common interface for all vehicles |
| `Car` | Concrete | Represents cars with seating capacity |
| `Truck` | Concrete | Represents trucks with cargo capacity |
| `Motorcycle` | Concrete | Represents motorcycles with engine size |
| `Garage` | Concrete | Manages collection of vehicles |
| `Main` | Demo | Comprehensive demonstration of all features |

### Attributes

**Vehicle (Base Class):**
- `ownerName: String` - Vehicle owner's name
- `brand: String` - Manufacturer brand
- `model: String` - Vehicle model
- `year: int` - Manufacturing year

**Car:**
- `seatingCapacity: int` - Number of seats

**Truck:**
- `cargoCapacity: double` - Maximum cargo capacity (tons)

**Motorcycle:**
- `engineSize: int` - Engine displacement (cc)

**Garage:**
- `vehicles: Vehicle[]` - Array holding up to 100 vehicles
- `count: int` - Current number of vehicles

### Core Methods

**Garage Operations:**
- `addVehicle(Vehicle)` - Add a vehicle to the garage
- `updateVehicle(...)` - Update vehicle details
- `removeVehicle(String)` - Remove vehicle by owner name
- `displayVehicles()` - Show all vehicles in garage
- `displayVehicleDetails(String)` - Show specific vehicle details

## 🏗️ OOP Principles Demonstrated

### 1. **Abstraction**
- `Vehicle` is an abstract class with abstract `displayInfo()` method
- Forces all subclasses to provide concrete implementation
- Hides implementation complexity from users

### 2. **Inheritance**
- `Car`, `Truck`, `Motorcycle` extend `Vehicle`
- Reuse common attributes and methods
- Each adds specialized functionality

### 3. **Encapsulation**
- All attributes marked as `private`
- Public getters and setters control access
- Internal state protected from external modification

### 4. **Polymorphism**
- `displayInfo()` overridden in all subclasses
- Runtime polymorphism: correct method called based on object type
- Garage works with `Vehicle` references, unaffected by actual subclass

## 📁 File Structure

```
UML/
├── Vehicle.java                 # Abstract base class
├── Car.java                     # Car implementation
├── Truck.java                   # Truck implementation
├── Motorcycle.java              # Motorcycle implementation
├── Garage.java                  # Collection manager
├── Main.java                    # Demo application
├── README.md                    # This file
├── DOCUMENTATION.md             # Detailed system documentation
├── UML_DIAGRAM.md               # UML class diagrams and relationships
└── IMPLEMENTATION_GUIDE.md      # Compilation and usage guide
```

## 🚀 Quick Start

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command-line terminal or IDE

### Compilation

```bash
cd c:\Users\LENOVO\OneDrive\Desktop\UML
javac *.java
```

### Execution

```bash
java Main
```

### Expected Output
The program will:
1. Create various vehicles (cars, trucks, motorcycles)
2. Add them to the garage
3. Display all vehicles with their specific details
4. Demonstrate search functionality
5. Update vehicle information
6. Remove vehicles
7. Show error handling

## 💻 Basic Usage Example

```java
// Create a garage
Garage garage = new Garage();

// Create vehicles
Car car = new Car("John Smith", "Toyota", "Camry", 2022, 5);
Truck truck = new Truck("Michael Brown", "Volvo", "FH16", 2020, 25.5);
Motorcycle bike = new Motorcycle("Sarah Wilson", "Harley-Davidson", "Street 750", 2023, 750);

// Add to garage
garage.addVehicle(car);
garage.addVehicle(truck);
garage.addVehicle(bike);

// Display all vehicles
garage.displayVehicles();

// Find specific vehicle
garage.displayVehicleDetails("John Smith");

// Update vehicle
garage.updateVehicle("John Smith", "Jane Smith", "Toyota", "Corolla", 2023);

// Remove vehicle
garage.removeVehicle("Michael Brown");
```

## 📊 Class Relationships

```
                    Vehicle (Abstract)
                    ▲      ▲      ▲
                    |      |      |
                  / |      |      \ \
                /  |      |      \  \
              Car  Truck  Motorcycle

              Garage ◇─────── Vehicle
              (1)  (0..100)
```

**Relationship Types:**
- **Inheritance:** Car, Truck, Motorcycle inherit from Vehicle
- **Aggregation:** Garage contains collection of Vehicles (one-to-many)

## 🔍 Key Design Patterns

1. **Array-based Collection**: Uses fixed-size array with count variable
2. **Linear Search**: Searches by owner name using iteration
3. **Polymorphic Dispatch**: Runtime method selection based on object type
4. **Encapsulation with Accessors**: Private fields with public get/set methods

## 📈 Scalability and Extensions

The system is designed to be easily extensible:

### Adding New Vehicle Types

Simply create a new class extending `Vehicle`:

```java
public class Bus extends Vehicle {
    private int passengerCapacity;
    // ... implement required methods
}
```

### Potential Enhancements

- [ ] Implement Comparable interface for sorting
- [ ] Add file persistence (save/load)
- [ ] Create graphical user interface (GUI)
- [ ] Add database integration
- [ ] Implement search filters (by brand, year, etc.)
- [ ] Add vehicle maintenance tracking
- [ ] Implement rental system
- [ ] Add pricing/valuation system

## 🐛 Troubleshooting

| Issue | Cause | Solution |
|-------|-------|----------|
| "Cannot instantiate abstract class" | Trying to create Vehicle object | Use subclass instead |
| "Garage is full" | Exceeds 100 vehicle limit | Remove some vehicles |
| "Not found" | Vehicle owner name doesn't exist | Check exact owner name |
| Compilation failed | Missing Java | Install JDK |
| Class file not found | In wrong directory | Navigate to UML folder |

## 📚 Documentation Files

- **DOCUMENTATION.md** - Complete system documentation with detailed class descriptions
- **UML_DIAGRAM.md** - Visual UML diagrams and class relationships
- **IMPLEMENTATION_GUIDE.md** - Step-by-step compilation, testing, and troubleshooting guide

## 🎯 Learning Outcomes

By studying this system, you'll understand:

✅ How to design abstract base classes  
✅ How inheritance enables code reuse  
✅ How polymorphism provides flexibility  
✅ How encapsulation protects data  
✅ How to manage collections of objects  
✅ How to apply SOLID principles in practice  
✅ Object-oriented design patterns  
✅ Professional Java coding practices  

## 📝 Code Quality Features

- **Comprehensive Comments:** Javadoc-style documentation for all classes and methods
- **Consistent Naming:** Follows Java naming conventions
- **Error Messages:** User-friendly feedback for all operations
- **Modular Design:** Each class has single, clear responsibility
- **No Code Duplication:** Common functionality in base class
- **Type Safety:** Proper use of inheritance hierarchy

## 🔐 Encapsulation Benefits

The system demonstrates how encapsulation provides:

1. **Data Protection:** Private attributes cannot be directly modified
2. **Controlled Access:** Setters can validate data before assignment
3. **Implementation Flexibility:** Internal changes don't affect external code
4. **Interface Stability:** Public methods remain consistent

## ⚙️ Performance Characteristics

| Operation | Time | Space | Notes |
|-----------|------|-------|-------|
| Add Vehicle | O(1) | O(1) | Constant time insertion |
| Search Vehicle | O(n) | O(1) | Linear search by owner |
| Remove Vehicle | O(n) | O(1) | Includes array shift |
| Display All | O(n) | O(1) | Iterates through all |

## 📖 Best Practices Demonstrated

✅ **SOLID Principles:** Single responsibility, open/closed principle  
✅ **DRY (Don't Repeat Yourself):** Eliminated code duplication  
✅ **Clean Code:** Clear naming and organization  
✅ **Documentation:** Comprehensive comments and guides  
✅ **Error Handling:** Graceful failure with informative messages  
✅ **Modularity:** Independent, reusable components  
✅ **Extensibility:** Easy to add new vehicle types  

## 🤝 Contributing

To improve this system:

1. Add new vehicle types by extending Vehicle
2. Implement advanced search features
3. Add vehicle filtering and sorting
4. Create a GUI interface
5. Add database support
6. Implement file persistence

## 📄 License

This is an educational project demonstrating Object-Oriented Programming principles in Java.

## 👨‍💼 Author Notes

This Vehicle Management System serves as a practical example of how to design robust, maintainable object-oriented software. It demonstrates that good design makes code easier to understand, modify, and extend.

---

**Version:** 1.0  
**Last Updated:** 2026  
**Language:** Java  
**Difficulty Level:** Beginner to Intermediate  

For detailed information, refer to DOCUMENTATION.md and IMPLEMENTATION_GUIDE.md.
