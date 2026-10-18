class Account {
    int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Deposit implements Runnable {
    Account a;

    Deposit(Account a) {
        this.a = a;
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
            a.deposit(500);
    }
}

class Withdrawal implements Runnable {
    Account a;

    Withdrawal(Account a) {
        this.a = a;
    }

    public void run() {
        for (int i = 1; i <= 3; i++)
            a.withdraw(300);
    }
}

public class Hello11 {
    public static void main(String[] args) {
        Account a = new Account();

        Thread t1 = new Thread(new Deposit(a));
        Thread t2 = new Thread(new Withdrawal(a));

        t1.start();
        t2.start();
    }
}