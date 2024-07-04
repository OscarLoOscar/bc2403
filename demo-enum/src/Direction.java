public enum Direction { // class: when starting the java program, JVM new 4 objects (static final) of Direction

  // Finite number of values
  EAST(1, 'E'), //
  SOUTH(2, 'S'), //
  WEST(-1, 'W'), //
  NORTH(-2, 'N'), //
  ;

  private int value;
  private char c;

  // private Direction() {

  // }

  private Direction(int value, char c) {
    this.value = value;
    this.c = c;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public static Direction oppsite(Direction direction) {
    if (direction == null)
      return null;
    for (Direction d : Direction.values()) { // values() -> implicit static method
      System.out.println("hello " + d.getValue());
      if (direction.getValue() * -1 == d.getValue())
        return d;
    }
    return null;
  }

  public Direction oppsite() {
    for (Direction d : Direction.values()) {
      if (this.value * -1 == d.getValue())
        return d;
    }
    return null;
  }


  // You cannot create Direction object by yourself.

  public static void main(String[] args) {
    // check if the direction is EAST?
    House house = new House(Direction.EAST); // set an address of enum object
    house.setDirection(Direction.NORTH);

    System.out.println(house.getDirection() == Direction.EAST); // true

    System.out.println(Direction.NORTH.getValue()); // 4
    Direction.NORTH.setValue(5);
    System.out.println(Direction.NORTH.getValue());

    System.out.println(Direction.oppsite(Direction.WEST)); // Direction.EAST

    System.out.println(Direction.EAST.oppsite().name()); // "WEST"

    Direction direction = Direction.NORTH;
    int degree = getDirectionDegree(direction);
    System.out.println("degree=" + degree);

  }

  public static int getDirectionDegree(Direction direction) {
    int result = -1;
    switch (direction) {
      case NORTH:
        // return 360;
        result = 360;
        break;
      case EAST:
        // return 90;
        result = 90;
        break;
      case SOUTH:
        // return 180;
        result = 180;
        break;
      case WEST:
        // return 270;
        result = 270;
        break;
      default:
        return -1;
    }
    return result;
  }
}
