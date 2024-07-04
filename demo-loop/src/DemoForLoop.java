public class DemoForLoop {
    public static void main(String[] args) {
        int x = 2;
        x = x * x; // 2 * 2 = 4
        x *= x; // 4 * 2 = 8

        // 2^60

        //
        // System.out.println("hello world");
        // System.out.println("hello world");

        // for (initialization; continue condition; value change rule)
        for (int i = 0; i < 3; i++) { // 0, 1, 2
            // Step 1: int i = 0
            // Step 2: i < 3 ? yes
            // Step 3: Print hello world
            // Step 4: i++ -> i become 1
            // Step 5: i < 3 ? yes
            // Step 6: Print hello world
            // Step 7: i++ -> become 2
            // Step 8: i < 3 ? yes
            // Step 9: Print hello world
            // Step 10: i++ -> become 3
            // Step 11: i < 3 ? no

            // Never to re-assign value to i within the loop
            // i++;
            System.out.println("hello world " + i);
        }

        for (int i = 5; i >= 0; i--) { // 5, 4, 3, 2, 1, 0
            System.out.println("hello world " + i);
        }

        // print out: 1 3 5 7 9
        for (int i = 1; i <= 9; i += 2) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) { // odd number
                System.out.print(i + " ");
            }
        }

        String s = "abcdefg";
        // print out: aceg
        // chatAt(), String concat
        String result = "";
        for (int i = 0; i < s.length(); i++) { // 0, 1, 2, 3, 4, 5, 6
            if (i % 2 == 0) {
                result += s.charAt(i); // 0, 2, 4, 6
            }
        }
        System.out.println(result);

        //
        String pattern = "cd";
        // "abcdefg" has string pattern "cd", so print true

        // 55 = 1 + 2 + 3 + 4 ... + 10
        int max = 10;
        int min = 1;
        // print: 55
        int k = 0;
        for (int i = min; i <= max; i++) {
            k += i;
        }
        System.out.println(k); // 55

        // sum up all even numbers
        k = 0;
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) { // even number
                k += i;
            }
        }
        System.out.println(k);

        // Counting
        String str = "hello world";
        // count the number of 'l' -> 3
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'l') {
                count++;
            }
        }
        System.out.println("count=" + count); // 3

        // sum up all odd numbers, and subtract all even numbers
        // 1 - 2 + 3 - 4 + 5 ... - 10
        int k2 = 0;
        for (int i = min; i <= max; i++) { // 
            if (i % 2 == 0) {
                k2 -= i;
            } else {
                k2 += i;
            }
        }
        System.out.println("k2=" + k2); // -5 (1 + 3 + 5 + 7 + 9 - 2 - 4 - 6 - 8 - 10)

        String s1 = "abcd";

        for (int i = 0; i < s1.length(); i++) {
          
        }

    }
}
