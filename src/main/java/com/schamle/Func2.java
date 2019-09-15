package com.schamle;

public interface Func2 {

    //single abstract method
    public String method(String a, String b);

    // default method, can be called from implemented interface
    default public String formatIt(String a, String b){
        return String.format("Pretty - {}, {}", a, b);
    }

    //static method
    public static String commas(String a, String b) {
        return a + "," + b;
    }
}
