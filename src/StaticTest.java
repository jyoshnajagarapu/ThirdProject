//used for blocks,var,methods,nested classses
//static block is executed only once: the first time the class is loaded into memory.
//
// Note static keyword after import.
import  static java.lang.System.*;
class B2 {
   static int n = 10;
   int m = 11;
    static int d3 = m7();
    B2() { System.out.println("B-Constructor Called"); }

    {
        System.out.println("B-IIB block");
    }

    static int m7() {
        System.out.println("from parent m7");
        return 2;
    }
}

class Test7 extends B2
{
    // static variable
    static int n = 12;
    static int a = 10;
    {
        System.out.println("init block1");
    }
    // static variable
    static int d = m2();

    static int b;
    public int c= 7;

    // Constructor calling
    Test7() { System.out.println("Constructor called"); }
    // static block
    static {
        //static int x= 10;  //Error: Static local variables are not allowed since static is class level variable
        System.out.println("Static block initialized.");
        b = a * 4;

        //c= 40; //Non-static field 'c' cannot be referenced from a static context
    }
    // static method
    static void m1()
    {
        System.out.println("from m1");
        //System.out.println("from m1 c" + c); //Non-static field 'c' cannot be referenced from a static context
        Test7 t = new Test7();
        System.out.println("from m1 c" + t.c); // possible by referring through object
        System.out.println("from m1 b" + b);
        System.out.println("from m1 n" + n);

    }

    {
        System.out.println("init block2");
    }


    // static block
    static {
        System.out.println("Inside static block");
    }

    // static method
    static int m2() {
        System.out.println("from m2");
        // m3(); //not possible since m3 is not static method
        //System.out.println("from m3" + m); // Non-static field 'm' cannot be referenced from a static contex
        System.out.println("from m2 printing n" + n);
        //System.out.println("from m2 printing n" + super.n); // Test7.super' cannot be referenced from a static context
        System.out.println("from m2 printing n with parent " + B2.n); // Test7.super' cannot be referenced from a static context

        //System.out.println("from m2 printing n" + this.c); // Test7.this' cannot be referenced from a static context
        return 20;

    }

    void m3(){

        System.out.println("from m3 printing n" + n);
        System.out.println("from m3 printing c" + c);
        m4();
    }

    void m4(){

        System.out.println("from m4 ");
    }

    public static void main(String[] args)
    {
        // calling m1 without creating
        // any object of class Test
        m1();
        Test7   d = new Test7();
        d.m3();
        System.out.println("Value of a : "+a);
        System.out.println("Value of b : "+b);

    }
}



//Static import is a feature introduced in Java programming language ( versions 5 and above ) that allows members ( fields and methods ) defined in a class as public static to be used in Java code without specifying the class in which the field is defined.

class StaticImportDemo
{
    public static void main(String args[])
    {
        // We don't need to use 'System.out'
        // as imported using static.
        out.println("GeeksforGeeks");
    }
}

