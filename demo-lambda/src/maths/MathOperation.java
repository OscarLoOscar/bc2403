package maths;

@FunctionalInterface
public interface MathOperation {
  double operate(double x, double y);

  static double calculate(int x, int y, MathOperation formula) {
    return formula.operate(x, y);
  }

  public static void main(String[] args) {
    // Create Class ABC implement MathOperation -> @Override operate() -> a + b -> new ABC()
    MathOperation addition = (a, b) -> a + b;
    MathOperation subtract = (a, b) -> a - b;
    MathOperation multiply = (a, b) -> a * b;
    MathOperation divide = (a, b) -> a / b;

    System.out.println(MathOperation.calculate(100, 5, divide)); // 20.0
    System.out.println(MathOperation.calculate(100, 5, addition)); // 105.0
    System.out.println(MathOperation.calculate(100, 5, multiply)); // 500.0
    System.out.println(MathOperation.calculate(100, 5, subtract)); // 95.0
  }
}
