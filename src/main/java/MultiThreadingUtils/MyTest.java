package MultiThreadingUtils;
class GThread extends Thread
{
    public void run()
    {
        System.out.println("GThread: run()");
    }

    public void start()
    {
        System.out.println("GThread: start()");
    }
}

class GRunnable implements Runnable
{
    public void run()
    {
        System.out.println("GRunnable: run()");
    }

    public void start()
    {
        System.out.println("GRunnable: start()");
    }
}

public class MyTest
{
    public static void main(String args[])
    {
        GThread gt = new GThread();
        GRunnable gr = new GRunnable();
        Thread thread = new Thread(gr);
        gt.start();
        thread.start();

    }
}
