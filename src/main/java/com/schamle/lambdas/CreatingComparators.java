package com.schamle.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public class CreatingComparators {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));

        //string sort alphabetically
        Comparator<String> cmp = (s1, s2) -> s1.compareTo(s2);
        strings.sort(cmp);
        System.out.println(strings);

        //sort by length
        Comparator<String> cmp1 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        strings.sort(cmp1);
        System.out.println(strings);

        //length by creation Function
        Function<String, Integer> toLength = s -> s.length();
        Comparator<String> cmp2 = Comparator.comparing(toLength);
        strings.sort(cmp2);
        System.out.println(strings);

        //length by creation IntFunction to avoid boxing/unboxing
        ToIntFunction<String> toLength1 = s -> s.length();
        Comparator<String> cmp3 = Comparator.comparingInt(toLength1);
        strings.sort(cmp3);
        System.out.println(strings);
    }
}
