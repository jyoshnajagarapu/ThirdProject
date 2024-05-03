// Java program to illustrate Constructor Chaining
// within same class Using this() keyword
//A constructor in Java can not be abstract, final, static and Synchronized.
class ConstructorchainingTest
{
    // default constructor 1
    // default constructor will call another constructor
    // using this keyword from same class
    //init block gets called only once per creating object even if we have constructor chaining in same class
    {
        System.out.println("init block");
    }
    ConstructorchainingTest()
    {
        // calls constructor 2
        this(5);// not mandatory to have constructor chaining in same class
        System.out.println("The Default constructor");
    }

    // parameterized constructor 2
    ConstructorchainingTest(int x)
    {
        // calls constructor 3
        this(5, 15);
        System.out.println(x);
    }

    // parameterized constructor 3
    ConstructorchainingTest(int x, int y)
    {
        System.out.println(x * y);
    }

    public static void main(String args[])
    {
        // invokes default constructor first
        new ConstructorchainingTest();
    }
}

// Java program to illustrate Constructor Chaining to
// other class using super() keyword
class Base
{
    String name;

    // constructor 1
    Base()
    {
        this("");
        System.out.println("No-argument constructor of" +
                " base class");
    }

    // constructor 2
    Base(String name)
    {
        this.name = name;
        System.out.println("Calling parameterized constructor"
                + " of base");
    }
}

class Derived extends Base
{
    // constructor 3
    Derived()
    {
        System.out.println("No-argument constructor " +
                "of derived");
    }

    // parameterized constructor 4
    Derived(String name)
    {
        // invokes base class constructor 2
        super(name);
        System.out.println("Calling parameterized " +
                "constructor of derived");
    }

    public static void main(String args[])
    {
        // calls parameterized constructor 4
        Derived obj = new Derived("test");

        // Calls No-argument constructor
        // Derived obj = new Derived();
    }
}

