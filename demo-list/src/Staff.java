import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Staff {

  private String name;

  public Staff(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Staff))
      return false;
    Staff staff = (Staff) obj;
    return Objects.equals(this.name, staff.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }

  @Override
  public String toString() {
    return "Staff(" //
        + "name=" + this.name //
        + ")";
  }

  public static void main(String[] args) {
    // Set is a data structure that ensures no duplicated elements is stored
    HashSet<Staff> staffs = new HashSet<>();
    staffs.add(new Staff("Vincent"));
    staffs.add(new Staff("Oscar"));
    System.out.println(staffs.size()); // 2
    System.out.println(staffs.isEmpty()); // false
    System.out.println(staffs);

    // add -> false
    System.out.println(staffs.add(new Staff("Vincent"))); // false
    System.out.println(staffs.size()); // 2

    HashSet<String> strings = new HashSet<>();
    strings.add("hello");
    strings.add("hello");
    System.out.println(strings.size()); // 1

    ArrayList<Integer> integers = new ArrayList<>();
    integers.add(100);
    integers.add(4);
    integers.add(100);
    integers.add(4);
    integers.add(44);
    System.out.println(integers); // [100, 4, 100, 4, 44]

    HashSet<Integer> integers2 = new HashSet<>();
    for (Integer x : integers) {
      integers2.add(x);
    }
    System.out.println(integers2); // [100, 4, 44]

    integers2.remove(new Integer(100));
    System.out.println(integers2); // [4, 44]
    System.out.println(integers2.contains(new Integer(44))); // true

  }
}
