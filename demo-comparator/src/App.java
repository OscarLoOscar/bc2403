import java.util.List;

public class App {

  public static int getX(List<String> strings) {
    return strings.size();
  }

  // Same Method Signatrue, becasue List<Integer> is same as List<String>, from input parameter perspective
  // public static int getX(List<Integer> strings) {
  //    return strings.size();
  // }

  public static void main(String[] args) throws Exception {
    System.out.println("Hello, World!");
  }
}
