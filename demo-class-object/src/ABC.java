public class ABC {

  public static void main(String[] args) {
    System.out.println("hello");
    Car c = new Car(); // c -> object reference
    c.setColor("RED");
    c.setSpeed(80.0d);
    c.setCapacity(4);
    System.out.println("color=" + c.getColor()); // color=RED
    System.out.println("speed=" + c.getSpeed()); // color=RED
    System.out.println("capacity=" + c.getCapacity());
    System.out.println(c.toString()); // Car(color=RED, speed=80.0, capacity=4)

    Car c2 = new Car(); // c -> object reference
    c2.setColor("YELLOW");
    c2.setSpeed(100.0d);
    c2.setCapacity(5);

    c = new Car();

    Person p1 = new Person();

  }

}
