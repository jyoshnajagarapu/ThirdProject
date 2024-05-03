package CollectionsTestPack;//Though, it may be slower than standard arrays
//ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases.
//ArrayList is not Synchronized. Its equivalent synchronized class in Java is Vector.
import java.util.*;

class ArrayListExample extends ArrayList {
    public static void main(String[] args)
    {

        int n = 5;
//add
        ArrayList<Integer> arrli = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++)
            arrli.add(i);
        System.out.println(arrli);
        System.out.println(arrli.size());
        System.out.println("The String representation is: " + arrli.toString());
        arrli.add(3, 35);
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
        arrli.remove(Integer.valueOf(4));
        System.out.println(arrli);
        System.out.println(arrli.size());
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");
//addAll
        System.out.println("ADDALL");
        ArrayList<Integer> arrlist2 =
                new ArrayList<Integer>(5);

        // use add() method to add elements in list2
        arrlist2.add(25);
        arrlist2.add(30);
        arrlist2.add(31);
        arrlist2.add(35);
        arrli.addAll(arrlist2);
 // indexOf
        int pos =arrli.indexOf(3);
        //int pos1 =arrli.indexOf(2,2); //doest support
 //lastIndexOf
        int pos2 =arrli.lastIndexOf(4);
       // int pos3 =arrli.lastIndexOf(5,1); doesnt support
 //isEmpty
        boolean ans = arrli.isEmpty();
        if (ans == true)
            System.out.println("The ArrayList is empty");
        else
            System.out.println("The ArrayList is not empty");

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
        System.out.println("listiterator next");
        while (iterator1.hasNext()) {
            System.out.println("Value is : "
                    + iterator1.next());
        }
        System.out.println("listiterator prev");
        while (iterator1.hasPrevious()) {
            System.out.println("Value is : "
                    + iterator1.previous());
        }
        for (int i = 0; i < arrli.size(); i++)
            System.out.print(arrli.get(i) + " ");

 //equals
        ArrayList<Integer> arrli1 = (ArrayList<Integer>) arrli.clone();//ClassCastException
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
        int[] arr5 = arrli.stream().mapToInt(o -> o).toArray();//check
        for (int x : arr5)
            System.out.print(x + " ");
            System.out.println("sublist");
//sublist
        List<Integer> arrlist3 = arrli.subList(2, 4);
        System.out.println("Sublist of arrlist: " + arrlist3);

//trimtosize
        System.out.println("trimtosize");
        arrli.trimToSize();
//clear
        System.out.println("clear");
        arrli.clear();

//remove
        System.out.println("remove");
        List<String>  myAlist = new ArrayList<String>();
        myAlist.add("Geeks");
        myAlist.add("Practice");
        myAlist.add("Quiz");
        System.out.println("Original ArrayList : " + myAlist);
        myAlist.remove("Quiz");
        System.out.println("Modified ArrayList : " + myAlist);
        myAlist.remove(1);
        System.out.println("Modified LinkedList : " + myAlist);
//constructors
        //1.nonparameterized
        ArrayList arr = new ArrayList();
        //example
        //List<String> names = new ArrayList<>(); this is also correct
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        //2.capacity
        ArrayList arr1 = new ArrayList(12);
       // List<String> names1 = new ArrayList<>(20); this is also correct
        ArrayList<String> names1 = new ArrayList<>(20);
        names.add("John");
        names.add("Jane");
        //3.collection param
        Set<String> names3 = new HashSet<>();
        names.add("Ned");
        names.add("Catelyn");
        List<String> list = new ArrayList<>(names3);
        List<String> list1 = new ArrayList<>(arr);//Unchecked assignment: 'java.util.ArrayList' to 'java.util.List<java.lang.String>'
        List<String> list2 = new ArrayList<>(names1);
    }
}
//method unique to ArrayList
 class GFG8 extends ArrayList<Integer> {

    public static void main(String[] args)
    {
        GFG8 arr = new GFG8();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(12);
        arr.add(9);
        arr.add(13);
 //removeRange
        System.out.println("The list before using removeRange:" + arr);
        arr.removeRange(0, 2);
        System.out.println("The list after using removeRange:" + arr);
        Boolean a= null;
        System.out.println(a);


    }
}




