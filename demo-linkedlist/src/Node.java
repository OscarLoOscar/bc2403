public class Node {

  private String str; // object reference

  // private Node previous;

  private Node next; // object reference

  // private Node tail;

  public Node(String str) {
    this.str = str;
  }

  public Node(String str, Node next) {
    this.str = str;
    this.next = next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public Node getNext() {
    return this.next;
  }

  public String getStr() {
    return this.str;
  }

  public static void main(String[] args) {
    // "hello", "abc", "def"
    Node head = new Node("hello", new Node("abc", new Node("def")));

    // check if head contains "def" -> true/ false
    // for loop? while loop -> linkedlist
    Node temp = head;
    boolean result = false;
    while (temp != null) {
      // find "def"
      if ("def".equals(temp.getStr())) {
        result = true;
        break;
      }
      // move to the next Node
      temp = temp.getNext();
    }
    System.out.println(temp.getStr()); // def
    System.out.println(result); // false ?

    System.out.println("hello".equals(null)); // false

  }
}
