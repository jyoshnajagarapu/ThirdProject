import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
public class Stringtest {
    public static void main(String args[]){
        //constructors of String
        byte[] b_arr = {71, 101, 101, 107, 115};
        String s_byte =new String(b_arr); //Geeks
        System.out.println("cons1 : "+  s_byte);
        Charset cs = Charset.defaultCharset();
        String s_byte_char = new String(b_arr, cs); //Geeks
        System.out.println("cons2 : "+  s_byte_char);

        //String s = new String(b_arr, "US-ASCII"); //Geeks
        String s = new String(b_arr, 1, 3); // eek
        System.out.println("cons4 : "+  s);
        String s1 = new String(b_arr, 1, 3, cs); // eek
        System.out.println("cons5 : "+  s1);
       // String s = new String(b_arr, 1, 4, "US-ASCII"); // eeks
        char char_arr[] = {'G', 'e', 'e', 'k', 's'};
        String s4 = new String(char_arr); //Geeks
        System.out.println("cons7 : "+  s4);
        String s5 = new String(char_arr , 1, 3); //eek
        System.out.println("cons8 : "+  s5);
        int[] uni_code = {71, 101, 101, 107, 115};
        String s6 = new String(uni_code, 1, 3); //eek
        System.out.println("cons9 : "+  s6);
        StringBuffer s_buffer = new StringBuffer("Geeks");
        String s7 = new String(s_buffer); //Geeks
        System.out.println("cons10 : "+  s7);
        StringBuilder s_builder = new StringBuilder("Geeks");
        String s8 = new String(s_builder); //Geeks
        System.out.println("cons11 : "+  s8);
        String s9 = new String("string"); //Geeks
        System.out.println("cons12 : "+  s9);

        //methods of string
        Locale TURKISH = Locale.forLanguageTag("tr");
        String st = "ilovepandasomuch";
        String st1 = "Ilovepandasomuch";
        String s2 = "ducktoo";
        String s3 = st.concat(s2);
        System.out.println("length : "+  st.length());
        System.out.println("charAt : "+  st.charAt(5));
        System.out.println("substring: "+  st.substring(5));//including start index
        System.out.println("substring1: "+  st.substring(5,7));//start index inclusive, end index exclusive
        System.out.println("concat: "+  s3);
        System.out.println("indexof "+  s3.indexOf("panda"));
        System.out.println("indexof1 : "+  s3.indexOf("o",2));//inclusive
        System.out.println("lastindexof1 : "+  st.lastIndexOf("o"));
        System.out.println("lastindexof1 : "+  st.lastIndexOf("o", 11));//inclusive
        System.out.println("equals : "+  st.equals(st1));
        System.out.println("equalsignorecase: "+  st.equalsIgnoreCase(st1));
        System.out.println("compareto: "+  s2.compareTo(st1));
        System.out.println("comparetoignorecase: "+  s2.compareToIgnoreCase(st1));
        System.out.println("tolowercase: "+  st1.toLowerCase());
        System.out.println("tolowercaselocale: "+  st1.toLowerCase(TURKISH));
        System.out.println("touppercase: "+  st1.toUpperCase());
        System.out.println("touppercaselocale: "+  st1.toUpperCase(TURKISH));
        String word1 = " Learn Share Learn ";
        System.out.println("print word"+  word1 + "before trim");
        System.out.println("word1 length before trim " + word1.length());
        System.out.println("trim:"+  word1.trim() + "immediate");
        System.out.println("print word"+  word1 + "after trim");
        System.out.println("word1 length after trim " + word1.length());
        String word2 = word1.trim();
        System.out.println("word2 length" + word2.length());
        System.out.println("print word2"+  word2 + "after trim");
        String Str = new String("Welcome to geeksforgeeks and geeks");
        System.out.println(Str.replace('o', 'T'));
        System.out.println(Str.replaceAll("geeks", "ASTHA TYAGI"));
        System.out.println(Str.replaceFirst("geeks", "ASTHA"));

        String s10 = new String("GeeksforGeeks");
        System.out.println("Unicode of Character " + "at Position 9 " + "in String = " + s10.codePointAt(9));
        System.out.println("Unicode of Character " + "before Position 9 " + "in String = " + s10.codePointBefore(9));
        System.out.println("no of Unicode of Character " + "in String = " + s10.codePointCount(2,9));
        System.out.println("stream of codepoints " + "in String = " + s10.codePoints());
        System.out.println("offsetbycodepoint  " + s10.offsetByCodePoints(2,5));
        System.out.println("SubSequence = " + s10.subSequence(0, 7));
        System.out.println(s10.contains("geeks"));
        System.out.println(s10.contains("Geeks"));
        System.out.println(s10.contentEquals("geeks"));
        System.out.println(s10.contentEquals("GeeksforGeeks"));
        System.out.println(s10.contentEquals(s_buffer));
        StringBuilder s_builder3 = new StringBuilder("GeeksforGeeks");
        StringBuffer s_buffer3 = new StringBuffer("GeeksforGeeks");
        String s11 = new String("GeeksforGeeks");
        CharSequence chSeq2 = "GeeksforGeeks";
        System.out.println("equals string: "+  s10.equals(s11));
        System.out.println("equals CharSequence: "+  s10.equals(chSeq2));
        System.out.println("equals StringBuffer: "+  s10.equals(s_buffer3));
        System.out.println("equals StringBuilder: "+  s10.equals(s_builder3));
        System.out.println("contentEquals string: "+  s10.contentEquals(s11));
        System.out.println("contentEquals CharSequence: "+  s10.contentEquals(chSeq2));
        System.out.println("contentEquals StringBuffer: "+  s10.contentEquals(s_buffer3));
        System.out.println("contentEquals StringBuilder: "+  s10.contentEquals(s_builder3));
        System.out.println("Welcome! to GeeksforGeeks".endsWith("Geeks"));//casesensitive
        System.out.println("Welcome! to GeeksforGeeks".endsWith(""));
        System.out.println("Welcome! to GeeksforGeeks".startsWith("Welcome"));//casesensitive
        System.out.println("Welcome! to GeeksforGeeks".startsWith(""));
        System.out.println("Welcome to geeksforgeeks".startsWith("geeks", 11));
        char[] array = new char[15];
        // initializsubStringe all character to .(dot).
        Arrays.fill(array, '.');
        s10.getChars(0, 9, array, 1);//start inclusive,end exclusive, dstbegin inclusive
        System.out.println("char array contains : " + s10);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        String s89 = "GeeksforGeeks";
        char[] gfg = s.toCharArray();
        for (int i = 0; i < gfg.length; i++) {
            System.out.println(gfg[i]);
        }
        System.out.println("testing intern and ==");
        // S1 refers to Object in the Heap Area
        String s91 = new String("GFG"); // Line-1

        // S2 refers to Object in SCP Area
        String s92 = s91.intern(); // Line-2

        // Comparing memory locations
        // s1 is in Heap
        // s2 is in SCP
        System.out.println(s91 == s92);

        // Comparing only values
        System.out.println(s91.equals(s92));

        // S3 refers to Object in the SCP Area
        String s93 = "GFG"; // Line-3

        System.out.println(s92 == s93);

        // S1 refers to Object in the Heap Area
        String s81 = new String("GFG"); // Line-1

        // S2 now refers to Object in SCP Area
        String s82 = s81.concat("GFG"); // Line-2
        System.out.println("".isEmpty());

        System.out.println("String format");// read about this in detail later
        String name="sonoo";
        int a = 1;
        String sf1=String.format("name is %s",name);
        String sf2=String.format("value is %f",32.33434);
        String sf3=String.format("value is %32.12f",32.33434);//returns 12 char fractional part filling with 0
        String sf4 = String.format(Locale.ENGLISH,"name is %s",name);
        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);
        System.out.println(sf4);


        System.out.println("String matches");
        String St = new String("Welcome to geeksforgeeks");
        String Str2 = new String("GEEKS");
        System.out.println(St.matches("(.*)geeks(.*)"));
        System.out.println(St.matches("geeks"));
        System.out.println(St.regionMatches(11, Str2, 0, 5));//case sensitive
        System.out.println(St.regionMatches(true, 11, Str2, 0, 5));//not case sensitive

        System.out.println("join method");
        String gfg1 = String.join(" < ", "Four", "Five", "Six", "Seven");
        System.out.println(gfg1);
        LinkedList ll = new LinkedList();
        ll.add("browsing");
        ll.add("geeks");
        ll.add("for");
        ll.add("geeks");
        ll.add("is");
        ll.add("fun");
        System.out.println(String.join("-a-", ll));


        //address comparison
        String s23 = "abc";
        String s24 = "abc";
        String s25 = new String ("abc");
        String s26 = new String ("abc");
        System.out.println(Integer.toHexString(s23.hashCode()));
        System.out.println(Integer.toHexString(s24.hashCode()));
        System.out.println(Integer.toHexString(s25.hashCode()));
        System.out.println(Integer.toHexString(s26.hashCode()));
        System.out.println(System.identityHashCode(s23));
        System.out.println(System.identityHashCode(s24));
        System.out.println(System.identityHashCode(s25));
        System.out.println(System.identityHashCode(s26));

        //split
//        limit > 0 – If this is the case, then the pattern will be applied at most limit-1 times, the resulting array’s length will not be more than n, and the resulting array’s last entry will contain all input beyond the last matched pattern.
//        limit < 0 – In this case, the pattern will be applied as many times as possible, and the resulting array can be of any size.
//        limit = 0 – In this case, the pattern will be applied as many times as possible, the resulting array can be of any size, and trailing empty strings will be discarded.
        String str = "geekss@for@geekss@  ";
        String[] arrOfStr = str.split("@", 2);
        String[] arrOfStr2 = str.split("@", -2);
        String[] arrOfStr1 = str.split("@");

        for (String a1 : arrOfStr)
            System.out.println(a1);

        System.out.println("//////");
        for (String a1 : arrOfStr1)
            System.out.println(a1);
        System.out.println("//////");
        for (String a1 : arrOfStr2)
            System.out.println(a1);






    }
}
