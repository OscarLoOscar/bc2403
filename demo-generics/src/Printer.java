public class Printer<T> {

  private T data;

  public Printer(T data) {
    this.data = data;
  }

  public void print() {
    System.out.println(data.toString()); // T -> Object.class
  }

  public static void main(String[] args) {
    Printer<String> ps = new Printer<>("hello");  // compile-time check
    ps.print(); // String.class -> toString()

    Printer<Integer> ip = new Printer<>(3);  // compile-time check
    ip.print();
  }
}
