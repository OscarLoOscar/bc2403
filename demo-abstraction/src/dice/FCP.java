package dice;

public enum FCP {
  FISH(4), CRAB(5), PRAWN(6);

  private int value;

  private FCP(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
