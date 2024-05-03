// Class 1
// Helper class
// Extending Thread class
 class PrintTest extends Thread {

    // Non synchronized Code

    // Method 1
    //remove synchronized and see how it works
    public synchronized void printThread(int n)
    {

        // This loop will print the currently executed
        // thread
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + n
                    + " is working...");

            // Try block to check for exceptions
            try {

                // Pause the execution of current thread
                // for 0.600 seconds using sleep() method
                Thread.sleep(600);
            }

            // Catch block to handle the exceptions
            catch (Exception ex) {

                // Overriding existing toString() method and
                // prints exception if occur
                System.out.println(ex.toString());
            }
        }

        // Display message for better readability
        System.out.println("--------------------------");

        try {

            // Pause the execution of current thread
            // for 0.1000 millisecond or 1sec using sleep
            // method
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            // Printing the exception
            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread Class
 class Thread1 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class1
    Thread1(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread1
    public void run()
    {

        // Calling method 1 as in above class
        test.printThread(1);
    }
}

// Class 3
// Helper class extending Thread Class
 class Thread2 extends Thread {

    // Declaring variable of type Class1
    PrintTest test;

    // Constructor for class2
    Thread2(PrintTest p) { test = p; }

    // run() method of this class for
    // entry point for thread2
    public void run() { test.printThread(2); }
}

// Class 4
// Main class
 class SynchroTest {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating object of class 1 inside main() method
        PrintTest p = new PrintTest();

        // Passing the same object of class PrintTest to
        // both threads
        Thread1 t1 = new Thread1(p);
        Thread2 t2 = new Thread2(p);

        // Start executing the threads
        // using start() method
        t1.start();
        t2.start();

        // This will print both the threads simultaneously
    }
}


// Java Program Illustrating Synchronized Code
// Using synchronized block

// Class 1
// Helper class extending Thread class
class PrintTest1 extends Thread {

    // Method 1
    // To print the thread
    public void printThread(int n)
    {

        // Making synchronized block that makes the block
        // synchronized
        synchronized (this)
        {

            // Iterating using for loop
            for (int i = 1; i <= 10; i++) {

                // Print message when these thread are
                // executing
                System.out.println("Thread " + n
                        + " is working...");

                // Try block to check for exceptions
                try {

                    // Making thread to pause for 0.6
                    // seconds
                    Thread.sleep(600);
                }

                // Catch block to handle exceptions
                catch (Exception ex) {

                    // Print message when exception.s occur
                    System.out.println(ex.toString());
                }
            }
        }

        // Display message only
        System.out.println("--------------------------");

        try {

            // Making thread t osleep for 1 sec
            Thread.sleep(1000);
        }

        catch (Exception ex) {

            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread class
class Thread11 extends Thread {

    PrintTest1 test;
    Thread11(PrintTest1 p) { test = p; }

    public void run() { test.printThread(1); }
}

// Class 3
// Helper class extending Thread class
class Thread12 extends Thread {

    PrintTest1 test;
    Thread12(PrintTest1 p) { test = p; }

    public void run() { test.printThread(2); }
}

// Class 4
// Main class
class SynchroTest1 {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating instance for class 1 inside main()
        PrintTest1 p = new PrintTest1();

        // Creating threads and
        // passing same object
        Thread11 t1 = new Thread11(p);
        Thread12 t2 = new Thread12(p);

        // Starting these thread using start() method
        t1.start();
        t2.start();
    }
}


// Using static synchronization

// Class 1
// Helper class
class PrintTest2 extends Thread {

    // Static synchronization locks the class PrintTest
    synchronized public static void printThread(int n)
    {

        for (int i = 1; i <= 10; i++) {

            // Print message when threads are executing
            System.out.println("Thread " + n
                    + " is working...");

            // Try block to check for exceptions
            try {

                // making thread to sleep for 0.6 seconds
                Thread.sleep(600);
            }

            // Catch block to handle the exceptions
            catch (Exception ex) {

                // Print message when exception occurs
                System.out.println(ex.toString());
            }
        }

        // Display message for better readability
        System.out.println("--------------------------");

        try {
            Thread.sleep(1000);
        }

        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

// Class 2
// Helper class extending Thread class
class Thread21 extends Thread {

    // run() method for thread
    public void run()
    {

        // Passing the class not the object
        PrintTest2.printThread(1);
    }
}

// Class 3
// Helper class extending Thread class
class Thread22 extends Thread {

    public void run()
    {

        // Passing the class not the object
        PrintTest2.printThread(2);
    }
}

// Class 4
// Main class
class SynchroTest2 {

    // Main driver method
    public static void main(String[] args)
    {

        // No shared object
        // Creating objects of class 2 and 3 that
        // are extending to Thr3ead class
        Thread21 t1 = new Thread21();
        Thread22 t2 = new Thread22();

        // Starting thread with help of start() method
        t1.start();
        t2.start();
    }
}



