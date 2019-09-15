package com.schamle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Func2Test {

    static String var2 = "static";

    @Test
    public void test1 () {

        String var1 = "This is it: ";
        //local var1 here has to be effectivelly final
        //instance or static var2 can be changed
        Func2 func1 = (s1,s2) -> var1 + s1 + "," + s2 + var2;;

        var2 = "new static";
        System.out.println(func1.method("one", "two"));
    }
}
