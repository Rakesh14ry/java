class FoodDelivery {

    String customerName = "Rakesh";
    String foodName = "Pizza";
    double price = 299.0;

    // Inner Class
    class OrderDetails {

        void displayOrder() {
            System.out.println("Customer: " + customerName);
            System.out.println("Food: " + foodName);
            System.out.println("Price: Rs. " + price);
        }
    }

    public static void main(String[] args) {

        FoodDelivery order = new FoodDelivery();

        // Object of Inner Class
        OrderDetails details = order.new OrderDetails();

        System.out.println("Order Details:");
        details.displayOrder();

        // Anonymous Class
        Runnable deliveryStatus = new Runnable() {
            public void run() {
                System.out.println("Delivery Status: Out for Delivery");
            }
        };

        deliveryStatus.run();
    }
}