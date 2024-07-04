package poker;

import java.util.Arrays;

public class Deck {

  public static final Suit[] SUITS =
      new Suit[] {Suit.DIAMOND, Suit.CLUB, Suit.HEART, Suit.SPADE};

  public static final int[] RANKS = new int[] {Card.ONE, Card.TWO, Card.THREE,
      Card.FOUR, Card.FIVE, Card.SIX, Card.SEVEN, Card.EIGHT, Card.NINE,
      Card.TEN, Card.JACK, Card.QUEEN, Card.KING};

  private final Card[] cards; // final the address of array

  private Deck(boolean isEmpty) {
    if (isEmpty) {
      this.cards = new Card[0];
    } else {
      this.cards = new Card[52];
      int idx = 0;
      for (Suit suit : SUITS) { // SUITS
        for (int rank : RANKS) { // RANKS
          this.cards[idx++] = new Card(rank, suit);
        }
      }
    }
  }

  public Card[] getCards() {
    return this.cards;
  }

  public static Deck empty() {
    return new Deck(true);
  }

  public static Deck full() {
    return new Deck(false);
  }

  public String toString() {
    return "Deck(" //
        + "cards=" + Arrays.toString(this.cards) //
        + ")";
  }

  public static void main(String[] args) {
    // Deck deck = new Deck();
    // insert 52 card to the deck

    Deck deck2 = Deck.empty();
    System.out.println(deck2);
    Deck deck3 = Deck.full();
    System.out.println(deck3);

    Suit x = Suit.SPADE;
    System.out.println(x != Suit.CLUB); // true
    System.out.println(x == Suit.SPADE); // true
    if (x == Suit.HEART) {
      System.out.println("its a heart");
    } else {
      System.out.println("not a heart");
    }

  }
}
