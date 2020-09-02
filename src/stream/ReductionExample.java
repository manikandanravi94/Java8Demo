package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10,10);
         //reduce are of three types
        //1. normal aggregation function min,max
        //2.boolean operation
        //3. find first like these
        Optional<Integer> total= list.stream().reduce( Integer::sum);
        total.ifPresent(System.out::println);

    }
}
