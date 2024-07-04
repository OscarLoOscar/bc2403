public class Dog {

  private String firstName;

  private String lastName;

  private int age;

  // Empty Constructor
  public Dog() {
    
  }

  // All arguments constructor
  public Dog(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public Dog(String firstName) {
    this.firstName = firstName;
    this.lastName = "Chan";
    this.age = 0;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  // public String getFirstName() {
  //   return this.firstName;
  // }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //  public String getLastName() {
  //   return this.lastName;
  // }

  public void setAge(int age) {
    this.age = age;
  }

  // public int getAge() {
  //   return this.age;
  // }

  public String fullName() {
    // return this.firstName + " " + this.lastName;
    return this.firstName.concat(" ").concat(this.lastName);
  }

  public String toString() {
    return "Dog(" //
        + "firstName=" + this.firstName //
        + ", lastName=" + this.lastName //
        + ", age=" + this.age //
        + ")";
  }

  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.setAge(8);
    dog.setFirstName("John");
    dog.setLastName("Lau");
    System.out.println(dog.toString()); // "Dog(firstName=John, lastName=Lau, age=8)"
    System.out.println(dog.fullName()); // "John Lau"
    dog.setFirstName("Vincent");
    System.out.println(dog.toString()); // "Dog(firstName=Vincent, lastName=Lau, age=8)"

    Square square = new Square();
    square.setLength(13);
    System.out.println(square.toString()); // "Square(length=13)"
    System.out.println(square.area()); // 169

    Dog dog2 = null;
    // dog2.setAge(4); // NPE: null pointer exception
    Dog dog3 = new Dog();
    dog3.setAge(15); // dog3 (address) -> find the dog object -> and then call its setAge() method

    Dog dog4 = new Dog("Ken", "Wong", 13);
    System.out.println(dog4.toString()); // Dog(firstName=Ken, lastName=Wong, age=13)

    Dog dog5 = new Dog("Jenny");
    System.out.println(dog5.toString()); // Dog(firstName=Jenny, lastName=Chan, age=0)

  }
}
