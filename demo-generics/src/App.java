import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    // Before Java 1.5 
    List ls = new ArrayList<>(); // Object[]
    ls.add("!");
    ls.add(123);
    ls.add(123L);
    ls.add(123.3d);
    System.out.println(ls); // [!, 123, 123, 123.3]

    System.out.println(((String) ls.get(0)).charAt(0)); // 
    
    for (Object o : ls) {
        if (o instanceof String) {
          String s = (String) o;
          System.out.println(s.concat("world"));
        } else if (o instanceof Long) {

        }
    }

    // After Java 1.5 -> Genercis
    List<Long> ll = new ArrayList<>();
    ll.add(3L);

    
  }
}
