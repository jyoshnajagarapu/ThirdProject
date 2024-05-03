package CollectionsTestPack;


import java.util.*;

 class GFG1c {
    public static void main(String[] argv) throws Exception
    {
        try {

            // creating object of List<String>
            List<String> arrlist = new ArrayList<String>();

            // Adding element to arrlist
            arrlist.add("A");
            arrlist.add("B");
            arrlist.add("C");
            arrlist.add("Tajmahal");

            // printing the arrlist before operation
            System.out.println("arrlist before operation : " + arrlist);

            // add the specified element to specified Collections
            // using addAll() method
            boolean b = Collections.addAll(arrlist, "1", "2", "3");

            // printing the arrlist after operation
            System.out.println("result : " + b);

            // printing the arrlist after operation
            System.out.println("arrlist after operation : " + arrlist);
        }

        catch (NullPointerException e) {

            System.out.println("Exception thrown : " + e);
        }
        catch (IllegalArgumentException e) {

            System.out.println("Exception thrown : " + e);
        }
    }
}
