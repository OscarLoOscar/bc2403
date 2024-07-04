package objects;

import java.time.LocalDate;

public class Staff { // 1. All class implicitly extends Topmost class "Object"

  private LocalDate joinDate;
  // 100 attributes

  public Staff(LocalDate joinDate) {
    this.joinDate = joinDate;
  }

  public LocalDate getJoinDate() {
    return this.joinDate;
  }

  // 2. Every class should implement/override its own toString() to represent its object values
  @Override
  public String toString() { 
    return "Staff(" //
        + "joinDate=" + this.joinDate //
        + ")";
  }

  public static void main(String[] args) {
    Object o = new Object();
    System.out.println(o.toString()); // java.lang.Object@7344699f

    Staff s = new Staff(LocalDate.now());
    System.out.println(s.toString()); // objects.Staff@659e0bfd
    // After adding toString(), print "Staff(joinDate=2024-04-17)"

    Staff s2 = new Staff(LocalDate.now());
    System.out.println(s2.toString()); // objects.Staff@2a139a55
    // After adding toString(), print "Staff(joinDate=2024-04-17)"

    System.out.println(s == s2); // false
    System.out.println(s.getJoinDate().compareTo(s2.getJoinDate())); // 0

    String str = "hello";
    System.out.println(str.toString()); // hello

    Integer i = 10;
    System.out.println(i.toString()); // "10"


  }

}
