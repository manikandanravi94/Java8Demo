package passingfunctionalites;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by gbs05347 on 21-01-2020.
 */
public class PassingFunctionalityB4Java8 {

    public static List<Person> people=Arrays.asList(new Person("mani","ravi",25),
            new Person("anbu","pichai",28),
            new Person("madhav","gopal",29));

    public static void main(String[] args) {
        Collections.sort(people, new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2)  {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });
        System.out.println("printing after arranging everything based on last name");
        PassingFunctionalityB4Java8 pass= new PassingFunctionalityB4Java8();
        pass.printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return true;
            }
        });
        System.out.println("printing if the last name starts with g");
        pass.printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                boolean b=false;
                if(p.getLastName().startsWith("g")){
                    b= true;
                }
                return b;
            }
        });
//        Stream<Person> peopleStream = people.stream();
//        peopleStream.filter(person ->person.getLastName().startsWith("g")).forEach(System.out::println);
//        peopleStream.close();
    }

    public void printConditionally(List<Person> people, Condition condition){
        for(Person p: people){
            if(condition.test(p)){
            System.out.println(p);}
        }
    }





}

interface Condition{

    boolean test(Person p);
        }
