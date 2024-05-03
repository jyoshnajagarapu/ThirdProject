class Temp
{
    // block to be executed before any constructor.
    {
        System.out.println("init block");
    }

    // no-arg constructor
    Temp()
    {
        System.out.println("default");
    }

    // constructor with one argument.
    Temp(int x)
    {
        System.out.println(x);
    }

    public static void main(String[] args)
    {
        // Object creation by calling no-argument
        // constructor.
        new Temp();

        // Object creation by calling parameterized
        // constructor with one parameter.
        new Temp(10);
    }
}

class Temp1
{
    // block to be executed first
    {
        System.out.println("init");
    }
    Temp1()
    {
        System.out.println("default");
    }
    Temp1(int x)
    {
        System.out.println(x);
    }

    // block to be executed after the first block
    // which has been defined above.
    {
        System.out.println("second");
    }
    public static void main(String args[])
    {
        new Temp1();
        new Temp1(10);
    }
}

// Java program to illustrate
// Instance Initialization Block
// with super()

// Parent Class
class B {
    B() { System.out.println("B-Constructor Called"); }

    {
        System.out.println("B-IIB block");
    }
}

// Child class
class A extends B {
    A()
    {
        super();
        System.out.println("A-Constructor Called");
    }
    {
        System.out.println("A-IIB block");
    }

    // main function
    public static void main(String[] args)
    {
        A a = new A();
    }
}


