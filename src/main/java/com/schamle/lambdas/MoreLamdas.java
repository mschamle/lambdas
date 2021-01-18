package com.schamle.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MoreLamdas {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

        Predicate<String> filter = s -> s.startsWith("t");
        strings.removeIf(filter); //remove items for which Predicate returns true

        Consumer<String> action = s -> System.out.println(s);
        strings.forEach(action); //run action method for each String

        //now do it again with inline methods
        strings.removeIf(s -> s.startsWith("t"));
        strings.forEach(s -> System.out.println(s));
    }
}
