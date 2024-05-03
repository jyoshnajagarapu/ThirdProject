//https://www.javacodegeeks.com/2021/05/java-8-streams-group-by-multiple-fields-with-collectors-groupingby.html
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class City {
    private String name;
    private double temperature;
    public City(String name, double temperature)
    {
        this.name = name;
        this.temperature = temperature;
    }
    public String getName()
    {
        return name;
    }
    public Double getTemperature()
    {
        return temperature;
    }
    @Override
    public String toString()
    {
        return name + " --> " + temperature;
    }
}


 class GFGrt {
     private static List<City> prepareTemperature()
     {
         List<City> cities = new ArrayList<>();
         cities.add(new City("New Delhi", 33.5));
         cities.add(new City("Mexico", 14));
         cities.add(new City("New York", 13));
         cities.add(new City("Dubai", 43));
         cities.add(new City("London", 15));
         cities.add(new City("Alaska", 1));
         cities.add(new City("Kolkata", 30));
         cities.add(new City("Sydney", 11));
         cities.add(new City("Mexico", 14));
         cities.add(new City("Dubai", 43));
         return cities;
     }
     public static void main(String[] args)
     {
         System.out.println(prepareTemperature().stream().filter(city -> city.getTemperature() > 10)
                 .collect(Collectors.toMap(City::getName, City::getTemperature, (key, identicalKey) -> key)));
                 //.collect(Collectors.toMap(c -> c.getName(), c -> c.getTemperature(),(k,v) -> k))); also works
         //c -> c.getName() -> (obj, args) -> obj.instanceMethod(args)
         //City::getName ->  ObjectType::instanceMethod
         System.out.println(prepareTemperature().stream()
                 .collect(Collectors.groupingBy(City::getName, Collectors.collectingAndThen(Collectors.counting(), Long::intValue))));
         System.out.println(prepareTemperature().stream()
                 .collect(Collectors.groupingBy(City::getName, Collectors.counting())));
         System.out.println(prepareTemperature().parallelStream()
                 .collect(Collectors.groupingByConcurrent(City::getName, Collectors.counting())));
         System.out.println(prepareTemperature().stream()
                 .collect(Collectors.groupingBy(City::getName)));
         System.out.println(prepareTemperature().stream()
                 .collect(Collectors.groupingByConcurrent(City::getName)));

     }
}

class Productw{
    int id;
    String name;
    float price;
    public Productw(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
 class CollectorsExample {
    public static void main(String[] args) {
        List<Productw> productsList = new ArrayList<Productw>();
        //Adding Products
        productsList.add(new Productw(1,"HP Laptop",25000f));
        productsList.add(new Productw(2,"Dell Laptop",30000f));
        productsList.add(new Productw(3,"Lenevo Laptop",28000f));
        productsList.add(new Productw(4,"Sony Laptop",28000f));
        productsList.add(new Productw(5,"Apple Laptop",90000f));
        List<Float> productPriceList = productsList.stream().map(x->x.price)         // fetching price
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList);
        Stream<String> s = Stream.of("Geeks", "for", "GeeksforGeeks", "Geeks Classes");
        Set<String> mySet = s.collect(Collectors.toSet());
        System.out.println(mySet);
        Stream<String> s1 = Stream.of("Geeks", "for", "GeeksClasses");
        Collection<String> names = s1
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(names);
        Stream<String[]> str = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "G", "Geeks" } });
        Map<String, String> map = str.collect(Collectors.toMap(p -> p[0], p -> p[1]));
        System.out.println("Map:" + map);
        //below throes error Duplicate key GFG (attempted merging values GeeksForGeeks and geeksforgeeks)
//        Stream<String[]> str4 = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "geeksforgeeks" },{ "GFG", "geeksfor" } });
//        Map<String, String> map3 = str4.collect(Collectors.toMap(p -> p[0], p -> p[1]));
//        System.out.println("Map:" + map3);
        str = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "geeksforgeeks" },{ "GFG", "geeksfor" } });
        Map<String, String> map1 = str.collect(Collectors.toMap(p -> p[0], p -> p[1], (s11, a) -> s11 + ", " + a));
        System.out.println("Map:" + map1);
        Stream<String[]> Ss1 = Stream.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "Geeks" } });
        LinkedHashMap<String, String> map2 = Ss1.collect(Collectors.toMap(p -> p[0], p -> p[1], (s4, a) -> s4 + ", " + a, LinkedHashMap::new));
        System.out.println("Map:" + map2);
        List<String> lt = Stream.of("GEEKS", "For", "GEEKS")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(lt);

        Stream<String> se = Stream.of("1", "2", "3", "4");
        long ans = se.collect(Collectors.counting());
        System.out.println(ans);
        List<String> g = Arrays.asList("geeks", "for", "geeks","ram","gau","div","babu");
        Map<String, Long> result = g.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        Map<String, Long> result1 = g.stream()
                .collect(Collectors.groupingBy(Function.identity(),TreeMap::new, Collectors.counting()));
        System.out.println(result1);
        ConcurrentMap<String, Long> result2 = g.stream()
                .collect(Collectors.groupingByConcurrent(Function.identity(), ConcurrentHashMap::new, Collectors.counting()));
        System.out.println(result2);
        char[] ch = { 'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's' };
        String chString = Stream.of(ch).map(String::new)
                .collect(Collectors.joining());
        System.out.println(chString);
        List<String> str1 = Arrays.asList("Geeks", "for", "Geeks");
        String chString1 = str1.stream()
                .collect(Collectors.joining());
        System.out.println(chString1);
        List<Character> ch1 = Arrays.asList('G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's');
        String chString12 = ch1.stream().map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(chString12);
        String chString21 = ch1.stream().map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(chString21);
        Stream<String> s3 = Stream.of("apple", "banana", "orange","appricot","bamboo");
        List<String> list = s3.collect(Collectors.mapping(s6 -> s6.substring(0, 2), Collectors.toList()));
        System.out.println(list);
        Stream<String> s4 = Stream.of("apple", "banana", "orange","appricot","bamboo");
        System.out.println(s4.collect(Collectors.groupingBy(s6 -> s6.substring(0, 2), Collectors.toList())));
        Stream<Integer> s34 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer> > map12 = s34.collect(Collectors.partitioningBy(num -> num > 3));
        System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map12);
        Stream<Integer> s345 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Long> map345 = s345.collect(Collectors.partitioningBy(num -> (num > 3), Collectors.counting()));
        System.out.println("Elements in stream " + "partitioned by " + "less than equal to 3: \n" + map345);
        Stream<Integer> s6 = Stream.of(3, 4, 5);
        double ans4 = s6.collect(Collectors.averagingDouble(num -> (num * 2)));
        System.out.println(ans4);
        Stream<Integer> s7 = Stream.of(3, 4, 5);
        double ans7 = s7.collect(Collectors.averagingInt(num -> (num + 2)));
        System.out.println(ans7);
        Stream<Integer> s9 = Stream.of(3, 4, 5);
        double ans9 = s9.collect(Collectors.averagingLong(num -> (num + 2)));
        System.out.println(ans9);
        //Collectors.groupingByConcurrent() uses a multi-core architecture and is very similar to Collectors.groupingBy(), as it also behaves like the "GROUP BY" statement in SQL.
        //This Collector is both concurrent and unordered. Being unordered, the collection operation doesn't preserve the order of the input by it's encounter. Being concurrent, the result container supports functions being called concurrently with the same result container from multiple threads.
        Stream<String> sw = Stream.of("apple", "banana", "orange");
        ConcurrentMap<Character, String> m = sw.collect(Collectors.toConcurrentMap(sw1 -> sw1.charAt(0), String::toUpperCase));
        System.out.println(m);
        Stream<String> sr = Stream.of("apple", "banana", "apricot", "orange");
        Map<Character, String> mr = sr.collect(Collectors.toConcurrentMap(sr1 -> sr1.charAt(0), String::toUpperCase, (sr1, sr2) -> sr1 + "|" + sr2));
        System.out.println(mr);
        Stream<String> st = Stream.of("apple", "banana", "apricot", "orange");
        ConcurrentHashMap<Character, String> mt = st
                .collect(Collectors.toConcurrentMap(st1 -> st1.charAt(0), String::toUpperCase, (st1, st2) -> st1 + "|" + st2, ConcurrentHashMap::new));
        System.out.println(mt);


        //'collect(maxBy())' can be replaced with 'max()' (may change semantics)
        Stream<String> s8 = Stream.of("2", "3", "4", "5");
        Optional<String> obj = s8
                .collect(Collectors.maxBy(Comparator.reverseOrder()));
        if (obj.isPresent()) {
            System.out.println(obj.get());
        }
        else {
            System.out.println("no value");
        }
        Stream<String> s0 = Stream.of("2", "3", "4", "5");
        //collect(minBy())' can be replaced with 'min()' (may change semantics)
        Optional<String> obj1 = s0
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        if (obj1.isPresent()) {
            System.out.println(obj1.get());
        }
        else {
            System.out.println("no value");
        }
        List<Integer> integerList = Arrays.asList(23, 23, 8);
        System.out.println("Contents of the list - " + integerList);
        Stream<Integer> integerStream = integerList.stream();
        IntSummaryStatistics intSummaryStatistics = integerStream.collect(Collectors.summarizingInt(e -> e * 2));
        System.out.println("Summary statistics of the stream - " + intSummaryStatistics);
        Stream<Integer> integerStream1 = integerList.stream();
        LongSummaryStatistics intSummaryStatistics1 = integerStream1.collect(Collectors.summarizingLong(e -> e * 2));
        System.out.println("Summary statistics of the stream - " + intSummaryStatistics1);
        Stream<Integer> integerStream2 = integerList.stream();
        DoubleSummaryStatistics intSummaryStatistics2 = integerStream2.collect(Collectors.summarizingDouble(e -> e * 2));
        System.out.println("Summary statistics of the stream - " + intSummaryStatistics2);

    }
}
 class Employee {

    private int id;
    private String name;
    private String designation;
    private String gender;
    private long salary;

    public Employee(int id, String name, String designation, String gender, long salary) {
        super();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", gender=" + gender
                + ", salary=" + salary + "]";
    }
}
 class GroupingByMultipleFieldsExample {

    public static void main(String[] args) {

        // Creating List and adding Employees values.
        List<Employee> employeesList = new ArrayList<>();

        employeesList.add(new Employee(101, "Glady", "Manager", "Male", 25_00_000));
        employeesList.add(new Employee(102, "Vlad", "Software Engineer", "Female", 15_00_000));
        employeesList.add(new Employee(103, "Shine", "Lead Engineer", "Female", 20_00_000));
        employeesList.add(new Employee(104, "Nike", "Manager", "Female", 25_00_000));
        employeesList.add(new Employee(105, "Slagan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(106, "Murekan", "Software Engineer", "Male", 15_00_000));
        employeesList.add(new Employee(107, "Gagy", "Software Engineer", "Male", 15_00_000));
        Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.groupingBy(Employee::getGender,Collectors.counting())));
        System.out.println("Group by on multiple properties" + multipleFieldsMap);
        ConcurrentMap<String, ConcurrentMap<String, Long>> multipleFieldsMap1 = employeesList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getDesignation, Collectors.groupingByConcurrent(Employee::getGender, Collectors.counting())));
        // printing the count based on the designation and gender.
        System.out.println("Group by on multiple properties" + multipleFieldsMap1);
    }
}

//https://stackabuse.com/guide-to-java-8-collectors-reducing/
//The reducing() collector is most useful when used in a multi-level reduction operation, downstream of groupingBy() or partitioningBy(). Otherwise, we could reasonably substitute it with Stream.map() and Stream.reduce() to perform a simple map-reduce on a stream instead.
 class Student0{
    private String name;
    private String city;
    private double avgGrade;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student0{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", avgGrade=" + avgGrade +
                ", age=" + age +
                '}';
    }

    public Student0(String name, String city, double avgGrade, int age) {
        this.name = name;
        this.city = city;
        this.avgGrade = avgGrade;
        this.age = age;
    }

    // Constructor, getters, setters and toString()
    public static void main(String[] args){
        List<Student0> students = Arrays.asList(
                new Student0("John Smith", "Miami", 7.38, 19),
                new Student0("Mike Miles", "New York", 8.4, 21),
                new Student0("Michael Peterson", "New York", 7.5, 20),
                new Student0("James Robertson", "Miami", 9.1, 20),
                new Student0("Joe Murray", "New York", 7.9, 19),
                new Student0("Kyle Miller", "Miami", 9.83, 20)
        );
        //https://www.webucator.com/article/how-to-use-the-comparatorcomparing-method-in-java/
        Map<String, Optional<Student0>> reduceByCityAvgGrade =   students.stream()
                .collect(Collectors.groupingBy(Student0::getCity, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Student0::getAvgGrade)))));
        System.out.println(reduceByCityAvgGrade);

        Map<String, Student0> reduceByCityAvgGrade1 = students.stream()
                .collect(Collectors.groupingBy(Student0::getCity, Collectors.reducing(new Student0("x", "x", 0.0, 0), BinaryOperator.maxBy(Comparator.comparing(Student0::getAvgGrade)))));
        System.out.println(reduceByCityAvgGrade1);
        //'collect(reducing())' can be replaced with 'map().reduce()'
        double largestAverageGrade = students.stream().map(Student0::getAvgGrade).reduce(0.0, BinaryOperator.minBy(Comparator.comparingDouble(value -> value)));
        System.out.println(largestAverageGrade);
        double largestAverageGrade1 = students.stream()
                .collect(Collectors.reducing(0.0, Student0::getAvgGrade,
                        BinaryOperator.maxBy(Comparator.comparingDouble(value -> value))));
        System.out.println(largestAverageGrade1);
        Map<String, Double> reduceByCityAvgGrade2 = students.stream()
                .collect(Collectors.groupingBy(Student0::getCity, Collectors.reducing(6.0, Student0::getAvgGrade, BinaryOperator.maxBy(Comparator.comparingDouble(i->i)))));
        System.out.println(reduceByCityAvgGrade2);
    }
}

