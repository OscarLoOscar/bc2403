public class DemoSwitch {
  public static void main(String[] args) {
    // Example 3
    char grade = 'D';
    // score > 90 -> A (Pass)
    // 80 - 90 -> B (Pass)
    // 70 - 79 -> C (Pass)
    // < 70 -> F (Fail)

    // break -> exit
    switch (grade) {
      case 'A':
        System.out.println("This is grade A");
        System.out.println("Bootcamp");
        break;
      case 'B':
        System.out.println("This is grade B");
        System.out.println("Bootcamp!!!");
        break;
      case 'C':
        System.out.println("This is grade C");
        System.out.println("Bootcamp!!!@@@");
        break;
      default:
        System.out.println("Default Value");
    }

    // Grade A: 5
    // B: 4
    // C: 3
    // D: 2
    // E: 1
    // F: 0
    int score = 0;
    switch (grade) {
      case 'A':
        score++;
      case 'B':
        score++;
      case 'C':
        score++;
      case 'D':
        score++;
      case 'E':
        score++;
      default:
    }
    System.out.println("score=" + score); // score=2

    // switch (CANNOT compare value)
    switch (score) {
      case 5:
        System.out.println("hello");
      case 4:
        System.out.println("hello");
      case 3:
        System.out.println("hello");
      case 2:
        System.out.println("world");
      case 1:
        System.out.println("world");
      default:
    }

    if (score >= 3) {
      System.out.println("hello");
    } else {
      System.out.println("world");
    }


  }
}
