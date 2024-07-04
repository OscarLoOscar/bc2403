package com.bootcamp.demo2403.parent;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BigCar {
  private double weight;

  // Getter, Setter

  public static void main(String[] args) {
    BigCar bc = new BigCar(10.0);
    System.out.println(bc.toString());
  }
}
