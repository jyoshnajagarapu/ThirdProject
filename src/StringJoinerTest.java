import java.util.StringJoiner;
 class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");
        joinNames.add("Raheem");
        System.out.println("joinNames" + joinNames);
        StringJoiner joinNames1 = new StringJoiner(":", "[", "]");   // passing comma(,) and square-brackets as delimiter

        // Adding values to StringJoiner
        joinNames1.add("Rahul");
        joinNames1.add("Raju");
        joinNames1.add("Peter");
        joinNames1.add("Raheem");

        System.out.println("joinNames1" + joinNames1);
        StringJoiner merge = joinNames.merge(joinNames1);//joinNames also gets modified
        System.out.println("merge" + merge);
        System.out.println("joinNames" + joinNames);
        StringJoiner joinNames2 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter
        System.out.println("joinNames2 length" + joinNames2.length());
        // Adding values to StringJoiner
        joinNames2.add("Rahul");
        joinNames2.add("Raju");
        StringJoiner merge1 = joinNames1.merge(joinNames2);
        System.out.println(merge1);
        System.out.println(joinNames1.merge(joinNames));
        StringJoiner joinNames3 = new StringJoiner(","); // passing comma(,) as delimiter

        // Prints nothing because it is empty
        System.out.println(joinNames3);

        // We can set default empty value.
        joinNames3.setEmptyValue("It is empty");
        System.out.println(joinNames3);

        int length = joinNames.length();
        System.out.println("Length: "+length);
        String str = joinNames.toString();
        System.out.println(str);

    }
}  