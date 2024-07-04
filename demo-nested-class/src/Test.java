

public class Test {
  public static void main(String[] args) {
    Outer o1 = new Outer();
    System.out.println(o1.getX()); // 10

    System.out.println(Outer.getY()); // 100

    Outer.getY();
    // getY();

    Outer.StaticNested o2 = new Outer.StaticNested();
    o2.print(); // hello

    Outer o3 = new Outer();
    Outer.Inner o4 = o3.new Inner();
    o4.print(); // hello2

    Outer.Inner o5 = o3.new Inner();
    o5.print(); // hello2

    Test t = new Test();
    // t.new Inner();

    Ball ball = Ball.builder() //
      .setColor(Ball.Color.BLACK) // 
      .setWeight(2.0d) //
      .build();
    System.out.println(ball);
  }
}
