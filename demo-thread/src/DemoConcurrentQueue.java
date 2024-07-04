import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DemoConcurrentQueue {
  
  static Queue<Character> characters = new ConcurrentLinkedQueue<>();

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    Runnable concatLinkedList = () -> {
      for (int i = 0; i < 10_000_000; i++) {
        characters.add('s');
      }
    };

    Thread th1 = new Thread(concatLinkedList);
    Thread th2 = new Thread(concatLinkedList);
    th1.start();
    th2.start();

    // 3 threads to 1 thread
    try {
      th1.join();
      th2.join();
    } catch (InterruptedException e) {

    }
    long endTime = System.currentTimeMillis();

    System.out.println(characters.size()); // 1354133
    // java.lang.ArrayIndexOutOfBoundsException

    System.out.println(endTime - startTime);
  }
}
