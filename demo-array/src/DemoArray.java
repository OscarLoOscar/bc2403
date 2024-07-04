import java.util.Arrays;

public class DemoArray {
  public static void main(String[] args) {
    // 9 types = Primitives + String
    int x = 2;
    String s = "abc";

    // Array 陣列 (Store a set of same type of values)
    int[] arr = new int[3];
    // Assign value to the int array
    arr[0] = 100;
    arr[1] = 2;
    arr[2] = -20000;
    // arr[3] = 100;
    // arr[-1] = 100;
    System.out.println(arr[0]); // 100
    System.out.println(arr[1]); // 2
    System.out.println(arr[2]); // -20000

    // Create another int array to the original variable
    arr = new int[4];
    System.out.println(arr[0]); // 0
    System.out.println(arr[1]); // 0
    System.out.println(arr[2]); // 0
    System.out.println(arr[3]); // 0

    arr[0] += 10; // 10
    arr[0] *= 2; // 20
    System.out.println(arr[0]); // 20

    long[] arr2 = new long[10];

    String[] strings = new String[3]; // String array object
    strings[0] = "abc";
    strings[1] = "hello";
    strings[2] = "xyz";
    strings[0] += "def";

    // strings[0] -> an address pointing to a String object
    System.out.println(strings[0]); // "abcdef"

    strings[1] = strings[2];
    System.out.println(strings[1]); // "xyz"

    String[] backup = strings; // assign the address of original array to another array variable

    strings = new String[4];
    strings[1] = "mvn";
    System.out.println(strings[0]); // null
    System.out.println(strings[2]); // null
    System.out.println(strings[3]); // null

    if ("abcdef".equals(strings[0])) {

    }

    int[] integers = new int[10];
    // default value of int is 0
    System.out.println(integers[3]); // 0

    // default value of double is 0.0
    // default value of boolean is false
    // default value of char is '\u0000'

    char c3 = 'a'; // 97
    System.out.println(c3); // a
    System.out.println(c3 > 97); // false
    System.out.println(c3 > 96); // true

    if (c3 == 97) {
      System.out.println("c3 is 97 in ASCII");
    }

    if (c3 == 'a') { // 'a' convert to int (ASCII code)
      System.out.println("c3 is char a");
    }

    if (c3 >= 'a') { // 'a' convert to int (ASCII code)
      System.out.println("c3 >= 97");
    }

    long l = 2200000000L;
    // int x2 = l; // compile time error
    int x2 = (int) l; // You pick the risk.
    System.out.println("x2=" + x2); // -2094967296

    short s2 = 128;
    byte b = (byte) s2;
    System.out.println("b=" + b); // -128 (risk: overflow)

    // The ways to declare and assign String value
    String s3 = "abc"; // "abc" is a string object in heap
    String s4 = new String("abc"); // this "abc" is another new string object in heap
    String s5 = "abc"; // this "abc" object is same as the one in s3.
    String s6 = new String("abc"); // this "abc" is another new string object

    //
    String[] strings2 = new String[3];
    strings2[0] = "hello";
    strings2[1] = "hello";
    strings2[2] = "hello";
    String[] strings3 = new String[] {"hello", "hello", "hello"}; // imply the length = 3
    String[] strings4 = {"hello", "hello", "hello"}; // imply you have to assign an string array object

    for (int i = 0; i < strings2.length; i++) { // 0,1,2
      System.out.println(strings2[i]);
    }

    // Example 1
    int[] integers2 = new int[] {1, 2, 3, 4, 5, 6, 7};
    // loop: print odd numbers
    for (int i = 0; i < integers2.length; i++) {
      if (integers2[i] % 2 == 1) {
        System.out.println(integers2[i]);
      }
    }

    // average value of even numbers
    int total = 0;
    int count = 0;
    for (int i = 0; i < integers2.length; i++) { // 100000
      if (integers2[i] % 2 == 0) {
        total += integers2[i];
        count++;
      }
    }
    double avg = total / count;
    // System.out.println(total / integers2.length);
    System.out.println(avg);

    // Find the max value within the int array
    int max = Integer.MIN_VALUE; // the min. value of int
    for (int i = 0; i < integers2.length; i++) {
      if (integers2[i] > max) {
        max = integers2[i];
      }
    }
    System.out.println("max=" + max); // 7

    // Find the min value within the int array
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < integers2.length; i++) {
      if (integers2[i] < min) {
        min = integers2[i];
      }
    }
    System.out.println("min=" + min); // 1

    // Searching
    char[] characters = new char[] {'a', 'b', 'e', '!'};
    // check if the array contains char '!' -> true/ false
    boolean result = false;
    // break
    for (int i = 0; i < characters.length; i++) {
      if (characters[i] == '!') {
        result = true;
        break;
      }
    }
    System.out.println(result);

    // print out the first index of '!', if not found, print -1.
    int index = -1;
    for (int i = 0; i < characters.length; i++) {
      if (characters[i] == '!') {
        index = i;
        break;
      }
    }
    System.out.println(index);

    // Store all index of '!' in another array
    char[] characters2 = new char[] {'a', 'b', '!', 'e', '!'};
    int[] indexes = new int[characters2.length];
    int j = 0;
    for (int i = 0; i < characters2.length; i++) {
      if (characters2[i] == '!') { // condition
        indexes[j] = i;
        j++;
      }
    }
    System.out.println(Arrays.toString(indexes)); // [2, 4, 0, 0, 0]

    //
    String[] balls = new String[] {"RED", "YELLOW", "BLACK", "YELLOW"};
    double[] prices = new double[] {5.5, 7.8, 10.0, 7.8};
    int[] quantities = new int[] {1, 3, 4, 5};
    // Find the total amount of Yellow balls (price * quantity)
    double amount = 0.0;
    for (int i = 0; i < balls.length; i++) {
      if ("YELLOW".equals(balls[i])) {
        amount += prices[i] * quantities[i]; // double value * int value -> double value
      }
    }
    System.out.println(amount); // 7.8 * 3 + 7.8 * 5 = 62.4

    // Swapping
    int[] arr3 = new int[] {10, 3, 9, 4};
    int temp = arr3[0];
    arr3[0] = arr3[2];
    arr3[2] = temp;
    System.out.println(Arrays.toString(arr3)); // [9,3,10,4]

    // Now: [9, 3, 10, 4]
    // Target: [3, 10, 4, 9]
    // Move the first element to the tail: loop + swap
    int t = -1;
    for (int i = 0; i < arr3.length - 1; i++) {
      t = arr3[i];
      arr3[i] = arr3[i + 1];
      arr3[i + 1] = t;
    }
    System.out.println(Arrays.toString(arr3));

    // Now: [3, 10, 4, 9]
    // Target: [10, 3, 4, 9]
    // Move the max value to the head of the array
    int max2 = Integer.MIN_VALUE;
    int idx = -1;
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i] > max2) {
        max2 = arr3[i];
        idx = i;
      }
    }
    // idx -> 1
    for (int i = idx; i > 0; i--) {
      t = arr3[i];
      arr3[i] = arr3[i - 1];
      arr3[i - 1] = t;
    }
    System.out.println(Arrays.toString(arr3)); // [10, 3, 4, 9]

    // Sorting - Bubble Sort
    int[] arr4 = new int[] {-10, -42, 8, 19, 1};
    // Round 1:
    // [-42, -10, 8, 19, 1] : -10 > -42
    // [-42, -10, 8, 19, 1] : 8 > -10
    // [-42, -10, 8, 19, 1] : 19 > 8
    // [-42, -10, 8, 1, 19] : 19 > 1
    // Round 2:
    // [-42, -10, 8, 1, 19] : -10 > -42
    // [-42, -10, 8, 1, 19] : 8 > -10
    // [-42, -10, 1, 8, 19]: 8 > 1
    // Round 3:

    // Target: [-42, -10, 1, 8, 19]
    for (int i = 0; i < arr4.length - 1; i++) { // 0,1,2,3,4
      for (int k = 0; k < arr4.length - i - 1; k++) {
        if (arr4[k] > arr4[k + 1]) {
          t = arr4[k];
          arr4[k] = arr4[k + 1];
          arr4[k + 1] = t;
        }
      }
    }
    System.out.println(Arrays.toString(arr4));

    // Sorting - Insertion sort
    int[] arr5 = new int[] {100, -1, -5, 10};
    for (int i = 1; i < arr5.length; i++) { // 1
      int key = arr5[i]; // 10
      int k;
      for (k = i - 1; k >= 0; k--) { // OK
        if (arr5[k] <= key) {
          break;
        }
        // 1000 lines of code ...
        arr5[k + 1] = arr5[k];
      }
      arr5[k + 1] = key;
    }
    System.out.println(Arrays.toString(arr5)); // [-5, -1, 10, 100]

    // Sorting - Selection Sort
  }
}
