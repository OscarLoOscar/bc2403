package staticblock;

public class Student {

  public static final String collegeName;
  public static String abc = initialize();

  // instance variable
  private String name;

  public static String initialize() {
    System.out.println("initialize()");
    return "hello";
  }

  // static block
  static {
    System.out.println("static block");
    collegeName = "ABC";
    abc = "world";
  }

  // instance block
  {
    System.out.println("instance block");
    this.name = "John";
  }
  
  public Student(String name) {
    System.out.println("Constructor");
    if (name != null) {
      this.name = name;
    }
  }

  public static void main(String[] args) {
    System.out.println("main start");
    Student s = new Student("Jenny");
    Student s2 = new Student("Sally");
    System.out.println("abc=" + abc); // world
    System.out.println("main end");

    // static block
    // main start
    // Constructor
    // main end
  }


}
