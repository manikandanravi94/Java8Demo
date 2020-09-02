package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        //Stream<List<Integer>> listStream= Stream.of(Arrays.asList(1, 2, 4),Arrays.asList(3,5,6));

        List<Integer> lst1=Arrays.asList(1,2,3);
        List<Integer> lst2=Arrays.asList(4,5,6);
        List<Integer> lst3=Arrays.asList(7,8,9);
        List<List<Integer>> list=Arrays.asList(lst1,lst2,lst3);

        list.stream().map(List::size).forEach(System.out::println);
        //map is used with the given stream.. if the entered value is stream of stream. map cannot execute the
        //internal stream where as flat map will do that operation too for us
        list.stream().flatMap(integers -> integers.stream()).forEach(System.out::println);

    }
}
