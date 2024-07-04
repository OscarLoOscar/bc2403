package bomb;

import java.util.Random;
import java.util.Scanner;

public class Game {
  public static void main(String[] args) {
    // min = 1, max = 100
    // random = 47 -> bomb
    // Round 1: Please a number bewteen 1 - 100 -> User input: 45 -> game continue
    // Round 2: Please a number bewteen 46 - 100 -> User input: 59 -> game continue
    // Round 3: Please a number bewteen 46 - 58 -> User input: 47 -> game exit

    int min = 1;
    int max = 100;
    Scanner scanner = new Scanner(System.in);
    int bomb = new Random().nextInt(max) + 1; // 0 - 99
    int input = 0;

    do {
      System.out.println("Please pick a number bewteen " + min + " - " + max + ":");
      input = scanner.nextInt();

      // validation: input between min and max, if no, pick the number again.
      // continue
      if (input < min || input > max) {
        System.out.println("The number is not in range. Please input again.");
        continue;
      }

      if (input < bomb) {
        min = input + 1;
      } else if (input > bomb) {
        max = input - 1;
      }
    } while (input != bomb);

    scanner.close();
    System.out.println("Bomb!");

  }
}
