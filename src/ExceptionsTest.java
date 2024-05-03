// object-->throwable--1.errors, 2. exceptions
//exceptions-->checked(compile time), unchecked exception
//checked--try.catch or throws keyword
//unchecked - runtime exceptions
//Error - jvm errors like stackoverflow
//How JVM handle an Exception? -- https://www.geeksforgeeks.org/exceptions-in-java/?ref=lbp
//Examples of Built-in Exception:
//Arithmetic exception,ArrayIndexOutOfBounds,ClassNotFoundException,FileNotFoundException,IOException,InterruptedException,NoSuchMethodException,NullPointerException,NumberFormatException,StringIndexOutOfBoundsException,ClassCastException,StackOverflowError,NoClassDefFoundError,ExceptionInInitializerError,IllegalArgumentException,IllegalThreadStateException,AssertionError,NoSuchFieldException
//Exception is a sub-class of Throwable


// Java program to demonstrate user defined exception

class MyException extends Exception
{

    private static int accno[] = {1001, 1002, 1003, 1004};

    private static String name[] =
            {"Nish", "Shubh", "Sush", "Abhi", "Akash"};

    private static double bal[] =
            {10000.00, 12000.00, 5600.0, 999.00, 1100.55};


    MyException() { }


    MyException(String str) { super(str); }


    public static void main(String[] args)
    {
        try {

            System.out.println("ACCNO" + "\t" + "CUSTOMER" +
                    "\t" + "BALANCE");


            for (int i = 0; i < 5 ; i++)
            {
                System.out.println(accno[i] + "\t" + name[i] +
                        "\t" + bal[i]);


                if (bal[i] < 1000)
                {
                    MyException me =
                            new MyException("Balance is less than 1000");
                    throw me;
                }
            }
        }

        catch (MyException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}


// Java program that demonstrates the use of throw
class ThrowExcep
{
    static void fun()
    {
        try
        {
            throw new NullPointerException("demo");
        }
        catch(NullPointerException e)
        {
            System.out.println("Caught inside fun().");
            throw e; // rethrowing the exception
        }
    }

    public static void main(String args[])
    {
        try {
            try {
                fun(); //uncomment this and see the result
               // throw new NullPointerException("demo");
            } catch (NullPointerException e) {
                System.out.println("Caught in main.");
            }
        }catch (NullPointerException e) {
            System.out.println("Caught in main2.");
         }
        System.out.println(" outside fun().");
    }
}

// Java program to demonstrate working of throws
class ThrowsExecp
{
    static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun(). ");
        throw new IllegalAccessException("demo");
    }
    public static void main(String args[])
    {
        try
        {
            fun();
        }
        catch(IllegalAccessException e)
        {
            System.out.println("caught in main.");
        }
    }
}


