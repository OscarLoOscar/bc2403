public class Test {
  public static void main(String[] args) {
    Car car = new Car(); // still work, because the class "Car" is public
    car.setSpeed(100.0d);
    System.out.println(car.getColor()); // null
    System.out.println(car.getCapacity()); // 0
    
    if (car.isOverSpeed()) { // car.isOverSpeed() == true

    }
    
    // int[] integers = null;
    // integers[0] = 1; // null pointer exception

    // int x = null;
    Integer x2 = null;
    String s2 = "hello"; // char[] -> 'h' 'e' 'l' 'l' 'o'

    boolean b1 = false;
    System.out.println(b1); // initialization before use
    
  }
}
