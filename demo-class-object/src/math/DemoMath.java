package math;

public class DemoMath {
  public static void main(String[] args) {
    // Math.pow()
    int base = 2;
    double result = Math.pow(2.0d, 3); // upcast: 1 -> double
    System.out.println(result); // 8

    int a = 10;
    int b = 9;
    int min = Math.min(a, b);

    if (a > b) {
      min = b;
    } else {
      min = a;
    }

    int max = Math.min(a, b);

    if (a > b) {
      max = a;
    } else {
      max = b;
    }

    double data = -3.2;
    double r = Math.abs(data);

    if (data < 0) {
      r *= -1;
    }

    System.out.println(Math.round(3.45)); // 3
    System.out.println(Math.round(3.50)); // 4

    System.out.println(Math.sqrt(9.0)); // 3.0
    System.out.println(Math.sqrt(9.1)); // 3.0166206257996713
    System.out.println(Math.sqrt(-9.0)); // double -> NaN

    System.out.println("ceil=" + Math.ceil(3.1)); // 4
    System.out.println("floor=" + Math.floor(3.7)); // 3

    double radian = 3.3333;
    double sinValue = Math.sin(radian);
    double cosValue = Math.cos(radian);
    double tanValue = Math.tan(radian);

    // Find Max value in an int array
    int[] arr = new int[] {10, 4, 20, 3};

    int maxx = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      maxx = Math.max(arr[i], maxx);
    }
    System.out.println("max=" + maxx); // 20


  }
}
