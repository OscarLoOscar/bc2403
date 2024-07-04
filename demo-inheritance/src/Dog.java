public class Dog extends Animal {

  private Color color;

  public void setColor(Color color) {
    this.color = color;
  }

  public void bark() {
    System.out.println("Barking ...");
  }

  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.setColor(Color.BLACK);
    dog.setName("Sally");
    System.out.println(dog.getName()); // "Sally"

    System.out.println(dog.toString()); // Dog@7e9e5f8a
  }

  
}
