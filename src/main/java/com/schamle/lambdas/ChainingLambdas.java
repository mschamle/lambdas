package com.schamle.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("c1 consumes " + s);
        Consumer<String> c2 = s -> System.out.println("c2 consumes " + s);

        //chain it ourselves
        Consumer<String> c3 = s -> {
            c1.accept("Hello");
            c2.accept("Hello");
        };
        c3.accept("Hello");

        //easier way to write above
        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("Hi There");

        //predicates
        Predicate<String> isNull = s -> s == null;
        System.out.println("for null = " + isNull.test(null));
        System.out.println("for Hello = " + isNull.test("Hello"));

        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("for '' = " + isEmpty.test(""));
        System.out.println("for Hello = " + isEmpty.test("Hello"));

        //chain them using negate() (we don't want it null or empty) and and()
        Predicate<String> isGood = isNull.negate().and(isEmpty.negate());
        System.out.println("isGood for null = " + isGood.test(null));
        System.out.println("isGood for '' = " + isGood.test(""));
        System.out.println("isGood for Hello = " + isGood.test("Hello"));




    }


}
