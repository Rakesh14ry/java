abstract class FoodOrder {

    double foodPrice;

    FoodOrder(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    // Abstract method
    abstract void calculateBill();
}

// Dine-In Order
class DineInOrder extends FoodOrder {

    DineInOrder(double foodPrice) {
        super(foodPrice);
    }

    void calculateBill() {

        double serviceCharge = foodPrice * 0.05;
        double total = foodPrice + serviceCharge;

        System.out.println("Order Type: Dine-In");
        System.out.println("Food Price: Rs. " + foodPrice);
        System.out.println("Service Charge: Rs. " + serviceCharge);
        System.out.println("Total Bill: Rs. " + total);
    }
}

// Take-Away Order
class TakeAwayOrder extends FoodOrder {

    TakeAwayOrder(double foodPrice) {
        super(foodPrice);
    }

    void calculateBill() {

        double packingCharge = 30;
        double total = foodPrice + packingCharge;

        System.out.println("Order Type: Take-Away");
        System.out.println("Food Price: Rs. " + foodPrice);
        System.out.println("Packing Charge: Rs. " + packingCharge);
        System.out.println("Total Bill: Rs. " + total);
    }
}

public class FoodOrderApplication {

    public static void main(String[] args) {

        DineInOrder dineIn = new DineInOrder(500);

        dineIn.calculateBill();

        System.out.println();

        TakeAwayOrder takeAway = new TakeAwayOrder(500);

        takeAway.calculateBill();
    }
}