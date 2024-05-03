package CollectionsTestPack;

import java.util.*;
//public class Stack<E> extends Stack<E>
//stack supports all the methods supported by vector
//refer to CollectionsTestPack.StackDemo class for additional methods of stack
class StackTest {
    public static void main(String[] args)
    {
//methods
        int n = 5;
//add
        Stack<Integer> arrli = new Stack<Integer>();
        for (int i = 1; i <= n; i++)
            arrli.add(i);
        arrli.add(2,8);
 //replaceAll
        System.out.println("replaceAll");
        arrli.replaceAll(o -> ++o);
        System.out.println(arrli);
 //toString
        System.out.println("The String representation is: " + arrli.toString());
        System.out.println(arrli);//internally calls toString
  //spliterator
        Spliterator<Integer> emails = arrli.spliterator();
        emails.forEachRemaining((k) -> System.out.println(k));
        System.out.println(arrli.size());
        arrli.add(3, 35);
        System.out.println("containsAll");
        Stack<Integer> arrli1 = (Stack<Integer>) arrli.clone();
 //equals
        System.out.println("Are all the elements equal? " + arrli.equals(arrli1));
        arrli1.remove(3);
        arrli1.remove(4);
        System.out.println(arrli1);
        System.out.println("Are all the elements equal? " + arrli.equals(arrli1));
 // containsAll
        System.out.println("Are all the contents equal? " + arrli.containsAll(arrli1));
        arrli1.add(6);
        System.out.println(arrli1);
        System.out.println("Are all the contents equal? " + arrli.containsAll(arrli1));
//remove
        arrli.remove(3);
        arrli.remove(new Integer(4));
        System.out.println(arrli);
        System.out.println(arrli.size());
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");
//addAll
        System.out.println("ADDALL");
        Stack<Integer> arrlist2 =
                new Stack<Integer>();

        // use add() method to add elements in list2
        arrlist2.add(25);
        arrlist2.add(30);
        arrlist2.add(31);
        arrlist2.add(35);
        arrli.addAll(arrlist2);
 // indexOf
        int pos =arrli.indexOf(2);
        int pos1 =arrli.indexOf(2,2); // not present in arraylist
 //lastIndexOf
        int pos2 =arrli.lastIndexOf(5);
        int pos3 =arrli.lastIndexOf(5,1); // not present in arraylist
        boolean ans = arrli.isEmpty();
        if (ans == true)
            System.out.println("The Stack is empty");
        else
            System.out.println("The Stack is not empty");
        // prints 2
        System.out.println("\nThe element 3 is at index : " + pos + pos2 + pos1 +pos3);
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");
        System.out.println("for loop");
        for (Integer value : arrli)
            System.out.print(value);
        //System.out.println("removeRange");
        //arrli.removeRange(0, 2);
//removeIf
        System.out.println("fremove if");
        arrli.removeIf(m -> (m % 3 == 0));
        System.out.println(arrli);
//removeAll
        System.out.println("fremove all");
        arrli.removeAll(arrlist2);
        System.out.println(arrli);
        System.out.println("addallarg");
 //addAll (index,element)
        arrli.addAll(2,arrlist2);
        System.out.println("listiterator");
 //listiterator
        ListIterator<Integer> iterator = arrli.listIterator();
        while (iterator.hasNext()) {
            System.out.println("Value is : "
                    + iterator.next());
        }
        System.out.println("listiterator argument");
        ListIterator<Integer> iterator1 = arrli.listIterator(3);
        while (iterator1.hasNext()) {
            System.out.println("Value is : "
                    + iterator1.next());
        }
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");
 //contains
        boolean ans1 = arrli.contains(25);

        if (ans1)
            System.out.println("The list contains 25");
        else
            System.out.println("The list does not contains 2");
//ensureCapacity
        arrli.ensureCapacity(400);
        System.out.println("for each");
 //forEach
        arrli.forEach((l) -> System.out.println(l));
//retainAll
        System.out.println("retain all");
        arrli.retainAll(arrlist2);
        System.out.println(arrli);
//set
        System.out.println("set");
        int i = arrli.set(3, 39);
        System.out.println("After operation: " + arrli);
        System.out.println("Replaced element: " + i);
 // hashCode
        System.out.println("hashCode");
        System.out.println("The hashCode value is: " + arrli.hashCode());
//Size
        System.out.println("Size of list = " + arrli.size());
//setSize
        arrli.setSize(5);//[25, 30, 31, 39, null]
        System.out.println("After setsize operation: " + arrli);
        arrli.add(8);//[25, 30, 31, 39, null, 8]
        System.out.println("After setsize operation: " + arrli);
        while (arrli.remove(null)) {
        }
        System.out.println("After removing all null" + arrli);
        arrli.setSize(4);
        System.out.println("After setsize  less operation: " + arrli);
 //trimtosize
        System.out.println("trimtosize");
        arrli.trimToSize();
 //sort
        //It works similar to java.util.Arrays.sort() method but it is better then as it can sort the elements of Array as well as linked list, queue and many more present in it.
        //it is static method
        Collections.sort(arrli);
        System.out.println("After sort " + arrli);
        Collections.sort(arrli, Collections.reverseOrder());
        System.out.println("After reverse sort " + arrli);
//spliterator
        System.out.println("spliterator");
        Spliterator<Integer> emails1 = arrli.spliterator();
        emails1.forEachRemaining((p) -> System.out.println(p));
// iterator
        System.out.println("iterator");
        Iterator value = arrli.iterator();
        while (value.hasNext()) {
            System.out.println(value.next());
        }
//toArray
        System.out.println("toArray");
        // Error: incompatible types: Object[] cannot be converted to Integer[]
        //Integer[] objects1 = arrli.toArray();
        Object[] objects = arrli.toArray();

        for (Object obj : objects)
            System.out.print(obj + " ");
        Integer[] arr4 = new Integer[arrli.size()];
        arr4 = arrli.toArray(arr4);
        System.out.println("toArray of arrlist:");
        for (Integer x : arr4)
            System.out.print(x + " ");
        System.out.println(" manual toArray of arrlist: using get method");
        Integer[] arr9 = new Integer[arrli.size()];
//get
        for (int j = 0; j < arrli.size(); j++)
            arr9[j] = arrli.get(j);
        for (Integer x : arr9)
            System.out.print(x + " ");
        System.out.println(" manual using streams");
        int[] arr5 = arrli.stream().mapToInt(o -> o).toArray();
        for (int x : arr5)
            System.out.print(x + " ");
        System.out.println("sublist");
//sublist
        List<Integer> arrlist3 = arrli.subList(2, 4);
        System.out.println("Sublist of arrlist: " + arrlist3);

//clear
        System.out.println("clear");
        arrli.clear();

//remove
        System.out.println("remove");
        List<String>  myAlist = new Stack<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original Stack : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified Stack : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified LinkedList : " + myAlist);

//constructors
        //1.nonparameterized
        Stack arr = new Stack();
        //example
        //List<String> names = new Stack<>(); this is also correct
        Stack<String> names = new Stack<>();
        names.add("John");
        names.add("Jane");

    }
}

//methods unique to  stack class
 class StackDemo {
    public static void main(String args[])
    {
        Stack<String> STACK = new Stack<String>();
 //push
        STACK.push("Welcome");
        STACK.push("To");
        STACK.push("Geeks");
        STACK.push("For");
        STACK.push("Geeks");
        System.out.println("Initial Stack: " + STACK);
        STACK.push("Hello");
        STACK.push("World");
        System.out.println("Final Stack: " + STACK);
 //peek
        System.out.println("The element at the top of the" + " stack is: " + STACK.peek());
 //search
        //This method starts the count of the position from 1 and not from 0. The element that is on the top of the stack is considered to be at position 1. If more than one element is present, the index of the element closest to the top is returned. The method returns its position if the element is successfully found and returns -1 if the element is absent.
        System.out.println("Does the stack contains 'For'? " + STACK.search("For"));
 //pop
        System.out.println("Popped element: " + STACK.pop());
        System.out.println("Popped element: " + STACK.pop());
 //empty
        System.out.println("Is the stack empty? " + STACK.empty());
        while(!STACK.empty()){
            STACK.pop();
        }
        System.out.println("Is the stack empty? " + STACK.empty());
    }
}
//methods from vector class
class   StackVectorDemo {
    public static void main(String args[]){

        Stack<Integer> arrl2 = new Stack<Integer>();
        //add(Object ) is due the fact that Vector implements List Interface and it is appeared since Java 1.2 when Vector was moved to Collections: The collection classes from earlier releases, Vector and Hashtable, have been retrofitted to implement the collection interfaces.
// addElement  - is "original" Vector's method.
        arrl2.addElement(9);
        arrl2.addElement(4);
        arrl2.addElement(2);
        arrl2.addElement(1);
        arrl2.addElement(8);
        arrl2.addElement(3);

//firstElement
        System.out.println("The first element is: " + arrl2.firstElement());
        //get(int) complies with the List interface added 15 years ago now.
// elementAt
        System.out.println("The element is: " + arrl2.elementAt(3));
        System.out.println(arrl2);
        System.out.println(arrl2.size());
 //elements
        Enumeration enu = arrl2.elements();
        System.out.println("The enumeration of values are:");
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
 //copyInto
        System.out.println("copyInto");
        //Integer a[] = new Integer[3];//arraycopy: last destination index 6 out of bounds for object array[3]
        Integer a[] = new Integer[arrl2.size() + 1];
        arrl2.copyInto(a);
        for(Integer b : a)
            System.out.print(b);
//capacity
        System.out.println("The capacity is: " + arrl2.capacity());
//lastElement
        System.out.println("The  element is: " + arrl2);
        System.out.println("The last element is: " + arrl2.lastElement());
 //removeElementAt
        System.out.println("removeElementAt");
        arrl2.removeElementAt(1);
        System.out.println(arrl2);
//removeElement
        arrl2.add(7);
        arrl2.add(8);
        arrl2.add(9);
        System.out.println(arrl2);
        arrl2.removeElement(9);
        System.out.println(arrl2);
//removeAllElements
        System.out.println("removeAllElements");
        Stack<Integer> arrli2 = (Stack<Integer>) arrl2.clone();
        System.out.println(arrli2);
        arrli2.removeAllElements();
        System.out.println(arrli2);
        arrli2.addElement(2);
        arrli2.addElement(1);
        arrli2.addElement(8);
        System.out.println("After addElement operation: " + arrli2);
//setElementAt
        arrli2.setElementAt(40,2);
        System.out.println("After setElementAt operation: " + arrli2);
//insertElementAt
        System.out.println("insertElementAt");
        arrli2.insertElementAt(25,3);
        System.out.println("After insertElementAt operation: " + arrli2);


    }

}