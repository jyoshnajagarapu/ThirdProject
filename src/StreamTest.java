// Java code to show the implementation of
// Collectors toList() function

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Producte{
    int id;
    String name;

    @Override
    public String toString() {
        return "Producte{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    float price;
    public Producte(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
 class JavaStreamExample {
    public static void main(String[] args) {

        // creating a Stream of strings
        Stream<String> s = Stream.of("Geeks",
                "for",
                "GeeksforGeeks",
                "Geeks Classes");
        List<Producte> productsList = new ArrayList<Producte>();
        //Adding Products
        productsList.add(new Producte(1,"HP Laptop",25000f));
        productsList.add(new Producte(2,"Dell Laptop",30000f));
        productsList.add(new Producte(3,"Lenevo Laptop",28000f));
        productsList.add(new Producte(4,"Sony Laptop",28000f));
        productsList.add(new Producte(5,"Apple Laptop",90000f));
        List<Float> productPriceList2 =productsList.stream().peek(System.out::println)
                .filter(p -> p.price > 26000).peek(System.out::println)// filtering data
                .map(p->p.price).peek(System.out::println)        // fetching price
                .collect(Collectors.toList()); // collecting as list
        System.out.println(productPriceList2);
// Creating a list of Prime Numbers
        System.out.println("flatMap");
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);
        List<List<Integer>> listOfListofInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("The Structure before flattening is : " + listOfListofInts);
        List<Integer> listofInts  = listOfListofInts.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("The Structure after flattening is : " + listofInts);
        List<Stream<Integer>> listofInts1  = listOfListofInts.stream().map(list -> list.stream()).collect(Collectors.toList());
        System.out.println("The Structure after mapping is : " + listofInts1);
        for(Stream<Integer> a : listofInts1){
            a.forEach(System.out :: print);
           System.out.println("");
        }
        Stream<String[]>
                str = Stream
                .of(new String[][] { { "GFG", "GeeksForGeeks" },
                        { "g", "geeks" },
                        { "G", "Geeks" } });
        System.out.println("iterate");
        // create a stream using iterate
        Stream<Integer> stream
                = Stream.iterate(1,
                i -> i <= 20, i -> i * 2);
        stream.forEach(System.out::println);
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
        Optional<Producte> productA = productsList.stream().max((product1, product2)->product1.price > product2.price ? 1: -1);
        System.out.println(productA.get().price);
        // min() method to get min Product price
        Optional<Producte> productB = productsList.stream().min((product1, product2)->product1.price > product2.price ? 1: -1);
        System.out.println(productB.get().price);

        long count = productsList.stream()
                .filter(product->product.price<30000)
                .count();
        System.out.println(count);
        String lines = "I Love Java 8 Stream!";

        // split by space, uppercase, and convert to Array
        String[] result = Arrays.stream(lines.split("\\s+"))
                .map(String::toUpperCase)
                .toArray((a) -> new String[a]);
                //.toArray(String[]::new);

        for (String s5 : result) {
            System.out.println(s5);
        }

        // Creating a Stream of Integers
        Stream<Integer> stream5 = Stream.of(5, 6, 7, 8, 9, 10);

        // Using Stream toArray()
        Object[] arr = stream5.toArray();

        // Displaying the elements in array arr
        System.out.println(Arrays.toString(arr));

        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

        System.out.println("The sorted stream is : ");

        // displaying the stream with elements
        // sorted in natural order
        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        list.stream().skip(2).forEach(System.out::println);
        Stream<String> stream6
                = Stream.of("CSE", "C++", "Java", "DS");

        // Now using Stream noneMatch(Predicate predicate)
        // and later storing the boolean answer as
        boolean answer
                = stream6.noneMatch(str6 -> (str6.length() == 4));

        // Printing the boolean value on the console
        System.out.println(answer);
        List<String> liste = Arrays.asList("CSE", "JAVA", "gfg",
                "C++", "C");

        // Using Stream mapToDouble(ToDoubleFunction mapper)
        // and displaying the corresponding DoubleStream
        // which contains square of length of each element in
        // given Stream

        liste.stream().mapToDouble(stre -> stre.length() * stre.length())
                .forEach(System.out::println);
        // Creating a List of Strings
        List<String> list56 = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");
        System.out.println("flatMapToDouble");
        String[][] arrayOfArrays = {{"1", "2"}, {"5", "6"}, {"3", "4", "8"}};
        List<String[]> ab = Arrays.asList(arrayOfArrays);
        ab.stream().flatMapToDouble((a) -> Arrays.stream(a).mapToDouble((a1) -> Double.parseDouble(a1))).forEach(System.out :: print);
        list56.stream().flatMapToDouble(str56 -> DoubleStream.of(str56.length())).forEach(System.out::println);
        System.out.println("MapToDouble");
        ab.stream().mapToDouble((a) -> Arrays.stream(a).count()).forEach(System.out ::println);
        System.out.println("flatMapToInt");
        ab.stream().flatMapToInt((a) -> Arrays.stream(a).mapToInt((a1) -> Integer.parseInt(a1))).forEach(System.out :: print);
        liste.stream().mapToInt(stre -> stre.length() * stre.length()).forEach(System.out::println);
        System.out.println("flatMapToLong");
        liste.stream().mapToLong(stre -> stre.length() * stre.length()).forEach(System.out::println);
        ab.stream().flatMapToLong((a) -> Arrays.stream(a).mapToLong((a1) -> Long.parseLong(a1))).forEach(System.out :: print);
// Creating two Streams
        System.out.println("concat");
        Stream<String> stream1 = Stream.of("Geeks", "for");
        Stream<String> stream2 = Stream.of("GeeksQuiz", "GeeksforGeeks");

        // concatenating both the Streams
        // with Stream.concat() function
        // and displaying the result
        Stream.concat(stream1, stream2)
                .forEach(element -> System.out.println(element));
        // Creating a list of Integers
        List<Integer> list4 = Arrays.asList(3, 4, 6, 12, 20);

        // Check if all elements of stream
        // are divisible by 3 or not using
        // Stream allMatch(Predicate predicate)
        boolean answer4 = list4.stream().allMatch(n-> n % 3 ==0);

        // Displaying the result
        System.out.println(answer4);

        Stream<String> stream54 = Stream.of("Geeks", "fOr",
                "GEEKSQUIZ", "GeeksforGeeks");

        // Check if Character at 1st index is
        // UpperCase in any string or not using
        // Stream anyMatch(Predicate predicate)
        boolean answer5 = stream54.anyMatch(str5 -> Character.isUpperCase(str5.charAt(1)));

        // Displaying the result
        System.out.println(answer5);
        // Using Stream builder()
        System.out.println("builder");
        Stream.Builder<String> builder = Stream.builder();

        // Adding elements in the stream of Strings
        Stream<String> stream66 = builder.add("Geeks")
                .add("for")
                .add("Geeks")
                .add("GeeksQuiz")
                .build();

        // Displaying the elements in the stream
        stream66.forEach(System.out::println);
        System.out.println("builder");
        // Creating a list of integers
        List<Integer> list43 = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);

        System.out.println("The distinct elements are :");

        // Displaying the distinct elements in the list
        // using Stream.distinct() method
        list43.stream().distinct().forEach(System.out::println);

        // Creating an empty Stream
        System.out.println("empty");
        Stream<String> stream55 = Stream.empty();

        // Displaying elements in Stream
        stream55.forEach(System.out::println);
        // Creating a List of Integers
        System.out.println("findany");
        List<Integer> list8 = Arrays.asList(2, 4, 6, 8, 10);

        // Using Stream findAny() to return
        // an Optional describing some element
        // of the stream
        Optional<Integer> answer8 = list8.stream().findAny();

        // if the stream is empty, an empty
        // Optional is returned.
        if (answer8.isPresent()) {
            System.out.println(answer8.get());
        }
        else {
            System.out.println("no value");
        }
        System.out.println("findFirst");
        // Creating a List of Integers
        List<Integer> listr = Arrays.asList(3, 5, 7, 9, 11);

        // Using Stream findFirst()
        Optional<Integer> answerr = listr.stream().findFirst();

        // if the stream is empty, an empty
        // Optional is returned.
        if (answerr.isPresent()) {
            System.out.println(answerr.get());
        }
        else {
            System.out.println("no value");
        }
        System.out.println("forEachOrdered");
        // Creating a list of Strings
        List<String> listee = Arrays.asList("GFG", "Geeks",
                "for", "GeeksforGeeks");

        // Using forEachOrdered(Consumer action) to
        // print the elements of stream in encounter order
        listee.stream().forEachOrdered(System.out::println);

        //Stream of infinite integers
        System.out.println("generate");
        Stream<Integer> randomNumbers = Stream.generate( () -> (new Random()).nextInt(100) );

        randomNumbers.limit(20).forEach( System.out::println ); //print first 20 numbers
        //Stream of infinite integers
        System.out.println("iterate");
        Stream<Integer> infiniteEvenNumbers = Stream.iterate(0, n -> n + 2);

        infiniteEvenNumbers.limit(10).forEach( System.out::println ); //print first 10 numbers
        System.out.println("collect");
        List<String> vowels = List.of("a", "e", "i", "o", "u");

// sequential stream - nothing to combine
        StringBuilder result3 = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y),
                (a, b) -> a.append(",").append(b));
        System.out.println(result3.toString());

// parallel stream - combiner is combining partial results
        StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
                (a, b) -> a.append(",").append(b));
        System.out.println(result1.toString());

//
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        ////https://www.javadevjournal.com/java/java-stream-reduce/
        //https://stackabuse.com/java-8-streams-guide-to-reduce/
        Optional<String> longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        longestString.ifPresent(System.out::println);
        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
        int sum = array.stream().reduce(100, (element1, element2) -> {
            System.out.println("a" + ": " + element1 + ":" + element2);
            return element1 + element2;
        });
        System.out.println("The sum of all elements is " + sum);
//        a: 100:-2
//        a: 98:0
//        a: 98:4
//        a: 102:6
//        a: 108:8
        System.out.println("reducing");
        List<Integer> array6 = Arrays.asList(-2, 0, 4, 6, 8);
        int sum6 = array6.stream().reduce(100, (element1, element2) -> {
            System.out.println("a" + ": " + element1 + ":" + element2);
            return element1 + element2;
        });
        System.out.println("The sum of all elements is " + sum6);
        List<Integer> array1 = Arrays.asList(-2, 0, 4, 6, 8);
        // Finding sum of all elements
        //combiner wont be called in stream,used only in parallel stream
        int sum2 = array1.stream().reduce(100,
                (element1, element2) -> {
                    System.out.println("a" + ": " + element1 + ":" + element2);
                    return element1 + element2;
                },(element1, element2) -> {
                    System.out.println("c" + ": " + element1 + ":" + element2);
                    return element1 + element2;
                });
        System.out.println("The sum of all elements is " + sum2);
        //The sum of all elements is 116
//        a: 100:-2
//        a: 98:0
//        a: 98:4
//        a: 102:6
//        a: 108:8
        int sum21 = array1.parallelStream().reduce(100,
                (element1, element2) -> {
                    System.out.println("a" + ": " + element1 + ":" + element2);
                    return element1 + element2;
                },(element1, element2) -> {
                    System.out.println("c" + ": " + element1 + ":" + element2);
                    return element1 + element2;
                });
        System.out.println("The sum of all elements is " + sum21);
//        a: 100:4
//        a: 100:-2
//        a: 100:0
//        a: 100:6
//        c: 98:100
//        a: 100:8
//        c: 106:108
//        c: 104:214
//        c: 198:318

//        //Here, we are finding out the length of all strings in the list. If we don’t use the combiner, it will throw one error. The identity is an integer, but the stream is a list of strings. The compiler expects the result and the identity to be a string, not an integer. The combiner tells the compiler that the result is an integer sum. You can use a combiner in a sequential stream, but they are useful only in a parallel stream.
        List < String > numbers = Arrays.asList("one", "two", "three", "four", "five");
        int sum1 = numbers.stream()
                .reduce(0, (first, second) -> first + second.length(),Integer::sum);

        System.out.println(sum1);

        List < String > numbers1 = Arrays.asList("one", "two", "three", "four", "five");
        String result12 = numbers1.stream().reduce("=>", (first, second) -> first + "$" + second,
                (first, second) -> first + "%" + second);
        //=>$one$two$three$four$five the combiner is not used. This is because it uses the combiner only with a parallel stream
        System.out.println(result12);
        List < String > numbers13 = Arrays.asList("one", "two", "three", "four", "five");
        String result123 = numbers13.parallelStream().reduce("=>", (first, second) -> first + "$" + second,
                (first, second) -> first + "%" + second);
        //=>$one%=>$two%=>$three%=>$four%=>$five
        System.out.println(result123);

        String string = "Our Mathematical Universe: My Quest for the Ultimate Nature of Reality";
        List<String> wordList = List.of(string.split(" "));

        int length = wordList
                .stream()
                .reduce(0,
                        (parLength, word) -> parLength + word.length(),
                        (parLength, otherParLength) -> parLength + otherParLength
                );

        System.out.println(String.format("The sum length of all the words in the paragraph is %d", length));
    }
}

//This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline.
//Since Java 9, if the number of elements is known in advance and unchanged in the stream, the .peek () statement will not be executed due to performance optimization. It is possible to force its operation by a command (formal) changing the number of elements eg. .filter (x -> true).
//Using peek without any terminal operation does nothing.
// Java Program to Illustrate peek() Method
// of Stream class Without Terminal Operation Count


// Main class
class GFGrtr {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating a list of Integers
        List<Integer> list
                = Arrays.asList(0, 2, 4, 6, 8, 10);

        // Using peek without any terminal
        // operation does nothing
        list.stream().peek(System.out::println);
        list.stream().peek(System.out::println).count();
        //forcing it to execute
        list.stream().filter(x -> true).peek(System.out::println).count();

    }
}


class Mainji {
    public static void main(String[] args) throws IOException {

        List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10);
        Stream < Integer > lines = list.stream();
        lines.parallel().forEach(System.out::println);
        list.stream().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);
    }
}
