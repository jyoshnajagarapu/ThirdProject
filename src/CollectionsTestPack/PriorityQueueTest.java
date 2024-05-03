package CollectionsTestPack;

import java.util.*;
//The PriorityQueue class provides the functionality of the heap data structure.
//It is important to note that the elements of a priority queue may not be sorted. However, elements are always retrieved in sorted order.
//The insertion order is not retained in the PriorityQueue.
public class PriorityQueueTest {
    public static void main(String[] args){

        //constructors
        ///1.intial default capacity of 11
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //2.
        int n = 5;
        LinkedList<Integer> arrl = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            arrl.add(i);
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(arrl);
        //3.
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10);
        //4. PriorityQueue(int initialCapacity, Comparator<E> comparator):  --check
        //5.
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(pq);
        //6.riorityQueue<E> pq = new PriorityQueue<E>(SortedSet<E> c); --check

        //METHODS
        PriorityQueue<Integer> arrli = new PriorityQueue<Integer>();
        PriorityQueue<Integer> arrl2 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> arrl3 = new PriorityQueue<Integer>();
//add
        arrli.add(1);
        arrli.add(2);
        arrli.add(5);
        arrli.add(3);
        arrli.add(4);
        arrli.add(15);
//addAll
        arrl3.add(21);
        arrl3.addAll(arrli);
        System.out.println("addAll" + arrli);
        System.out.println(arrl3);
        System.out.println("Are all the elements equal? " + arrli.equals(arrl3)); //always returns false cause this method is not implemented and takes it from object class
//isEmpty
        while(!arrli.isEmpty()){
//poll
            System.out.println("The removed ele is " + arrli.poll());
        }
        arrli.addAll(arrl3);
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
        PriorityQueue<String>  myAlist = new PriorityQueue<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original PriorityQueue : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified PriorityQueue : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified PriorityQueue : " + myAlist);

    }
}

class priorityDemo{
    public static void main (String[] args){
        PriorityQueue<String> queue = new PriorityQueue<String>();
        queue.add("G");
//comparator
        Comparator comp = queue.comparator();
        System.out.println("default Comparator value is: " + comp);
        PriorityQueue<String> queue1= new PriorityQueue<String>(new The_Comparator());
        queue.add("G");
        queue.add("E");
        queue.add("E");
        queue.add("K");
        queue.add("S");
        queue.add("4");
        System.out.println("The elements with the highest priority element at front of queue"
                + "order:" + queue );
//        while(!queue.isEmpty()){
//            System.out.print(" "+queue.poll());
//        }
        System.out.println(" Comparator value is: " + queue1.comparator());


//offer
        queue.offer("L");
        System.out.println("The elements "+ "order:" + queue );
//element
        System.out.println("head of queue using element" + queue.element());
//peek
        System.out.println("head of queue using peek" + queue.peek());
//poll
        System.out.print(" "+queue.poll());
//remove
        System.out.println("removing head of queue" + queue.remove());


        PriorityQueue<Integer> pq = new PriorityQueue<>(new The_Comparator3());
        for(int i=0;i<3;i++){
            pq.add(i);
            pq.add(1);
        }
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }


    }
}

class The_Comparator implements Comparator<String> {
    public int compare(String str1, String str2)
    {
        String first_Str;
        String second_Str;
        first_Str = str1;
        second_Str = str2;
        return second_Str.compareTo(first_Str);
    }
}

class The_Comparator3 implements Comparator<Integer> {
    public int compare(Integer str1, Integer str2)
    {

        return (str1 - str2);
    }
}

