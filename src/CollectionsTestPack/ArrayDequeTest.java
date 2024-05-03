package CollectionsTestPack;
//implemented using DLL
import java.util.*;

class ArrayDequeue {

    public static void main(String args[])
    {

        //constructor
        //constructors
        ///1.intial default capacity of 16
        ArrayDeque<Integer> pq = new ArrayDeque<Integer>();
        //2.
        int n = 5;
        LinkedList<Integer> arrl = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            arrl.add(i);
        ArrayDeque<Integer> pq1 = new ArrayDeque<Integer>(arrl);
        //3.
        ArrayDeque<Integer> pq2 = new ArrayDeque<Integer>(10);

        //METHODS
        ArrayDeque<Integer> arrli = new ArrayDeque<Integer>();
        ArrayDeque<Integer> arrl2 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> arrl3 = new ArrayDeque<Integer>();
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
        ArrayDeque<String>  myAlist = new ArrayDeque<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original ArrayDeque : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified ArrayDeque : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified ArrayDeque : " + myAlist);
    }
}

//methods from queue and dequeue
class ArrayDequeueDemo {
    public static void main(String args[]) {
        ArrayDeque<String> list = new ArrayDeque<String>();
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("20");
        list.add("10");
        System.out.println("The list is:" + list);
//addLast
        list.addLast("At");
        list.addLast("Last");
        System.out.println("The new List is:" + list);
//offer
        list.offer("Asthma");
//offerLast
        list.offerLast("Asthalast");
//addFirst
        list.addFirst("First");
        list.addFirst("At");
        System.out.println("The new List is:" + list);
//offerFirst
        list.offerFirst("Asthma");
 //push
        list.push("GeeksforGeeks");

 //descendingIterator
        Iterator x = list.descendingIterator();
        while (x.hasNext()) {
            System.out.print("Value is : "
                    + x.next() + ";");

        }
//element
        System.out.println("The head element is " + list.element());
 //getFirst
        System.out.println("Element at 1st index is : " + list.getFirst());
//peek
        System.out.println("Head of the list : " + list.peek());
//peekFirst
        System.out.println("First element of the list is : " + list.peekFirst());
        System.out.println("list is : " + list);
//poll
        System.out.println("list poll : " + list.poll());
        System.out.println("list is : " + list);
//pollFirst
        System.out.println("list pollFirst : " + list.pollFirst());
        System.out.println("list is : " + list);
//pop
        System.out.println("list pop : " + list.pop());
        System.out.println("list is : " + list);
//remove
        System.out.println("list remove : " + list.remove());
        System.out.println("list is : " + list);
//removeFirst
        System.out.println("The removeFirst element is: " + list.removeFirst());
        System.out.println("list is : " + list);
 //removeFirstOccurrence
        System.out.println("The removeFirstOccurrence element is: " + list.removeFirstOccurrence("At"));
        System.out.println("list is : " + list);
//getLast
        System.out.println("Element at last index is : " + list.getLast());
//peekLast
        System.out.println("Last element of the list is : " + list.peekLast());
        System.out.println("list is : " + list);
 //pollLast
        System.out.println("list pollLast : " + list.pollLast());
        System.out.println("list is : " + list);
  //removeLast
        System.out.println("The last element is removeLast: " + list.removeLast());
        System.out.println("list is : " + list);
 //removeLastOccurrence
        System.out.println("The last element is removeLast: " + list.removeLastOccurrence("Geeks"));
        System.out.println("list is : " + list);
    }


}
