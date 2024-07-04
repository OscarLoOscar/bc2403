package com.bootcamp.demo2403;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Annotations
@AllArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
public class Dog {
  private String name;
  private int age;

  // Custom Constructor
  public Dog(String name) {
    this.name = name;
  }

  // Custom Constructor
  public Dog() {
    this.name = "Sally";
    this.age = 2 * 2;
  }

  public static void main(String[] args) {
    Dog dog = new Dog("Vincent", 3);
    Dog dog2 = new Dog();
    dog.setAge(10);
    System.out.println(dog.getAge()); // 10
  }
}
