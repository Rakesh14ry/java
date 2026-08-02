class Mobile {
    String brand;
    int price;

    // Default Constructor
    Mobile() {
        brand = "Not Available";
        price = 0;
    }

    // Parameterized Constructor
    Mobile(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    // Copy Constructor
    Mobile(Mobile m) {
        this.brand = m.brand;
        this.price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {

        Mobile m1 = new Mobile();                    // Default Constructor
        Mobile m2 = new Mobile("Samsung", 25000);    // Parameterized Constructor
        Mobile m3 = new Mobile(m2);                  // Copy Constructor

        System.out.println("Mobile 1:");
        m1.display();

        System.out.println("\nMobile 2:");
        m2.display();

        System.out.println("\nMobile 3 (Copy of Mobile 2):");
        m3.display();
    }
}