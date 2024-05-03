package CollectionsTestPack;

import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 class LinkedLinkedHashMapTest {
    public static void main(String[] args) {
        //constructors
        //1. default initial capacity is 16 and the default load factor is 0.75.
        LinkedHashMap<Integer, String> hm1 = new LinkedHashMap<>();
        //2. default load factor is 0.75.
        LinkedHashMap<Integer, String> hm2 = new LinkedHashMap<>(10);
        //3.
        LinkedHashMap<Integer, String> hm3 = new LinkedHashMap<>(5, 0.75f);
        //4.
        LinkedHashMap<Integer, String> hm4 = new LinkedHashMap<Integer, String>(hm1);
        //5.
        //if accessOrder is true, then it will result in access Order, One of the important application of access order LinkedHashMap is building LRU cache.
        LinkedHashMap<Integer, String> hm9 = new LinkedHashMap<>(5, 0.75f,true);


        //METHODS
//Put
        hm1.put(10, "Geeks");
        hm1.put(15, "4");
        hm1.put(20, "Geeks");
        hm1.put(25, "Welcomes");
        hm1.put(30, "You");
        hm1.put(30, "Your");
        hm1.put(36, null);
        System.out.println("Initial Mappings are: " + hm1);
        String returned_value = (String)hm1.put(20, "All");
        System.out.println("Returned value is: " + returned_value);
        System.out.println("New map is: " + hm1);
//putAll
        hm2.put(40,"hey");
        hm2.putAll(hm1);
        System.out.println("The new map looks like this: " + hm2);
//equals
        System.out.println("Equality: " + hm1.equals(hm2));
//remove
        String returned_value1 = (String)hm2.remove(40);
        System.out.println("Returned value  from remove is: "+ returned_value1);
        System.out.println("Equality: " + hm1.equals(hm2));

//size
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
        LinkedHashMap<Integer, String> hm5 = (LinkedHashMap<Integer, String>) hm1.clone();
        LinkedHashMap<Integer, String> hm6 = (LinkedHashMap<Integer, String>) hm1.clone();
        LinkedHashMap<Integer, String> hm7 = (LinkedHashMap<Integer, String>) hm1.clone();
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
        // create a LinkedHashMap and add some values
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(1, "L");
        map1.put(2, "M");
        map1.put(3, "N");
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>();
        map2.put(1, "B");
        map2.put(2, "G");
        map2.put(3, "R");
        System.out.println("LinkedHashMap1: " + map1.toString());
        System.out.println("LinkedHashMap2: " + map2.toString());
//forEach
        map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + ", " + v2));
        System.out.println("New LinkedHashMap map1: " + map1);
        System.out.println("New LinkedHashMap map2: " + map2);
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




    }
}

class DemoAccessOrderLinkedHashMap {

    public static void main(String[] args) {
        Map<Integer, String> mapVehicleNoAndOwner = new LinkedHashMap<>(2,0.75f,true);

        mapVehicleNoAndOwner.put(1000, "Federer");
        mapVehicleNoAndOwner.put(2000, "Bradman");
        mapVehicleNoAndOwner.put(3000, "Jordan");
        mapVehicleNoAndOwner.put(4000, "Woods");
        mapVehicleNoAndOwner.put(5000, "Ali");

        System.out.println("1. Iterating default LinkedHashMap: ");
        demoIterate_AccessOrder(mapVehicleNoAndOwner);
        int key = 1000;
        System.out.printf("2. Accessting value at key: %d is %s\n",key,mapVehicleNoAndOwner.get(key));

        key = 3000;
        System.out.printf("3. Accessting value at key: %d is %s\n",key,mapVehicleNoAndOwner.get(key));

        System.out.println("4. Iterating LinkedHashMap, least accessed to most accessed keys: ");
        demoIterate_AccessOrder(mapVehicleNoAndOwner);

    }

    private static void demoIterate_AccessOrder(Map<Integer, String> mapSportsPersonality) {

        mapSportsPersonality.forEach((key, value) -> {
            System.out.println("Key:"+ key + ", Value:" + value);
        });
    }
}

// Java program to illustrate removeEldestEntry()

 class Linked_Hash_Map_Demo {

    // Refers to the max size of the map following which
    // the removal takes place of the eldest entry
    private static final int MAX = 6;

    public static void main(String[] args)
    {
//try with access order
        // Creating the linked hashmap and implementing
        // removeEldestEntry() to MAX size
        LinkedHashMap<Integer, String> li_hash_map =
                new LinkedHashMap<Integer, String>() {
                    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest)
                    {
                        return size() > MAX;
                    }
                };
        // Adding elements using put()
        li_hash_map.put(0, "Welcome");
        li_hash_map.put(1, "To");
        li_hash_map.put(2, "The");
        li_hash_map.put(3, "World");
        li_hash_map.put(4, "Of");
        li_hash_map.put(5, "geeks");
        //li_hash_map.get(0);
        System.out.println("" + li_hash_map);

        // Adding more elements
        li_hash_map.put(6, "GeeksforGeeks");

        // Displaying the map after adding one more element
        System.out.println("" + li_hash_map);

        // Adding more elements
        li_hash_map.put(7, "Hello");

        // Displaying the map after adding one more element
        System.out.println("" + li_hash_map);
    }
}


