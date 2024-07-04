package com.bootcamp.demo2403.bag;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import lombok.Getter;

@Getter
public class Bag {
  private List<Ball> balls;

  public Bag() {
    balls = new LinkedList<>();
  }

  public boolean add(int value, Color color) {
    return this.balls.add(Ball.of(value, color));
  }

  public Ball withdraw() { // randomly
    if (this.balls.size() <= 0)
      throw new IllegalStateException();
    int idx = new Random().nextInt(this.balls.size());
    return this.balls.remove(idx); // loop
  }

  public int sumOfValues() {
    return this.balls.stream() //
        .mapToInt(e -> e.getValue()) // from ball object to int value
        .sum();
  }

  public int size() {
    return this.balls.size();
  }

}
