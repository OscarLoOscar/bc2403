import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import javax.swing.text.html.Option;

public class App {
  public static void main(String[] args) {
    System.out.println(upperName("Steven")); // Optional[STEVEN]
    System.out.println(upperName("Steven").get()); // STEVEN
    System.out.println(upperName(null)); // Optional.empty

    // Optional.of(null); // NPE

    // 1. ifPresent()
    Optional<String> result = upperName(null);

    result.ifPresent(e -> {
      System.out.println("hello " + e.charAt(0)); // e -> T (String.class)
    });

    upperName("Steven").ifPresent(e -> {
      System.out.println("hello " + e.charAt(0));
    });

    // 2. isPresent()
    Optional<String> name = Optional.of("Vincent");
    if (name.isPresent()) {
      System.out.println("example2=" + name.get().charAt(0)); // No risk on NPE
    } else {
      System.out.println("example2=" + name); // Optional.empty -> you cannot call get()
    }

    // 3. orElse
    name = Optional.ofNullable(null);
    String user = name.orElse("Jenny"); // T
    System.out.println("user=" + user); // Jenny

    // 4. orElseGet
    String user2 = name.orElseGet(() -> "Jenny"); // Supplier<T>
    System.out.println("user2=" + user2); // Jenny

    // 5. orElseThrow
    // String user3 = name.orElseThrow(() -> new RuntimeException());
    // System.out.println(user3); // throw runtime

    // 6. stream and optional
    Cat cat = List
        .of(new Cat(3, "Vincent"), new Cat(6, "Oscar"), new Cat(10, "Vincent"),
            new Cat(4, "Tommy")) //
        .stream() //
        .filter(e -> "Vincent".equals(e.getName())) //
        .findFirst() // Optional<Cat>
        .orElse(new Cat(0, "Vincent")); // Cat

    System.out.println(cat.getAge()); // 3

    List.of(new Cat(3, "Vincent"), new Cat(6, "Oscar"), new Cat(10, "Vincent"),
        new Cat(4, "Tommy")) //
        .stream() //
        .filter(e -> "Vincent".equals(e.getName())) //
        .findFirst() //
        .ifPresent(e -> {
          System.out.println(e.getAge()); // 3
        });

    // Method Reference
    Function<String, Integer> stringToInteger = Integer::valueOf; // Integer::new
    Integer number = stringToInteger.apply("123");
    System.out.println(number);

  }

  public static Optional<String> upperName(String name) {
    // if (name == null)
    // throw new IllegalArgumentException();
    if (name != null)
      return Optional.of(name.toUpperCase());
    return Optional.empty(); // optional object, with null inside
  }
}
