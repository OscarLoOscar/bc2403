import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ball implements Comparable<Ball> {
  private Color color;
  private double size;

  public Ball(Color color, double size) {
    this.color = color;
    this.size = size;
  }

  public double getSize() {
    return this.size;
  }

  public Color getColor() {
    return this.color;
  }

  @Override
  public int compareTo(Ball b) {
    // this, b -> int
    // -1 means (this) object move to left
    // return this.color == Color.YELLOW ? -1 : 1;
    // return this.size > b.getSize() ? -1 : 1;
    if (this.color == Color.YELLOW)
      return -1;
    if (this.color.name().charAt(0) > b.getColor().name().charAt(0))
      return -1;
    else if (this.color.name().charAt(0) < b.getColor().name().charAt(0))
      return 1;
    return this.size > b.getSize() ? -1 : 1;
  }

  @Override
  public String toString() {
    return "Ball(" //
        + "size=" + this.size //
        + ", color=" + this.color //
        + ")";
  }

  public static void main(String[] args) {
    List<Ball> balls = new LinkedList<>();
    balls.add(new Ball(Color.BLACK, 10.3));
    balls.add(new Ball(Color.YELLOW, 2.0d));
    balls.add(new Ball(Color.YELLOW, 3.2d));
    balls.add(new Ball(Color.RED, 7.4d));
    balls.add(new Ball(Color.RED, 2.4d));
    Collections.sort(balls); // Compile-time Check if the list of the objects implements a contract "Comparable"
    System.out.println(balls);
    // [Ball(size=3.2, color=YELLOW), Ball(size=2.0, color=YELLOW), Ball(size=7.4, color=RED), Ball(size=2.4, color=RED), Ball(size=10.3, color=BLACK)]
  }
}
