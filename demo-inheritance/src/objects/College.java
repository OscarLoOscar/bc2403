package objects;

import java.util.Objects;

public class College {

  private double area;

  public double getArea() {
    return this.area;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof College))
      return false;
    College c = (College) obj;
    return Objects.equals(this.area, c.getArea());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.area);
  }

  @Override
  public String toString() {
    return "College(" //
        + "area=" + this.area //
        + ")";
  }

  public static void main(String[] args) {
    Object o = new College(); // Polymorphism
    // College c = new Object(); // NOT OK
    // College c = new College(); // OK
    System.out.println(o.hashCode()); // 31, address -> int
    System.out.println(new College().hashCode()); // 31, after @Override the hashCode()
    System.out.println(o.equals(new College())); // true, after @Override the equals()

    if (o instanceof College) { // ask if o is an object of College.class, instanceof -> true/false
      College c2 = (College) o;
    }

    Class<?> s = o.getClass();
    System.out.println(s.getName()); // return package String -> objects.College

    System.out.println(o.getClass().getName());

    String str = "ABC";
    System.out.println(str.hashCode()); // 64578

    StringBuilder sb = new StringBuilder("hello");
    StringBuilder sb2 = new StringBuilder("hello");
    System.out.println(sb.equals(sb2)); // false
    System.out.println(sb.compareTo(sb2)); // 0

    System.out.println(o); // College(area=0.0)


  }
}
