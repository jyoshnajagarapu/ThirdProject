import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Here 3 constants are defined in it namely as follows:
//
//public static int NORM_PRIORITY - default 5
//public static int MIN_PRIORITY - 1
//public static int MAX_PRIORITY - 10
//child takes parent priority
//main is default 5
//max_priority thread executes first
//https://www.geeksforgeeks.org/thread-pools-java/?ref=lbp
//When thread enters into synchronized instance method or block, it acquires Object level lock and when it enters into synchronized static method or block it acquires class level lock.
class MultithreadingDemo extends Thread {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

// Main Class
 class Multithread {
    public static void main(String[] args)
    {
        int n = 8; // Number of threads
        for (int i = 0; i < n; i++) {
            MultithreadingDemo object
                    = new MultithreadingDemo();
            object.start();
        }
        //below also possible
        MultithreadingDemo object1
                = new MultithreadingDemo();

        Thread t = new Thread(object1);
        Thread s = new Thread(object1);
    }

}
// Java code for thread creation by implementing
// the Runnable Interface
class MultithreadingDemo1 implements Runnable {
    public void run()
    {
        try {
            // Displaying the thread that is running
            System.out.println(
                    "Thread " + Thread.currentThread().getId()
                            + " is running");
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

}

// Main Class
class Multithread1 {
    public static void main(String[] args)
    {

        ThreadGroup tg = new ThreadGroup("thgr");

        Thread t = new Thread();

        Thread obj2 = new Thread("thread2");
        Thread object3 = new Thread(tg, "tgthread");

        Thread object7 = new Thread(new MultithreadingDemo1());
        Thread object2 = new Thread(tg, new MultithreadingDemo1());

        Thread object1 = new Thread(new MultithreadingDemo1(), "thread1");
        Thread object6 = new Thread(tg,new MultithreadingDemo1(), "thread3");
        Thread object8 = new Thread(tg,new MultithreadingDemo1(), "thread6", 20);

        System.out.println("number of active thread: " + Thread.activeCount());
        Thread[] group = new Thread[Thread.activeCount()];
        int count = Thread.enumerate(group);
        for (int i = 0; i < count; i++)
        {
            System.out.println("Thread " + group[i].getName() + " found");
        }
        object7.checkAccess();
        object8.setPriority(4);
        System.out.println(object8.toString());
        System.out.println("isalive" + object8.isAlive());
        System.out.println("getPriority" + object8.getPriority());
        object8.setDaemon(true);//If you call the setDaemon() method after starting the thread, it would throw IllegalThreadStateException.
        System.out.println(object8.isDaemon());

        System.out.println("thread: isInterrupted " + object6.isInterrupted());
        object6.interrupt();
        System.out.println("thread: isInterrupted " + object6.isInterrupted());
        System.out.println("thread: Interrupted " + Thread.interrupted());

        System.out.println("thread: " + Thread.currentThread());
        System.out.println("thread:dumpStack ");
                Thread.dumpStack();
        Map<Thread, StackTraceElement[]> st = Thread.getAllStackTraces();
        Set<Thread> threadSet = st.keySet();
        // iterating over the threads to get the names of
        // all the active threads
        System.out.println("thread: printing ");
        for (Thread x : threadSet) {
            System.out.println(x.getName());
        }
        ClassLoader c = t.getContextClassLoader();
        // sets the context ClassLoader for this Thread
        t.setContextClassLoader(c);
        System.out.println("Class = " + c.getClass());
        System.out.println("Parent = " + c.getParent());
        System.out.println("Current Thread ID: " + Thread.currentThread().getId());
        System.out.println(" Thread GROUP: " + object2.getThreadGroup().getName());
        System.out.println(" Thread getUncaughtExceptionHandler: " + object2.getUncaughtExceptionHandler());
        object2.setUncaughtExceptionHandler(object2.getUncaughtExceptionHandler());
        Thread.yield();





    }
}

// Java Program Illustrating How to Check if a Thread Holds
// Lock on a Particular Object


// Main class
class GFG {

    // Creating the constructor
    GFG()
    {

        // Checking the status of the lock on the object
        System.out.println(Thread.holdsLock(this));

        // Synchronizing the thread
        synchronized (this)
        {

            // Checking the status of the lock on the object
            // using holdsLock() method over
            // same thread using this keyword
            System.out.println(Thread.holdsLock(this));
        }
    }

    // Main driver method
    public static void main(String[] args)
    {

        // Creating a Thread class object
        Thread ob = new Thread() {
            // run() method for this thread which
            // is invoked as start() method is invoked
            public void run()
            {

                // Creating a class object
                // inside the run() methodof the class
                GFG ob1 = new GFG();
            }
        };

        // Starting the thread with
        // the help of start() method
        ob.start();
    }
}


// Java program to demonstrate thread states
class thread implements Runnable {
    public void run()
    {
        System.out.println(
                "thread 2 run started");
        // moving thread2 to timed waiting state
        System.out.println("Current Thread 2 : "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(15000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "State of thread1 while it called join() method on thread2 -"
                        + Testerrrrr.thread1.getState());
        try {
            Thread.sleep(20000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

 class Testerrrrr implements Runnable {
    public static Thread thread1;
    public static Testerrrrr obj;

    public static void main(String[] args)
    {
        obj = new Testerrrrr();
        thread1 = new Thread((Runnable) obj);

        // thread1 created and is currently in the NEW
        // state.
        System.out.println(
                "State of thread1 after creating it - "
                        + thread1.getState());
        System.out.println("Current Thread main: "
                + Thread.currentThread().getName());
        thread1.start();

        // thread1 moved to Runnable state
        System.out.println(
                "State of thread1 after calling .start() method on it - "
                        + thread1.getState());
    }

    public void run()
    {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);

        // thread1 created and is currently in the NEW
        // state.
        System.out.println(
                "State of thread2 after creating it - "
                        + thread2.getState());
        thread2.start();

        // thread2 moved to Runnable state
        System.out.println(
                "State of thread2 after calling .start() method on it - "
                        + thread2.getState());

        // moving thread1 to timed waiting state
        try {
            // moving thread1 to timed waiting state
            Thread.sleep(10000,4000);
            System.out.println("Current Thread 1 : "
                    + Thread.currentThread().getName());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 after calling .sleep() method on it - "
                        + thread2.getState());
        System.out.println(
                "State of thread1 "
                        + thread1.getState());

        try {
            // waiting for thread2 to die
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(
                "State of thread2 when it has finished it's execution - "
                        + thread2.getState());
    }
}
// Java program to control the Main Thread

// Importing required classes

// Class 1
// Main class extending thread class
 class e extends Thread {

    // Main driver method
    public static void main(String[] args)
    {

        Thread t = Thread.currentThread();


//        Thread.currentThread().join(); //Java program to demonstrate deadlock using Main thread
//        // This statement will never execute
//        System.out.println("This statement will never execute");
        System.out.println("Current thread: "
                + t.getName());

        // Changing the name of Main thread
        t.setName("Geeks");
        System.out.println("After name change: "
                + t.getName());

        // Getting priority of Main thread
        System.out.println("Main thread priority: "
                + t.getPriority());

        // Setting priority of Main thread to MAX(10)
        t.setPriority(MAX_PRIORITY);

        // Print and display the main thread priority
        System.out.println("Main thread new priority: "
                + t.getPriority());

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread");
        }

        // Main thread creating a child thread
        Thread ct = new Thread() {
            // run() method of a thread
            public void run()
            {

                for (int i = 0; i < 5; i++) {
                    System.out.println("Child thread");
                }
            }
        };

        // Getting priority of child thread
        // which will be inherited from Main thread
        // as it is created by Main thread
        System.out.println("Child thread priority: "
                + ct.getPriority());

        // Setting priority of Main thread to MIN(1)
        ct.setPriority(MIN_PRIORITY);

        System.out.println("Child thread new priority: "
                + ct.getPriority());

        // Starting child thread
        ct.start();
        //main thread priority doesnt change by changing child thread priority
        System.out.println("main thread  priority: "
                + t.getPriority());

    }
}

// Class 2
// Helper class extending Thread class
// Child Thread class
class ChildThread extends Thread {

    @Override public void run()
    {

        for (int i = 0; i < 5; i++) {

            // Print statement whenever child thread is
            // called
            System.out.println("Child thread");
        }
    }
}


// Java program to illustrate
// ThreadPool


// Task class to be executed (Step 1)
class Task implements Runnable
{
    private String name;

    public Task(String s)
    {
        name = s;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run()
    {
        try
        {
            for (int i = 0; i<=5; i++)
            {
                if (i==0)
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for"
                            + " task name - "+ name +" = " +ft.format(d));
                    //prints the initialization time for every task
                }
                else
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        }

        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
 class Testee
{
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args)
    {
        // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
// A Java program to demonstrate working of
// synchronized.

// A Class used to send a message
class Sender
{
    public void send(String msg)
    {
        System.out.println("Sending\t" + msg );
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
    //Alternately, we could define the whole send() block as synchronized, producing the same result. Then we don’t have to synchronize the Message object inside the run() method in ThreadedSend class.
//    public synchronized void send(String msg)
//    {
//        System.out.println("Sending\t" + msg);
//        try {
//            Thread.sleep(1000);
//        }
//        catch (Exception e) {
//            System.out.println("Thread interrupted.");
//        }
//        System.out.println("\n" + msg + "Sent");
//    }



    // One more alternate implementation to demonstrate
// that synchronized can be used with only a part of
// method hen we don’t have to synchronize the Message object inside the run() method in ThreadedSend clas
//    public void send(String msg)
//    {
//        synchronized(this)
//        {
//            System.out.println("Sending\t" + msg );
//            try
//            {
//                Thread.sleep(1000);
//            }
//            catch (Exception e)
//            {
//                System.out.println("Thread interrupted.");
//            }
//            System.out.println("\n" + msg + "Sent");
//        }
//    }

    //Instance and Static Methods: Both synchronized instance methods and synchronized static methods can be executed concurrently because they are used to lock different Objects.
}

// Class for send a message using Threads
class ThreadedSend extends Thread
{
    private String msg;
    Sender sender;

    // Receives a message object and a string
    // message to be sent
    ThreadedSend(String m, Sender obj)
    {
        msg = m;
        sender = obj;
    }

    public void run()
    {
        // Only one thread can send a message
        // at a time.
        synchronized(sender)
        {
            // synchronizing the snd object
            sender.send(msg);
        }
    }
}

// Driver class
class SyncDemo
{
    public static void main(String args[])
    {
        Sender snd = new Sender();
        ThreadedSend S1 =
                new ThreadedSend( " Hi " , snd );
        ThreadedSend S2 =
                new ThreadedSend( " Bye " , snd );

        // Start two threads of ThreadedSend type
        S1.start();
        S2.start();

        // wait for threads to end
        try
        {
            S1.join();
            S2.join(2000);
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}
// Java program to demonstrate
// the exception handler

// Creating a random class to
// implement the interface
class Random1
        implements Thread
        .UncaughtExceptionHandler {

    // Method to handle the
    // uncaught exception
    public void uncaughtException(
            Thread t, Throwable e)
    {

        // Custom task that needs to be
        // performed when an exception occurs
        System.out.println(
                "Welcome to GeeksforGeeks");
    }
}

 class GFGr {

    public static void main(String[] args) throws Exception {

        // Passing the object of the type
        // UncaughtExceptionHandler to the
        // setter method
        // setDefaultUncaughtExceptionHandler()
        Thread
                .setDefaultUncaughtExceptionHandler(
                        new Random1());
        System.out.println(Thread.getDefaultUncaughtExceptionHandler());

        //System.out.println(10 / 0); both works
        throw new Exception("Exception");
    }
}
// Java code illustrating equals() method
 class StackTraceElementDemo
{
    public static void main(String[] arg)
    {
        StackTraceElement st1 = new StackTraceElement("foo", "fuction1",
                "StackTrace.java", 1);
        StackTraceElement st2 = new StackTraceElement("bar", "function2",
                "StackTrace.java", 1);

        Object ob = st1.getFileName();

        // checking whether file names are same or not
        System.out.println(st2.getFileName().equals(ob));
        System.out.println("Class name of each thread involved:");
        for(int i = 0; i<2; i++)
        {
            System.out.println(Thread.currentThread().getStackTrace()[i].
                    getClassName());
        }
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].getFileName());
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].getLineNumber());
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].getMethodName());
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].hashCode());
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].isNativeMethod());
        for(int i = 0; i<2; i++)
            System.out.println(Thread.currentThread().getStackTrace()[i].toString());

    }
}
// Java Program Illustrating How to Check if a Thread Holds
// Lock on a Particular Object

// Importing the libraries

// Main class
class GFGyy {

    // Creating the constructor
    GFGyy()
    {

        // Checking the status of the lock on the object
        System.out.println(Thread.holdsLock(this));

        // Synchronizing the thread
        synchronized (this)
        {

            // Checking the status of the lock on the object
            // using holdsLock() method over
            // same thread using this keyword
            System.out.println(Thread.holdsLock(this));
        }
    }

    // Main driver method
    public static void main(String[] args)
    {

        // Creating a Thread class object
        Thread ob = new Thread() {
            // run() method for this thread which
            // is invoked as start() method is invoked
            public void run()
            {

                // Creating a class object
                // inside the run() methodof the class
                GFGyy ob1 = new GFGyy();
            }
        };

        // Starting the thread with
        // the help of start() method
        ob.start();
    }
}

class MyThread extends Thread {
    public void run()
    {
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());
        System.out.println("run() method called");
    }
}

class GeeksforGeeks {
    public static void main(String[] args)
    {
        MyThread t = new MyThread();

//        t.start(); //uncomment and comment next line and see difference
//        t.start();
        t.run();
        t.run();//run can be called twice but not start
    }
}

// Java program to Illustrate notify() method in Thread
// Synchronization.

// Importing required classes


// Class 1
// Thread1
// Helper class extending Thread class
 class GFGuu {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating object(thread) of class 2
        Thread212 objB = new Thread212();
        System.out.println(Thread.currentThread().getState());
        // Starting the thread
        objB.start();

        synchronized (objB)
        {
            // Try block to check for exceptions
            try {

                // Display message only
                System.out.println(Thread.currentThread().getName() +
                        "Waiting for Thread 2 to complete...");

                // wait() method for thread to be in waiting
                // state
                objB.wait();
                System.out.println(objB.getState());
                System.out.println(Thread.currentThread().getState());
            }

            // Catch block to handle the exceptions
            catch (InterruptedException e) {

                // Print the exception along with line
                // number using printStackTrace() method
                e.printStackTrace();
            }

            // Print and display the total threads on the
            // console
            System.out.println("Total is: " + objB.total);
        }
    }
}
// Class 2
// Thread2
// Helper class extending Thread class
class Thread212 extends Thread {

    int total;

    // run() method which is called automatically when
    // start() is initiated for the same
    // @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() +
                "entering run" + Thread.currentThread().getState());
        synchronized (this)
        {

            // iterating over using the for loo
            for (int i = 0; i < 10; i++) {

                total += i;
            }
            System.out.println("lockt" + Thread.holdsLock(this));
            // Waking up the thread in waiting state
            // using notify() method
            notify();
        }
    }
}




