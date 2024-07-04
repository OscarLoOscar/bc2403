import java.util.Arrays;

public class DemoMethodArray {
  public static void main(String[] args) {
    double[] prices = new double[] {2.0, 3.2, 5.1};
    int[] quantities = new int[] {2, 4, 5};

    double totalAmount = total(prices, quantities);
    System.out.println("totalAmount=" + totalAmount); // 4 + 12.8 + 25.5

    //
    double amount = DemoMethodArray.total(prices, quantities);

    System.out.println(ABC.hello()); // "hello"

    String old = "he llo";
    String result = trimSpace(old); // pass by value
    System.out.println(old); // he llo
    System.out.println(result); // hello

    String[] ss = new String[] {"a a a  ", "bb b"};
    String[] ss2 = trimSpace(ss);
    System.out.println(Arrays.toString(ss2)); // [aaa, bbb]

    // pass by reference example
    String[] mm = new String[] {"a a a  ", "bb b"};
    trimSpace2(mm);
    System.out.println(Arrays.toString(mm)); // [aaa, bbb]
  }

  public static Integer sum(Integer x, Integer y) { // pass by value
    return x + y; // int + int -> int -> autobox
  }

  public static String trimSpace(String s) { // pass by value (a copy of the original stirng object)
    return s.replace(" ", "");
  }

  // return {"aaa", "bbb"}
  public static String[] trimSpace(String[] ss) { // pass by reference (address)
    String[] strings = new String[ss.length];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = ss[i].replace(" ", "");
    }
    return strings; // returning string array object address
  }

  public static void trimSpace2(String[] ss) { // pass by reference (address)
    for (int i = 0; i < ss.length; i++) {
      ss[i] = ss[i].replace(" ", "");
    }
  }

  // Method: totalAmount -> call subTotal()
  public static double total(double[] prices, int[] quantities) {
    double totalAmount = 0.0d;
    for (int i = 0; i < prices.length; i++) {
      totalAmount += subTotal(prices[i], quantities[i]);
    }
    return totalAmount;
  }

  // Method: subTotal(double price, int quantity)
  public static double subTotal(double price, int quantity) {
    return price * quantity; // double value * double value
  }

}
