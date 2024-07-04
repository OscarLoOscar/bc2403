public class DemoForLoop2 {
  public static void main(String[] args) { // hotkey: main + enter
    // hotkey: sysout + enter

    // Single Loop
    for (int i = 0; i < 5; i++) { // 0,1,2,3,4
      System.out.print("*"); // *****
    }

    // Nested Loop
    for (int i = 0; i < 3; i++) { // 0,1,2
      for (int j = 0; j < 2; j++) { // 0,1
        System.out.println("i=" + i + ",j=" + j); // i = ?, j = ?
      }
      System.out.println("hello");
    }
    // i=0,j=0
    // i=0,j=1
    // hello
    // i=1,j=0
    // i=1,j=1
    // hello
    // i=2,j=0
    // i=2,j=1
    // hello

    // ***** i = 0, j -> 5 - 0 times
    // **** i = 1, j -> 5 - 1 times
    // *** i = 2, j -> 5 - 2 times
    // ** i = 3, j -> 5 - 3 times
    // * i = 4, j -> 5 - 4 times
    int n = 5;
    for (int i = 0; i < n; i++) { // 
      for (int j = 0; j < n - i; j++) { 
        System.out.print("*");
      }
      System.out.println();
    }
    //   *
    //  ***
    // *****
    //  ***
    //   *
    // Searching
    String str2 = "abcdefg hello world!";
    // Find the index of the second of space character. If exists, print the index, if no, print N/A
    int spaceCount = 0;
    for (int i = 0; i < str2.length(); i++) {
      if (str2.charAt(i) == ' ' && ++spaceCount == 2) {
        System.out.println("index=" + i);
        break;
      }
    }
    if (spaceCount < 2) {
      System.out.println("N/A");
    }

    // break;
    for (int i = 0; i < 10; i++) {
      if (i > 3) {
        break; // break the nearest loop
      }
      System.out.println("hello");
    }
    // hello
    // hello
    // hello
    // hello

    // continue;
    for (int i = 0; i < 10; i++) {
      System.out.println("abc");
      if (i > 3) {
        continue; // skip the rest, go to next iteration
      }
      System.out.println("hello");
    }

  }
}
