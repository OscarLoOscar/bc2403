public class DemoMethod {

  // static method
  // void is a return type, representing it should not return anything.
  public static void main(String[] args) {
    System.out.println("hello");
    // 1 + 3 = ?
    // 2 + 5 = ?
    int result = 1 + 3;
    int result2 = 2 + 5;

    // call method
    result = sum(1, 3);
    result2 = sum(2, 5);

    sum(1.3, 1.4); //
    System.out.println(sum("1", "3")); // 4

    Integer m = 3; // autobox
    Integer n = 4; // autobox
    if (m > n) { // wrong (concept)

    }
    if (m.compareTo(n) > 0) { // check if m > n

    }

    // radius -> Circle area
    double area = area(3.2d);
    double area2 = area("Circle", 3.2d);
    double area3 = area("Square", 3.2d);
    double area4 = calculate("Circle", "area", 3.2d);
    double area5 = calculate("Square", "area", 3.2d);
    double perimeter1 = calculate("Circle", "perimeter", 3.2d);
    double perimeter2 = calculate("Square", "perimeter", 3.2d);

    // Adult
    int age = 18;
    if (age >= 18) {

    }
    boolean isAdult = isAdult(age);

  }

  // static method
  // "sum" is a method name
  // "(int x, int y)" is declaration of input parameters for methods
  // "int" is also a return type.
  // keyword "return" : for all non-void scenario
  public static int sum(int x, int y) {
    int z = x + y;
    return z;
  }

  // subtraction
  public static int substract(int x, int y) {
    // int z = x - y;
    // return x - y; // int value - int value -> int value
    System.out.println(x + y);
    return x + y;
  }

  // Method Definition: Method Name + Input Parameters (type & no. of parameter)
  public static double sum(double x, double y) {
    return x + y; // double value + double value -> double value
  }

  public static double sum(double x, int y) {
    return x + y; // double value + int value -> double value
  }

  public static double sum(int x, double y) {
    return x + y; // int value + double value -> double value
  }

  public static int sum(String x, String y) {
    // Integer z = Integer.valueOf(x) + Integer.valueOf(y); // convert String to Integer
    // Integer Object -> int value
    return Integer.valueOf(x) + Integer.valueOf(y); // Integer + Integer -> int + int -> int
  }

  public static double area(double radius) {
    return radius * radius * Math.PI; // bug
  }

  public static double area(String s, double x) {
    // if (...) return different formula
    // double area = -1.0;
    if ("Circle".equals(s)) {
      return x * x * Math.PI;
    } else if ("Square".equals(s)) {
      return x * x;
    }
    return -1.0d;
  }

  public static double calculate(String shape, String target, double x) {
    if ("area".equals(target)) {
      if ("Circle".equals(shape)) {
        return Math.pow(x, 2) * Math.PI;
      } else if ("Square".equals(shape)) {
        return Math.pow(x, 2);
      }
    } else if ("perimeter".equals(target)) {
      if ("Circle".equals(shape)) {
        return x * 2 * Math.PI;
      } else if ("Square".equals(shape)) {
        return x * 4;
      }
    }
    return -1.0d;
  }

  public static boolean isAdult(int age) {
    // Approach 1:
    // if (age >= 18)
    //   return true;
    // return false;

    // Approach 2:
    // return age >= 18 ? true : false;

    // Approach 3:
    return age >= 18;
  }



}
