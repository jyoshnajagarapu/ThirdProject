package CollectionsTestPack;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Spliterator;

//When iterating through a HashSet the order is unpredictable, while a LinkedLinkedHashSet lets us iterate through the elements in the order in which they were inserted.
 class LinkedHashSetTest {
    public static void main(String[] args)
    {
        //constructors
        //1. default initial capacity is 16 and the default load factor is 0.75.
        LinkedHashSet<String> h1 = new LinkedHashSet<String>();
        //2. default load factor is 0.75.
        LinkedHashSet<String> h2 = new LinkedHashSet<String>(10);
        //3.
        LinkedHashSet<String> h3 = new LinkedHashSet<String>(20,0.80f);
        //4.
        LinkedHashSet<String> h4 = new LinkedHashSet<String>(h1);
        //METHODS
        LinkedHashSet<Integer> arrli = new LinkedHashSet<Integer>();
        LinkedHashSet<Integer> arrl2 = new LinkedHashSet<Integer>();
        LinkedHashSet<Integer> arrl3 = new LinkedHashSet<Integer>();
//add -duplicates not allowed but insertion order is maintained
        arrli.add(100);
        arrli.add(2);
        arrli.add(5);
        arrli.add(35);
        arrli.add(4);
        arrli.add(15);
        arrli.add(1);
        arrli.add(2);
        arrli.add(4);
        //multiple null allowed
//        arrli.add(null);
//        arrli.add(null);
//addAll - The elements are added randomly without following any specific order.
        arrl3.addAll(arrli);
        System.out.println("addAll" + arrli);
        System.out.println(arrl3);
//equals - The list returns true only if both LinkedHashSet contains same elements
        System.out.println("Are all the elements equal? " + arrli.equals(arrl3));
//isEmpty
        System.out.println(arrli.isEmpty());
//size
        System.out.println(arrli.size());
//tostring
        System.out.println("The String representation is: " + arrli.toString());

//remove
        arrli.remove(3);
        arrli.remove(new Integer(4));
        System.out.println(arrli);

//removeIf
        System.out.println("fremove if");
        arrli.removeIf(m -> (m % 3 == 0));
        System.out.println(arrli);
//removeAll
        arrli.add(9);
        arrli.add(11);
        System.out.println("fremove all");
        arrli.removeAll(arrl3);
        System.out.println(arrli);
        System.out.println("Are all the elements equal? " + arrli.equals(arrl3));
        arrli.addAll(arrl3);
        System.out.println(arrli);
        System.out.println(arrl3);

// containsAll
        System.out.println("Are all the contents equal? " + arrli.containsAll(arrl3));
//contains
        boolean ans1 = arrli.contains(21);
        if (ans1)
            System.out.println("The list contains 25");
        else
            System.out.println("The list does not contains 2");
        System.out.println("for each");
//forEach
        arrli.forEach((l) -> System.out.print(l + ","));
//retainAll
        System.out.println("retain all");
        arrli.retainAll(arrl3);
        System.out.println(arrli);
//spliterator
        System.out.println("spliterator");
        Spliterator<Integer> emails = arrli.spliterator();
        emails.forEachRemaining((p) -> System.out.print(p + ","));
//iterator
        System.out.println("iterator");
        Iterator value = arrli.iterator();
        while (value.hasNext()) {
            System.out.print(value.next() + ",");
        }
//hashCode
        System.out.println("hashCode");
        System.out.println("The hashCode value is: " + arrli.hashCode());
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
        System.out.println(" manual using streams");
        int[] arr5 = arrli.stream().mapToInt(o -> o).toArray();
        for (int x : arr5)
            System.out.print(x + " ");
        System.out.println("sublist");

//clear
        System.out.println("clear");
        arrli.clear();
//remove
        System.out.println("remove");
        LinkedHashSet<String>  myAlist = new LinkedHashSet<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original LinkedHashSet : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified LinkedHashSet : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified LinkedHashSet : " + myAlist);

        // Instantiate an object of LinkedHashSet - can also store collection apart from object
        LinkedHashSet<ArrayList> set = new LinkedHashSet<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        set.add(list1);
        set.add(list2);
        System.out.println(set.size());
//clone
        LinkedHashSet cloned_set = new LinkedHashSet();
        cloned_set = (LinkedHashSet)set.clone();

        System.out.println("The new set: " + cloned_set);

    }
}
