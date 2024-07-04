package com.bootcamp.demo2403.parent;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Car extends BigCar {
  private String model;

  // public Car(String model) {
  //   super();
  //   this.model = model;
  // }

  // Custom Constructor
  public Car(String model, double weight) {
    super(weight);
    this.model = model;
  }

  public static void main(String[] args) {
    Car car = new Car("TSLA"); // AllargsConstructor
    car.setWeight(10.0);
    System.out.println(car.getWeight());
    System.out.println(car.toString()); // Car(super=BigCar(weight=10.0), model=TSLA)

    Car car2 = new Car("TSLA");
    car2.setWeight(10.0);
    System.out.println(car.equals(car2)); // true
  }

}
