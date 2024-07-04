public class Car {

  // Attributes
  private String color; // "RED", "YELLOW", "BLACK" ...

  private double speed;

  private int capacity;

  private boolean isOverSpeed; // false, useless -> we should use speed to derive isOverSpeed()

  // Behavior or instance methods
  // Setter
  public void setColor(String color) {
    this.color = color;
  }

  // Getter
  public String getColor() {
    return this.color;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
    if (speed > 90)
      this.isOverSpeed = true;
  }

  public double getSpeed() {
    return this.speed;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getCapacity() {
    return this.capacity;
  }

  // getter
  public boolean isOverSpeed() {
    return this.isOverSpeed;
  }

  public String toString() {
    return "Car(" //
        + "color=" + this.color //
        + ", speed=" + this.speed //
        + ", capacity=" + this.capacity //
        + ")";
  }

}
