package com.schamle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Func1Test {

    @Test
    public void test1 () {

        //single param doesn't need parentheses
        Func1 func1 = s1 -> s1*s1;
        int result = func1.method(2);
        assertEquals(4, result);

        //single line method doesn't need braces or return
        Func1b func1b = (a1, a2) -> a1*a2;
        int result2 = func1b.method(3,4);
        assertEquals(12, result2);

        Func1b func1b2 = (a1,a2) -> {
            int b = a1+a2;
            return b*2;
        };
        int result3 = func1b2.method(2,3);
        assertEquals(10, result3);
    }
}
