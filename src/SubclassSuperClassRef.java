class A5 {}
class B5 extends A5 {}
class Bicycle
{

    public int gear;
    public int speed;
    public int radius = 20;
    int x = 10;

    public Bicycle(int gear, int speed)
    {
        System.out.println("superclass Bicycle constructor");
        this.gear = gear;
        this.speed = speed;
    }

    static void hidingTest(){
         System.out.println("superclass Bicycle hidingTest");
    }

    public void applyBrake(int decrement)
    {
        System.out.println("superclass applyBrake");
        speed -= decrement;
    }

    public void speedUp()
    {
       System.out.println("superclass speedup");
    }
    public void speedUp3()
    {
        System.out.println("superclass speedup3");
    }

    private void speedUp1()
    {
        System.out.println("superclass speedup1");
    }

    public String toString()
    {
        return("superclass to string");
    }

    // private methods are not overridden
    private void m1()
    {
        System.out.println("From parent m1()");
    }

    // private methods are not overridden
    protected void m3()
    {
        System.out.println("From parent m3()");
    }


    //Java 5.0 onwards it is possible to have different return type for a overriding method in child class, but child’s return type should be sub-type of parent’s return type
    //Covariant return types
    A5 fun()
    {
        System.out.println("parent fun()");
        return new A5();
    }

    static void hidingTest1(){
        System.out.println("superclass Bicycle hidingTest1");
    }

}


class MountainBike extends Bicycle
{


    public int seatHeight;
    public int radius  = 30;
    int x = 20;


    public MountainBike(int gear,int speed,
                        int startHeight)
    {

        super(gear, speed);
        seatHeight = startHeight;
        System.out.println("subclass MountainBike constructor");
    }

    // no issue while throwing unchecked exception
    public void setHeight(int newValue) throws ArithmeticException
    {
        seatHeight = newValue;
        System.out.println("subclass setHeight");
        super.applyBrake(2);
    }

    // new m1() method
    // unique to Child class
    private void m1()
    {
        System.out.println("From child m1()");
    }

   //The access modifier for an overriding method can allow more, but not less, access than the overridden method. For example, a protected instance method in the super-class can be made public, but not private, in the subclass.
    public void m3()
    {
        System.out.println("From child m3()");
    }

    //if static keyword removed from here it wil cause compilation error
    static void  hidingTest(){
        System.out.println("subclass MountainBike hidingTest");
    }

    //if static keyword added here it wil cause compilation error
    public void speedUp()
    {
        super.speedUp();
        System.out.println("subclass speedup");
        System.out.println("printing superclass radius" + super.radius) ;
        System.out.println("printing same class radius" + radius);
    }

    public void speedUp1()
    {
        System.out.println("subclass speedup1");
    }
    //we can overload the methods inherited from the superclass they are new methods, unique to the subclass.
    public void speedUp3(int a)
    {
        System.out.println("subclass speedup3");
    }
  //If the super-class overridden method does not throw an exception, subclass overriding method can only throws the unchecked exception, throwing checked exception will lead to compile-time error.
    @Override
    //public String toString() throws Exception //'toString()' in 'MountainBike' clashes with 'toString()' in 'Bicycle'; overridden method does not throw 'java.lang.Exception'
    public String toString()
    {

        return ("subclass to string");
    }

    B5 fun()
    {
        System.out.println("child fun()");
        return new B5();
    }

}

class Grandc extends MountainBike{
    public int grand;
    Grandc(int a , int b, int c, int d){
        super(a,b,c); //error will be thrown if this commented since mountainbike doesnt have no arg constructor
        grand = d;
        System.out.println("grandchild constructor");
    }

    public String toString()
    {
        return("Grandc to string");
    }
}

// driver class
 class Test1
{
    public static void main(String args[])
    {
        System.out.println("grandchild access");
        Grandc g = new Grandc(1,2,3,4);
        System.out.println(g.toString());
        g.applyBrake(1);
        g.setHeight(7);
        System.out.println("superclass referring superclass");
        Bicycle mb3 = new Bicycle( 1, 2);
        mb3.applyBrake(1);
        mb3.speedUp();
        mb3.hidingTest();
        Bicycle.hidingTest();
        System.out.println(mb3.toString());
        System.out.println(g instanceof Grandc);
        System.out.println(g instanceof MountainBike);
        mb3.fun();


        System.out.println("superclass referring subclass");
        Bicycle mb2 = new MountainBike(4, 200, 20);
        System.out.println(mb2.toString());
        //we can override methods only, not the variables
        System.out.println("superclass variable " + mb2.x);
        mb2.speedUp();
        //mb2.speedUp3(2);//'speedUp3()' in 'Bicycle' cannot be applied to '(int)'
        mb2.speedUp3();
        System.out.println("superclass hidingtest" );
        mb2.hidingTest();
        //mb2.m1();//'m1()' has private access in 'Bicycle'
        System.out.println("superclass speedup1" );
        //mb2.speedUp1(); //has private access in 'Bicycle'
        System.out.println("superclass radius" + mb2.radius);
        System.out.println("superclass gear" + mb2.gear);
        mb2.m3();
        mb2.applyBrake(1);
        mb2.fun();

        /* The following statement is invalid because Bicycle
		does not define a seatHeight.
		// System.out.println("seat height of second bicycle is "
												+ mb2.seatHeight); */

		/* The following statement is invalid because Bicycle
		does not define setHeight() method.
		mb2.setHeight(21);*/
        //but can be done using typecasting
        MountainBike mb4 = (MountainBike)mb2;
        System.out.println("seat height of second bicycle is "
                + mb4.seatHeight);
        mb4.setHeight(21);
        mb4.fun();
        mb4.speedUp3();

        System.out.println("subclass referring subclass");
        MountainBike mb1 = new MountainBike(3, 100, 25);

        System.out.println("seat height of first bicycle is "
                + mb1.seatHeight);

        System.out.println(mb1.toString());
        mb1.hidingTest();
        mb1.setHeight(7);
        mb1.speedUp();
        mb1.fun();
        //subclass inherits static method of superclass which is not overriden in dervied class. this is not possible in interfaces
        mb1.hidingTest1();
        System.out.println("parentclass referring grandc");
        //We can have multilevel method-overriding.
        Bicycle bc = new Grandc(1,2,3,4);
        System.out.println("grandc tostring " + bc.toString() );




    }
}

// Java program to demonstrate overriding when
// superclass method does declare an exception

class Parent {
    void m1() throws RuntimeException
    {
        System.out.println("From parent m1()");
    }
}

class Child1 extends Parent {
    @Override
        // no issue while throwing same exception
    void m1() throws RuntimeException
    {
        System.out.println("From child1 m1()");
    }
}
class Child2 extends Parent {
    @Override
        // no issue while throwing subclass exception
    void m1() throws ArithmeticException
    {
        System.out.println("From child2 m1()");
    }
}
class Child3 extends Parent {
    @Override
        // no issue while not throwing any exception
    void m1()
    {
        System.out.println("From child3 m1()");
    }
}
class Child4 extends Parent {
    //@Override
        // compile-time error
        // issue while throwing parent exception
//    void m1() throws Exception
//    {
//        System.out.println("From child4 m1()");
//    }
}

/* Java program to demonstrate overriding when
superclass method does not declare an exception
*/

class Parent2 {
    void m1()
    {
        System.out.println("From parent m1()");
    }

    void m2()
    {
        System.out.println("From parent m2()");
    }
}

class Child5 extends Parent2 {
    @Override
        // no issue while throwing unchecked exception
    void m1() throws ArithmeticException
    {
        System.out.println("From child m1()");
    }

   // @Override
        // compile-time error
        // issue while throwin checked exception
//    void m2() throws Exception
//    {
//        System.out.println("From child m2");
//    }
}


