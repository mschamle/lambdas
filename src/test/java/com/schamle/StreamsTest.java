package com.schamle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Streams provide means to iterate collection entries through a non-mutating pipeline
     filter: filters out non-true
     parameter: Stream<T> filter takes Predicate<T>

     map #input=#output
     parameter: Stream<T> takes Function<R,T> to return Stream<R>

     both filter and map stay within their swimlanes
     (they focus on same element and don't look outside it)

    reduce works on all elements (that were not filtered)
    reduce on Stream<T> takes two params: T, BiFunction<R, T, R> to produce a result of <R></R>
 */
public class StreamsTest {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    List<Integer> numbersRepeat = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

    public static List<Person> createPeople () {
        return Arrays.asList(
                new Person ("Sara", Person.Gender.FEMALE, 20),
                new Person ("Sara", Person.Gender.FEMALE, 22),
                new Person ("Marc", Person.Gender.MALE, 24),
                new Person ("Paula", Person.Gender.FEMALE, 32),
                new Person ("Jack", Person.Gender.MALE, 22),
                new Person ("Jack", Person.Gender.MALE, 52),
                new Person ("Jackie", Person.Gender.FEMALE, 42)
                );
    }

    @Test
    //reduce function (to list, set
    public void testCollect() {
        //double even values and put it in a list

        //the wrong way. shared mutability
//        List<Integer> doubleOfEven = new ArrayList<>();
//        numbersRepeat.stream()
//                     .map(e -> e*2)
//                     .forEach(e -> doubleOfEven.add(e));  //shared variable being changed
//        System.out.println(doubleOfEven);

        //the right way
        List<Integer> doubleOfEven2 =
                numbersRepeat.stream()
                             .filter(e -> e % 2 == 0)
                             .map(e -> e*2)
                             .collect(toList());  //thread safe
        System.out.println(doubleOfEven2);

    }

    @Test
    public void testMap() {
        List<Person> people = createPeople();

        //create a name with name and age as key, value is Person
        Map<String, Person> peopleMap =
                people.stream()
                    .collect(toMap(
                            person -> person.getName() + "-" + person.getAge(),
                            person -> person
                    ));

        System.out.println(peopleMap);

        //given a list of people, create a map where
        //name is the key and value is all the people with that name
        Map<String, List<Person>> peopleMap2 =
                people.stream()
                .collect(groupingBy(Person::getName));
        System.out.println(peopleMap2);

        //given a list of people, create a map where
        //name is the key and value is the ages of people with that name
        Map<String, List<Integer>> peopleMap3 =
                people.stream()
                        .collect(groupingBy(Person::getName,
                                mapping(Person::getAge, toList())));
        System.out.println(peopleMap3);

    }
}
