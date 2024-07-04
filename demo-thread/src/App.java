public class App {
    public static void main(String[] args) throws Exception {
        // 3 threads
        // 1. main thread
        // 2. th1
        // 3. th2

        // Approach 1: A class to implement Runnable interface (Thread constructor)
        Task task = new Task();

        // Approach 2: Lambda to create a runnable object (Thread constructor)
        Runnable task2 = () -> {
          System.out.println("I'm task 2, and running ...");
        };

        // Approach 3: MyThread extends Thread
        MyThread myThread = new MyThread();
        myThread.start(); //MyThread is running ...
        
        Thread th1 = new Thread(task);
        th1.start(); // I'm a task, and running ...
        
        Thread th2 = new Thread(task2);
        th2.start(); // I'm a task 2, and running ...

        System.out.println("main ends ...");

    }
}
