public class Operator {
  public static void main(String[] args) {
    // increment
    int x = 1;
    x = x + 1; // x + 1 -> 1 + 1
    x = x + 1; // 3

    int y = 1;
    y++; // 2
    y++; // 3
    ++y; // 4
    y = y + 1; // 5
    y += 1; // 6, "+=" -> self + 1
    System.out.println(y);

    int e = 10;
    e--;
    --e;
    e = e - 1;
    e -= 1; // 6

    int predecrement = --e; // predecrement = 5
    System.out.println(predecrement); // 5

    int postdecrement = e--; // postdecrement = 5;
    System.out.println(postdecrement); // 5
    System.out.println(e); // 4

  }
}
