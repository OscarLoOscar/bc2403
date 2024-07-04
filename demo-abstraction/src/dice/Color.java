package dice;

public enum Color {

  RED(1), YELLOW(2), BLACK(3), WHITE(4), PINK(5), BLUE(6);

  private Color(int value) {
    this.value = value;
  }

  private int value;

  public int getValue() {
    return this.value;
  }

}
