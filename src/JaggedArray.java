
// Another Java program to demonstrate 2-D jagged
// array such that first row has 1 element, second
// row has two elements and so on.
import java.util.Scanner;
class JaggedArray {
    public static void main(String[] args)
    {
//        int arr_name[][] = new int[][]  {
//                new int[] {10, 20, 30 ,40},
//                new int[] {50, 60, 70, 80, 90, 100},
//                new int[] {110, 120}
//        };
//
//        OR
//
//        int[][] arr_name = {
//                new int[] {10, 20, 30 ,40},
//                new int[] {50, 60, 70, 80, 90, 100},
//                new int[] {110, 120}
//        };
//
//        OR
//
//        int[][] arr_name = {
//                {10, 20, 30 ,40},
//                {50, 60, 70, 80, 90, 100},
//                {110, 120}
//        };
        int r = 5;

        // Declaring 2-D array with 5 rows
        int arr[][] = new int[r][];

        // Creating a 2D array such that first row
        // has 1 element, second row has two
        // elements and so on.
        for (int i = 0; i < arr.length; i++)
            arr[i] = new int[i + 1];

        // Initializing array
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = count++;

        // Displaying the values of 2D Jagged array
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

// Java program to illustrate creating an array
// of integers, puts some values in the array,
// and prints each value to standard output.

class GFG3
{
    public static void main (String[] args)
    {
        // declares an Array of integers.
        int[] arr = new int[5];
        int[] intArray = { 1,2,3,4,5,6,7,8,9,10 };
        int[] intArray1 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][][] arr2 = { {{1, 2}, {3, 4}}, {{5, 6}, {7, 8}} };
        sum(intArray);

    }
    public static void sum(int[] arr)
    {
        // getting sum of array values
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum+=arr[i];

        System.out.println("sum of array values : " + sum);
    }
    public static int[] m1()
    {

        return new int[]{1, 2, 3};
    }
}



 class GFGTestCase {
    public static void main(
            String[] args)
    {
        // Scanner class to take
        // values from console
        Scanner scanner = new Scanner(System.in);

        // totalTestCases = total
        // number of TestCases
        // eachTestCaseValues =
        // values in each TestCase as
        // an Array values
        int totalTestCases, eachTestCaseValues;

        // takes total number of
        // TestCases as integer number
        totalTestCases = scanner.nextInt();

        // An array is formed as row
        // values for total testCases
        int[][] arrayMain = new int[totalTestCases][];

        // for loop to take input of
        // values in each TestCase
        for (int i = 0; i < arrayMain.length; i++) {
            eachTestCaseValues = scanner.nextInt();
            arrayMain[i] = new int[eachTestCaseValues];
            for (int j = 0; j < arrayMain[i].length; j++) {
                arrayMain[i][j] = scanner.nextInt();
            }
        } // All input entry is done.

        // Start executing output
        // according to condition provided
        for (int i = 0; i < arrayMain.length; i++) {

            // Initialize total number of
            // even & odd numbers to zero
            int nEvenNumbers = 0, nOddNumbers = 0;

            // prints TestCase number with
            // total number of its arguments
            System.out.println(
                    "TestCase " + i + " with "
                            + arrayMain[i].length + " values:");
            for (int j = 0; j < arrayMain[i].length; j++) {
                System.out.print(arrayMain[i][j] + " ");

                // even & odd counter updated as
                // eligible number is found
                if (arrayMain[i][j] % 2 == 0) {
                    nEvenNumbers++;
                }
                else {
                    nOddNumbers++;
                }
            }
            System.out.println();

            // Prints total numbers of
            // even & odd
            System.out.println(
                    "Total Even numbers: " + nEvenNumbers
                            + ", Total Odd numbers: " + nOddNumbers);
        }
    }
}
// This code is contributed by Udayan Kamble.


