//type,repeatable annotation
//method parameter reflection
//type interface
//parallel array sort
//java nashorn - https://www.javatpoint.com/java-nashorn
//optional class - https://www.javatpoint.com/java-8-optional
//StringJoiner class - https://www.javatpoint.com/java-stringjoiner
//collectors class - https://www.javatpoint.com/java-8-collectors
//forEach,for Each Ordered method
//default,static methods in interface
//base 64 encode decode - https://www.javatpoint.com/java-base64-encode-decode
//lambda expressions
//method references
//functional interfaces
//STREAM Api

import java.util.ArrayList;
import java.util.List;
class TypeInferenceExample {
    public static void showList(List<Integer>list){
        if(!list.isEmpty()){
            list.forEach(System.out::println);
        }else System.out.println("list is empty");
    }
    public static void main(String[] args) {
        // An old approach(prior to Java 7) to create a list
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(11);
        showList(list1);
        // Java 7
        List<Integer> list2 = new ArrayList<>(); // You can left it blank, compiler can infer type
        list2.add(12);
        showList(list2);
        // Compiler infers type of ArrayList, in Java 8
        showList(new ArrayList<>());
    }
}