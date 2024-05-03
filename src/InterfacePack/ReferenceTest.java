package InterfacePack;

// Test.java
class Main {
    // swap() doesn't change i value in main method
    public static void swap(Integer i)
    {
        i = 5; // almost same as i = new Integer(5);
        System.out.println("i in swap " + i);
    }
    public static void main(String[] args)
    {
        Integer i = 10;
        System.out.println("i in before main " + i);
        swap(i);
        System.out.println("i in main " + i);
    }
}


// A Java program to show that references are also passed
// by value.
class Test20
{
    int x;
    Test20(int i) { x = i; }
    Test20()	 { x = 0; }
}

class Main2
{
    public static void main(String[] args)
    {
        // t is a reference
        Test20 t = new Test20(5);

        // Reference is passed and a copy of reference
        // is created in change()
        change(t);

        // Old value of t.x is printed
        System.out.println(t.x);
    }
    public static void change(Test20 t)
    {
        // We changed reference to refer some other location
        // now any changes made to reference are not reflected
        // back in main
        t = new Test20();

        t.x = 10;
    }
}

// A Java program to show that we can change members using using
// reference if we do not change the reference itself.


class Main20
{
    public static void main(String[] args)
    {
        // t is a reference
        Test20 t = new Test20(5);

        // Reference is passed and a copy of reference
        // is created in change()
        change(t);

        // New value of x is printed
        System.out.println(t.x);
    }

    // This change() doesn't change the reference, it only
    // changes member of object referred by reference
    public static void change(Test20 t)
    {
        t.x = 10;
    }
}

//call by reference using arrays
class Prepbytes{

    // pass array of type int as a parameter
    public static void increment(int[] number){
        number[0] = number[0]+1;  // increment first element of an array by 1
        System.out.println("value in method: "+number[0]);
    }


    public static void main(String[] args) {
        int[] number=new int[1]; // create an array of size 1
        number[0]=10; // assign value to fist element of an array
        System.out.println("value before method call: "+number[0]);
        increment(number);
        System.out.println("value after method call: "+number[0]);

    }
}


