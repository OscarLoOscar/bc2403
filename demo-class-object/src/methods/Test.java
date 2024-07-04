package methods;

public class Test {

  // Attribute/ Instance Variable
  private int v; // 0

  public Test(int v) {
    this.v = v;
  }
  
  public static void main(String[] args) {
    // / Staff s1 = new Staff("John"); // private constructor

    // Static Method
    Staff s2 = Staff.of("John");
    Staff s3 = Staff.peter();

    // Instance Method
    double salary = s3.getSalary(); // every Staff object has its own salary

    // instance, means object
    Test t = new Test(3);
    System.out.println(t.sum(1, 100)); // 101
    System.out.println(Test.sum2(1, 100)); // 101
    
    test2("hello", "world", "ccc");
    test2(new String[] {"hello", "world", "ccc"});
    test(new String[] {"hello", "world", "ccc"});
    // test("hello", "world", "ccc"); // NOT OK
  }

  // Instance method can access parameters + instance variable
  public int sum(int x, int y) { // method sum belongs to object
    return x + y;
  }

  // Static method can access parameters
  // but cannot access (read/write) instance variable (cannot use this here)
  public static int sum2(int x, int y) { // method sum2 belongs to Class
    return x + y;
  }

  public static void test(String[] arr) {

  }

  public static void test2(String... arr) {
    
  }

}
