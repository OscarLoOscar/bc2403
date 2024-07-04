package com.bootcamp.demo2junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SolutionTets {

  int x = 0;

  @Test
  @Order(1)
  void testX() {
    this.x++;
    assertEquals(1, this.x);
  }


  @Test
  @Order(2)
  void testX2() {
    this.x++;
    assertEquals(2, this.x);
  }
}
