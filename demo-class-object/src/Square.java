public class Square {

  private int length;

  public void setLength(int length) {
    this.length = length;
  }

  public int getLength() {
    return this.length;
  }

  public int area() {
    return this.length * this.length; // Math.pow(this.length, 2)
  }

  public String toString() {
    return "Square(" //
        + "length=" + this.length //
        + ")";
  }
  
}
