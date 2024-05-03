import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//An entity such as class, interface, or method that operates on a parameterized type is called a generic entity.
// cant pass primityive types as parameters for generic classes
//T - Type
//E - Element
//K - Key
//N - Number
//V - Value
//GENERIC CLASSES
class Test12<T>
{
    // An object of type T is declared
    T obj;
    Test12(T obj) { this.obj = obj; } // constructor
    public T getObject() { return this.obj; }
}

// Driver class to test above
class Main9
{
    public static void main (String[] args)
    {
        // instance of Integer type
        Test12 <Integer> iObj = new Test12<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        Test12 <String> sObj =
                new Test12<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
        //iObj = sObj; Even though iObj and sObj are of type Test, they are the references to different types because their type parameters differ. Generics add type safety through this and prevent errors.
    }
}


// A Simple Java program to show multiple
// type parameters in Java Generics

// We use < > to specify Parameter type
class Test21<T, U>
{
    T obj1; // An object of type T
    U obj2; // An object of type U

    // constructor
    Test21(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

// Driver class to test above
class Main24
{
    public static void main (String[] args)
    {
        Test21 <String, Integer> obj =
                new Test21<String, Integer>("GfG", 15);

        obj.print();
    }
}


//GENERIC FUNCTIONS
// A Simple Java program to show working of user defined
// Generic functions

class Test23
{
    // A Generic method example
    static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                " = " + element);
    }

    // Driver method
    public static void main(String[] args)
    {
        //Test23<int> obj = new Test23<int>(20);//Type argument cannot be of primitive type
        //But primitive type array can be passed to the type parameter because arrays are reference type.
        ArrayList<int[]> a = new ArrayList<>();

        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");

        // Calling generic method with double argument
        genericDisplay(1.0);
    }
}

// Using generics converts run time exceptions into
// compile time exception.


class Test25
{
    public static void main(String[] args)
    {
        // Creating a an ArrayList with String specified
        ArrayList <String> al = new ArrayList<String> ();

        al.add("Sachin");
        al.add("Rahul");

        // Now Compiler doesn't allow this
        //al.add(10);

        String s1 = (String)al.get(0);
        // We don't need to typecast individual members of ArrayList like above statement
        // Typecasting is not needed
        String s3 = al.get(0);
        String s2 = al.get(1);
    }
}

//    Why the static method needs to have its own generics separate from those of the Class?
//
//        This is because, the static method can be called without even instantiating the Class. So if the Class is not yet instantiated, we do not yet know what is T. This is the reason why the static methods needs to have its own generics.
//
//        So, whenever you are calling the static method,
//
//        Greet.sayHello("Bob");
//        Greet.sayHello(123);
//        JVM interprets it as the following.
//
//        Greet.<String>sayHello("Bob");
//        Greet.<Integer>sayHello(123);
class Greet1<T> {

    public static <T> void sayHello(T obj) {
        System.out.println("Hello " + obj);
    }
}
//The following code is also completely valid and equivalent to the above code.
class Greet<T> {

    public static <E> void sayHello(E obj) {
        System.out.println("Hello " + obj);
    }
}

//The ? (question mark) symbol represents the wildcard element. It means any type. If we write <? extends Number>, it means any child class of Number, e.g., Integer, Float, and double. Now we can call the method of Number class through any child class object.
//
//We can use a wildcard as a type of a parameter, field, return type, or local variable. However, it is not allowed to use a wildcard as a type argument for a generic method invocation, a generic class instance creation, or a supertype.
// ("?") followed by the extends (in case of, class) or implements (in case of, interface)
//Upper Bounded Wildcards
//The purpose of upper bounded wildcards is to decrease the restrictions on a variable.
//Using List<? extends Number> is suitable for a list of type Number or any of its subclasses whereas List<Number> works with the list of type Number only. So, List<? extends Number> is less restrictive than List<Number>.
abstract class Shape1{
    abstract void draw();
}
class Rectangle1 extends Shape1{
    void draw(){System.out.println("drawing rectangle");}
}
class Circle1 extends Shape1{
    void draw(){System.out.println("drawing circle");}
}
class GenericTest{
    //creating a method that accepts only child class of Shape
    public static void drawShapes(List<? extends Shape1> lists){
        for(Shape1 s:lists){
            s.draw();//calling method of Shape class by child class instance
        }
    }
    public static void main(String args[]){
        List<Rectangle1> list1=new ArrayList<Rectangle1>();
        list1.add(new Rectangle1());

        List<Circle1> list2=new ArrayList<Circle1>();
        list2.add(new Circle1());
        list2.add(new Circle1());

        drawShapes(list1);
        drawShapes(list2);
    }}

//Unbounded Wildcards
//The unbounded wildcard type represents the list of an unknown type such as List<?>. This approach can be useful in the following scenarios: -
//
//When the given method is implemented by using the functionality provided in the Object class.
//When the generic class contains the methods that don't depend on the type parameter.

 class UnboundedWildcard {

    public static void display(List<?> list)
    {

        for(Object o:list)
        {
            System.out.println(o);
        }

    }


    public static void main(String[] args) {

        List<Integer> l1= Arrays.asList(1,2,3);
        System.out.println("displaying the Integer values");
        display(l1);
        List<String> l2=Arrays.asList("One","Two","Three");
        System.out.println("displaying the String values");
        display(l2);
    }

}
//Lower Bounded Wildcards
//The purpose of lower bounded wildcards is to restrict the unknown type to be a specific type or a supertype of that type. It is used by declaring wildcard character ("?") followed by the super keyword, followed by its lower bound.
//Suppose, we want to write the method for the list of Integer and its supertype (like Number, Object). Using List<? super Integer> is suitable for a list of type Integer or any of its superclasses whereas List<Integer> works with the list of type Integer only. So, List<? super Integer> is less restrictive than List<Integer>.
 class LowerBoundWildcard {

    public static void addNumbers(List<? super Integer> list) {

        for(Object n:list)
        {
            System.out.println(n);
        }



    }
    public static void main(String[] args) {

        List<Integer> l1=Arrays.asList(1,2,3);
        System.out.println("displaying the Integer values");
        addNumbers(l1);

        List<Number> l2=Arrays.asList(1.0,2.0,3.0);
        System.out.println("displaying the Number values");
        addNumbers(l2);
    }

}
