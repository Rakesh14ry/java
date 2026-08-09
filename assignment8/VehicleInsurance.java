class Vehicle {

    String vehicleNumber = "MH12AB1234";
    String vehicleModel = "Toyota Fortuner";

    void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Model: " + vehicleModel);
    }
}

class CarInsurance extends Vehicle {

    String insuranceType = "Comprehensive";

    void displayInsurance() {

        System.out.println("Insurance Type: " + insuranceType);

        // Accessing parent class variables
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);

        // Calling parent class method
        super.displayVehicle();
    }
}

class BikeInsurance extends Vehicle {

    String insuranceType = "Third Party";

    void displayInsurance() {

        System.out.println("Insurance Type: " + insuranceType);

        // Accessing parent class variables
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Vehicle Model: " + super.vehicleModel);

        // Calling parent class method
        super.displayVehicle();
    }
}

public class VehicleInsurance {

    public static void main(String[] args) {

        CarInsurance car = new CarInsurance();

        System.out.println("Car Insurance:");
        car.displayInsurance();

        System.out.println();

        BikeInsurance bike = new BikeInsurance();

        System.out.println("Bike Insurance:");
        bike.displayInsurance();
    }
}