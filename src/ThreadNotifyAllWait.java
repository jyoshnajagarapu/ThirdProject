import java.util.Scanner;

// Java program to illustrate the
// behaviour of notify() method
class Geek1 extends Thread {
    public void run()
    {
        synchronized (this)
        {
            System.out.println(
                    Thread.currentThread().getName()
                            + "...starts");
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    Thread.currentThread().getName()
                            + "...notified");
           // notify(); uncomment and check output
        }
    }
}
class Geek2 extends Thread {
    Geek1 geeks1;

    Geek2(Geek1 geeks1){
        this.geeks1 = geeks1;
    }

    public void run()
    {
        synchronized (this.geeks1)
        {
            System.out.println(
                    Thread.currentThread().getName()
                            + "...starts");

            try {
                this.geeks1.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    Thread.currentThread().getName()
                            + "...notified");
        }
    }
}
class Geek3 extends Thread {
    Geek1 geeks1;
    Geek3(Geek1 geeks1) { this.geeks1 = geeks1; }
    public void run()
    {
        synchronized (this.geeks1)
        {
            System.out.println(
                    Thread.currentThread().getName()
                            + "...starts");
            //this.geeks1.notify();//uncomment this and check
            this.geeks1.notifyAll();
            System.out.println(
                    Thread.currentThread().getName()
                            + "...notified");
        }
    }
}
class MainClass {
    public static void main(String[] args)
            throws InterruptedException
    {

        Geek1 geeks1 = new Geek1();
        Geek2 geeks2 = new Geek2(geeks1);
        Geek3 geeks3 = new Geek3(geeks1);
        Thread t1 = new Thread(geeks1, "Thread-1");
        Thread t2 = new Thread(geeks2, "Thread-2");
        Thread t3 = new Thread(geeks3, "Thread-3");
        t1.start();
        t2.start();
        Thread.sleep(100);
        t3.start();
    }
}

// Java program to demonstrate the use of wait() method
class GunFight {
    private int bullets = 40;

    // This method fires the number of bullets that are
    // passed it. When the bullet in magazine becomes zero,
    // it calls the wait() method and releases the lock.
    synchronized public void fire(int bulletsToBeFired)
    {
        for (int i = 1; i <= bulletsToBeFired; i++) {
            if (bullets == 0) {
                System.out.println(i - 1
                        + " bullets fired and "
                        + bullets + " remains");
                System.out.println(
                        "Invoking the wait() method");
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        "Continuing the fire after reloading");
            }

            bullets--;
        }
        System.out.println(
                "The firing process is complete");
    }

    // reload() increases the bullets by 40 everytime it is
    // invoked and calls the notify() method which wakes up
    // the thread that was sent to sleep using wait() inside
    // of fire() method
    synchronized public void reload()
    {
        System.out.println(
                "Reloading the magazine and resuming "
                        + "the thread using notify()");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        bullets += 40;
        notify();//notify doesnt leave the lock it only wakes other threads
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "sleeping done");
    }
}

 class WaitDemo extends Thread {
    public static void main(String[] args)
    {

        GunFight gf = new GunFight();

        // Creating a new thread and invoking
        // our fire() method on it
        new Thread() {
            @Override public void run() { gf.fire(60); }
        }.start();

        // Creating a new thread and invoking
        // our reload method on it
        new Thread() {
            @Override public void run() { gf.reload(); }
        }.start();
    }
}

// Java program to demonstrate inter-thread communication
// (wait(), join() and notify())

class threadexample
{
    public static void main(String[] args) throws InterruptedException
    {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static class PC
    {
        public void produce()throws InterruptedException
        {
            // synchronized block ensures only one thread
            // running at a time.
            synchronized(this)
            {
                System.out.println("producer thread running");

                // releases the lock on shared resource
                wait();

                // and waits till some other method invokes notify().
                System.out.println("Resumed");
            }
        }

        // Sleeps for some time and waits for a key press. After key
        // is pressed, it notifies produce().
        public void consume()throws InterruptedException
        {
            // this makes the produce thread to run first.
            Thread.sleep(1000);
            Scanner s = new Scanner(System.in);

            // synchronized block ensures only one thread
            // running at a time.
            synchronized(this)
            {
                System.out.println("Waiting for return key.");
                s.nextLine();
                System.out.println("Return key pressed");

                // notifies the produce thread that it
                // can wake up.
                notify();
                //Firstly, unlike wait(), it does not release the lock on shared resources therefore for getting the desired result, it is advised to use notify only at the end of your method. Secondly, it notifies the waiting threads that they can now wake up but only after the current method terminates.
                // Sleep
                Thread.sleep(10000);
            }
        }
    }
}


