package bulitin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoFunction {
  public static void main(String[] args) {
    // y = f(x)
    // y = x + 1
    Function<String, Integer> function = s -> s.length();
    System.out.println(function.apply("Hello")); // 5

    BiFunction<String, String, Integer> totalLength =
        (s1, s2) -> s1.length() + s2.length();
    System.out.println(totalLength.apply("hello", "abc")); // 8

    // Why do we need to learn BiFunction
    Map<String, Integer> nameLengthMap = new HashMap<>();
    nameLengthMap.put("John", "John".length());

    Function<String, Integer> nameLength = s -> s.length();
    nameLengthMap.computeIfAbsent("Vincent", nameLength); // if "Vincent" does not exists -> nameLength
    nameLengthMap.computeIfAbsent("Oscar", s -> s.length() + 1); // can be different formula
    System.out.println(nameLengthMap);

    // merge()
    System.out.println(nameLengthMap.merge("Vincent", 9, (o, n) -> o * n)); // 7 * 9

  }
}
