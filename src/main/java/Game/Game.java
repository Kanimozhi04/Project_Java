package Game;
import java.util.*;
import static java.lang.System.*;


class Game 
{
    Deck deck;
    int roundsPlayed;
    int Max_rounds = 15;
    String player1;
    String player2;
    int player1_score;
    int player2_score;
    Scanner input = new Scanner(System.in);
	
   //deck are created
   Game() 
	{
       System.out.println("\nCreating Deck...");
       deck = new Deck();
       System.out.println("Deck created.");
       roundsPlayed = 0;
       player1 = "";
       player2 = "";
       player1_score = 0;
       player1_score = 0;
   }
   //player's name
   void run() 
   {
		System.out.println("Enter player1 name");
	    player1=input.nextLine();
	   System.out.println("Enter player2 name");
	   player2=input.nextLine();
       Card p1Card;
       Card p2Card;
      //checks up to Max_rounds
       while (roundsPlayed < Max_rounds) 
       {
           try 
           {
               p1Card = deck.getNextCard();
               p2Card = deck.getNextCard();

               System.out.printf("%n Round %d %n%n", roundsPlayed + 1);

				System.out.printf("%s's card: %s%n", player1, p1Card.toString());
               System.out.printf("%s's card: %s%n%n", player2, p2Card.toString());
               //compares the player1 card and player2 card
               if (p1Card.compareTo(p2Card) < 0) 
				{
                   player1_score += 2;
                   out.printf("%s wins this round!%n", player1);
               } 
				else if (p1Card.compareTo(p2Card) > 0) 
				{
                   player1_score += 2;
                   out.printf("%s wins this round!%n", player1);
               } 
               //If tie each player gets one point
				else
				{
                   ++player1_score;
                   ++player2_score;
                   out.printf("This round is a tie!%n");
               }
           } 
           catch (Exception e) 
           {
               out.println("An error occurred. Please try running the game again.");
           }

           out.printf("%s's score: %d%n", player1, player1_score);
           out.printf("%s's score: %d%n", player2, player2_score);

           ++roundsPlayed;

           out.println("Press Enter to go to the next round...");
           try
           {
               System.in.read();
           } 
           catch (Exception e)
           {
               out.println("Error reading key press. Moving on to the next round.");
           }
       }

       out.printf("%nGame over. ");
       //checks the score of player1 and player2
       if (player1_score > player2_score) 
		{
           out.printf("%s wins!%n%n", player1);
        } 
		else if (player1_score < player2_score) 
		{
           out.printf("%s wins!%n%n", player2);
        } 
		else 
		{
           out.printf("It is a tie!%n%n");
       }
       
       // get ready to run another game
       deck = new Deck();
       roundsPlayed = 0;
       player1 = "";
       player2 = "";
       player1_score = 0;
       player2_score = 0;
      
   }
  
}

