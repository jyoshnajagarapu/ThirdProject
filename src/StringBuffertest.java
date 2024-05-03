import java.util.Arrays;
//This new class is called StringBuilder. It is identical to StringBuffer except for one important difference: it is not synchronized, which means that it is not thread-safe. The advantage of StringBuilder is faster performance. However, in cases in which you are using multithreading,  you must use StringBuffer rather than StringBuilder.

public class StringBuffertest {
    public static void main(String[] args)
    {
        //constructors of string buffer
        StringBuffer s19 = new StringBuffer();
        System.out.println("Length  with null arg =" + s19.length());
        System.out.println("Capacity  with null argument =" + s19.capacity());
        s19.append("geeksbefo rtrim  ");
        System.out.println("Length  with null arg after=" + s19.length());
        System.out.println("Capacity  with null argument after =" + s19.capacity());
        StringBuffer s20 = new StringBuffer();
        System.out.println("Length  with null arg =" + s20.length());
        System.out.println("Capacity  with null argument =" + s20.capacity());
        s20.append("geeksbefo rtrim  abcdefghijkl");
        System.out.println("Length  with null arg after=" + s20.length());
        System.out.println("Capacity  with null argument after =" + s20.capacity());
        StringBuffer s15 = new StringBuffer(20);
        System.out.println("Length  with int arg =" + s15.length());
        System.out.println("Capacity  with int argument =" + s15.capacity());
        s15.append("geeksbefo rtrim   ");
        System.out.println("Length  with int arg after =" + s15.length());
        System.out.println("Capacity  with int argument after =" + s15.capacity());
        StringBuffer s17 = new StringBuffer(15);
        System.out.println("Length  with int arg =" + s17.length());
        System.out.println("Capacity  with int argument =" + s17.capacity());
        s17.append("geeksbefo rtrim   ");
        System.out.println("Length  with int arg after =" + s17.length());
        System.out.println("Capacity  with int argument after =" + s17.capacity());
        StringBuffer s14 = new StringBuffer("GeeksforGeeks");
        System.out.println("Length  with string arg =" + s14.length());
        System.out.println("Capacity  with string argument =" + s14.capacity());
        s14.append("geeksbefo rtrim     ");
        System.out.println("Length  with string arg after =" + s14.length());
        System.out.println("Capacity  with string argument after =" + s14.capacity());
        StringBuffer s21 = new StringBuffer("GeeksforGeeks");
        System.out.println("Length  with string arg =" + s21.length());
        System.out.println("Capacity  with string argument =" + s21.capacity());
        s21.append("geeksbefo rtrim     geeksbefo rtrim     geeksbefo rtrim     ");
        System.out.println("Length  with string arg after =" + s21.length());
        System.out.println("Capacity  with string argument after =" + s21.capacity());
        System.out.println("Length  with  arg stringbuffer =" + s14.length());
        System.out.println("Capacity  with arg stringbuffer =" + s14.capacity());
        StringBuffer s22 = new StringBuffer(s14);
        System.out.println("Length  with stringBuffer arg =" + s22.length());
        System.out.println("Capacity  with stringBuffer argument =" + s22.capacity());
        CharSequence chSeq2 = "geeks";
        StringBuffer s13 = new StringBuffer(chSeq2);
        System.out.println("Length  with charsequence argument=" + s13.length());
        System.out.println("Capacity  with charsequence argument =" + s13.capacity());
        StringBuilder s_builder = new StringBuilder("Geekssssss");
        StringBuffer s16 = new StringBuffer(s_builder);
        System.out.println("Length  with StringBuilder argument=" + s13.length());
        System.out.println("Capacity  with StringBuilder argument =" + s13.capacity());
        StringBuffer s9 = new StringBuffer("GeeksforGeeks");
        s9.replace(5, 8, "are");//start inclusive, end exclusive
        System.out.println("replace "+s9); // returns GeeksareGeeks
        System.out.println("charAt = " + s9.charAt(3));
        System.out.println("index of  " + s9.indexOf("for"));
        System.out.println("index of  " + s9.indexOf("ge", 2));
        System.out.println("lastindex of  " + s9.lastIndexOf("e"));
        System.out.println("lastindex of  " + s9.lastIndexOf("e",9));
        System.out.println("Substring = " + s9.substring(5));
        System.out.println("Substring = " + s9.substring(5, 9 ));
        StringBuffer s = new StringBuffer("GeeksforGeeks");

        StringBuffer sbf1 = new StringBuffer("We are geeks and its really ");
        System.out.println("Input: " + sbf1);
        sbf1.append(true);
        System.out.println("Result after appending boolean: " + sbf1);
        sbf1.append('M');
        System.out.println("Result after appending character = " + sbf1);
        char[] s3 = new char[] {'a','b','c','d','e','f','g'};
        sbf1.append(s3);
        System.out.println("Result after appending char array = " + sbf1);
        sbf1.append(s3,2,2); //inclusive,length
        System.out.println("Result after appending char array substring = " + sbf1);
        double astr = 636.47d;
        sbf1.append(astr);
        System.out.println("Result after appending double = " + sbf1);
        float astr1 = 5.2f;
        sbf1.append(astr1);
        System.out.println("Result after appending float = " + sbf1);
        int astr2 = 827;
        sbf1.append(astr2);
        System.out.println("Result after appending integer = " + sbf1);
        long astr3 = 827l;
        sbf1.append(astr3);
        System.out.println("Result after appending integer = " + sbf1);
        CharSequence chSeq = "geeks";
        sbf1.append(chSeq);
        System.out.println("Result after appending charsequence = " + sbf1);
        CharSequence chSeq1 = "wegeekss";
        sbf1.append(chSeq1, 2, 7);
        System.out.println("Result after appending charsequence substring = " + sbf1); //inclusive and exclusive
        Object objectvalue = "geeks";
        sbf1.append(objectvalue);
        System.out.println("Result after appending Object = " + sbf1);
        String strvalue = "_geeks_string_";
        sbf1.append(strvalue);
        System.out.println("Result after appending string = " + sbf1);
        StringBuilder s_builder1 = new StringBuilder("Geekssssss");
        sbf1.append(s_builder1);
        System.out.println("Result after appending s_builder1 = " + sbf1);
        StringBuffer sbf2 = new StringBuffer("forgeeks ");
        sbf1.append(sbf2);
        System.out.println("Result after appending stringbuffer = " + sbf1);
        StringBuffer str = new StringBuffer("geeks for geeks");
        str.insert(8, true);
        System.out.println("After insertion boolean=" + str);/// inclusive
        str.insert(8, 'p');
        System.out.println("After insertion char=" + str);
        char cArr[] = { 'p', 'a', 'w', 'a', 'n' };
        str.insert(8, cArr);
        System.out.println("After insertion char array =" + str);
        char cArr1[] = { 'p', 'a', 'w', 'a', 'n' };
        str.insert(8, cArr1,2,2);
        System.out.println("After insertion char array1 =" + str);
        str.insert(8, 41.35f);
        System.out.println("After insertion float=" + str);
        str.insert(8, 41.35d);
        System.out.println("After insertion double=" + str);
        str.insert(8, 546986L);
        System.out.println("After insertion long =" + str);
        int x = 10;
        str.insert(8, x);
        System.out.println("After insertion int=" + str);
        StringBuffer sbf = new StringBuffer("Geeksforgeeks!");
        System.out.println("String buffer = " + sbf);
        str.insert(8, sbf);
        System.out.println("After insertion string buffer=" + str);
        str.insert(6, "abc");
        System.out.println("After insertion string =" + str);

        CharSequence chSeq3 = "wegeekss";
        str.insert(2, chSeq3);
        System.out.println("After insertion charsequence =" + str);
        CharSequence chSeq4 = "wegeekss";
        str.insert(2, chSeq4,2,5);
        System.out.println("After insertion charsequence1 =" + str);
        Object objectvalue1 = "geeks";
        str.insert(6, objectvalue1);
        System.out.println("After insertion object =" + str);
        sbf.reverse();
        System.out.println("String buffer after reversing = " + sbf);
        StringBuffer s7 = new StringBuffer("Geeksforgeeks");
        System.out.println("string buffer = " + s7);
        s7.delete(6, 8);//start inc,end exc
        System.out.println("After deletion string buffer is = " + s7);
        StringBuffer s8 = new StringBuffer("raghav");
        System.out.println("String buffer before deletion = " + s8);
        s8.deleteCharAt(5);
        System.out.println("After deletion new StringBuffer = " + s8);
        //replace

        //ensurecapacity
        StringBuffer s4 = new StringBuffer();
        System.out.println("Before ensureCapacity " + "method capacity = " + s4.capacity());
        s4.ensureCapacity(18);
        System.out.println("After ensureCapacity" + " method capacity = " + s4.capacity());
        //codepoint
        StringBuffer s10 = new StringBuffer("Geeksforgeeks");
        s10.appendCodePoint(65);
        System.out.println("After appending CodePoint is = " + s10);
        System.out.println("Unicode of Character " + "at Position 9 " + "in StringBuffer = " + s10.codePointAt(9));
        System.out.println("Unicode of Character " + "before Position 9 " + "in StringBuffer = " + s10.codePointBefore(9));
        System.out.println("no of Unicode of Character " + "in StringBuffer = " + s10.codePointCount(2,9));
        System.out.println("stream of codepoints " + "in StringBuffer = " + s10.codePoints());
        System.out.println("offsetbycodepoint  " + s10.offsetByCodePoints(2,5));
        char[] array = new char[15];
        // initialize all character to .(dot).
        Arrays.fill(array, '.');
        str.getChars(0, 9, array, 1);//start inclusive,end exclusive, dstbegin inclusive
        System.out.print("char array contains : " + str);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("chars function=" + s.chars());
        s10.setCharAt(7, 'i');
        System.out.println("setchatat " + s10);
        StringBuffer s11 = new StringBuffer("WelcomeGeeks");
        System.out.println("String length = " + s11.length() + " and contains = " + s11);
        s11.setLength(10);
        System.out.println("After setLength() String = " + s11);
        s11.setLength(25);
        System.out.println("After setLength() String = " + s11 + "h " + s11.length());
        System.out.println("SubSequence = " + s11.subSequence(0, 7));
        String s18 = s11.toString();
        System.out.println("tostring = " + s18);
        s11.setCharAt(1, 'a');
        System.out.println(" after modify to original stringbuffer = " + s18);
        //trim
        StringBuffer s12 = new StringBuffer();
        System.out.println("capacity before append"+ s12.capacity());
        s12.append("geeksbefo rtrim   ");
        System.out.println("capacity before trim"+ s12.capacity());
        s12.trimToSize();
        System.out.println("capacity after trim"+ s12.capacity());


        //address comparison
       // StringBuffer s23 = "abc"; // not possible

        StringBuffer s25 = new StringBuffer ("abc");
        StringBuffer s26 = new StringBuffer ("abc");
        StringBuffer s27 = new StringBuffer (s25);
        System.out.println(Integer.toHexString(s25.hashCode()));
        System.out.println(Integer.toHexString(s26.hashCode()));
        System.out.println(Integer.toHexString(s27.hashCode()));
        System.out.println(System.identityHashCode(s25));
        System.out.println(System.identityHashCode(s26));
        System.out.println(System.identityHashCode(s27));



    }
}
