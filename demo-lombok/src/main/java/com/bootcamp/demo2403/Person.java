package com.bootcamp.demo2403;

import lombok.Value;
// import lombok.var;

// read-only
@Value // AllargsContructor + getters
public class Person {
  private String name; // final
  private int age; // final

  // public void setName(String name) {
    // this.name = name;
  // }

  public static void main(String[] args) {
    Person p1 = new Person("Vincent", 5);
    System.out.println(p1.getAge());
    System.out.println(p1.getName());

    Person p2 = new Person("Vincent", 5);
    System.out.println(p1.equals(p2)); // true

    System.out.println(p1);
    System.out.println(p2);

    var name = "Vincent";
    // name = 1;

  }
}
