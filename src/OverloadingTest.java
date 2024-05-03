class Demo {
    public void show(int x)
    {
        System.out.println("In int" + x);
    }
    public void show(String s)
    {
        System.out.println("In String" + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte" + b);
    }

    public static void foo() {
        System.out.println("Test.foo() called ");
    }
    public static void foo(int a) {
        System.out.println("Test.foo(int) called ");
    }

//    public void foo() { // Compiler Error: cannot redefine foo()
//        System.out.println("Test.foo(int) called ");
//    }
}
class UseDemo {
    public static void main(String[] args)
    {
        byte a = 25;
        Demo obj = new Demo();
        obj.show(a);
        obj.show("hello");
        obj.show(250);
        obj.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show("A"); // String
       // obj.show(7.5); // since float datatype
// is not available and so it's higher
// datatype, so at this step their
// will be an error.
        obj.foo();
        obj.foo(1);
        System.out.println("Hi Geek (from main)");
        //program doesn’t execute the overloaded main method when we run your program, we need to call the overloaded main method from the actual main method only.
        UseDemo.main("Geek");
    }


    // Overloaded main methods
    public static void main(String arg1) {
        System.out.println("Hi, " + arg1);
        UseDemo.main("Dear Geek","My Geek");
    }
    public static void main(String arg1, String arg2) {
        System.out.println("Hi, " + arg1 + ", " + arg2);
    }
}

class Test5
{
    // Overloaded methods
    public void fun(Integer i)
    {
        System.out.println("fun(Integer ) ");
    }
    public void fun(String name)
    {
        System.out.println("fun(String ) ");
    }
    public void fun1(int i)
    {
        System.out.println("fun(Integer ) ");
    }
    public void fun1(char name)
    {
        System.out.println("fun(String ) ");
    }

    // Driver code
    public static void main(String [] args)
    {
        Test5 mv = new Test5();

        // This line causes error because both functions above accept null parameter as Integer and String can be null and it gets confused which method to call
        //This compile time error wouldn’t happen unless we intentionally pass null value.
        //it also wont happen if one of the above method is commented
        //mv.fun(null);
        // No compiler error because we are specifying that the argument is of type Integer
        Integer arg = null;
        mv.fun(arg);
        Test5 mv1 = new Test5();
        //doesnt work even if one of the above is commented cause primitve data types doesnt accept null
        //mv1.fun1(null);

    }
}



