package Game;

import Game.Card.Rank;
import Game.Card.Suit;
import java.security.SecureRandom;

class Deck 
{
    int total_cards = 52;
    SecureRandom random = new SecureRandom();
    Card[] cards = new Card[total_cards];

    /* keeps track of which card is at the top of the deck, i.e. which card
       is going to be drawn next from the deck**/
    
     int indexOfTopCard = 0;
    //constructor
    Deck() 
    {
        createCards();
        shuffleCards();
    }
    //Card is created

    public void createCards() {
        int numCardsCreated = 0;

        for (Rank rank : Rank.values())
         {
            for (Suit suit : Suit.values()) 
            {
                cards[numCardsCreated] = new Card(rank, suit);
                ++numCardsCreated;
            }
        }
    }
    //shuffle the cards
    public void shuffleCards() 
    {
        int randomIndex;
        Card temp;

        try 
        {
            for (int i = 0; i <total_cards; ++i) 
            {
                temp = cards[i];
                randomIndex = random.nextInt(total_cards);
                cards[i] = cards[randomIndex];
                cards[randomIndex] = temp;
            }
        }
         catch (Exception e) 
         {
            e.printStackTrace();
        }
    }
    //Gets the next card
    Card getNextCard() throws Exception
    {
        Card card;

        try 
        {
            card = cards[indexOfTopCard];
            ++indexOfTopCard;
        } 
        catch (ArrayIndexOutOfBoundsException e) 
        {
            throw new Exception("All cards have been drawn from the deck.");
        }

        return card;
    }
}
