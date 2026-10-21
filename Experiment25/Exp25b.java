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
class DepositThread extends Thread {     
    BankAccount account; 
    DepositThread(BankAccount account) { 
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
class WithdrawThread extends Thread {     
    BankAccount account; 
    WithdrawThread(BankAccount account) {         this.account = account; 
    } 
    public void run() {         for (int i = 1; i <= 5; i++) { 
            account.withdraw(300); 
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException e) { 
                System.out.println(e); 
            } 
        } 
    } } public class Exp25b { 
    public static void main(String[] args) {         BankAccount account = new BankAccount();         DepositThread depositThread =             new DepositThread(account); 
        WithdrawThread withdrawThread =             new WithdrawThread(account); 
        depositThread.start(); 
        withdrawThread.start(); 
    } } 
