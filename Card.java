package RummyHand;

public class Card {

    public final static int SPADES = 1,
            HEARTS = 2,
            DIAMONDS = 3,
            CLUBS = 4;

    public final static int ACE = 1,
            JACK = 11,
            QUEEN = 12,
            KING = 13,
            JOKER = 0;

    public int suit;
    public int rank;

    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String getSuitAsString() {
        switch ( suit ) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "??";
        }
    }

    public String getValueAsString() {
        switch ( rank ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            case 13:  return "King";
            default:  return "JOKER";
        }
    }

    @Override
    public String toString() {
        return getValueAsString().equals("JOKER") ? "JOKER" : getValueAsString() + "(" + getSuitAsString() + ")";
    }

    @Override
    public boolean equals(Object card) {
        return suit == ((Card) card).getSuit() && rank == ((Card) card).getRank();
    }
}



