class BankAccount
{
    int balance=1000;
    synchronized void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Deposit: "+amount+" Balance: "+balance);
    }
    synchronized void withdraw(int amount)
    {
        if(balance>=amount)
        {
            balance-=amount;
            System.out.println("Withdraw: "+amount+" Balance: "+balance);
        }
        else
            System.out.println("Insufficient Balance");
    }
}
class DepositThread extends Thread
{
    BankAccount acc;
    DepositThread(BankAccount acc)
    {
        this.acc=acc;
    }
    public void run()
    {
        for(int i=0;i<5;i++)
            acc.deposit(500);
    }
}
class WithdrawThread extends Thread
{
    BankAccount acc;
    WithdrawThread(BankAccount acc)
    {
        this.acc=acc;
    }
    public void run()
    {
        for(int i=0;i<5;i++)
            acc.withdraw(300);
    }
}
public class Main1
{
    public static void main(String args[])
    {
        BankAccount acc=new BankAccount();

        DepositThread d=new DepositThread(acc);
        WithdrawThread w=new WithdrawThread(acc);
        d.start();
        w.start();
    }
}