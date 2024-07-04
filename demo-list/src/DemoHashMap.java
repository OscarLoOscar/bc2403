import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoHashMap {
  public static void main(String[] args) {
    // John 13
    // Vincent 18
    HashMap<String, Integer> mapper = new HashMap<>(); // Left hand side: KEY, right hand side: Value
    mapper.put("John", Integer.valueOf(13)); // put an "entry" into map
    mapper.put("Vincent", 18);
    // no ordering.
    // Get Value by Key (We CANNOT get key by value)
    System.out.println(mapper.get("Vincent")); // 18
    System.out.println(mapper.get("John")); // 13

    // for-each
    for (Map.Entry<String, Integer> m : mapper.entrySet()) {
      System.out.println(m.getKey() + " " + m.getValue());
    }

    // Key cannot be duplciated in a HashMap
    // put -> update
    mapper.put("Vincent", 20);
    System.out.println(mapper.get("Vincent")); // 20

    mapper.put("Jenny", 24);
    // sum up all integers in the map
    int sum = 0;
    for (Map.Entry<String, Integer> map : mapper.entrySet()) {
      sum += map.getValue();
    }
    System.out.println("sum=" + sum);

    HashMap<Customer, Integer> ageMap = new HashMap<>();
    ageMap.put(new Customer("John"), 13);
    ageMap.put(new Customer("John"), 17);
    System.out.println(ageMap.get(new Customer("John"))); // null
    System.out.println(ageMap.size()); // 2

    //
    HashMap<Customer, ArrayList<Order>> orderMap = new HashMap<>();

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new Order(100));
    orders.add(new Order(250));

    orderMap.put(new Customer("John"), orders);

    ArrayList<Order> orders2 = new ArrayList<>();
    orders2.add(new Order(1200));
    orders2.add(new Order(20));
    orders2.add(new Order(88));

    orderMap.put(new Customer("Vincent"), orders2);
    // John -> order 1: 100, order 2: 250
    // Vincent -> order: 1200, order 2: 20, order 3: 88

    // totalOrderAmount=1658
    // entrySet()
    sum = 0;
    for (Map.Entry<Customer, ArrayList<Order>> entry : orderMap.entrySet()) { // entrySet() -> entry -> key and value
      for (Order o : entry.getValue()) {
        sum += o.getAmount();
      }
    }
    System.out.println("totalOrderAmount=" + sum);

    // values()
    sum = 0;
    for (ArrayList<Order> orderList : orderMap.values()) {
      for (Order o : orderList) {
        sum += o.getAmount();
      }
    }
    System.out.println("totalOrderAmount=" + sum);

    // keySet()
    for (Customer customer : orderMap.keySet()) {
        System.out.println("customer=" + customer.getName());
    }

    // containsKey(), containsValue()
    System.out.println(orderMap.containsKey(new Customer("Vincent"))); // false, why?

    // Conclusion:
    // 1. If they are Different Objects -> we can treat them as same thing (equals(), hashCode())
    // 2. if they are Same Object, -> all the values inside the object are same

    orderMap.put(new Customer("Sally"), orders); // same array objects with John

    // orders -> add an order

    // print out John and Sally orders

    HashMap<String, ArrayList<Order>> example1 = new HashMap<>();
    HashMap<Integer, ArrayList<Order>> example2 = new HashMap<>();

    orderMap.remove(new Customer("Vincent")); // With hashCode(), cannot remove by customer object
    System.out.println(orderMap);
  }
}
