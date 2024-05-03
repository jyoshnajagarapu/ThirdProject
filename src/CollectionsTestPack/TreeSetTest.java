package CollectionsTestPack;

import java.security.PublicKey;
import java.util.*;

//sorted set provides mechanism for sorting the elements.they are stored in sorted order
//navigable set provides methods for navigation in addition to sorting provided by sorted set
public class TreeSetTest {
    public static void main (String[] args){
        //constructors
        TreeSet<String> h1 = new TreeSet<String>();
        // TreeSet(Comparator<E> comparator):  --check
        TreeSet<String> h4 = new TreeSet<String>(h1);
        //TreeSet<E> pq = new TreeSet<E>(SortedSet<E> c); --check

        //METHODS
        TreeSet<Integer> arrli = new TreeSet<Integer>();
        TreeSet<Integer> arrl2 = new TreeSet<Integer>();
        TreeSet<Integer> arrl3 = new TreeSet<Integer>();
//add -duplicates not allowed
        arrli.add(100);
        arrli.add(2);
        arrli.add(5);
        arrli.add(35);
        arrli.add(4);
        arrli.add(15);
        arrli.add(1);
        arrli.add(2);
        arrli.add(4);
//addAll - The elements are added randomly without following any specific order.
        arrl3.addAll(arrli);
        System.out.println("addAll" + arrli);
        System.out.println(arrl3);
//equals - The list returns true only if both TreeSet contains same elements, irrespective of order.
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
        TreeSet<String>  myAlist = new TreeSet<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original TreeSet : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified TreeSet : " + myAlist);
        //below not possible cause we cannnot remove integer from string type as treeset accepts only comparable types
        //myAlist.remove(1);

        // Instantiate an object of TreeSet - treeset cannot store collection objects as they are not comparable
        //TreeSet<ArrayList> set = new TreeSet<>();
//clone
        TreeSet cloned_set = new TreeSet();
        cloned_set = (TreeSet)arrli.clone();

        System.out.println("The new set: " + myAlist);
    }

}

class TreeSetDemo{
    public static void main(String[] args){
        TreeSet<Integer> arrli = new TreeSet<Integer>();
        arrli.add(100);
        arrli.add(2);
        arrli.add(5);
        arrli.add(35);
        arrli.add(4);
        arrli.add(15);
        arrli.add(1);
        arrli.add(2);
        arrli.add(4);
        arrli.add(5);
        arrli.add(10);
        arrli.add(30);
        arrli.add(40);
        arrli.add(50);
//ceiling
        System.out.println("Ceiling value for null: " + arrli.ceiling(15));
        System.out.println("Ceiling value for null: " + arrli.ceiling(20));
        System.out.println("Ceiling value for null: " + arrli.ceiling(210));
//higher
        System.out.println("higher" + arrli.higher(10));
        TreeSet<String> queue1= new TreeSet<String>(new The_Comparator1());

        System.out.println(" Comparator value is: " + queue1.comparator());
//tailSet
        //The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        TreeSet<Integer> tail_set = (TreeSet<Integer>) arrli.tailSet(15);
        System.out.println(" tail_set value is: " + tail_set);
        tail_set.add(109);
        System.out.println("arrli after tailset changing " + arrli);
        arrli.add(110);
        System.out.println("tail_set after arrli changing " + tail_set);
        tail_set = (TreeSet<Integer>) arrli.tailSet(15, false);
        System.out.println(" tail_set value is: " + tail_set);
//subSet
        //The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        TreeSet<Integer> sub_set = (TreeSet<Integer>) arrli.subSet(30,100);
        System.out.println(" sub_set value is: " + sub_set);
        sub_set.add(99);//number shouldnt exceed max limit
        System.out.println("arrli after sub_set changing " + arrli);
        arrli.add(120);
        arrli.add(98);
        System.out.println("sub_set after arrli changing " + sub_set);
//pollLast
        System.out.println("set: " + arrli);
        System.out.println("The Last element of the set: " + arrli.pollLast());
        System.out.println("after The Last element removed from the set: " + arrli);
//pollFirst
        System.out.println("First lowest element " + "removed is : " + arrli.pollFirst());
        System.out.println("after The first element removed from the set: " + arrli);
//lower
        System.out.println("strictly lower " + arrli.lower(15));
//last
        System.out.println("The last element is: " + arrli.last());
//headSet
        //The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
                TreeSet<Integer>head_set = (TreeSet<Integer>)arrli.headSet(35);
        System.out.println("The headSet elements are: " + head_set);
        head_set = (TreeSet<Integer>)arrli.headSet(35,true);
        System.out.println("The headSet elements are: " + head_set);
//floor
        System.out.println("Floor value for 25: " + arrli.floor(5));
//first
        System.out.println("The first element is: " + arrli.first());
//descendingSet
        //The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        NavigableSet<Integer> treereverse = arrli.descendingSet();
        System.out.println("\nValues using DescendingSet:" + treereverse);
//descendingIterator
        Iterator<Integer> iterator = arrli.descendingIterator();
        System.out.println("\nValues using DescendingIterator:");
        while (iterator.hasNext()) {
            System.out.println("Value : " + iterator.next());
        }


    }

}

class The_Comparator1 implements Comparator<String> {
    public int compare(String str1, String str2) {
        String first_Str;
        String second_Str;
        first_Str = str1;
        second_Str = str2;
        return second_Str.compareTo(first_Str);
    }
}
