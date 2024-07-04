package shape;

import java.math.BigDecimal;

// 1. You can implements more than one Interface in a class
public class Circle implements Shape {

  private double radius;

  @Override
  public double area() {
    return BigDecimal.valueOf(this.radius) //
        .multiply(BigDecimal.valueOf(this.radius)) //
        .multiply(Shape.PI) //
        .doubleValue();
  }

  @Override
  public String print() {
    return String.valueOf(this.radius);
  }

  public void sleep() {
    System.out.println("Sleep ...");
  }

  public static void main(String[] args) {
    // Polymorhism
    Shape s = new Circle(); // OK
    s.area();
    s.print();
    // s.sleep();
  }

}
