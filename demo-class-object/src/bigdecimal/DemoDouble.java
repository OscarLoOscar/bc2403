package bigdecimal;

import java.math.BigDecimal;

public class DemoDouble {
  public static void main(String[] args) {
    double result = 0.1d + 0.2d;
    System.out.println(result); // 0.30000000000000004

    BigDecimal bd1 = new BigDecimal("0.1");
    BigDecimal bd2 = bd1.add(new BigDecimal("0.2"));
    System.out.println(bd2.doubleValue()); // 0.3

    double d1 =
        BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2)).doubleValue();
    System.out.println("d1=" + d1); // 0.3
  }
}
