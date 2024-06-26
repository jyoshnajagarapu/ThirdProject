package InterfacePack;

// Java program to demonstrate How Diamond Problem
// Is Handled in case of Default Methods

// Interface 1
interface GPI {

    // Default method
    default void show()
    {

        // Print statement
        System.out.println("Default GPI");
    }
    default void show1()
    {

        // Print statement
        System.out.println("Default GPI show1");
    }
}

// Interface 2
// Extending the above interface
interface PI1 extends GPI {
    default void show1()
    {

        // Print statement
        System.out.println("Default PI1 show1");
        //super.show1(); //Unqualified super reference is not allowed in extension method
        GPI.super.show1();
    }
}

// Interface 3
// Extending the above interface
interface PI2 extends GPI {
}

// Main class
// Implementation class code
class TestClass implements PI1, PI2 {

    // Main driver method
    public static void main(String args[])
    {

        // Creating object of this class
        // in main() method
        TestClass d = new TestClass();

        // Now calling the function defined in interface 1
        // from whom Interface 2and 3 are deriving
        d.show();
        d.show1();
    }
}
