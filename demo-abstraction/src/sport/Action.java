package sport;

public interface Action {
  void run();
  void walk();
  // After Java 8
  default void swim() { // instance method by inheritance
    System.out.println("Default method: swim ...");
  };
  static void sleep() { // normal static method
    System.out.println("Static method: sleep ...");
  }

  public static void main(String[] args) {
    Action.sleep();
    Person p = new Person();
    p.swim();
    // p.sleep(); // NOT OK
  }
}
