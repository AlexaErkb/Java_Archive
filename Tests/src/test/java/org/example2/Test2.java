package org.example2;

import com.example.MyClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test2 {
    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Тест 1",
                        () -> Assertions.assertEquals(3, MyClass.calc(1, 1))),
                DynamicTest.dynamicTest("Тест 2",
                        () -> Assertions.assertEquals(4, MyClass.calc(2, 2))));
    }
    @RepeatedTest(3)
    void addNumber(TestInfo testInfo) {
        Assertions.assertEquals(4, MyClass.calc(1, 1), "Тест 3");
    }
    public boolean isPositive(String n) {
        return n == null ? false : Integer.valueOf(n) > 0;
    }

    @ParameterizedTest(name = "{index} - {0} is positive")
    @ValueSource(strings = { "12321", "-129" })
    void testPositive(String n) {
        assertTrue(isPositive(n));
    }
}
