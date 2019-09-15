package com.schamle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsTest {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Test
    public void test () {
        //stream and sum
        System.out.println(
                numbers.stream()
                    .reduce(0, (total, e) -> Integer.sum(total, e)));

        //stream and sum with method reference (possible because params implementation method params)
        System.out.println(
                numbers.stream()
                        .reduce(Integer::sum));
    }

    @Test
    public void testStreams() {
        //streams is like an iterator with additional functions

        //convert to string and concat (note on reduce if you don't include base param it will be Optional)
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", (carry, str) -> carry.concat(str)));  //not two params, 1 target with 1 param

        //method ref on concat
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .reduce("", String::concat));

        //stream and double only even numbers
        System.out.println(
                numbers.stream()
                       .filter(e -> e % 2 == 0)
                       .map(e -> e *2)
                       .reduce(0, Integer::sum)
        );

        //above and mapToInt
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e *2)
                        .sum()
        );
    }
}
