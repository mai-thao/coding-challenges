package designpatterns.factory;

/**
 * An interface defines a set of method contracts with no shared states (no memory allocated). It is ideal
 * for unrelated classes like a "Flyable" interface that can be implemented by unrelated objects like a
 * bird, plane, drones, etc.
 *
 * Its method are declared and not defined. The implementing class MUST implement the methods (with method
 * bodies).
 */
interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

/**
 * Abstract classes define shared states (with memory spaces) and behaviors for RELATED classes. Like an
 * `Animal` class that shares common properties like `name` or `age` and common behaviors like `sleep()`
 * or `eat()`. An abstract class can have both concrete (implemented) or abstract methods (no implementation).
 *
 * For example, the abstract method `createVehicle()` is not implemented (no method body) and must be implemented
 * in its extending subclass.
 */
abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}

class TruckFactory extends VehicleFactory {
    public Vehicle createVehicle() {
        return new Truck();
    }
}

/**
 * The Factory Method is a creational design pattern that provides an interface for creating objects
 * in a superclass but allows subclasses to alter the type of objects that will be created.
 */
public class FactoryMethodDesign {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactory bikeFactory = new BikeFactory();

        Vehicle myCar = carFactory.createVehicle();
        Vehicle myTruck = truckFactory.createVehicle();
        Vehicle myBike = bikeFactory.createVehicle();

        System.out.println(myCar.getType());   // "Car"
        System.out.println(myTruck.getType()); // "Truck"
        System.out.println(myBike.getType());  // "Bike"
    }
}
