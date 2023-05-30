package org.example;

import com.example.MyClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.ExemptionMechanismException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Test1 {
    @Test
    public void test1() {
        //Assume.assumeTrue(System.getProperty("os.name").toLowerCase().contains("ааа"));
        Assertions.assertEquals(3, MyClass.calc(3, 3), "Тест не пройден");
    }
    @Test
    public void test2() {
        Assertions.assertNotEquals(6, MyClass.calc(3, 3), "Тест не пройден");
    }
    @Test
    public void test3() {
        Assertions.assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2}, "Тест не пройден");
    }
    @Test
    public void test4() {
        Iterable<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        Iterable<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3));
        Assertions.assertIterableEquals(list1, list2, "Тест не пройден");
    }
    @Test
    public void test5() {
        List<String> l1 = List.of("one", "two", "three");
        List<String> l2 = List.of("one", "two");
        Assertions.assertLinesMatch(l1, l2, "Тест не пройден");
    }
    @Test
    public void test6() {
        Assertions.assertNotNull(null, "Тест не пройден");
    }
    @Test
    public void test7() {
        String original = "test";
        String clone = original;
        Assertions.assertSame(original, "not test", "Тест не пройден");
    }
    @Test
    public void test8() {
        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(200);
            return "result";
        }, "Тест не пройден");
    }
    @Test
    public void test9() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new ExemptionMechanismException("error message");
        }, "Тест не пройден");
    }
}
