//Reference to a static method.
// If a lambda expression just call a static method of a class
//(args) -> Class.staticMethod(args)
//// Shorthand if a lambda expression just call a static method of a class
//Class::staticMethod

// If a lambda expression just call a default method of an object

//(args) -> obj.instanceMethod(args)
// Shorthand if a lambda expression just call a default method of an object

//obj::instanceMethod
// If a lambda expression just call an instance method of a  ObjectType

//(obj, args) -> obj.instanceMethod(args)
//// Shorthand if a lambda expression just call an instance method of a ObjectType
//
//ObjectType::instanceMethod
// If a lambda expression just create an object
//(args) -> new ClassName(args)
// Shorthand if a lambda expression just create an object
//ClassName::new
import java.util.function.BiFunction;
import java.util.function.Function;

class Arithmetic{
    static int i= 9;
    public static int add(int a, int b){
        return a+b;
    }
    public static float add(int a, float b){
        return a+b;
    }
    public static float add(float a, float b){
        return a+b;
    }
    public static int test(int r  ){return r;}

}
 class MethodReference4 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;//Class::staticMethod
        BiFunction<Integer, Integer, Integer>adder4 = (a,b) -> Arithmetic.add(a,b); //(args) -> Class.staticMethod(args)
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;
        Function<Integer,Integer> test3 = Arithmetic:: test;
        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        Function<Integer, Integer> getSquare = i -> i * i;
        SomeFunction(getSquare);//can be passed as method parameters
    }

     private static void SomeFunction(Function<Integer, Integer> getSquare) {
        getSquare.apply(2);

         //list.forEach(System.out::println) shorthand for printing
     }
 }

 class MethodReference2 {
    public static void ThreadStatus(){
        System.out.println("Thread is running...");
    }
    public static void main(String[] args) {
        Thread t2=new Thread(MethodReference2::ThreadStatus);
        t2.start();
    }
}
//Reference to an Instance Method
interface Sayable{
    void say();
}
 class InstanceMethodReference {
    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        InstanceMethodReference methodReference1 = new InstanceMethodReference();
        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething; //obj::instanceMethod
        Sayable sayable1 = () -> methodReference.saySomething(); //(args) -> obj.instanceMethod(args)

        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();

        Thread t2=new Thread(new InstanceMethodReference()::saySomething);
        t2.start();
    }
}
class Arithmetica{
    public int add(int a, int b){
        return a+b;
    }
}
 class InstanceMethodReference3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer>adder = new Arithmetica()::add;
        int result = adder.apply(10, 20);
        System.out.println(result);
    }
}

//Reference to a Constructor

@FunctionalInterface
interface MyFunctionalInterface {
    Studentee getStudent(String name);
}
 class ConstructorReferenceTest1 {
    public static void main(String[] args) {
        MyFunctionalInterface mf = Studentee::new;

        Function<String, Studentee> f1 = Studentee::new;   //ClassName::new
        Function<String, Studentee> f2 = (name) -> new Studentee(name);// (args) -> new ClassName(args)

        System.out.println(mf.getStudent("Adithya").getName());
        System.out.println(f1.apply("Jai").getName());
        System.out.println(f2.apply("Jai").getName());
    }
}

// Student class
class Studentee {
    private String name;
    public Studentee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}