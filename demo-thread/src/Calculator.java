public class Calculator {
  public static int x = 17;

  public synchronized static void addOne() {
    x++;
  }

  public static void main(String[] args) {
    Runnable incrementOne = () -> {
      for (int i = 0; i < 1_000_000; i++) {
        // Calculator.x++; // non thread-safe
        addOne();
      }
    };

    Thread th1 = new Thread(incrementOne);
    Thread th2 = new Thread(incrementOne);
    th1.start();
    th2.start();

    try {
      th1.join();
      th2.join();
    } catch (InterruptedException e) {

    }

    System.out.println(Calculator.x); // main thread, 17 or 18 or 19
  }
}
