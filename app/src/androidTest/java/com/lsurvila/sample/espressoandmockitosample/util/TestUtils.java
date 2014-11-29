package com.lsurvila.sample.espressoandmockitosample.util;

import static junit.framework.Assert.assertEquals;

public class TestUtils {

    public static void assertIntegerEquals(int expected, Integer actual) {
        assertEquals(Integer.valueOf(expected), actual);
    }

    public static void assertBooleanEquals(boolean expected, Boolean actual) {
        assertEquals(Boolean.valueOf(expected), actual);
    }
}
