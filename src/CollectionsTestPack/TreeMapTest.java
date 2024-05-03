package CollectionsTestPack;
import java.util.*;
import java.util.concurrent.*;
import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        //constructors
        //1
        TreeMap<Integer, String> hm1 = new TreeMap<>();
        //2.
        Map<Integer,String> m2 = new HashMap<Integer,String>();
        TreeMap<Integer, String> hm8 = new TreeMap<Integer, String>(m2);
        //4.
        TreeMap<Integer, String> hm4 = new TreeMap<Integer, String>(hm1);

        //METHODS
//Put
        hm1.put(10, "Geeks");
        hm1.put(15, "4");
        hm1.put(30, "You");
        hm1.put(20, "Geeks");
        hm1.put(30, "Your");
        hm1.put(25, "Welcomes");
        hm1.put(36, null);
        System.out.println("Initial Mappings are: " + hm1);
        String returned_value = (String)hm1.put(20, "All");
        System.out.println("Returned value is: " + returned_value);
        System.out.println("New map is: " + hm1);
//putAll
        hm4.put(40,"hey");
        hm4.putAll(hm1);
        System.out.println("The new map looks like this: " + hm4);
//equals
        System.out.println("Equality: " + hm1.equals(hm4));
//remove
        String returned_value1 = (String)hm4.remove(40);
        System.out.println("Returned value  from remove is: "+ returned_value1);
        System.out.println("Equality: " + hm1.equals(hm4));

////size
        System.out.println("The size of the map is " + hm1.size());
//values
        System.out.println("The collection is: " + hm1.values());
//keySet
        System.out.println("The set is: " + hm1.keySet());
//isEmpty
        System.out.println("Is the map empty? " + hm1.isEmpty());
//get
        System.out.println("The Value is: " + hm1.get(25));
//entrySet
        Set<Map.Entry<Integer,String>> s = hm1.entrySet();
        System.out.println("The entrySet Value is: " + s);
//containsValue
        System.out.println("Is the value 'Geeks' present? " + hm1.containsValue("Geeks"));
//containsKey
        System.out.println("Is the key '20' present? " + hm1.containsKey(20));
//hashCode
        System.out.println("hashCode " + hm1.hashCode());
//toString
        System.out.println("toString " + hm1.toString());
//clone
        TreeMap<Integer, String> hm5 = (TreeMap<Integer, String>) hm1.clone();
        TreeMap<Integer, String> hm6 = (TreeMap<Integer, String>) hm1.clone();
        TreeMap<Integer, String> hm7 = (TreeMap<Integer, String>) hm1.clone();
        System.out.println("clone " + hm5);
        System.out.println("clone " + hm6);
//compute
        hm1.compute(25, (key, val) -> (val == null) ? "default" : "modified");
        hm1.compute(36, (key, val) -> (val == null) ? "default" : "modified");
        hm1.compute(90, (key, val) -> (val == null) ? "default" : "modified");
        hm1.compute(20, (key, val) -> null);
        System.out.println("compute " + hm1);
//computeIfPresent
        hm6.computeIfPresent(25, (key, val) -> (val == null) ? "default" : "modified");
        hm6.computeIfPresent(36, (key, val) -> "modify");
        hm6.computeIfPresent(90, (key, val) -> (val == null) ? "default" : "modified");
        hm6.computeIfPresent(20, (key, val) -> null);
        System.out.println("computeIfPresent " + hm6);
//computeIfAbsent
        hm5.computeIfAbsent(25, (key) -> (key == 25) ? "twenty_five" : "modified");
        hm5.computeIfAbsent(36, (key) -> "hey");
        hm5.computeIfAbsent(90, (key) -> "done");
        hm5.computeIfAbsent(20, (key) -> null);
        System.out.println("computeIfAbsent " + hm5);
//clear
        hm5.clear();
        System.out.println("clear " + hm5);
//merge
        hm7.merge(25,"new" ,(oldv, newv) -> oldv + newv);
        hm7.merge(36, "new",(oldv, newv) -> oldv + newv);
        hm7.merge(90, "new",(oldv, newv) -> oldv + newv);
        hm7.merge(20,"new", (oldv, newv) -> null);
        System.out.println("merge " + hm7);
        // create a TreeMap and add some values
        TreeMap<Integer, String> map1 = new TreeMap<>();
        map1.put(1, "L");
        map1.put(2, "M");
        map1.put(3, "N");
        TreeMap<Integer, String> map2 = new TreeMap<>();
        map2.put(1, "B");
        map2.put(2, "G");
        map2.put(3, "R");
        System.out.println("TreeMap1: " + map1.toString());
        System.out.println("TreeMap2: " + map2.toString());
//forEach
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + ", " + v2));
        System.out.println("New TreeMap map1: " + map1);
        System.out.println("New TreeMap map2: " + map2);
//getOrDefault
        System.out.println("getOrDefault " + hm1.getOrDefault(25, "500"));
        System.out.println("getOrDefault " + hm1.getOrDefault(100, "500"));
        hm1.put(200,null);
        System.out.println("hm1 " + hm1);
        System.out.println("getOrDefault " + hm1.getOrDefault(200, "500"));
        System.out.println("hm1 " + hm1);
//putIfAbsent
        hm1.putIfAbsent(55 , "fifties");
        hm1.putIfAbsent(200 , "hundreds");
        hm1.putIfAbsent(25 , "twenties");
        System.out.println("putIfAbsent " + hm1);
//remove
        System.out.println("remove matching" + hm1.remove(200,"hundreds"));
        System.out.println("remove  not matching" + hm1.remove(55,"abc"));
        System.out.println("remove " + hm1);
        hm1.put(300, null);
//replace
        System.out.println("replace yes" + hm1.replace(25,"twenty_five"));
        System.out.println("replace  no" + hm1.replace(300,"abc"));
        System.out.println("replace " + hm1);
//replace
        System.out.println("replace yes" + hm1.replace(25,"twenty_five","25"));
        System.out.println("replace  no" + hm1.replace(300,"abcd","threehun"));
        System.out.println("replace " + hm1);
//replaceAll
        hm1.replaceAll((key, oldValue) -> oldValue + oldValue);
        System.out.println("replaceAll " + hm1);

//methods for treemap
//firstEntry
        System.out.println("Lowest entry is: "
                + hm1.firstEntry());
        Map.Entry<Integer,String> fe = hm1.firstEntry();
        System.out.println("Lowest entry value is: " +fe.getValue());
//firstKey
        System.out.println("Lowest key is: "
                + hm1.firstKey());
//headMap
        //The returned map is backed by this map
        System.out.println("The headmap is: " + hm1.headMap(36,false));
        System.out.println("The headmap is: " + hm1.headMap(36));
        System.out.println("The headmap is: " + hm1.headMap(36,true));
//lastKey
        System.out.println("The last key is " + hm1.lastKey());
//subMap
        System.out.println("The subMap is " + hm1.subMap(15, 30));
        //tailMap
        //The returned map is backed by this map
        System.out.println("The tailMap is " + hm1.tailMap(15));
//ceilingEntry
        System.out.println("The ceilingEntry  is " + hm1.ceilingEntry(15));
//ceilingKey
        System.out.println("The ceilingKey  is " + hm1.ceilingKey(15));
//descendingKeySet
        System.out.println("The descendingKeySet  is " + hm1.descendingKeySet());
//descendingMap
        System.out.println("The descendingMap  is " + hm1.descendingMap());

//floorEntry
        System.out.println("The floorEntry  is " + hm1.floorEntry(15));
//floorKey
        System.out.println("The ceilingKey  is " + hm1.floorKey(15));

//higherEntry
        System.out.println("The higherEntry  is " + hm1.higherEntry(15));
//higherKey
        System.out.println("The higherKey  is " + hm1.higherKey(15));
//lastEntry
        System.out.println("The lastEntry  is " + hm1.lastEntry());
        //lowerEntry
        System.out.println("The lowerEntry  is " + hm1.lowerEntry(15));
//lowerKey
        System.out.println("The lowerKey  is " + hm1.lowerKey(15));
//navigableKeySet
        //The set is backed by the map,
        System.out.println("The navigableKeySet  is " + hm1.navigableKeySet());

//pollFirstEntry
        System.out.println("The pollFirstEntry  is " + hm1.pollFirstEntry());
//pollLastEntry
        System.out.println("The pollLastEntry  is " + hm1.pollLastEntry());
//navigableKeySet
        System.out.println("The navigableKeySet  is " + hm1.navigableKeySet());
 //comparator
        System.out.println("The comparator  is " +  hm1.comparator());





    }
}
// Java Program to Demonstrate TreeMap
// using Comparator Constructor

// Importing required classes


// Class 1
// Helper class representing Student
class Student {

    // Attributes of a student
    int rollno;
    String name, address;

    // Constructor
    public Student(int rollno, String name, String address)
    {

        // This keyword refers to current object itself
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Method of this class
    // To print student details
    public String toString()
    {
        return this.rollno + " " + this.name + " "
                + this.address;
    }
}

class Sortbyroll implements Comparator<Student> {

    public int compare(Student a, Student b)
    {
        return a.rollno - b.rollno;
    }
}

 class GFG9 {
    public static void main(String[] args)
    {
        TreeMap<Student, Integer> tree_map
                = new TreeMap<Student, Integer>(
                new Sortbyroll());
        tree_map.put(new Student(111, "bbbb", "london"), 2);
        tree_map.put(new Student(131, "aaaa", "nyc"), 3);
        tree_map.put(new Student(121, "cccc", "jaipur"), 1);
        System.out.println("TreeMap: " + tree_map);


        SortedMap<Integer, String> sorted_map
                = new ConcurrentSkipListMap<Integer, String>();
        sorted_map.put(10, "Geeks");
        sorted_map.put(15, "4");
        sorted_map.put(20, "Geeks");
        sorted_map.put(25, "Welcomes");
        sorted_map.put(30, "You");
        TreeMap<Integer, String> tree_map1
                = new TreeMap<Integer, String>(sorted_map);

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map1);

    }
}
