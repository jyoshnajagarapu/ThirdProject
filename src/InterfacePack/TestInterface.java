package InterfacePack;
//but the methods declared in an interface are by default abstract
//If a class implements an interface and does not provide method bodies for all functions specified in the interface, then the class must be declared abstract.
//all fields are public, static and final by default.
//all methids are public and abstract by default
//why use interfaces when we have abstract classes?
//        The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
//jdk8 - default and static methods
//jdk9 - Private methods ,Private Static methods

public interface TestInterface
{
    // abstract method by default
    public void square(int a);

    // default method also called as defender methods or virtual extension methods.
    default void show()
    {
        System.out.println("Default Method Executed");
    }

    //static method these methods are not inherited.
    static void show1()
    {
        System.out.println("Static Method Executed");
    }

    //default method common to other interface
    default void show2()
    {
        System.out.println("Default TestInterface1");
        show3();
    }
    private void show3()
    {
        System.out.println("private TestInterface1");
        show4();
    }

    private static void show4()
    {
        System.out.println(" private Static Method Executed");
    }
}


