public class StaticNested {
  void print() {
    System.out.println("hello");
  }

  public static void main(String[] args) {
    StaticNested o = new StaticNested();
    o.print();
  }
}
