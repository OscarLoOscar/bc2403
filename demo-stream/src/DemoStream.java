import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DemoStream {
  public static void main(String[] args) {
    List<Integer> integers = new LinkedList<>();
    integers.add(21);
    integers.add(44);
    integers.add(100);
    integers.add(101);

    // List of Odd number
    List<Integer> odds = new ArrayList<>();
    for (Integer number : integers) {
      if (number % 2 == 1)
        odds.add(number);
    }
    System.out.println(odds); // [21, 101]

    // Stream
    List<Integer> result = integers.stream() // List<Integer> -> Stream<Integer>
        .filter(e -> e % 2 == 1) // Stream<Integer>
        .collect(Collectors.toList()); // List<Integer> (new)
    System.out.println(result); // [21, 101]

    List<Integer> result2 = integers.stream() //
        .filter(e -> e % 2 == 1) //
        .filter(e -> e > 100) //
        .collect(Collectors.toList());
    System.out.println(result2); // [101]

    List<Integer> result3 = integers.stream() //
        .filter(e -> e % 2 == 1 && e > 100) //
        .collect(Collectors.toList());

    List<Integer> integers2 = new LinkedList<>(List.of(101, 101, 203, 200));
    // remove duplicated -> Set
    List<Integer> result4 = integers2.stream() //
        .distinct() //
        .collect(Collectors.toList());
    System.out.println(result4);

    // counting
    long size = integers2.stream() //
        .filter(e -> e < 200).distinct() //
        .count();
    System.out.println(size); // 1

    //
    List<Customer> customers = new LinkedList<>(
        List.of(new Customer(13, "Jenny"), new Customer(18, "Vincent")));


    List<Customer> adultCustomers = customers.stream() // -> new Stream<Customer>
        .filter(e -> e.getAge() >= 18) //
        .collect(Collectors.toList()); // -> new ArrayList() -> existing Customer Vincent

    System.out.println(customers);
    System.out.println(adultCustomers);

    customers.get(1).setAge(19); // updating customers -> adultCustomers has been updated

    System.out.println(customers);
    System.out.println(adultCustomers);

    String[] strings = new String[] {"abc", "Akjf", "a", "bcd", "aaa"};
    // stream -> startsWith "a"

    Arrays.asList(strings); // fixed size list -> do not support add/remove,etc

    List<String> startsWitha = Arrays.asList(strings).stream() //
        .filter(e -> e.startsWith("a")) //
        .collect(Collectors.toList());
    System.out.println(startsWitha);

    // list -> array
    String[] arr = startsWitha.stream() //
        .toArray(s -> new String[s]);
    System.out.println(Arrays.toString(arr));
  }

  public static List<Integer> getOdds(List<Integer> integers) {
    return integers.stream() //
        .filter(e -> e % 2 == 1) //
        .collect(Collectors.toList());
  }
}
