//applicable only to variable,method and class not to interface
//A final variable can be assigned value later, but only once.
//used in immutable classes
//If a class is declared as final as by default all of the methods present in that class are automatically final, but variables are not.
//There is only one situation where  finally block won’t be executed when we are using System.exit(0) method. When we are using System.exit(0) then JVM itself shutdown, hence in this case finally block won’t be executed. Here, the number within the parenthesis is known as status code. Instead of zero, we can take any integer value where zero means normal termination, non-zero means abnormal termination.
class GFG1 {


    final int THRESHOLD = 5;
    final  int CAPACITY;
    final int MINIMUM;
    // direct initialize
    static final double PI = 3.141592653589793;
    static final double EULERCONSTANT; // cant be initialized in initializer block cause initializer block is associated with objects

    // instance initializer block for
    // initializing CAPACITY
    {
        System.out.println("GFG1 initialization block");
        CAPACITY = 25;
        //EULERCONSTANT = 2.3;
    }

    // static initializer block for
    // initializing EULERCONSTANT
    static{
        System.out.println("GFG1 static block");
        EULERCONSTANT = 2.3;
    }

    // constructor for initializing MINIMUM
    // Note that if there are more than one
    // constructor, you must initialize MINIMUM
    // in them also
    public GFG1()
    {
        MINIMUM = -1;
    }
    public GFG1(int a)
    {
        MINIMUM = a; // if commented it will throw error Variable 'MINIMUM' might not have been initialized
    }
    void display(){
        System.out.println("PRINTING minimum final" + MINIMUM);
    }
    //A final method cannot be overridden.

    final void m1()
    {
        System.out.println("This is a final method.");
    }




}

class A7  {
    A7()
    {
        super();
        System.out.println("A-Constructor Called");
    }
    {
        System.out.println("A-IIB block");
    }

    static{
        System.out.println("A7 static block");
    }

    public static void main(String[] args)
    {
        // Creating sn object of StringBuilder class
        // Final reference variable
        final StringBuilder sb = new StringBuilder("Geeks");
        System.out.println(sb);
        // changing internal state of object reference by
        //  final reference variable sb
        sb.append("ForGeeks");
        System.out.println(sb);
        //final variable cannot be re-assign .reference final variable, the internal state of the object pointed by that reference variable can be changed. Note that this is not re-assigning. This property of final is called non-transitivity.

        GFG1 gf = new GFG1();
        System.out.println("PRINTING minimum in main" + gf.MINIMUM);

        GFG1 gf1 = new GFG1(7);
        System.out.println("PRINTING minimum in main" + gf1.MINIMUM);
        // Re-assigning final variable will throw compile-time error
        //gf.CAPACITY = 5;
        System.out.println("PRINTING EULERCONSTANT in main" + GFG1.EULERCONSTANT);
        //local final variable
        final int i;
        i = 20;

        System.out.println("local final variable" + i);
        //i = 20;//Variable 'i' might already have been assigned to

        //Since the “j” variable goes out of scope with each iteration of the loop, it is actually re-declaration each iteration
        int arr[] = { 1, 2, 3 };
        for (final int j : arr)
            System.out.println("final j in for " + j + " ");


    }
}


//final class

final class A9
{
}
// The following class is illegal Cannot inherit from final 'A9'
//For example, all Wrapper Classes like Integer, Float, etc. are final classes

//class B9 extends A9
//{
//    // COMPILE-ERROR! Can't subclass A
//}

class B3 extends GFG1
{
    //m1()' cannot override 'm1()' in 'GFG1'; overridden method is final
//    void m1()
//    {
//        // Compile-error! We can not override
//        System.out.println("Illegal!");
//    }
}

// Java program to illustrate
// use of final with inheritance

abstract class Shape
{
    // method getArea() declared abstract because
    // it upon its subclasses to provide
    // complete implementation
    abstract void getArea();
}

class Rectangle extends Shape
{
    // getArea method is overridden and declared
    // as final so any class extending
    // Rectangle can't override it
    @Override
    final void getArea()
    {
        System.out.println("getarea in Rectangle");
    }
}

class Square extends Shape
{
    @Override
    final void getArea()
    {
        System.out.println("getarea in square");
    }
}

 class Testt1
{
    public static void main(String[] args)
    {
        Shape s1 = new Rectangle();
        Shape s2 = new Square();
        System.out.print("area of s1 : ");
        s1.getArea();
        System.out.print("area of s2 : ");
        s2.getArea();
    }
}




