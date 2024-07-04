public class BootcampException extends Exception {
  // "extends Exception" implies "BootcampException" is a checked exception
  // because Exception.class is a checked exception

  public static void main(String[] args) { // throw JVM
    try {
      calculate(10, 2);
      System.out.println("End of Calculate() method");
    } catch (BootcampException e) {
      System.out.println("Exception in calculate() method, recovery step ...");
    } finally {
      System.out.println("finally ...");
    }

  }

  public static int divide(int x, int y) {
    return x / y; // if y = 0, JVM will throw an object of ArithmeticException
  }

  public static void calculate(int x, int y) throws BootcampException { // Solution 1
    try {
      divide(x, y);
      // .... throw  IAE
    } catch (ArithmeticException | IllegalArgumentException e) {
      throw new BootcampException(); 
      // because it is a checked exception, so we have to handle it before compilation
    }
  }

}
