public class Outer {
  private int x = 10;

  private static int y = 100;

  public int getX() {
    return this.x;
  }

  public static int getY() {
    return y;
  }

  public void print() {
    class LocalInner { // 2b. Local Inner Class
      int x;
      LocalInner(int x) {
        this.x = x;
      }
      void print() {
        System.out.println("hello3" + this.x);
      }
    }
    LocalInner li = new LocalInner(20);
    li.print(); // 20
  }

  public static class StaticNested { // 1. Static Nested Class (Static member of Outer Class)
    void print() {
      System.out.println("hello " + y);
      // System.out.println("hello " + x); // cannot access outer object instance variable x
    }
  }

  public class Inner { // 2. Inner Class (non-static) (Instance member of Outer Class)
    void print() {
      System.out.println("hello2" + x); // OK
      // System.out.println("hello2" + this.x); // NOT OK, because this -> Outer object
      System.out.println("hello2" + y); // OK
    }
  }

  public static void main(String[] args) {
    Outer o1 = new Outer();
    System.out.println(o1.x); // 10

    System.out.println(Outer.y); // 100

    Outer.getY();
    getY();

    Outer.StaticNested o2 = new Outer.StaticNested();
    o2.print(); // hello

    Outer o3 = new Outer();
    Outer.Inner o4 = o3.new Inner();
    o4.print(); // hello2

    Outer.Inner o5 = o3.new Inner();
    o5.print(); // hello2

    Outer o6 = new Outer();
    o6.print(); // hello3 20

    // before Java 8 (before lambda)
    Drivable vincent = new Drivable() {
      @Override
      public void drive() {
        System.out.println("I'm driving...");
      }
      @Override
      public void abc() {
        System.out.println("abc ...");
      }
    };

    vincent.drive(); // I'm driving...
    vincent.abc();
  }
}
