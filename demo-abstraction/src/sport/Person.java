package sport;

public class Person implements Action {
  
  @Override
  public void run() {
    System.out.println("run ....");
  }

  @Override
  public void walk() {
    System.out.println("walk ....");
  }

  // You can still Override the default method in Interface
  @Override
  public void swim() {
    System.out.println("Person is swimming ...");
  }

  public void cry() {
    System.out.println("Person is crying ...");
  }

  public static void main(String[] args) {
    Action a = new Person();
    // a.cry(); // compile error, Action Type does not have cry() method.
    Person p = null;
    if (a instanceof Person) {
      p = (Person) a;
      p.cry();
    }
    p.cry();

  }
}
