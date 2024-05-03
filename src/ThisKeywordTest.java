//1. Using ‘this’ keyword to refer current class instance variables
//2. Using this() to invoke current class constructor
//3. Using ‘this’ keyword to return the current class instance
//4. Using ‘this’ keyword as method parameter
//        5. Using ‘this’ keyword to invoke current class method
//6. Using ‘this’ keyword as an argument in the constructor call



class Test8
{
    int a;
    int b;

    // Parameterized constructor
    Test8(int a, int b)
    {
        System.out.println("Inside  double constructor \n");
        this.a = a;
        this.b = b;
    }
    //Default constructor
    Test8()
    {

        this(10, 20);
        System.out.println("invoked  parameter constructor \n");
        System.out.println("invoking current object function \n");
        this.display();
        System.out.println("Inside  default constructor \n");
    }

    //Method that returns current class instance
      Test8 get()
    {
        return this;
    }
    void display()
    {
        //Displaying value of variables a and b
        System.out.println("a = " + a + " b = " + b);
    }
    // Method that receives 'this' keyword as parameter
    void display(Test8 obj)
    {
        System.out.println("a = " +obj.a + "  b = " + obj.b);
    }

    void get1()
    {
        display(this);
    }

    public static void main(String[] args)
    {
        Test8 object1 = new Test8();
        Test8 object = new Test8(10, 20);
        object.display();
        object.get().display();
    }
}

// Java code for using this as an argument in constructor
// call
// Class with object of Class B as its data member
class A1
{
    B1 obj;

    // Parameterized constructor with object of B
    // as a parameter
    A1(B1 obj)
    {
        this.obj = obj;

        // calling display method of class B
        obj.display();
    }

}

class B1
{
    int x = 5;

    // Default Constructor that create a object of A
    // with passing this as an argument in the
// constructor
    B1()
    {
        A1 obj = new A1(this);
    }

    // method to show value of x
    void display()
    {
        System.out.println("Value of x in Class B : " + x);
    }

    public static void main(String[] args) {
        B1 obj = new B1();
    }
}

class Test11
{

    private int value = 10;
    private int value1 = 20;
    private int value2 = 30;


    void method(int value)
    {
        value = 70;
        value1 = 50;
        System.out.println("Value of Instance variable :"
                + this.value);
        System.out.println("Value of Local variable :"
                + value);

        System.out.println("Value of Local variable1 :"
                + value1);
        System.out.println("Value of Local variable1 :"
                + this.value1);
    }
}

class UseTest
{
    public static void main(String args[])
    {
        int a = 10;
        Test11 obj1 = new Test11();
        obj1.method(1);
        {
            //int a = 20; -- Variable 'a' is already defined in the scope
        }
    }
}


