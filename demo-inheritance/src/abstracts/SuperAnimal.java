package abstracts;

public abstract class SuperAnimal extends SuperObject { // 1. You cannot create an object for an abstract class SuperAnimal.

  private String name;

  // 2. Abstract class is still having constructor, even you cannot create an object for it.
  public SuperAnimal() { 
    // super();
  }

  public SuperAnimal(String name) {
    // super();
    this.name = name;
  }

  public abstract void eat(); // 3. Abstract method, but it is a method signatrue ONLY.
  // the child class has to implement it.

  // 4. Automatically inherits abstract method from parent abstract class
 
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void sleep() {
    System.out.println("Animal is sleeping ...");
  }

  public void run() {
    System.out.println("Animal is running ...");
  }

  public final void swim() {
    System.out.println("Animal is swimming ...");
  }

  public static void main(String[] args) {
    // SuperAnimal sa = new SuperAnimal();

  }
}
