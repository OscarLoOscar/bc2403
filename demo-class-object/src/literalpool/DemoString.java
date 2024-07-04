package literalpool;

public class DemoString {
  public static void main(String[] args) {
    String s = "hello";
    String s2 = "hello";

    System.out.println(System.identityHashCode(s)); // 1933863327, hashcode -> object address
    System.out.println(System.identityHashCode(s2)); // 1933863327

    String s3 = "hello ";
    System.out.println(System.identityHashCode(s3)); // 112810359

    String s4 = new String("hello");
    System.out.println(System.identityHashCode(s4)); // 2124308362

    String s5 = String.valueOf("hello");
    System.out.println(System.identityHashCode(s5)); // 1933863327

    System.out.println(s == s2); // true
    System.out.println(s == s5); // true
    System.out.println(s == s4); // false

    StringBuilder sb1 = new StringBuilder("hello");
    StringBuilder sb2 = new StringBuilder("hello");
    System.out.println(sb1 == sb2); // false

    String str = "aaa";
    System.out.println(System.identityHashCode(str)); // 146589023
    str = str + "bbb";
    System.out.println(System.identityHashCode(str)); // 349885916

  }
}
