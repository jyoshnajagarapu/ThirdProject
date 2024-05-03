package InterfacePack;
//member interface or nested interface.
//the classes and interfaces themselves can have only two access specifiers when declared outside any other class.
//        1) public
//2) default (when no access specifier is specified)
//Nested interfaces and classes can have all access specifiers.


//protected class Test {} Modifier 'protected' not allowed here

import java.util.*;
class Test
{
    //protected interface Yes - this also works
    //private interface Yes  - can be declared but cannot Testing class cannot implement it cause its private
    interface Yes
    {
        void show();
    }
}

class Testing implements Test.Yes
{
    public void show()
    {
        System.out.println("show method of interface");
    }
}

class A
{
    public static void main(String[] args)
    {
        Test.Yes obj;
        Testing t = new Testing();
        obj=t;
        obj.show();
    }
}



interface Test1
{
    //Note: In the  example, access specifier is public even if we have not written public. If we try to change access specifier of interface to anything other than public, we get compiler error
    interface Yes
    {
        void show();
    }

}

class Testing1 implements Test1.Yes
{
    public void show()
    {
        System.out.println("show method of interface");
    }
}

class A1
{
    public static void main(String[] args)
    {
        Test1.Yes obj;
        Testing1 t = new Testing1();
        obj = t;
        obj.show();
    }
}

interface Test3 {
    int x = 10;  // x is public static final and must be initialized here
    void foo();  // foo() is public
}


