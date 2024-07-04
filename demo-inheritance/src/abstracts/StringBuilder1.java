package abstracts;

public class StringBuilder1 {
  
  private String s;

  public StringBuilder1(String s) {
    this.s = s;
  }

  public char charAt(int index) {
    return s.charAt(index);
  }

  public static void main(String[] args) {
    StringBuilder1 sb1 = new StringBuilder1("hello");
    char c = sb1.charAt(2);
  }

}
