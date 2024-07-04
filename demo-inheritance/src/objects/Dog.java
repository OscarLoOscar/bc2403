package objects;

public class Dog {

  private int id;
  
  private Color color;

  public Dog(int id, Color color) {
    this.id = id;
    this.color = color;
  }

  public Color getColor() {
    return this.color;
  }

  public int getID() {
    return this.id;
  }
}
