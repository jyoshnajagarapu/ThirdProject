package CollectionsTestPack;
//implemented using DLL
import java.util.*;

 class GFG1 {

    public static void main(String args[])
    {
        int n = 5;
//add
        LinkedList<Integer> arrli = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            arrli.add(i);

        System.out.println(arrli);
        System.out.println(arrli.size());
        System.out.println("The String representation is: " + arrli.toString());
        arrli.add(3, 35);
        System.out.println(arrli);
        System.out.println(arrli);
        System.out.println(arrli.size());
//replaceAll
        System.out.println("replaceAll");
        arrli.replaceAll(o -> ++o);
        System.out.println(arrli);
//sort
        //It works similar to java.util.Arrays.sort() method but it is better then as it can sort the elements of Array as well as linked list, queue and many more present in it.
        //it is static method
        Collections.sort(arrli);
        System.out.println("After sort " + arrli);
        Collections.sort(arrli, Collections.reverseOrder());
        System.out.println("After reverse sort " + arrli);
//remove
        arrli.remove(3);
        arrli.remove(new Integer(4));
        System.out.println(arrli);
        System.out.println(arrli.size());
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");
//addAll
        System.out.println("ADDALL");
        LinkedList<Integer> arrlist2 =
                new LinkedList<Integer>();

        // use add() method to add elements in list2
        arrlist2.add(25);
        arrlist2.add(30);
        arrlist2.add(31);
        arrlist2.add(35);
        arrli.addAll(arrlist2);
        // indexOf
        int pos =arrli.indexOf(3);
        //int pos1 =arrli.indexOf(2,2); doest support
        //lastIndexOf
        int pos2 =arrli.lastIndexOf(4);
        // int pos3 =arrli.lastIndexOf(5,1); doesnt support
        boolean ans = arrli.isEmpty();
        if (ans == true)
            System.out.println("The LinkedList is empty");
        else
            System.out.println("The LinkedList is not empty");

        // prints 2
        System.out.println("\nThe element 3 is at index : " + pos + pos2);
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

        //equals
        LinkedList<Integer> arrli1 = (LinkedList<Integer>) arrli.clone();//ClassCastException
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
        //contains
        boolean ans1 = arrli.contains(25);

        if (ans1)
            System.out.println("The list contains 25");
        else
            System.out.println("The list does not contains 2");

        //ensureCapacity
       // arrli.ensureCapacity(400);
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
//Size
        System.out.println("Size of list = " + arrli.size());
//spliterator
        System.out.println("spliterator");
        Spliterator<Integer> emails = arrli.spliterator();
        emails.forEachRemaining((p) -> System.out.println(p));
//iterator
        System.out.println("iterator");
        Iterator value = arrli.iterator();
        while (value.hasNext()) {
            System.out.println(value.next());
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
//trimtosize
        System.out.println("trimtosize");
        //arrli.trimToSize();
//clear
        System.out.println("clear");
        arrli.clear();

//remove
        System.out.println("remove");
        List<String>  myAlist = new LinkedList<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original LinkedList : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified LinkedList : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified LinkedList : " + myAlist);
 //CONSTRUCTORS
        System.out.println("CONSTRUCTORS");
        LinkedList<String> l2 = new LinkedList<String>();
        l2.add("A");//A
        l2.add("B");//AB
        LinkedList<String> l3 = new LinkedList<String>(l2);
        System.out.println(l3);//AB
        l3.add("C");
        l3.add("D");
        System.out.println(l3);//ABCD
    }
}

//methods from deque and queue
 class LinkedListDemo {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
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
