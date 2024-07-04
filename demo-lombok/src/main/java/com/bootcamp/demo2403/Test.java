package com.bootcamp.demo2403;

import java.time.LocalDate;

public class Test {

  public static void main(String[] args) {
    Staff s1 = new Staff("Vincent", LocalDate.of(2013, 10, 1));
    Staff s2 = new Staff("Vincent", LocalDate.of(2013, 10, 2));
    System.out.println(s1.equals(s2)); // true
    System.out.println(s1 == s2); // false

    Dog d1 = new Dog();
    Dog d2 = new Dog();
    System.out.println(d1.equals(d2)); // false

    System.out.println(s1.toString()); // Staff(name=Vincent, joinDate=2013-10-01)
    System.out.println(s1.hashCode()); // 919669803
    System.out.println(s2.hashCode()); // 919669803

    System.out.println(d1.hashCode()); // 1943105171
    System.out.println(d2.hashCode()); // 1704856573

    // Order order = new Order("O1");
    Customer c1 = new Customer("Vincent");
    c1.add(new Order("O1"));
    Customer c2 = new Customer("Vincent");
    c2.add(new Order("O1"));

    System.out.println(c1.equals(c2)); // true

    System.out.println(c1.orderCount()); // 1

    Staff t1 = Staff.builder() //
        .name("Vincent") //
        .joinDate(LocalDate.of(2013, 4, 30)) //
        .build();

    System.out.println(t1.toString());
  }

}
