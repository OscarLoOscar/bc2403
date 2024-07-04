import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoFlatMap {
  public static void main(String[] args) {
    List<List<Integer>> integerLists = new LinkedList<>();
    integerLists.add(List.of(1, 2, 3));
    integerLists.add(List.of(10, -10, 100, 101));
    integerLists.add(List.of(101, 203, -99));

    List<Integer> flattenedList = integerLists.stream() //
        .flatMap(e -> e.stream()) //
        .collect(Collectors.toList());

    System.out.println(flattenedList);

    // List<List<Integer>> -> List<Customer>
    List<Customer> customers = integerLists.stream() //
        .map(e -> new Customer(e.size(), "Vincent")) //
        .collect(Collectors.toList());
    System.out.println(customers);
  }
}
