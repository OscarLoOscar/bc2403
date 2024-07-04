import java.util.PriorityQueue;
import java.util.Queue;

public class DemoPriorityQueue {
  public static void main(String[] args) {
    Queue<Integer> integers = new PriorityQueue<>(); // by default ascending order
    integers.add(12);
    integers.add(5);
    integers.add(1000);
    integers.add(-2);
    System.out.println(integers); // [-2, 5, 1000, 12]
    System.out.println(integers.poll()); // -2, sorting
    System.out.println(integers.poll()); // 5, sorting
    System.out.println(integers.poll()); // 12, sorting
    System.out.println(integers); // [1000]
    System.out.println(integers.poll()); // 1000

    Queue<Integer> integers2 = new PriorityQueue<>(new SortByDescending());
    integers2.add(12);
    integers2.add(5);
    integers2.add(1000);
    integers2.add(-2);
    System.out.println(integers2);
    System.out.println(integers2.poll()); // 1000
    System.out.println(integers2.poll()); // 12
    System.out.println(integers2.poll()); // 5
    System.out.println(integers2.poll()); // -2

    

  }
}
