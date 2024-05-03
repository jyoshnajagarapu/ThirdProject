//https://www.javatpoint.com/java-annotation
//https://www.geeksforgeeks.org/inherited-annotations-in-java/
//https://www.geeksforgeeks.org/annotations-in-java/
import java.util.ArrayList;

//@Override annotation assures that the subclass method is overriding the parent class method.
class Animal{
    void eatSomething(){System.out.println("eating something");}
}

class Dog extends Animal{
    @Override
    void eatSomething(){System.out.println("eating foods");}//should be eatSomething
}

class TestAnnotation1{
    public static void main(String args[]){
        Animal a=new Dog();
        a.eatSomething();
    }}

//@SuppressWarnings annotation: is used to suppress warnings issued by the compiler.
class TestAnnotation2{
    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        ArrayList list=new ArrayList();
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");

        for(Object obj:list)
            System.out.println(obj);

    }}

//@Deprecated annoation marks that this method is deprecated so compiler prints warning.
class Ae{
    void m(){System.out.println("hello m");}

    @Deprecated
    void n(){System.out.println("hello n");}
}

class TestAnnotation3{
    public static void main(String args[]){

        Ae a=new Ae();
        a.n();
    }}
