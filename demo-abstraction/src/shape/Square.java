package shape;

import java.math.BigDecimal;

public class Square implements Shape {

  private double length;

  @Override
  public double area() {
    return BigDecimal.valueOf(this.length) //
        .multiply(BigDecimal.valueOf(this.length)) //
        .doubleValue();
  }

  @Override
  public String print() {
    return String.valueOf(this.length);
  }
}
