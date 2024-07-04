public record Person(String name, int age) {

  public static int x = 10;

  public static int getX() {
    return x;
  }

  // You can @Override the default implemented method getter, equals(), hashCode(), toString()
  @Override
  public String name() {
    return "hello";
  }
  
  public static void main(String[] args) {
    // Only one constructor - all args
    Person p1 = new Person("Vincent", 13);
    Person p2 = new Person("Vincent", 13);

    System.out.println(p1.equals(p2)); // true
    System.out.println(p1.hashCode() == p2.hashCode()); // true
    System.out.println(p1.toString()); // Person[name=Vincent, age=13]

    // getter
    System.out.println(p1.name()); // getter, Skip "get"
    System.out.println(p1.age());

    // no setter
  }
}
