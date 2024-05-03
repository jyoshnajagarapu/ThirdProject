import java.util.Optional;
import java.util.function.Function;

class OptionalExample {
    public static void main(String[] args) throws Exception {
        String[] str = new String[10];
        str[5] = "JAVA OPTIONAL CLASS EXAMPLE";  // Setting value for 5th index  
        // It returns an empty instance of Optional class   
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        // It returns a non-empty Optional  
        Optional<String> value = Optional.of(str[5]);
        value.ifPresent(System.out::println);
        // If value is present, it returns an Optional otherwise returns an empty Optional  
        System.out.println("Filtered value: "+value.filter((s)->s.equals("Abc")));
        System.out.println("Filtered value: "+value.filter((s)->s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
        // It returns value of an Optional. if value is not present, it throws an NoSuchElementException    
        System.out.println("Getting value: "+value.get());
        // It returns hashCode of the value  
        System.out.println("Getting hashCode: "+value.hashCode());
        // It returns true if value is present, otherwise false  
        System.out.println("Is value present: "+value.isPresent());
        // It returns non-empty Optional if value is present, otherwise returns an empty Optional  
        System.out.println("Nullable Optional: "+Optional.ofNullable(str[5]));
        // It returns value if available, otherwise returns specified value,  
        System.out.println("orElse: "+value.orElse("Value is not present"));
        System.out.println("orElse: "+empty.orElse("Value is not present"));

        value.ifPresent(System.out::println);   // printing value by using method reference
        String country = empty.orElseGet(()->"India"); // will return "India"
        System.out.println("Country =" + country);
        Optional<String> stringOptional = Optional.of("Arvind");
        Optional<Integer> intOptional = stringOptional.map(String::length);
        System.out.println(intOptional.get()); // 6
        Optional<Integer> intOptional1 = stringOptional.flatMap(s->Optional.of(s.length()));
        System.out.println(intOptional1.get()); // 6
        Optional<String> optional = Optional.of("United States");

        Function<String,Optional<Integer>> mapper = s->Optional.of(s.length()); // mapper which return Optional<Integer>
        String msg1 = optional.orElseThrow(()->new Exception("Message not available"));

        System.out.println(msg1);



        Optional<Optional<Integer>> mapOptional = optional.map(mapper); // added additional layer

        Optional<Integer> flatMapOptional = optional.flatMap(mapper); // no additional layer

        System.out.println("map value="+ mapOptional.get());
        System.out.println("flatMap value="+ flatMapOptional.get());

        String msg = empty.orElseThrow(()->new Exception("Message not available"));

        System.out.println(msg);
    }
}  