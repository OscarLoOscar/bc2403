import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class DemoDeque {
  public static void main(String[] args) {
    // Deque extends Queue
    Deque<String> strings = new LinkedList<>();
    strings.add("hello"); // addLast -> tail
    strings.add("abc");
    strings.addFirst("ijk"); // addFirst -> head
    System.out.println(strings); // [ijk, hello, abc]

    System.out.println(strings.poll()); // ijk, pollFirst()
    System.out.println(strings.pollLast()); // abc, poll the element from tail

    strings.add("world");
    System.out.println(strings.peek());  // hello
    System.out.println(strings.peekLast()); // world

    strings.pop(); // removeFirst()
    System.out.println(strings); // [world]
    strings.push("mmm"); // addFirst, [mmm, push]
    System.out.println(strings);

    // stack (pop, push)
    List<String> strings3 = new Stack<>(); // thread-safe
    strings3.add("hello");

    Stack<String> strings4 = new Stack<>();
    strings4.push("hello");
    strings4.push("hello2");
    strings4.push("hello3");
    System.out.println(strings4.pop()); // hello3

    // Stack Use Case: reverse
    
    // Queue/ Deque -> LinkedList or Array
    Queue<String> qs = new ArrayDeque<>(); // LinkedList / Array
    qs.add("hello");
    qs.add("abc"); // array -> resize
    System.out.println(qs.poll()); // hello

    qs.add("x");
    qs.add("y");
    qs.remove(); // abc
    System.out.println(qs); // [x, y]
    qs.remove("y");
    System.out.println(qs); // [x]

    Deque<String> ds = (Deque<String>) qs;
    ds.addLast("mnm");
    ds.addFirst("nmn");
    System.out.println(ds); // [nmn, x, mnm]

    System.out.println(qs); // [nmn, x, mnm]
    qs.add("ooo");
    qs.offer("kkk");
    System.out.println(qs);

    Deque<String> ds2 = new LinkedBlockingDeque<>(2);
    ds2.add("hello");
    ds2.add("world");
    System.out.println(ds2.size());
    // ds2.add("xxx"); // IllegalStateException: Deque full
    System.out.println(ds2.offer("yyy")); // false
    System.out.println(ds2);


  }
}
