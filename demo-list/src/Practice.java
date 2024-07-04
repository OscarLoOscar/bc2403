import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Practice {
  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(2);
    integers.add(2);
    integers.add(2);
    integers.add(3);
    integers.add(3);
    integers.add(1);
    System.out.println(getDuplicated(integers)); // [2, 3]
  }

  public static Set<Integer> getDuplicated(List<Integer> integers) { // 2,2,2,3,3,1 -> 2,3
    // Map
    Set<Integer> results = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (Integer x : integers) {
      if (map.containsKey(x)) {
        results.add(x);
        continue;
      }
      map.put(x, null);
    }
    return results;
  }
}
