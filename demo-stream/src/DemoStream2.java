import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStream2 {
  public static void main(String[] args) {
    Stream<String> empty = Stream.empty(); // static method -> constructor -> new Stream object
    System.out.println(empty.count()); // 0

    Stream<String> strings = Stream.of("Hello", "abc"); // static method -> constructor -> new Stream object
    // filter, collect

    Stream<Integer> integers = Stream.iterate(1, n -> n + 2).limit(10); // ten numbers
    System.out.println(integers.collect(Collectors.toList()));

    strings = strings.filter(e -> e.length() > 3); // intermediate operation -> new Stream
    // .count(); // terminal operation
    // System.out.println(strings.collect(Collectors.toList())); // terminal operation -> [Hello]

    // stream -> forEach
    strings.forEach(e -> { // terminal operation
      System.out.println(e);
    });

    // sorted()
    List<Integer> integers2 =
        new ArrayList<>(List.of(400, 3, -1, 0, 100, -200));
    List<Integer> integers3 = integers2.stream() //
        .filter(e -> e.compareTo(0) >= 0) // >= 0
        .sorted() // interminate operation
        .collect(Collectors.toList());
    System.out.println(integers3);

    List<Customer> customers = new LinkedList<>(
        List.of(new Customer(13, "Vincent"), new Customer(18, "Tommy"),
            new Customer(15, "Jenny"), new Customer(17, "Jenny")));

    Comparator<Customer> sortByAgeDesc =
        (c1, c2) -> c1.getAge() > c2.getAge() ? -1 : 1;

    List<Customer> sortedCustomers = customers.stream() //
        .sorted(sortByAgeDesc) // Comparator object -> descending order for age
        .collect(Collectors.toList());

    System.out.println(sortedCustomers);

    // List<Customer> -> List<String>
    // Type change
    Map<Character, String> nameMap = customers.stream() //
        .map(c -> c.getName()) // type change: Customer -> String
        .filter(name -> name.startsWith("J")) // filter object
        .sorted() //
        .distinct() //
        .collect(Collectors.toMap(s -> s.charAt(0), s -> s));

    System.out.println(nameMap);


    Stream.of(1, 2, 3).map(i -> {
      System.out.println(i); // 1,2,3
      return i + 1;
    }).forEach(e -> System.out.println(e)); // 2,3,4
    // because map() is interminate operations, the map function will not be executed until terminal operation
    
    Stream.of(1, 2, 3).map(i -> {
      System.out.println(i); // 1,2,3
      return String.valueOf(i);
    }).count();
    // because map() won't affect the result of count, 
    // so Stream would NOT execute map function if the terminal operation is count()

  }
}
