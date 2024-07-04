public class StringPrinter {

  private String data;

  public StringPrinter(String data) {
    this.data = data;
  }

  public void setData(String s) {
    this.data = s;
  }

  public void print() {
    System.out.println(this.data);
  }

  public String toString() {
    return "StringPrinter(" //
        + "data=" + this.data //
        + ")";
  }

  public static void main(String[] args) {
    StringPrinter sp = new StringPrinter("hello");
    sp.print();
  }
}
