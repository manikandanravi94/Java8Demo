package stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("one","two","three");
        Predicate<String> p = s -> s.equals("two");
        Predicate<String> p1 = s -> s.equals("three");
        stringStream.filter(p.or(p1)).forEach(System.out::println);
//   Always a final operation does operation on data.. intermediart operations are used to some operation but dont
//execute the same on data.. to execute a operation on data we need final operation because streams dont work on data
 //steam never return data.. it looks like a collection and returning data but not data
        
//foreach(not lazy) is a final operation and peek(lazy operation) is a intermediatary operation
//        stringStream.peek(System.out::println);

    }
}
