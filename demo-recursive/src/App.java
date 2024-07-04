public class App {
  public static void main(String[] args) throws Exception {

    int result = 1;
    for (int i = 1; i <= 5; i++) {
      result *= i;
    }
    System.out.println(result);

    System.out.println(multiply(5));

    // 2 + 4 + 6 + 8 + 10 ... + 98 + 100

    System.out.println(addEven(100));


    // fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
    // n = 1 -> 0
    // n = 4 -> 2
    // n = 7 -> 8
  }

  public static int addEven(int n) {
    if (n <= 2)
      return n;
    return n + addEven(n - 2);
  }

  public static int multiply(int n) {
    // base case (exit criteria)
    if (n <= 1)
      return n;
    return n * multiply(n - 1); 
    // 5 * (5 - 1) -> waiting 1 release 4 (when we put (5-1) to muliply(), we are waiting an int value returned)
      // 4 * (4 - 1) -> waiting 2 release 3
        // 3 * (3 - 1) -> waiting 3  release 2
          // 2 * (2 - 1) -> waiting 4 release 1
            // 1 -> return 1
  }
}
