public class DemoWrapper {
  public static void main(String[] args) {
    int x = 1; // +, -, *, /, %
    Integer x2 = 1; // Integer wrapper class -> object (i.e. String.class -> String Object)
    Integer x3 = new Integer("1");

    Long l1 = new Long("10");
    Short s1 = new Short("10");
    Byte b1 = new Byte("10");

    Double d1 = new Double("10.0");
    Float f1 = new Float("10.0");

    Character c1 = new Character('p');
    Boolean b2 = new Boolean("true");

    if (x2.equals(1)) {
      System.out.println("x2=1");
    }

    if (x2 == 1) {
      System.out.println("x2=1");
    }

    x2 = 128;
    if (x2 == 128) {
      System.out.println("x2=128");
    }

    Integer num1 = Integer.valueOf(127); // valueOf() -> "new" a Integer object
    Integer num2 = Integer.valueOf(127); 
    // "==" is checking if they are same object
    System.out.println(num1 == num2); // true
    // equals() is checking if they are with same value
    System.out.println(num1.equals(num2)); // true

    Integer num5 = new Integer("127");
    System.out.println(num1 == num5); // false

    Integer num3 = Integer.valueOf(128);
    Integer num4 = Integer.valueOf(128);
    System.out.println(num3 == num4); // false?
    System.out.println(num3.equals(num4)); // true

    String str = "hello";
    String str2 = "hello";
    String str3 = new String("hello");
    String str4 = String.valueOf("hello");
    // "==" is checking if they are same object
    System.out.println(str == str2); // true 
    System.out.println(str == str3); // false
    System.out.println(str == str4); // true
    System.out.println(str.equals(str2)); // true 
    System.out.println(str.equals(str3)); // true 

    Double d2 = 1.0;
    Double d3 = 1.0;
    Double d4 = Double.valueOf(1.0);
    System.out.println(d2 == d3); // false
    System.out.println(d2 == d4); // false
    System.out.println(d2.equals(d3)); // true
    System.out.println(d2.equals(d4)); // true

    System.out.println(d2.compareTo(d3)); // 0

    int u = 1;
    if (u == 1) {

    }

    // 17 Types + array
    Integer i1 = 3; // 3 (int value) -> Integer Object with value 3 -> auto-box
    int i2 = i1; // i1 (Integer Object) -> unbox

    Character c2 = 'c'; // autobox
    char c3 = c2; // unbox

    Integer i3 = 10;
    long l4 = i3; // Integer -> int (unbox) -> long (upcast)
    // short s4 = i3; // Integer -> int (unbox) -> short (un-secure)

    int i5 = 12;
    Long l5 = (long) i5; // int -> long (upcast) -> Long (autobox)

    // Float.valueOf()
    Float f2 = Float.valueOf("1.0");
    // f2.compareTo(...) -> 0,-1,1
    // f2.equals(...) -> true, false
    

  }
}
