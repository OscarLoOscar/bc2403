package shapes;

import java.math.BigDecimal;

public class Square extends Shape {

  private double length;

  @Override
  public double area() {
    return BigDecimal.valueOf(this.length) //
        .multiply(BigDecimal.valueOf(this.length)) //
        .doubleValue();
  }

  // public BigDecimal area2() {
  //   return BigDecimal.valueOf(this.length) //
  //       .multiply(BigDecimal.valueOf(this.length));
  // }

}
