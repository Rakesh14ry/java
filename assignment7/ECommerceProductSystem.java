// Product Interface
interface Product {

    void displayProduct();

    void calculatePrice();
}

// Common Parent Class
class ProductDetails {

    String name;
    double price;

    ProductDetails(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Electronic Product
class Electronic extends ProductDetails implements Product {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product: " + name);
        System.out.println("Category: Electronic");
        System.out.println("Price: Rs. " + price);
    }

    public void calculatePrice() {
        double finalPrice = price + (price * 0.18);
        System.out.println("Price with GST: Rs. " + finalPrice);
    }
}

// Clothing Product
class Clothing extends ProductDetails implements Product {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product: " + name);
        System.out.println("Category: Clothing");
        System.out.println("Price: Rs. " + price);
    }

    public void calculatePrice() {
        double discount = price * 0.10;
        double finalPrice = price - discount;
        System.out.println("Price after discount: Rs. " + finalPrice);
    }
}

// Grocery Product
class Grocery extends ProductDetails implements Product {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void displayProduct() {
        System.out.println("Product: " + name);
        System.out.println("Category: Grocery");
        System.out.println("Price: Rs. " + price);
    }

    public void calculatePrice() {
        System.out.println("Final Price: Rs. " + price);
    }
}

// Main Class
public class ECommerceProductSystem {

    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 50000);

        System.out.println("Electronic Product:");
        e.displayProduct();
        e.calculatePrice();

        System.out.println();

        Clothing c = new Clothing("T-Shirt", 1000);

        System.out.println("Clothing Product:");
        c.displayProduct();
        c.calculatePrice();

        System.out.println();

        Grocery g = new Grocery("Rice", 800);

        System.out.println("Grocery Product:");
        g.displayProduct();
        g.calculatePrice();
    }
}