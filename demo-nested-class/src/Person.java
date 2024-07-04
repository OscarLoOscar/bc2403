public class Person {
  void read() {
    System.out.println("I'm reading...");
  }

  public static void main(String[] args) {
    Person p1 = new Person();

    p1.read();

    Person p2 = new Person() {
      @Override
      public void read() {
        System.err.println("I'm reading 2 ...");
      }
    };

    p2.read();
  }
}
