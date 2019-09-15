package com.schamle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ParallelTest {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    @Test
    public void test() {
        TimeIt.code(() ->
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(ParallelTest::compute)
                        .sum());
    }

    @Test
    public void testParallel() {
        //use more threads to get answer faster (more resources)
        TimeIt.code(() ->
                numbers.parallelStream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(ParallelTest::compute)
                        .sum());
    }

    private static int compute (int val){
        //assume this takes time
        try {Thread.sleep(1000);} catch (Exception e){}
        return val * 2;
    }
}
