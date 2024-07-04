package poker;

public class Card {

  public static final char DIAMOND = 'D'; // Card.DIAMOND
  public static final char CLUB = 'C'; // Card.CLUB
  public static final char HEART = 'H'; // Card.HEART
  public static final char SPADE = 'S'; // Card.SPADE
  public static final int ONE = 1; // Card.ONE
  public static final int TWO = 2; // Card.TWO
  public static final int THREE = 3; // Card.THREE
  public static final int FOUR = 4; // Card.FOUR
  public static final int FIVE = 5; // Card.FIVE
  public static final int SIX = 6; // Card.SIX
  public static final int SEVEN = 7; // Card.SEVEN
  public static final int EIGHT = 8; // Card.EIGHT
  public static final int NINE = 9; // Card.NINE
  public static final int TEN = 10; // Card.TEN
  public static final int JACK = 11; // Card.JACK
  public static final int QUEEN = 12; // Card.QUEEN
  public static final int KING = 13; // Card.KING

  private int rank;
  private Suit suit;

  public Card(int rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public int getRank() {
    return this.rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public void setSuit(Suit suit) {
    this.suit = suit;
  }

  public String toString() {
    return "Card(" //
        + "suit=" + this.suit //
        + ", rank=" + this.rank //
        + ")";
  }

}
