import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DemoDS {
  public static void main(String[] args) {
    Map<String, StringPrinter> map = new HashMap<>();
    StringPrinter sp = new StringPrinter("hello");
    StringPrinter sp2 = new StringPrinter("world");
    map.put("a", sp);
    map.put("b", sp2);

    Queue<StringPrinter> qs = new LinkedList<>();
    qs.add(sp);
    qs.add(sp2);

    // StringPrinter sp3 = new StringPrinter("xxx");
    // map.put("b", sp3); // key exists, replace value
    sp2.setData("xxx");
    map.get("b").setData("zzz");
    System.out.println(map.size()); // 2
    System.out.println("qs=" + qs); // [StringPrinter(data=hello), StringPrinter(data=zzz)]
  }
}
