public class BCList<T, U> {
  private T data1;
  private U data2;

  //
  public BCList(T data1, U data2) {
    this.data1 = data1;
    this.data2 = data2;
  }

  public T getData1() {
    return this.data1;
  }

  public U getData2() {
    return this.data2;
  }

  public static <T extends Number> double sum(T number1, T number2) { // No relationship to line 1 <T>
    System.out.println(number1.getClass()); // Integer
    System.out.println(number2.getClass()); // Long
    return number1.doubleValue() + number2.doubleValue();
  }

  public static void main(String[] args) {
    BCList<String, Integer> bclist = new BCList<>("hello", 12);
    System.out.println(bclist.getData1());
    System.out.println(bclist.getData2());

    // T and U can be same type or different type
    BCList<String, String> bcList2 = new BCList<>("abc", "xxx");
    System.out.println(bcList2.getData1());
    System.out.println(bcList2.getData2());

    // "public class BCList<T, T>" -> two attributes must be same type
    sum(Integer.valueOf(13), Long.valueOf(20));

    // int -> Integer (autobox)
    // integer -> int (unbox)
    // int -> long (upcast)
    // long -> int (downcast -> overflow)

    // Wrapper Class cannot be coverted between each others
    // Integer -> Long (No auto or direct relationship)
    // Long -> Integer (No auto or direct relationship)
    
  }
}
