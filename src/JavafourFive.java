//assertion
//for-each
//varargs
//static import
//autoboxing - https://www.javatpoint.com/autoboxing-and-unboxing
//enum
//generics
//annotationsg

import java.util.Scanner;

import static java.lang.System.*;
class StaticImportExample{
    public static void main(String args[]){

        out.println("Hello");//Now no need of System.out
        out.println("Java");

    }
}

//varargs
//void method(String... a, int... b){}//Compile time error
//
//void method(int... a, String b){}//Compile time error
//
//Internally, the Varargs method is implemented by using the single dimensions arrays concept. Hence, in the Varrargs method, we can differentiate arguments by using Index.
class VarargsExample3{

    static void display(int num, String... a){
        System.out.println("number is "+num);
        for(String s:a){
            System.out.println(s);
        }
        System.out.println("Number of arguments: "
                + a.length);
    }

    public static void main(String args[]){
        String[] a = {"my","name","is","varargs"};
        display(500,"hello");//one argument
        display(1000,"my","name","is","varargsd");//four arguments
        display(1000, a);
        display(5);//vararg can also be zero
    }
}

//assert expression;
//assert expression1 : expression2;
//by default assertions are not enabled
class AssertionExample{
    public static void main( String args[] ){

        Scanner scanner = new Scanner( System.in );
        System.out.print("Enter ur age ");

        int value = scanner.nextInt();
        assert value>=18:" Not valid";

        System.out.println("value is "+value);
    }
}
