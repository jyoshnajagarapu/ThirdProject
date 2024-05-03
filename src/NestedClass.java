//Nested classes are divided into two categories:
//static nested class : Nested classes that are declared static are called static nested classes.
//inner class : An inner class is a non-static nested class.
//There are two special kinds of inner classes :
//Local inner classes
//Anonymous inner classes
// Java program to demonstrate accessing
// a static nested class

// outer class
class OuterClass
{
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private static int outer_private = 30;

    // static nested class
    static class StaticNestedClass
    {
        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can access display private static member of outer class
            System.out.println("outer_private = " + outer_private);

            // The following statement will give compilation error
            // as static nested class cannot directly access non-static members
            // System.out.println("outer_y = " + outer_y);

        }
    }
}

// Driver class
 class StaticNestedClassDemo
{
    public static void main(String[] args)
    {
        // accessing a static nested class
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

        nestedObject.display();

    }
}


// Nested Inner Class

// outer class
class OuterClass1
{
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private int outer_private = 30;
    ////As a member of its enclosing class, a nested class can be declared private, public, protected, or package private(default).
    // inner class
    public class InnerClass
    {
        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can also access non-static member of outer class
            System.out.println("outer_y = " + outer_y);

            // can also access a private member of the outer class
            System.out.println("outer_private = " + outer_private);

        }
        //We can not have a static method in a nested inner class because an inner class is implicitly associated with an object of its outer class so it cannot define any static method for itself. For example, the following program doesn’t compile.
        //Static declarations in inner classes are not supported at language level '11'
//        public static void stat(String[] args)
//        {
//            System.out.println("inside inner class Method");
//        }
    }
}

// Driver class
 class InnerClassDemo
{
    public static void main(String[] args)
    {
        // accessing an inner class
        OuterClass1 outerObject = new OuterClass1();
        OuterClass1.InnerClass innerObject = outerObject.new InnerClass();

        innerObject.display();

    }
}
//https://www.geeksforgeeks.org/local-inner-class-java/
// Local Inner Classes
// local inner class can’t be marked as private, protected, static, and transient but can be marked as abstract and final, but not both at the same time.
//They belong to the block they are defined within, due to which local inner classes cannot have any access modifiers associated with them.
class Outer1 {
    int a = 20;
    void outerMethod()
    {
        System.out.println("inside outerMethod");
        int x = 98;
        final int y1 = 40;
        //Modifiers not allowed here
        //Local inner class must be instantiated in the block they are defined in.
        //Sometimes this block can be a for loop or an if clause
        //Till JDK 7, the Local inner class can access only the final local variable of the enclosing block. However, From JDK 8, it is possible to access the non-final local variable of enclosing block in the local inner class.
        class Inner {
            void innerMethod()
            {
                System.out.println("x= "+x);
                System.out.println("a= "+a);
                System.out.println("y= "+y1);
                System.out.println("inside innerMethod");
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}
class GFG1e {

    public static void main(String[] args)
    {
        Outer1 x = new Outer1();
        x.outerMethod();
    }
}

 //   Anonymous Inner Classes
//        As a subclass of the specified type
//        As an implementer of the specified interface

class Demo1{
    void show()
    {
        System.out.println(
                "i am in show method of super class");
    }
    void show1(){
        System.out.println(
                "i am in show1 method of super class");
    }
}
class Flavor1Demo {

    // An anonymous class with Demo as base class
    static Demo1 d = new Demo1() {
        void show()
        {
            super.show();
            System.out.println("i am in Flavor1Demo class");
        }
        void show2(){
            System.out.println(
                    "i am in show method of super class");
        }
    };
    public static void main(String[] args)
    {
        d.show();
        d.show1();
        //d.show2(); not possible
    }
}

// Java Program to Illustrate Anonymous Inner Classes
// As an implementer of Specified interface
interface Hello {
    void show();
}

class GFGee1 {
    static Hello h = new Hello() {
        public void show()
        {
            System.out.println("i am in anonymous class");
        }
        void show2(){
            System.out.println(
                    "i am in show method of super class");
        }
    }; //written as below in java 8
    //static Hello h = () -> System.out.println("i am in anonymous class");


    public static void main(String[] args)
    {
        h.show();
        //h.show2(); not possible
    }
}


abstract class Bb {
    //declaring inner class as abstract with abstract method
    abstract class Cc {
        abstract void myAbstractMethod();
    }
}
class D extends Bb {
    class E extends Cc {
        // implementing the abstract method
        void myAbstractMethod() { System.out.println("Inside abstract method implementation"); }
    }
}

class Mainuj {

    public static void main(String args[])
    {
        // Instantiating the outer class
        D outer = new D();

        // Instantiating the inner class
        D.E inner = outer.new E();
        inner.myAbstractMethod();
    }
}

