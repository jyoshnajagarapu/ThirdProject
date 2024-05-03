// Java program to demonstrate Autoboxing
//Wrapper Classes like Integer, Float, etc. are final classes.
//In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable
import java.util.ArrayList;
class Autoboxing
{
    public static void main(String[] args)
    {
        char ch = 'a';

        // Autoboxing- primitive to Character object conversion
        Character a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        // Autoboxing because ArrayList stores only objects
        arrayList.add(25);

        // printing the values from object
        System.out.println(arrayList.get(0));
    }
}

// Java program to demonstrate Unboxing
class Unboxing
{
    public static void main(String[] args)
    {
        Character ch = 'a';

        // unboxing - Character object to primitive conversion
        char a = ch;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(24);

        // unboxing because get method returns an Integer object
        int num = arrayList.get(0);

        // printing the values from primitive data types
        System.out.println(num);
    }
}


// Java program to demonstrate Wrapping and UnWrapping
// in Java Classes
class WrappingUnwrapping
{
    public static void main(String args[])
    {
        // byte data type
        byte a = 1;

        // wrapping around Byte object
        Byte byteobj = new Byte(a);

        // int data type
        int b = 10;

        //wrapping around Integer object
        Integer intobj = new Integer(b);

        // float data type
        float c = 18.6f;

        // wrapping around Float object
        Float floatobj = new Float(c);

        // double data type
        double d = 250.5;

        // Wrapping around Double object
        Double doubleobj = new Double(d);
        // double data type
        double d1 = 250.5;

        // Wrapping around Double object
        Double doubleobj1 = d1;

        // char data type
        char e='a';

        // wrapping around Character object
        Character charobj=new Character(e);

        // printing the values from objects
        System.out.println("Values of Wrapper objects (printing as objects)");
        System.out.println("Byte object byteobj: " + byteobj);
        System.out.println("Integer object intobj: " + intobj);
        System.out.println("Float object floatobj: " + floatobj);
        System.out.println("Double object doubleobj: " + doubleobj);
        System.out.println("Character object charobj: " + charobj);

        // objects to data types (retrieving data types from objects)
        // unwrapping objects to primitive data types
        byte bv = byteobj;
        int iv = intobj;
        float fv = floatobj;
        double dv = doubleobj;
        char cv = charobj;

        // printing the values from data types
        System.out.println("Unwrapped values (printing as data types)");
        System.out.println("byte value, bv: " + bv);
        System.out.println("int value, iv: " + iv);
        System.out.println("float value, fv: " + fv);
        System.out.println("double value, dv: " + dv);
        System.out.println("char value, cv: " + cv);
    }
}

class Abc{
    public static void main(String args[] ){
        boolean a = true;
    }
}

class Main78 {
    // swap() doesn't swap i and j
    public static void swap(Integer i, Integer j)
    {
        Integer temp = i;
        System.out.println("temp"+  temp);
        i = j;
        j = temp;
    }
    public static void main(String[] args)
    {
        Integer a = new Integer(30);
        Integer b = new Integer(a);
        Integer c = a;
        System.out.println("a" +  a + "b" + b + "c" + c);

        Integer i = new Integer(10);
        Integer j = new Integer(20);
        swap(i, j);
        System.out.println("i = " + i + ", j = " + j);
    }
}



