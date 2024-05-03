
//Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
// Java Predefined-Functional Interfaces - https://www.javatpoint.com/java-8-functional-interfaces
//Java lambda expression is treated as a function, so compiler does not create .class file.
import java.util.*;
import java.util.function.*;

interface FuncInterface
{
    void abstractFun(int x);
    default void normalFun()
    {
        System.out.println("Hello");
    }
    //A functional interface can have methods of object class. See in the following example.
    int hashCode();
    String toString();
    boolean equals(Object obj);
}

class Testerr
{
    public static void main(String args[])
    {
        FuncInterface fobj = (int x)->System.out.println(2*x);
        fobj.abstractFun(5);
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        arrL.forEach(n -> System.out.println(n));
        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });

        List<String> names =
                Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
        Predicate<String> p = (s)->s.startsWith("G");
        for (String st:names)
        {
            if (p.test(st))
                System.out.println(st);
        }
    }


}

//predicate

// Java program to illustrate Simple Predicate


 class PredicateInterfaceExample1 {
    public static void main(String[] args)
    {
        Predicate<Integer> lesserthan = i -> (i < 18);
        System.out.println(lesserthan.test(10));
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        // Java program to illustrate Predicate Chaining
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);
        boolean result1 = greaterThanTen.or(lowerThanTwenty).test(21);
        System.out.println(result1);
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
// passing Predicate into function
        pred(10, (i) -> i > 7);
    }
     static void pred(int number, Predicate<Integer> predicate)
     {
         if (predicate.test(number)) {
             System.out.println("Number " + number);
         }
     }
}

// Java program to demonstrate working of predicat
class User
{
    String name, role;
    User(String a, String b) {
        name = a;
        role = b;
    }
    String getRole() { return role; }
    String getName() { return name; }
    public String toString() {
        return "User Name : " + name + ", Role :" + role;
    }

    public static void main(String args[])
    {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
        //check
//        List admins = users.stream()
////                .filter((user) -> user.getRole().equals("admin"))
////                .collect(Collectors.toList());
    }

    public static List<User> process(List<User> users,
                                     Predicate<User> predicate)
    {
        List<User> result = new ArrayList<User>();
        for (User user: users)
            if (predicate.test(user))
                result.add(user);
        return result;
    }
}

// Java Program to demonstrate
// Consumer's accept() methods

 class Main5s {
    public static void main(String args[])
    {

        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Consumer to display a list of integers - check
        Consumer<List<Integer> >
                dispList = list2 -> list2.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(1);
        list1.add(3);

        // using addThen()
        modify.andThen(dispList).accept(list1);
    }
}

// Java Program to Illustrate Functional Interface
// Via apply() method
 class GFG8{

    // Main driver method
    public static void main(String args[])
    {
        // Function which takes in a number
        // and returns half of it
        Function<Integer, Double> half = a -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(10));
        half = half.andThen(a -> 3 * a);

        System.out.println(half.apply(10));
        //System.out.println(half.compose(b -> 3 * b).apply(10));//Operator '*' cannot be applied to 'int', 'java.lang.Object'

        Function<Integer, Double> half1 = a -> a / 2.0;
        half1 = half1.compose(a -> 3 * a);
        System.out.println(half1.apply(10));

        Function<Integer, Integer> i = Function.identity();

        // Print statement
        System.out.println(i.apply(10));
    }
}


 class GFG10 {
    public static void main(String args[])
    {

        // Instantiate the UnaryOperator interface
        UnaryOperator<Boolean>
                op = UnaryOperator.identity();

        // Apply identify() method
        System.out.println(op.apply(true));

        UnaryOperator<Integer> xor = a -> a ^ 1;
        UnaryOperator<Integer> and = a -> a & 1;
        Function<Integer, Integer> compose = xor.andThen(and);
        System.out.println(compose.apply(2));

        Function<Integer, Integer> compose1 = xor.compose(and);
        System.out.println(compose1.apply(231));
    }
}


class comparatorDemo {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        queue.add("G");
//comparator
        Comparator comp = queue.comparator();
        System.out.println("default Comparator value is: " + comp);
        PriorityQueue<String> queue1 = new PriorityQueue<String>(new The_Comparator1());
        queue.add("G");
        queue.add("E");
        queue.add("E");
        queue.add("K");
        queue.add("S");
        queue.add("4");
        System.out.println("The elements with the highest priority element at front of queue"
                + "order:");
        System.out.println(" Comparator value is: " + queue1.comparator());
    }
}
class The_Comparator1 implements Comparator<String> {
    public int compare(String str1, String str2)
    {
        String first_Str;
        String second_Str;
        first_Str = str1;
        second_Str = str2;
        return second_Str.compareTo(first_Str);
    }
}

// Java Program to demonstrate
// BiFunction's apply() method

 class Maineee {
    public static void main(String args[])
    {
        // BiFunction to add 2 numbers
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // Implement add using apply()
        System.out.println("Sum = " + add.apply(2, 3));

        // BiFunction to multiply 2 numbers
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        // Implement add using apply()
        System.out.println("Product = " + multiply.apply(2, 3));


        // Using addThen() method
        multiply = multiply.andThen(a -> 3 * a);

        // Printing the result
        System.out.println("Composite2 = " + multiply.apply(2, 3));


    }
}
// Java Program to demonstrate
// BiConsumer's accept() method


 class GFGghj{
    public static void main(String args[])
    {

        // Create the first list
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(2);
        lista.add(1);
        lista.add(3);

        // Create the second list
        List<Integer> listb = new ArrayList<Integer>();
        listb.add(2);
        listb.add(1);
        listb.add(2);

        // BiConsumer to compare both lists
        BiConsumer<List<Integer>, List<Integer> >
                equals = (list1, list2) ->
        {
            if (list1.size() != list2.size()) {
                System.out.println("False");
            }
            else {
                for (int i = 0; i < list1.size(); i++)
                    if (list1.get(i) != list2.get(i)) {
                        System.out.println("False");
                        return;
                    }
                System.out.println("True");
            }
        };
        equals.accept(lista, listb);
        // BiConsumer to print 2 lists
        BiConsumer<List<Integer>, List<Integer> > disp = (list1, list2) ->
        {
            list1.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
            list2.stream().forEach(a -> System.out.print(a + " "));
            System.out.println();
        };

        // Using addThen() method
        equals.andThen(disp).accept(lista, listb);
    }
}
 class LambdaExpressionExample9{
    public static void main(String[] args) {

        //Thread Example without lambda
        Runnable r1=new Runnable(){
            public void run(){
                System.out.println("Thread1 is running...");
            }
        };
        Thread t1=new Thread(r1);
        t1.start();
        //Thread Example with lambda
        Runnable r2=()->{
            System.out.println("Thread2 is running...");
        };
        Thread t2=new Thread(r2);
        t2.start();
    }
}

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
 class LambdaExpressionExample10{
    public static void main(String[] args) {
        List<Product> list=new ArrayList<Product>();

        //Adding Products
        list.add(new Product(1,"HP Laptop",25000f));
        list.add(new Product(3,"Keyboard",300f));
        list.add(new Product(2,"Dell Mouse",150f));

        System.out.println("Sorting on the basis of name...");

        // implementing lambda expression
        Collections.sort(list,(p1,p2)->{
            return p1.name.compareTo(p2.name);
        });
        for(Product p:list){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }

    }
}

//A functional interface can extends another interface only when it does not have any abstract method.

interface sayable{
    void say(String msg);   // abstract method
}
////@FunctionalInterface - Multiple non-overriding abstract methods found in interface Doable
interface Doable extends sayable{
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface
    void doIt();
}



 class Mainere {
    public static void main(String args[])
    {

        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
    }
}


 class GFGtt {
    public static void main(String args[])
    {
        BinaryOperator<Integer>
                op = BinaryOperator
                .maxBy(
                        (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));

        System.out.println(op.apply(98, 11));
        BinaryOperator<Integer>
                op1 = BinaryOperator
                .minBy(
                        (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
        op.andThen(Function.identity());

        System.out.println(op1.apply(98, 11));
    }
}


 class Maintr {
    public static void main(String args[])
    {
        ToDoubleFunction<Integer> ob = a -> a / 2;

        // using applyAsDouble()
        System.out.println(ob.applyAsDouble(3));
    }
}


 class Mainrw {
    public static void main(String args[])
    {

        // Instantiating ToIntFunction
        ToIntFunction<Double> ob = a -> (int)(a * 10);

        // Applying the above function
        // using applyAsInt()
        System.out.println(ob.applyAsInt(3.23));
    }
}


 class Maing {
    public static void main(String args[])
    {

        // Instantiating ToLongFunction
        ToLongFunction<Integer> ob = a -> a * 10000;

        // Applying the above function
        // using applyAsLong()
        System.out.println(ob.applyAsLong(3));
    }
}



 class Maino {
    public static void main(String args[])
    {
        IntFunction<Double> ob = a -> a / 2.0;

        // Using apply() method
        System.out.println(ob.apply(3));
    }
}


















