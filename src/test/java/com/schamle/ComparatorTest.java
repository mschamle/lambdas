package com.schamle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

public class ComparatorTest {

    public static final String var1 = "hello";
    public static final String var2 = "world";

    @Test
    public void compareTest () {
        //old school
        Comparator<String> stringComparator = new Comparator<String>(){
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        int compareOriginal = stringComparator.compare(var1, var2);

        //lambda (params) -> {method body}
        Comparator<String> lambdaComparator =
                (String o1, String o2) -> {return o1.compareTo(o2); };

        int compare1 = lambdaComparator.compare(var1,var2);
        assertEquals(compareOriginal,compare1);

        //lambda with type inference (params inferred) -> (single statement)
        Comparator<String> lambdaComparator1 =
                (o1,o2) -> o1.compareTo(o2);

        int compare2 = lambdaComparator1.compare(var1,var2);
        assertEquals(compareOriginal,compare2);

    }
}
