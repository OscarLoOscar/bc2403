package methods;

import java.util.Arrays;

public class Square {

  private int length;

  public Square(int length) {
    this.length = length;
  }

  public int getLength() {
    return this.length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int area() {
    return this.length * this.length;
  }

  public static void resize(Square square, int newLength) {
    square.setLength(newLength);
    // return square;
  }

  public static int sum(int x, int y) {
    return x + y;
  }

  public static String concat(String x, String y) {
    return x + y;
  }

  public static void addOne(short[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (short) (arr[i] + 1); // short + int -> int (cannot assign int value to short variable)
    }
  }

  public static void xxx(Square square) {
    square = new Square(3);
  }

  public static void main(String[] args) {
    // pass by value -> primitives, wrapper classes object, String object
    // pass by reference -> all types of array object, custom class object

    int a = 4;
    int b = 7;
    int r1 = sum(a, b); // passing copy of values of a and b
    // after sum(), a = 4, b = 7, r1 = 11

    Integer q = 10;
    Integer e = 11;
    int r2 = sum(q, e); // passing copy of values of q and e
    // after sum(), q = 10, e = 11, r2 = 21

    String s1 = "hello";
    String s2 = "world";
    String r3 = concat(s1, s2); // passing copy of values of s1 and s2
    // after concat(), s1 = "hello", s2 = "world", r3 = "helloworld"

    short[] arr1 = new short[] {3, 4, 9};
    addOne(arr1); // passing copy of reference of arr1
    System.out.println(Arrays.toString(arr1));
    // after addOne(), [4, 5, 10], arr1 is still pointing to the original object

    Square sq1 = new Square(10);
    resize(sq1, 20); // passing copy of reference of sq1
    System.out.println(sq1.area()); // 400

    Square sq2 = new Square(9);
    xxx(sq2);
    System.out.println(sq2.area()); // 81
  }

}
