package Game;

class Card implements Comparable<Card>
{
    private Rank rank;
    private Suit suit;
   //Cards
    enum Rank 
    {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
        KING(13);

        public final int value;

        private Rank(int value) 
        {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    //Suits
    enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }
    //Gets the rank
    Rank getRank() 
    {
        return rank;
    }
    
    Card(Rank rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }
    
    
    public int compareTo(Card other) 
    {
        return Integer.compare(rank.getValue(), other.getRank().getValue());
    }
    //Displays the rank and suit
    public String toString() {
        return String.format("%s of %s", rank, suit);
    }

	
}