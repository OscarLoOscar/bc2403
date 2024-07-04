public class Calculator<T extends Number> {

  private T x;

  private T y;

  public double sum3(T x, T y) {
    return x.doubleValue() + y.doubleValue();
  }

  public static int sum(int x, int y) {
    return x + y;
  }

  public static double sum(double x, double y) {
    return x + y; // BigDecimal
  }

  // "<T extends Number>" implies x and y are the objects that
  // belongs to the class of Byte, Short, Integer, Long, Double, Float
  // So you cannot pass a String object into the parameters x and y
  public static <T extends Number & Swim> double sum(T x, T y) { // primitive? Wrapper Class?
    // Byte, Short, Integer, Long, Double, Float
    return x.doubleValue() + y.doubleValue(); // BigDecimal
  }

  public static double sum2(Number x, Number y) {
    return x.doubleValue() + y.doubleValue(); // BigDecimal
  }

  public static void main(String[] args) {
    System.out.println(sum(2, 3)); // 5.0
    System.out.println(sum(2, 3L)); // 5.0
    System.out.println(sum(2, 3.3d)); // 5.3
    System.out.println(sum(2.3f, 3.2d)); //

    // Compile-time -> Type-Safety
    // limit the type range of x and y, so that x and y must be able to call doubleValue()

    // Run-time -> Polymorphism
    // sum(2.3f, 3.2d)
    // x.doubleValue() -> find the Float object in heap, we are calling the Float.doubleValue()

    System.out.println(sum2(3.4d, 3L)); // 6.4

    //
    Calculator<Long> calculator = new Calculator<>();
    System.out.println(calculator.sum3(Long.valueOf(10), Long.valueOf(20))); // object -> call static method

    Calculator.sum(3.2d, 3.4d); // static method

    Calculator.sum(new SuperLong(), new SuperLong());
  }
}
