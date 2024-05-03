import java.util.ArrayList;
import java.util.List;

public class palindrome {
}

// Java Program to print all
// palindromes in a given range

class Palindrome1
{

    // A function to check
    // if n is palindrome
    public static int isPalindrome(int n)
    {
        int rev = 0;
        for (int i = n; i > 0; i /= 10)
            rev = rev * 10 + i % 10;
        return(n == rev) ? 1 : 0;
    }

    public static List<Integer> GetPalindrome(int StartNumber, int EndNumber)
    {
        List<Integer> palList = new ArrayList<>();
        for (int i = StartNumber; i <= EndNumber; i++)
            if (isPalindrome(i)==1)
                palList.add(i);
        return palList;
    }

    // Driver Code
    public static void main(String args[])
    {
        List<Integer> palList1 = GetPalindrome(100, 2000);
        for(Integer a : palList1){
            System.out.println (a + ",");
        }
    }
}

// This code is contributed by Taritra Saha.

