//In java, abstraction is achieved by interfaces and abstract classes.
//abstract is a non-access modifier in java applicable for classes, methods but not variable
//we cannot instantiate abstract classes
//Any subclass of an abstract class must either implement all of the abstract methods in the super-class, or be declared abstract itself
//Any class that contains one or more abstract methods must also be declared abstract
//the following are various illegal combinations
//abstract final
//abstract native
//abstract synchronized
//abstract static
//abstract private
//abstract strictfp
//We can have abstract class without any abstract method. This allows us to create classes that cannot be instantiated but can only be inherited.
//Abstract classes can also have final methods,static methods


//Encapsulation vs Data Abstraction
//
//        Encapsulation is data hiding(information hiding) while Abstraction is detailed hiding(implementation hiding).
//        While encapsulation groups together data and methods that act upon the data, data abstraction deal with exposing the interface to the user and hiding the details of implementation.

//abstract ckasses can inherit interfaces as well but vice versa not possible
// A java program to demonstrate
// use of abstract keyword.

// abstract with class
abstract class A4
{
    String color;//it can have nin final variables as well
    static int a = 10;
    int b = 20;
    final String color1 = "10";
    // abstract with method
    // it has no body
    abstract void m1();

    // abstract class can have the constructor
    public A4(String color)
    {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    A4()
    {
        // Print statement
        System.out.println("Base Constructor Called");
    }
    // concrete methods are still allowed in abstract classes
    void m2()
    {
        System.out.println("This is a concrete method.");
    }
}

// concrete class B
class B4 extends A4
{
    // class B must override m1() method or be declared abstract
    // otherwise, compile-time exception will be thrown
    void m1() {
        System.out.println("B's implementation of m2.");
    }
    double radius;
//if below constructor is commented error will be thrown that default constructor not available for A4 , if no arg constructor of a4 is comented
    public B4(String color, double radius)
    {

        // calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }
    // Constructor of class2
    B4()
    {
        System.out.println("Derived Constructor Called");
    }



}

// Driver class
 class AbstractDemo
{
    public static void main(String args[])
    {
        B4 b = new B4("ab" , 12);
        //Although abstract classes cannot be used to instantiate objects, they can be used to create object references because Java’s approach to run-time polymorphism
        A4 a = b;
        a = new B4();
        b.m1();
        b.m2();
    }
}

// Java Program to illustrate Abstract class
// Without any abstract method


abstract class Base1 {


    void fun()
    {

        System.out.println(
                "Function of Base class is called");
    }

    final void fun1()
    {
        System.out.println("Function of Base class fun1() called");
    }

    static void demofun()
    {

        System.out.println("Geeks for Geeks");
    }
}


class Derived1 extends Base1 {
}


class Main4 {

    public static void main(String args[])
    {

        Base1 d = new Derived1();
       // Base1 d1 = new Base1(); 'Base1' is abstract; cannot be instantiated
        d.fun();
        d.fun1();
        Base1.demofun();
    }
}


/*package whatever //do not write package name here */

abstract class Demot {
    abstract void m1();
    abstract void m2();
    abstract void m3();
}
abstract class FirstChild extends Demot {
    public void m1() {
        System.out.println("Inside m1");
    }
}

class SecondChild extends FirstChild {
    public void m2() {
        System.out.println("Inside m2");
    }
    public void m3() {
        System.out.println("Inside m3");
    }
}
class GFGer {
    public static void main(String[] args)
    {
        // if we remove the abstract keyword from FirstChild
        // Class and uncommented below obj creation for
        // FirstChild then it will throw
        // compile time error as did't override all the
        // abstract methods

        // FirstChild f=new FirstChild();
        // f.m1();

        SecondChild s = new SecondChild();
        s.m1();
        s.m2();
        s.m3();
    }
}


