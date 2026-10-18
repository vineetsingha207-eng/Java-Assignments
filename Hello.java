class NumberThread extends Thread
{
    NumberThread(String name)
    {
        super(name);
    }

    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(getName()+" : "+i);

            try
            {
                Thread.sleep(300);
            }
            catch(Exception e){}
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
        NumberThread t1=new NumberThread("Thread-1");
        NumberThread t2=new NumberThread("Thread-2");
        NumberThread t3=new NumberThread("Thread-3");

        System.out.println(t1.getState());

        t1.start();
        t2.start();
        t3.start();

        System.out.println(t1.getState());
    }
}