class BankAccount {
    final int accountNumber = 12345;
    String name = "Rahul";
    double balance = 25000;

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.display();
    }
}
  
