package CardGame186;

import java.util.Random;

public class Deck {
	
	//cardsInDeck hold the number of cards within the deck at any given point throughout the deck's lifespan
	public static int cardsInDeck;
	public static Card [] Deck;
	
	//maximum number of cards in the deck
	private final int maxCards;
	
	
	// CONSTRUCTORS
	//////////////////////////////////////////////////////
	public Deck () {
		maxCards = 52; 					// default if no argument is given to constructor
		cardsInDeck = maxCards-1; 		// # of cards in deck is equal to max cards in deck when initialized
		Deck = new Card [maxCards]; 	// initialize new deck with max number of cards
		
		Random r = new Random();	//non-specified random seed
		int i = 0;
		
		//for every suit, make all 13 cards within that suit have an individual rank
		for (int suit = 0; suit <= 3; suit++) {
			//for every rank of every suit, create a card in Deck
		    for (int rank = 1; rank <= 13; rank++) {
		        Deck[i] = new Card(rank, suit);
		        i++;
		    }
		}
		this.shuffle(r);					//shuffle the deck before use
	}
	
	public Deck (int maximumCards, Random r) {
		maxCards = maximumCards; 		// given maximum
		cardsInDeck = maxCards-1; 		// # of cards in deck is equal to max cards in deck when initialized
		Deck = new Card [maxCards]; 	// initialize new deck with max number of cards
		
		int i = 0;
		
		//for every suit, make all 13 cards within that suit have an individual rank
		for (int suit = 0; suit <= 3; suit++) {
			//for every rank of every suit, create a card in Deck
		    for (int rank = 1; rank <= 13; rank++) {
		        Deck[i] = new Card(rank, suit);
		        i++;
		    }
		}
		//printDeck(Deck);
		this.shuffle(r);					//shuffle the deck before use with a given random generator
	}
	
	// METHODS
	//////////////////////////////////////////////////////
	public void shuffle(Random r) {
	    for (int i = Deck.length - 1; i > 0; i--) {
          int index = r.nextInt(i + 1);
          
          if (Deck[index] == null) {
        	  // nothing
          }
          //Temporary card
          Card temp = Deck[index];
          //Swap
          Deck[index] = Deck[i];
          Deck[i] = temp;
          }
	}

	public Card drawCard () {
		Card topCard = Deck[cardsInDeck];
		--cardsInDeck; 
		return topCard;
	}
	
	public Card drawRandomCard (Random r) {
		--cardsInDeck;
		int indexOfCard = r.nextInt(cardsInDeck+1);	//generates int between 0 and cardsInDeck
		Card randomCard = Deck[indexOfCard];		//draws the card within the deck at that index
		
		// REDUCE DECK
		for (int i = indexOfCard; i < cardsInDeck + 1; ++i) {
			Deck[i] = Deck[i+1];
		}
		
		return randomCard;
	}
	
	public int returnDeckSize() {
		return cardsInDeck+1;
	}
	
	public static void printDeck(Card[] deck) {
	    for (int i = 0; i < cardsInDeck + 1; i++) {
	        System.out.printf("%d. %s\n", i+1, deck[i].returnCardString());
	    }
	}
}
