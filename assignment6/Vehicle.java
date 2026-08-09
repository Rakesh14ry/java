class Vehicle {

    String brand = "Toyota";
    String model = "Fortuner";
    int year = 2024;

    // Inner Class
    class VehicleDetails {

        void displayDetails() {
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
        }
    }

    public static void main(String[] args) {

        Vehicle v = new Vehicle();

        // Object of Inner Class
        VehicleDetails details = v.new VehicleDetails();

        System.out.println("Vehicle Details:");
        details.displayDetails();

        // Anonymous Class
        Runnable action = new Runnable() {
            public void run() {
                System.out.println("Vehicle is starting...");
            }
        };

        action.run();
    }
}