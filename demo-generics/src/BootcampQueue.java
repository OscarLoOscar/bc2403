import java.util.LinkedList;
import java.util.Queue;

public class BootcampQueue<T> {

  private Queue<T> data;

  private Object data2;

  public BootcampQueue() {
    this.data = new LinkedList<>();
  }

  // add
  public void add(Object data2) { // s -> Integer or String or Customer ...
    this.data2 = data2;
  }

  public void add2(T data) { // s -> Integer or String or Customer ...
    this.data2 = data;
  }

  // poll
  public T poll() {
    return this.data.poll();
  }


  public static void main(String[] args) {
    BootcampQueue<String> bq = new BootcampQueue<>();
    bq.add2("hello");
    // bq.add2(3); // compile time type check

    bq.add(3);
    bq.add(3L);
    bq.add("llll");



  }
}
