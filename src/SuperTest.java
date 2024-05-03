//1. Use of super with variables:
//2. Use of super with methods:
//3. Use of super with constructors:
   //should be careful when u have argument constructor in the class.
  //case1. when block1 is commented block2 is enabled and super enabled in block3
//  super will throw error in both block3 cause parent class has one arg constructor and no 0 arg constructor. compiler wont call default constructor and error will be thrown
//error wont be thrown if block 2 is commented cause then default constructor will be called
//case2.block1 disabled and block2 enabled and super commented in block4 then error will eb thrown cause when super is not explicitly mentioned
//and compiler tries to call no arg constructor. since single arg is enabled in parent class and no arg is commented compiler cannot call default constructor
//error wont happen if block 2 is disabled cause then default constructor can be called
//case3. if block 3 super enabled and block4 super is disabled  and block 1 and block2 both disabled, error wont be thrown cause in this case default constructor will be called
//case4 if block2 is disabled and super commented in block4 it wont throw error cause it calls block 1 constructor
//error wont happenfor classes whose superclass is object cause object has no arg constructor

class Vehicle
{
    int maxSpeed = 120;
    //block1
    Vehicle()
    {
        System.out.println("parent class Constructor");
    }
    //block2
    Vehicle(int a)
    {
        System.out.println("parent class single argument Constructor");
    }

    void message()
    {
        System.out.println("This is parent class");
    }
}


class Car extends Vehicle
{
    int maxSpeed = 180;
    //block3
    Car()
    {
        super();
        System.out.println("child class Constructor");
    }
    //block4
    Car(int a,int b)
    {

        super(a);
        System.out.println("child class Constructor");
    }
    void message()
    {
        System.out.println("Maximum Speed: " + super.maxSpeed);
        System.out.println("This is child class");
    }
    void display()
    {
        message();
        super.message();
    }
}


class TestSuper
{
    public static void main(String[] args)
    {
        Car small = new Car();
        small.display();
        Car small1 = new Car(1,2);
    }
}

class Vehicle1
{


}

class Car1 extends Vehicle1 {
    Car1() {

        System.out.println("child class Constructor");
    }
}

class TestSuper1
{
    public static void main(String[] args)
    {
        Car1 small = new Car1();

    }
}



