class BankAccount {

    private int balance = 1000;

    synchronized void deposit(int amount) {

        balance = balance + amount;

        System.out.println(
            "Deposit: Rs." + amount +
            " | Balance: Rs." + balance
        );
    }

    synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance = balance - amount;

            System.out.println(
                "Withdraw: Rs." + amount +
                " | Balance: Rs." + balance
            );

        } else {

            System.out.println(
                "Withdraw: Rs." + amount +
                " | Insufficient Balance"
            );
        }
    }
}

class DepositTask implements Runnable {

    private BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.deposit(500);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawTask implements Runnable {

    private BankAccount account;

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            account.withdraw(300);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Exp26b {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        DepositTask depositTask = new DepositTask(account);
        WithdrawTask withdrawTask = new WithdrawTask(account);

        Thread depositThread = new Thread(depositTask);
        Thread withdrawThread = new Thread(withdrawTask);

        depositThread.start();
        withdrawThread.start();
    }
}
