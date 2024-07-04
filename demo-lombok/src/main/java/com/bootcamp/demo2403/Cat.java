package com.bootcamp.demo2403;

public class Cat {
  private String name;
  private int age;

  public Cat(String name, int age) {
    if (name == null) {
      throw new NullPointerException("name cannot be null when create cat object.");
    }
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public static void main(String[] args) {
    Cat c = new Cat("Vincent", 10);
  }
}
