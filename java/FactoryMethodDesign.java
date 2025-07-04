/**
 * The Factory Method is a creational design pattern that provides an interface for creating objects
 * in a superclass but allows subclasses to alter the type of objects that will be created.
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

// Abstract methods like `createVehicle()` are not implemented (no method body) in their abstract classes
// That means all subclasses MUST implement it themselves
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
