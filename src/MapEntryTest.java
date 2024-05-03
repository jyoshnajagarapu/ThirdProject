// Java Program to demonstrate the
// methods of Map.Entry
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

 class GFG9
{
    public static void main(String[] args)
    {
        LinkedHashMap<String,Integer> m = new LinkedHashMap<String, Integer>();
        m.put("1 - Bedroom" , 25000);
        m.put("2 - Bedroom" , 50000);
        m.put("3 - Bedroom" , 75000);
        m.put("1 - Bedroom - hall", 65000);
        m.put("2 - Bedroom - hall", 85000);
        m.put("3 - Bedroom - hall", 105000);
        System.out.println("Before change of value " + m);
//entrySet
        Set<Map.Entry<String,Integer>> s = m.entrySet();
        for (Map.Entry<String, Integer> it: s)
        {
//getKey,getValue
            System.out.println("Before change of value = " + it.getKey() + " " + it.getValue());
            System.out.print("hashcode" + it.hashCode() + ";");
            System.out.print("toString" + it.toString() + ";");
            double getRandom = Math.random() * 100000;
            int getRoundoff = (int) Math.round(getRandom);
//setValue
            it.setValue(getRoundoff);
            System.out.println("After change of value = " +
                    it.getKey() + " " + it.getValue());
        }
        System.out.println("after change of value " + m);
    }
}
