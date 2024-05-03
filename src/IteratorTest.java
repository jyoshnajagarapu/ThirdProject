// Java program to Demonstrate Iterator

// Importing ArrayList and Iterator classes
// from java.util package
import java.util.*;
import java.util.stream.Stream;

// Main class
 class Teste {
    // Main driver method
    public static void main(String[] args)
    {
        // Creating an ArrayList class object
        // Declaring object of integer type
        ArrayList<Integer> al = new ArrayList<Integer>();

        // Iterating over the List
        for (int i = 0; i < 10; i++)
            al.add(i);

        // Printing the elements in the List
        System.out.println(al);

        // At the beginning itr(cursor) will point to
        // index just before the first element in al
        Iterator itr = al.iterator();

        // Checking the next element where
        // condition holds true till there is single element
        // in the List using hasnext() method
        while (itr.hasNext()) {
            // Moving cursor to next element
            int i = (Integer)itr.next();

            // Getting even elements one by one
            System.out.print(i + " ");

            // Removing odd elements
            if (i % 2 != 0)
                itr.remove();
        }

        // Command for next line
        System.out.println();

        // Printing the elements inside the object
        System.out.println(al);
        System.out.println("forEachRemaining");
        itr.forEachRemaining((x)->System.out.println(x));
        Iterator itr1 = al.iterator();
        System.out.println("forEachRemaining1");
        itr1.forEachRemaining((x)->System.out.println(x));
    }
}

// Java program to demonstrate
// methods of Spliterator
 class SpliteratorDemo
{
    public static void main(String[] args)
    {
        // Create an array list for doubles.
        ArrayList<Integer> al = new ArrayList<>();

        // Add values to the array list.
        al.add(1);
        al.add(2);
        al.add(-3);
        al.add(-4);
        al.add(5);

        // getting Spliterator object on al
        Spliterator<Integer> splitr1 = al.spliterator();


        // estimateSize method
        System.out.println("estimate size : " + splitr1.estimateSize());

        // getExactSizeIfKnown method
        System.out.println("exact size : " + splitr1.getExactSizeIfKnown());

        // hasCharacteristics and characteristics method
        System.out.println(splitr1.hasCharacteristics(splitr1.characteristics()));
        System.out.println("Content of arraylist usinf tryadvance:");
        splitr1.tryAdvance((n) -> System.out.println(n));
        System.out.println("Content of arraylist :");
        // forEachRemaining method
        splitr1.forEachRemaining((n) -> System.out.println(n));

        // Obtaining another Stream to the array list.
        Stream<Integer> str1 = al.stream();
        splitr1 = str1.spliterator();

        // trySplit() method
        Spliterator<Integer> splitr2 = splitr1.trySplit();

        // If splitr1 could be split, use splitr2 first.
        if(splitr2 != null) {
            System.out.println("Output from splitr2: ");
            splitr2.forEachRemaining((n) -> System.out.println(n));
        }

        // Now, use the splitr
        System.out.println("\nOutput from splitr1: ");
        splitr1.forEachRemaining((n) -> System.out.println(n));
        System.out.println("try advance");
        Stream<Integer> str4 = al.stream();
        Spliterator<Integer>  splitr3 = str4.spliterator();
        while(splitr3.tryAdvance((n) -> System.out.println(n)));
        System.out.println("foreach");
        splitr3.forEachRemaining((n) -> System.out.println(n));

    }
}


// Java program to demonstrate Enumeration


// Main class
 class Testerrr
{
    // Main driver method
    public static void main(String[] args)
    {
        // Creating a vector object
        Vector v = new Vector();

        // Iterating over vector object
        for (int i = 0; i < 10; i++)
            v.addElement(i);

        // Printing elements in vector object
        System.out.println(v);

        // At beginning e(cursor) will point to
        // index just before the first element in v
        Enumeration e = v.elements();

        // Checking the next element availability where
        // condition holds true till threre is a single element
        // remaining in the List
        while (e.hasMoreElements())
        {
            // Moving cursor to next element
            int i = (Integer)e.nextElement();

            // Print above elements in object
            System.out.print(i + " ");
        }
    }
}

// Java program to demonstrate ListIterator

// Importing ArrayList and List iterator classes
// from java.util package


// Main class
 class TestList {
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        for (int i = 0; i < 10; i++)
            al.add(i);
        System.out.println(al);
        ListIterator ltr = al.listIterator();
        System.out.print("hasnext");
        System.out.println();
        while (ltr.hasNext()) {
            int i = (Integer)ltr.next();
            System.out.print(i + " " + "nextindex" + ltr.nextIndex() + "; ");
            if (i % 2 == 0) {
                i++;
                ltr.set(i);
                ltr.add(i);

            }
            System.out.println(al);
        }
        System.out.println();
        System.out.print("final");
        System.out.println();
        System.out.println(al);
        System.out.println();
        System.out.print("hasprevious");
        while(ltr.hasPrevious()){
            int i = (Integer)ltr.previous();
            System.out.print(i + " " + "previndex" + ltr.previousIndex() + "; ");
            if(i == 7){
                ltr.remove();
            }
        }
        System.out.print("final");
        System.out.println();
        System.out.println(al);

    }
}



