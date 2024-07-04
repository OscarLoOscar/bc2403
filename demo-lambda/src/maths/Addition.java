package maths;

public class Addition implements MathOperation {

  @Override
  public double operate(double x, double y) {
    return x + y;
  }

  public static void main(String[] args) {
    Addition addition = new Addition();
    addition.operate(100, 5); // 105
  }

}
