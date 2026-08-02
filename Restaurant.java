class Restaurant {

    
    static int totalOrders = 0;

    
    void bill(int amount) {
        System.out.println("Dine-in Bill = Rs. " + amount);
        totalOrders++;
    }

   
    void bill(int amount, int packingCharge) {
        System.out.println("Takeaway Bill = Rs. " + (amount + packingCharge));
        totalOrders++;
    }

    
    void bill(int amount, int packingCharge, int deliveryCharge) {
        System.out.println("Delivery Bill = Rs. " + (amount + packingCharge + deliveryCharge));
        totalOrders++;
    }

    public static void main(String[] args) {

        Restaurant r = new Restaurant();

        r.bill(500);            
        r.bill(500, 30);        
        r.bill(500, 30, 50);    

        System.out.println("Total Orders = " + Restaurant.totalOrders);
    }
}