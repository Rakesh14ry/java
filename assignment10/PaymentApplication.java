abstract class Payment {

    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    // Abstract method
    abstract void makePayment();

    void displayAmount() {
        System.out.println("Payment Amount: Rs. " + amount);
    }
}

// Credit Card Payment
class CreditCard extends Payment {

    CreditCard(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using Credit Card");
    }
}

// UPI Payment
class UPI extends Payment {

    UPI(double amount) {
        super(amount);
    }

    void makePayment() {
        System.out.println("Payment made using UPI");
    }
}

public class PaymentApplication {

    public static void main(String[] args) {

        CreditCard card = new CreditCard(1500);

        System.out.println("Credit Card Payment:");
        card.displayAmount();
        card.makePayment();

        System.out.println();

        UPI upi = new UPI(1000);

        System.out.println("UPI Payment:");
        upi.displayAmount();
        upi.makePayment();
    }
}