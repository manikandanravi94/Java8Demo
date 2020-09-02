package passingfunctionalites;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by gbs05347 on 22-01-2020.
 */
public class PassingFunctionalityAfterJ8 {
    public static List<Person> people= Arrays.asList(new Person("mani","ravi",25),
            new Person("anbu","pichai",28),
            new Person("madhav","gopal",29));

    public static void main(String[] args) {
        Collections.sort(people, Comparator.comparing(Person::getLastName));
        System.out.println("printing after arranging everything based on last name");
        PassingFunctionalityB4Java8 pass= new PassingFunctionalityB4Java8();
        pass.printConditionally(people, p->true);
        System.out.println("printing if the last name starts with g");
        pass.printConditionally(people, p-> {return p.getLastName().startsWith("g");});
    }

    public void printConditionally(List<Person> people, Predicate condition){
        for(Person p: people){
            if(condition.test(p)){
                System.out.println(p);}
        }
    }
}
/*
We dont want to mention the type of the lambda expression if we are going to use predefined functionalities
test method accepts one parameter and return boolean value is present in predicate
 */
//interface ConditionJ8{
//
//    boolean test(Person p);
//}
