package com.schamle.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

    public static void main(String[] args) {
        //supplier example
        Supplier<String> supplier = () -> "Hello!"; //create body for get() method
        String string = supplier.get();
        System.out.println("string = " + string);

        //consumer example
        Consumer<String> consumer = s -> { //create body for accept(T t) method
            System.out.println("Inside the consumer");
            System.out.println(s);
        };
        consumer.accept("Hello");
    }
}
