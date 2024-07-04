package com.bootcamp.demo2403.abc;

import static org.junit.jupiter.api.Assertions.*; // static import
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.bootcamp.demo2403.Calculator;
import com.bootcamp.demo2403.StringChecker;

// We can use static import to import all static methods of the Class.
class CalculatorTest {

  @Test
  void testSum() {
    int actual = Calculator.sum(3, 4);
    assertEquals(7, actual);
    assertEquals(-10, Calculator.sum(-1, -9));
    assertEquals(0, Calculator.sum(0, 0));
    assertNotEquals(8, Calculator.sum(3, 4));
  }

  // Test-Driven Design
  @Test
  void testSubtract() {
    assertEquals(8, Calculator.subtract(-1, -9));
    assertEquals(8, Calculator.subtract(10, 2));
    assertEquals(0, Calculator.subtract(2, 2));
  }

  @Test
  void testSort() {
    int[] arr = new int[] {2, 4, 3, 1};
    Calculator.sort(arr);
    assertArrayEquals(new int[] {1, 2, 3, 4}, arr);

    int[] arr2 = new int[] {};
    Calculator.sort(arr2);
    assertArrayEquals(new int[] {}, arr2);
  }

  @ParameterizedTest
  @CsvSource({
    "2, 1, 1",
    "100, 49, 51"
  })
  void testSumEqauls(int expected, int x, int y) {
    assertEquals(expected, Calculator.sum(x, y));
  }

  @ParameterizedTest
  @CsvSource({
    "2, 1, 2",
    "100, 49, 50"
  })
  void testSumNotEqauls(int expected, int x, int y) {
    assertNotEquals(expected, Calculator.sum(x, y));
  }

  @Test
  void testConcat() {
    assertEquals(new String("abcdefijk"),
        Calculator.concat(List.of("abc", "def", "ijk")));

  }

}
