public class Animal {

  public static String x = "abc";

  private String name;

  public Animal() {
    System.out.println("I'm Animal Constructor ...");
  }

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void sleep() {
    System.out.println("Sleeping ...");
  }

  public void run() {
    System.out.println("Running ...");
  }

  private void hello() {
    System.out.println("hello");
  }

  public String lowerY() {
    return Cat.y.toLowerCase();
  }

  public static void main(String[] args) {
    Cat c = new Cat(12); // I'm Animal Constructor ...
    Cat c2 = new Cat(4, "Vincent");
    System.out.println(c2.getName()); // Vincent

    Animal animal = new Animal();
    System.out.println(animal.lowerY()); // def
  }

}
