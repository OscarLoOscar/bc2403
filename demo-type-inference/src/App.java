import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import javax.swing.text.html.Option;

public class App {
  public static void main(String[] args) {
    // Java 10
    String x = "hello";

    var x2 = "hello"; // compile-time: compiler knows x2 is with type String
    // String x2 = "hello"
    // x2 = 100;

    var age = 5;
    var name = "Vincent";
    var names = List.of("Vincent", "Oscar");

    for (var n : names) {
      System.out.println(n);
    }

    var d = new Dog();
    // var c;

    Predicate<String> isTooLong = s -> s.length() > 10;
    // var isTooLong2 = s -> s.length() > 10;

    // var arr = {1, 2, 3}; // int[] or double[] or ...
    var arr = new int[] {1, 2, 3};

    Optional<String> name2 = Optional.of("Vincent");
    String result = name2.orElse(getDefault());
    System.out.println(result);
  }

  public static String getDefault() {
    System.out.println("do invoke");
    return "default";
  }

  // Cannot Do in var

  // 1. return type
  // public static var print(int x) {
  // return x;
  // }

  // 2. instance variable
  // refer to Dog.class

  // 3. without initialization
  // var n;

  // 4. Lambda

  // 5. Array

  // 6. input parameter
  // public static int sum(var x, var y) {
  //   return x + y;
  // }
}
