//numeric literals
//type interface
//trywith resources
//multi catch
//switch with string
//binary literals
//java 7 jdbc
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//Ex. int a = _10; // Error, this is an identifier, not a numeric literal
//Ex. int a = 10_; // Error, cannot put underscores at the end of a number
//Ex. float a = 10._0; // Error, cannot put underscores adjacent to a decimal point
//Ex. float a = 10_.0; // Error, cannot put underscores adjacent to a decimal point
//Ex. long a = 10_100_00_L; // Error, cannot put underscores prior to an L suffix
//Ex. float a = 10_100_00_F; // Error, cannot put underscores prior to an F suffix
 class UnderscoreInNumericLiteralExample {
    public static void main(String[] args) {
        // Underscore in integral literal
        int a = 10_00000;
        System.out.println("a = "+a);
        // Underscore in floating literal
        float b = 10.5_000f;
        System.out.println("b = "+b);
        // Underscore in binary literal
        int c = 0B10_10;
        System.out.println("c = "+c);
        // Underscore in hexadecimal literal
        int d = 0x1_1;
        System.out.println("d = "+d);
        // Underscore in octal literal
        int e = 01_1;
        System.out.println("e = "+e);
    }
}
 class TypeInference {
    public static void main(String[] args) {
        // In Java 6 and earlier
        List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        for (Integer element : list) {
            System.out.println(element);
        }
        // In Java 7
        List<Integer> list2 = new ArrayList<>(); // Here, diamond is used
        list2.add(12);
        for (Integer element : list2) {
            System.out.println(element);
        }
    }
}

 class TryWithResources {
    public static void main(String args[]){
        // Using try-with-resources
        try(    // Using multiple resources
                FileOutputStream fileOutputStream =new FileOutputStream("/java7-new-features/src/abc.txt");
                InputStream input = new FileInputStream("/java7-new-features/src/abc.txt")){
            // -----------------------------Code to write data into file--------------------------------------------//
            String msg = "Welcome to javaTpoint!";
            byte byteArray[] = msg.getBytes();  // Converting string into byte array
            fileOutputStream.write(byteArray);  // Writing  data into file
            System.out.println("------------Data written into file--------------");
            System.out.println(msg);
            // -----------------------------Code to read data from file---------------------------------------------//
            // Creating input stream instance
            DataInputStream inst = new DataInputStream(input);
            int data = input.available();
            // Returns an estimate of the number of bytes that can be read from this input stream.
            byte[] byteArray2 = new byte[data]; //
            inst.read(byteArray2);
            String str = new String(byteArray2); // passing byte array into String constructor
            System.out.println("------------Data read from file--------------");
            System.out.println(str); // display file data
        } catch(Exception exception){
            System.out.println(exception);
        }
    }
}
//So here, in case when your are catching multiple exceptions, follow the rule of generalized to more specialized. It means that, if you are using super (general) class, don't use child (specialized) class.
 class MultipleExceptionExample{
    public static void main(String args[]){
        try{
            int array[] = new int[10];
            array[10] = 30/0;
        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
}
//    Object game = "Hockey"; // It is not allowed
//    String game = "Hockey"; // It is OK.
 class StringInSwitchStatementExample {
    public static void main(String[] args) {
        String game = "Card-Games";
        switch(game){
            case "Hockey": case"Cricket": case"Football":
                System.out.println("This is a outdoor game");
                break;
            case "Chess": case"Card-Games": case"Puzzles": case"Indoor basketball":
                System.out.println("This is a indoor game");
                break;
            default:
                System.out.println("What game it is?");
        }
    }
}
//specify a binary literal, add the prefix 0b or 0B to the integral value.
 class BinaryLiteralsExample {
    public static void main(String[] args) {
        // Binary literal in byte type
        byte b1 = 0b101;    // Using b0, The b can be lower or upper case
        byte b2 = 0B101;    // Using B0
        System.out.println("----------Binary Literal in Byte----------------");
        System.out.println("b1 = "+b1);
        System.out.println("b2 = "+b2);

        // Binary literal in short type
        short s1 = 0b101;   // Using b0, The b can be lower or upper case
        short s2 = 0B101;   // Using B0
        System.out.println("----------Binary Literal in Short----------------");
        System.out.println("s1 = "+s1);
        System.out.println("s2 = "+s2);

        // Binary literal in int type
        int i1 = 0b101;     // Using b0, The b can be lower or upper case
        int i2 = 0B101;     // Using B0
        System.out.println("----------Binary Literal in Integer----------------");
        System.out.println("i1 = "+i1);
        System.out.println("i2 = "+i2);

        // Binary literal in long type
        long l1 = 0b0000011111100001;   // Using b0, The b can be lower or upper case
        long l2 = 0B0000011111100001;   // Using B0
        System.out.println("----------Binary Literal in Long----------------");
        System.out.println("l1 = "+l1);
        System.out.println("l2 = "+l2);
    }
}
