// A Java program to demonstrate
// shallow copy using clone()
import java.util.ArrayList;

// An object reference of this class is
// contained by Test2Clone
//A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to make a field-for-field copy of instances of that class.
//Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the exception CloneNotSupportedException being thrown.
//By convention, classes that implement this interface should override Object.clone (which is protected) with a public method. See Object.clone() for details on overriding this method.
//Note that this interface does not contain the clone method. Therefore, it is not possible to clone an object merely by virtue of the fact that it implements this interface. Even if the clone method is invoked reflectively, there is no guarantee that it will succeed.
class TestClone {
    int x, y;
}

// Contains a reference of Test and
// implements clone with shallow copy.
class Test2Clone implements Cloneable {
    int a;
    int b;
    TestClone c = new TestClone();
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Driver class
 class Main8 {
    public static void main(String args[])
            throws CloneNotSupportedException
    {
        Test2Clone t1 = new Test2Clone();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        Test2Clone t2 = (Test2Clone)t1.clone();

        // Creating a copy of object t1
        // and passing it to t2
        t2.a = 100;

        // Change in primitive type of t2 will
        // not be reflected in t1 field
        t2.c.x = 300;

        // Change in object type field will be
        // reflected in both t2 and t1(shallow copy)
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                + " " + t1.c.y);
        System.out.println(t2.a + " " + t2.b + " " + t2.c.x
                + " " + t2.c.y);
    }
}

// A Java program to demonstrate
// deep copy using clone()

// Contains a reference of Test and
// implements clone with deep copy.
class Test3Clone implements Cloneable {
    int a, b;

    TestClone c = new TestClone();

    public Object clone() throws CloneNotSupportedException
    {
        // Assign the shallow copy to
        // new reference variable t
        Test3Clone t = (Test3Clone)super.clone();

        // Creating a deep copy for c
        t.c = new TestClone();
        t.c.x = c.x;
        t.c.y = c.y;

        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy
        return t;
    }
}

 class Main10 {
    public static void main(String args[])
            throws CloneNotSupportedException
    {
        Test3Clone t1 = new Test3Clone();
        t1.a = 10;
        t1.b = 20;
        t1.c.x = 30;
        t1.c.y = 40;

        Test3Clone t3 = (Test3Clone)t1.clone();
        t3.a = 100;

        // Change in primitive type of t2 will
        // not be reflected in t1 field
        t3.c.x = 300;

        // Change in object type field of t2 will
        // not be reflected in t1(deep copy)
        System.out.println(t1.a + " " + t1.b + " " + t1.c.x
                + " " + t1.c.y);
        System.out.println(t3.a + " " + t3.b + " " + t3.c.x
                + " " + t3.c.y);
    }
}



 class Book implements Cloneable {

    private String name;
    private int pages;
    private float price;

    public Book(String name, int pages, float price) {
        this.name = name;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //since this contains only primitive data types, we need not write anything here
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

 class Student1 implements Cloneable {

    private String name;
    private int rollNumber;
    private Book book;

    Student1(int rollNumber, String name, Book book) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.book = book;
    }

     public int getRollNumber() {
         return rollNumber;
     }

     public void setRollNumber(int rollNumber) {
         this.rollNumber = rollNumber;
     }

     public void setBook(Book book) {
         this.book = book;
     }

     public Book getBook() {
         return book;
     }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student1 clonedStudent = (Student1)super.clone();
        clonedStudent.getBook();
        clonedStudent.setBook((Book)clonedStudent.getBook().clone());
        return clonedStudent;
    }

}


//Arrays
//    Iterating each element of the given original array and copy one element at a time
//     Using clone() method
//     Using arraycopy() method
//     Using copyOf() method of Arrays class
//     Using copyOfRange() method of Arrays class
// Java program to demonstrate array
// copy using System.arraycopy()

 class Arrayclone {

    public static void main(String[] args)
    {
        int a[] = { 1, 8, 3 };
        int b[] = new int[a.length];
        System.arraycopy(a, 0, b, 0, 3);
        b[0]++;
        System.out.println("Contents of a[] ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println("\n\nContents of b[] ");
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
    }
}

//clone()
//Arrays in Java are objects; therefore they inherit all the characteristics of java.lang.Object. An array type has a public method clone(), which overrides the clone() method of class Object.
//it is shallow clone.
 class ArrayCloneDemo
{
    public static void main(String[] args)
    {
        int ai[] = {1, 2, 3, 4, 5};
        int aic[] = ai;
        aic[2] = -9;
        System.out.println(aic[2]);
        System.out.println(ai[2]);
        System.out.println("---"); //separator
        aic = ai.clone();
        aic[1] = -15;
        System.out.println(aic[1]);
        System.out.println(ai[1]);
    }
}
//multidimensional array needs deep clone
 class CloneTwoDArrayDemo
{
    public static void main(String[] args)
    {
        //shallow copy
        int arri[][] = {{1, 2}, {3, 4}, {5, 6}};
        int cloneArri[][];
        cloneArri = arri.clone();
        cloneArri[0] = null;
        System.out.println("cloneArri[0]: " + cloneArri[0]); // null
        System.out.println("arri[0]: " + arri[0]); //class name + @ + hashcode in hex
        System.out.println(); // blank line
        cloneArri[1][1] = -9;
        System.out.println("cloneArri[1][1]: " + cloneArri[1][1]);
        System.out.println("arri[1][1]: " + arri[1][1]);
        //deepcopy
        int arri1[][] = {{1, 2}, {3, 4}, {5, 6}};
        int cloneArri1[][] = deepCopy(arri1);
        cloneArri1[0] = null;
        System.out.println("cloneArri[0]: " + cloneArri1[0]);
        System.out.println("arri[0]: " + arri1[0]);
        System.out.println();
        cloneArri1[1][1] = -9;
        System.out.println("cloneArri[1][1]: " + cloneArri1[1][1]);
        System.out.println("arri[1][1]: " + arri1[1][1]);

    }

    public static int[][] deepCopy(int[][] array) {
        int[][] clone = new int[array.length][];

        for (int i = 0; i < clone.length; i++) {
            clone[i] = array[i].clone();
        }

        return clone;
    }
}
