
// all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable.
// Java Program to Create An Immutable Class
//Immutable class in java means that once an object is created, we cannot change its content

import java.util.HashMap;
import java.util.Map;

//class should be final
final class Student {

    // Member attributes should be final and private
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;


    public Student(String name, int regNo,
                   Map<String, String> metadata)
    {
        this.name = name;
        this.regNo = regNo;
        //creating deep copy
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metadata = tempMap;
    }

    public String getName() { return name; }

    public int getRegNo() { return regNo; }

    // Note tha there should not be any setters

    public Map<String, String> getMetadata()
    {

       //deep copy
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

class GFG2 {

    public static void main(String[] args)
    {

        Map<String, String> map = new HashMap<>();

        map.put("1", "first");
        map.put("2", "second");

        Student s = new Student("ABC", 101, map);

        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());

        // Uncommenting below line causes error
        // s.regNo = 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetadata());
    }
}
