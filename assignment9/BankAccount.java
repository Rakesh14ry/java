class BankAccount {

    // Final variable
    final long accountNumber = 1234567890L;

    String holderName = "Rakesh";
    double balance = 25000;

    void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: Rs. " + balance);
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.displayAccount();

        // This is not allowed because accountNumber is final
        // account.accountNumber = 9876543210L;
    }
}