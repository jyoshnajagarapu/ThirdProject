import InterfacePack.TestInterface;
import InterfacePack.TestInterface2;

class TestClass implements TestInterface,TestInterface2
{
    // implementation of square abstract method
    public void square(int a)
    {
        System.out.println(a*a);
    }
// if below function is commented it will throw error
    // TestClass inherits unrelated defaults for show2() from types InterfacePack.TestInterface and InterfacePack.TestInterface2
    public void show2()
    {
        // use super keyword to call the show
        // method of TestInterface1 interface
        TestInterface.super.show2();

        // use super keyword to call the show
        // method of TestInterface2 interface
        TestInterface2.super.show2();
        //super.show(); not possible too super cannot be used alone with interface methods
    }

    public static void main(String args[])
    {
        TestClass d = new TestClass();
        TestInterface d1 = new TestClass();
        //abstract method
        d.square(4);
        // default method
        d.show();
        //static method
        TestInterface.show1();

        //d.show1(); Static method may be invoked on containing interface class only cause it is not inherited
        //d1.show1(); not possible too
        //common method to both interfaces
        d.show2();

    }
}

abstract class  TestClass1 implements TestInterface {
    //it will throw if abstract is removed and square is not implemented Class 'TestClass1' must either be declared abstract or implement abstract method 'square(int)' in 'TestInterface

//    public void square(int a) {
//        System.out.println(a * a);
//    }
}
