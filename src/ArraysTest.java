//It consists of only static methods and the methods of Object class.

import java.util.*;
import java.lang.*;
 class GFG7 {
    public static void main(String[] argv) throws Exception
    {
        try {
            String a[] = new String[] { "A", "B", "C", "D" };
            //special Note: The type of array must be a Wrapper Class(Integer,Float, etc) in case of primitive data types(int, float,etc) , i.e you can’t pass int a[] but you can pass Integer a[]. If you pass int a[], this function will return a  List <int a[]> and not List <Integer> , as “autoboxing” doesn’t happen in this case and int a[] is itself identified as an object and a List of int array is returned, instead of list of integers , which will give error in various Collection functions .
// 1.asList()
            System.out.println("asList");
            List<String> list = Arrays.asList(a);
            System.out.println("The list is: " + list);
            List<String> list1 = Arrays.asList("a","b","c");
            System.out.println("The list is: " + list1);
            //list.add("L"); //throws error and it returns fixed size list

            String[][] ab = new String[][] { { "GFG", "GeeksForGeeks" },
                    { "g", "geeks" },
                    { "G", "Geeks" } };
            List<String[]> bc = Arrays.asList(ab);
            for(String[] c : bc){
                for(String d : c ){
                    System.out.println("The list is: " + d);
                }
            }



// 2.binarysearch()
            //If the input list is not sorted, the results are undefined.
            //Arrays.binarysearch() works for arrays which can be of primitive data type and object  also. Collections.binarysearch() works for objects Collections like ArrayList and LinkedList.
            char charArr[] = { 'g', 'p', 'q', 'c', 'i' };
            Arrays.sort(charArr);
            System.out.println("The char array is: ");
            for(char b : charArr){
                System.out.print(b);
            }
            char charKey = 'g';
            System.out.println(charKey + " found at index = " + Arrays.binarySearch(charArr, charKey));
            //the range within which the specified key to be searched must be sorted
            int intArr[] = { 1, 2,7,8,9, 3, 4, 5, 6 };
            Arrays.sort(intArr,1,7);
            int intKey = 3;
            System.out.println(intKey + " found at index = "
                            + Arrays.binarySearch(intArr, 1, 4, intKey));
            System.out.println("using comparator");
            Short shortArr[] = new Short[]{5, 2, 15, 52, 10};

            // use comparator as null, sorting as natural ordering
            Comparator<Short> comp = null;
            // sorting array
            Arrays.sort(shortArr, comp);
            System.out.println("The sorted short array is:");
            for (short number : shortArr) {
                System.out.println("Number = " + number);
            }
            short searchVal = 15;
            int retVal = Arrays.binarySearch(shortArr, searchVal, comp);
            System.out.println("The index of element 15 is : " + retVal);
            Short shortArr1[] = new Short[]{1,6,5, 2, 15, 52, 10};
            Arrays.sort(shortArr1, 4,6,comp);
            int retVal1 = Arrays.binarySearch(shortArr1,4,6,searchVal, comp);
            System.out.println("The index of element 15 in range is : " + retVal1);

            Integer array[]={90, 55, 49, 42, 33, 25, 8, 6, 1};
            Integer key = 33;
            int index5 = Arrays.binarySearch(array,key, (o1, o2) -> {
                if(o1>o2)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            });
            System.out.print(key+" found at index: "+index5);
 //3.compare
            // - primitive data types and object
            int array1[]={19,27,55,80};
            int array2[]={19,27,55,80};
            System.out.println(Arrays.compare(array1,array2));//0
            int array3[]={18,5,13,2};
            int array4[]={19,5,13,2};
            System.out.println(Arrays.compare(array3,array4));//-1
            int array5[]={21,15,3,12};
            int array6[]={19,15,3,12};
            System.out.println(Arrays.compare(array5,array6));//1
            System.out.println(Arrays.compare(array5,1,3,array6,0,3));//-1

//compareunsigned - check this in detail
            System.out.println("\nArrays.compareUnsigned(array1, array2): " + Arrays.compareUnsigned(array1, array2));
            System.out.println("\nArrays.compareUnsigned(array1, array2): " + Arrays.compareUnsigned(array1,0,2 ,array2,2,3));

 //copyOf
            System.out.println("copyOf");
            GFG7.printArray(intArr);
            int[] copy = Arrays.copyOf(intArr, 11);
            System.out.println("");
            GFG7.printArray(copy);
            int[] copy1 = Arrays.copyOf(intArr, 6);
            System.out.println("");
            GFG7.printArray(copy1);
 //copyOfRange
            System.out.println("copyOfRange");
            int[] copy2 = Arrays.copyOfRange(intArr, 2, 5);
            GFG7.printArray(copy2);
            int[] copy3 = Arrays.copyOfRange(intArr, 2, 12);
            GFG7.printArray(copy3);
//deepEquals
            //Equals() vs deepEquals()
            //Though Arrays.equals() works correctly on an single dimensional array but it cannot check the equality of a multidimensional arrays.
            //While Arrays.deepEquals() work on all arrays irrespective of the dimension.
            System.out.println("deepEquals");
            int a1[][] = { { 10, 20 }, { 40, 50 }, { 60, 70 } };
            int a2[][] = { { 30, 20 }, { 10, 0 }, { 60, 80 } };
            int a3[][] = { { 10, 20 }, { 40, 50 }, { 60, 70 } };
            int a4[][] = null;
            int a5[][] = null;
            System.out.println("Check if a1 is equal to a2 : " + Arrays.deepEquals(a1, a2));
            System.out.println("Check if a2 is equal to a3 : " + Arrays.deepEquals(a2, a3));
            System.out.println("Check if a1 is equal to a3 : " + Arrays.deepEquals(a1, a3));
            System.out.println("Check if a1 is equal to a3 : " + Arrays.deepEquals(a4, a5));
//equals

            int[] arr11 = new int [] {1, 2, 3, 4};
            int[] arr12 = new int [] {1, 2, 3, 4};
            int[] arr13 = new int [] {1, 2, 4, 3};

            System.out.println("is arr1 equals to arr2 : " +
                    Arrays.equals(arr11, arr12));
            System.out.println("is arr1 equals to arr3 : " +
                    Arrays.equals(arr11, arr13));
            //while using equals on user defined objects, over ride the equals method to have own check of equals. refer to OvverridingObjectMeth.java class for this

//deephashcode
            //So it is very clear from this example that even though there is inequality in two arrays but based on the deep content it may generate the same hash code.
            System.out.println("deephashcode");
            int[][] array8 = {
                    { 8, 7, 4 },
                    { 3, 6, 5 },
                    { 0, 2, 1 } };
            int[][] array7 = {
                    { 8, 4, 0 },
                    { 6, 7, 5 },
                    { 3, 2, 1 } };
            System.out.println("Hash array1 " + Arrays.deepHashCode(array8));
            System.out.println("Hash array2 " + Arrays.deepHashCode(array7));


//deeptoString
            //The simple toString() method works well for simple arrays, but doesn’t work for multidimensional arrays. This method is designed for converting multi-dimensional arrays to strings.
            // Create a 2D array
            int[][] mat = new int[2][2];
            mat[0][0] = 99;
            mat[0][1] = 151;
            mat[1][0] = 30;
            mat[1][1] = 5;

            // print 2D integer array using deepToString()
            System.out.println(Arrays.deepToString(mat));
            String[] strs = new String[] {"practice.geeksforgeeks.org",
                    "quiz.geeksforgeeks.org"
            };
            System.out.println(Arrays.deepToString(strs));

            Integer []  arr1 = {10, 20, 30, 40};
            System.out.println(Arrays.deepToString(arr1));

        /* Uncommenting below code would cause error as
           deepToString() doesn't work for  one dimension primitive types */
        int []  arr2 = {10, 20, 30, 40};
       // System.out.println(Arrays.deepToString(arr2));
 //toString
            int[] intArr1 = new int[] { 1, 2, 3, 4 };
            System.out.println("toString" + Arrays.toString(intArr1));

//fill
            int ar[] = {2, 2, 1, 8, 3, 2, 2, 4, 2};
            Arrays.fill(ar, 10);
            System.out.println("Array completely filled" +
                    " with 10\n" + Arrays.toString(ar));
            Arrays.fill(ar, 1, 5, 5);
            System.out.println("Array completely filled" +
                    " with 10\n" + Arrays.toString(ar));
//hashcode
            int arr[] = {3, 2, 4, 5, 7};
            int hashCode=Arrays.hashCode(arr);
            System.out.println("HashCode for int array: "+hashCode);

//mismatch
            int array9[] = { 5, 10, 15, 20, 25 };
            int array10[] = { 5, 10, 15, 80, 100 };
            int index = Arrays.mismatch(array9, array10);
            System.out.println("mismatched index for both arrays is: "+index);
            int array11[] = { 15, 4, 22, 20, 45, 37, 18, 14, 12};
            int array12[] = { 7, 10, 11, 20, 45, 37, 18, 14, 12};
            int index1 = Arrays.mismatch(array11, 3, 5, array12, 3, 8 );//check this
            System.out.println("mismatched index for both arrays is: "+index1);


 //sort
            int[] arr6 = { 13, 7, 6, 45, 21, 9, 101, 102 };
            Arrays.sort(arr6);
            System.out.println("Modified arr[] :" +  Arrays.toString(arr6));
            int[] arr7 = { 13, 7, 6, 45, 21, 9, 101, 102 };
            Arrays.sort(arr7,3,7);
            System.out.println("Modified arr[] :" +  Arrays.toString(arr7));
            Integer[] arr8 = { 13, 7, 6, 45, 21, 9, 2, 100 };

            // Sorts arr[] in descending order using
            // reverseOrder() method of Collections class
            // in Array.sort() as an argument to it
            Arrays.sort(arr8, Collections.reverseOrder());//check this
            System.out.println("Modified arr[] :" +  Arrays.toString(arr8));
            Arrays.sort(arr8,3,6,Collections.reverseOrder());

 //parallelsort
            //The parallel sort uses Fork/Join Concept for sorting.
            //parallelSort() method uses concept of MultiThreading which makes the sorting faster as compared to normal sorting method.

            int numbers[] = { 21,23,50,9, 8, 7, 6, 3, 1 };
            Arrays.parallelSort(numbers);
            System.out.println("parallel sort " + Arrays.toString(numbers));
            int numbers1[] = { 21,23,50,9, 8, 7, 6, 3, 1 };
            Arrays.parallelSort(numbers1,1,5);
            System.out.println("parallel sort " + Arrays.toString(numbers1));
            Integer[] arr9 = { 13, 7, 6, 45, 21, 9, 2, 100 };
            Arrays.parallelSort(arr9, Collections.reverseOrder());
            System.out.println("parallel sort " + Arrays.toString(arr9));
            Integer[] arr10 = { 13, 7, 6, 45, 21, 9, 2, 100 };
            Arrays.parallelSort(arr10, 1,5,Collections.reverseOrder());
            System.out.println("parallel sort " + Arrays.toString(arr10));
            //Arrays.stream()
            ///Arrays.spliterator()
            //Arrays.parallelPrefix();
            //Arrays.parallelSetAll();
            //Arrays.setAll();






        }
        catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }

    static void printArray(int[] a){
        for(int b : a){
            System.out.print(b);
        }
    }
}


// Java program to demonstrate working of Arrays.toString()
// for user defined objects.


// Driver class
class Main0 {
    public static void main(String[] args)
    {
        Student9[] arr = { new Student9(111, "bbbb", "london"),
                new Student9(131, "aaaa", "nyc"),
                new Student9(121, "cccc", "jaipur") };

        System.out.println(Arrays.toString(arr));
    }
}

// A class to represent a student.
class Student9 {
    int rollno;
    String name, address;

    // Constructor
    public Student9(int rollno, String name,
                   String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()

    public String toString()
    {
        return this.rollno + " " + this.name + " " + this.address;
    }
}

