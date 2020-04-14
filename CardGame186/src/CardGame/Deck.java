package CardGame186;

import java.util.Arrays;
import java.util.Random;

public class Deck {
	
	//VARIABLES
	//////////////////////////////////////////////////////
	
	/**
	 * The deck of cards.
	 */
	public static Card [] Deck;
	
	private Card Joker = new Card(0,0);
	private boolean hasShuffled = false;
	private Random r;
	private static int cardsInDeck;
	private final int maxCards; //no more than 52
	
	
	// CONSTRUCTORS
	//////////////////////////////////////////////////////
	
	/**
	 * Constructs a deck object. By default, it will construct a deck with a maximum of 52 cards in order.
	 * Order: For every suit, in this order - "Clubs", "Diamonds", "Hearts", "Spades" - make a card with every
	 * every rank, in this order - "Joker", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", 
	 * "King".
	 * 
	 * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
	 * appear only when the deck is empty as an indicator the the deck is empty. They are not part of the game.
	 */
	public Deck () {
		maxCards = 52; 					// default if no argument is given to constructor
		cardsInDeck = maxCards-1; 		// # of cards in deck is equal to max cards in deck when initialized
		Deck = new Card [maxCards]; 	// initialize new deck with max number of cards
		
		r = new Random();	//non-specified random seed
		int i = 0;
		
		//for every suit, make all 13 cards within that suit have an individual rank
		for (int suit = 0; suit <= 3; suit++) {
			//for every rank of every suit, create a card in Deck
		    for (int rank = 1; rank <= 13; rank++) {
		        Deck[i] = new Card(rank, suit);
		        i++;
		    }
		}
	}
	
	/**
	 * Constructs a deck object with a given maximum amount of cards and a set random seed. It will first generate
	 * the deck in a set order.
	 * Order: For every suit, in this order - "Clubs", "Diamonds", "Hearts", "Spades" - make a card with every
	 * every rank, in this order - "Joker", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", 
	 * "King".
	 * 
	 * It will then shuffle the deck, and then trim it down to maximumCards size.
	 * 
	 * If the given maximum is more than 52, it will be set to 52, and if it's set to less than 0, it will be
	 * set to 0.
	 * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
	 * appear only when the deck is empty as an indicator the the deck is empty. They are not part of the game.
	 * @param maximumCards the desired maximum amount of cards in the deck, no more than 52
	 * @param random a Java random
	 */
	public Deck (int maximumCards, Random random) {
		if (maximumCards < 0) {
			maxCards = 0;
		} else if (maximumCards > 52) {
			maxCards = 52;
		} else {
			maxCards = maximumCards; 		// given maximum
		}
		r = random;
		cardsInDeck = maxCards-1; 		// # of cards in deck is equal to max cards in deck when initialized
		Card[] full = new Card[52];
		int i = 0;
		//for every suit, make all 13 cards within that suit have an individual rank
		for (int suit = 0; suit <= 3; suit++) {
			//for every rank of every suit, create a card in Deck
		    for (int rank = 1; rank <= 13; rank++) {
		        full[i] = new Card(rank, suit);
		        i++;
		    }
		}
		this.shuffle(full);	//shuffle the deck before use with a given random generator
		Deck = Arrays.copyOfRange(full, 0, maxCards);	// initialize new deck with max number of cards
	}
	
	// METHODS
	//////////////////////////////////////////////////////
	
	/**
	 * Shuffles the deck of cards. Can only be done once per deck.
	 * Utilizes a pseudo random unless given one in the constructor.
	 */
	public void shuffle() {
		if(!hasShuffled && maxCards == cardsInDeck + 1) {
			for (int i = Deck.length - 1; i > 0; i--) {
	          int index = r.nextInt(i + 1);
	          
	          //Temporary card
	          Card temp = Deck[index];
	          //Swap
	          Deck[index] = Deck[i];
	          Deck[i] = temp;
	          }
		} else {
			System.out.println("The deck has already been shuffled. It cannot be shuffled further.");
		}

	}
	
	/**
	 * Helper method of the Deck constructor. Otherwise identical to shuffle().
	 * @param deck deck to shuffle (in this case, full)
	 */
	private void shuffle (Card [] deck) {
		if(!hasShuffled) {
			for (int i = deck.length - 1; i > 0; i--) {
	          int index = r.nextInt(i + 1);

	          //Temporary card
	          Card temp = deck[index];
	          //Swap
	          deck[index] = deck[i];
	          deck[i] = temp;
	          }
			hasShuffled = true;
		} else {
			System.out.println("The deck has already been shuffled at the start of the game. It cannot be shuffled again.");
		}

	}
	
	/**
	 * Draws a card from the top of the deck. 
	 * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
	 * appear only when the deck is empty as an indicator that the deck is empty.
	 * @return the top Card in the deck if the deck has cards and Joker otherwise
	 */
	public Card drawCard () {
		if (!isDeckEmpty()) {
			Card topCard = Deck[cardsInDeck];
			--cardsInDeck; 
			return topCard;
		} else { return Joker; } //return a card with a Joker rank, unusable
	}
	/**
	 * Draws a random card from the deck. 
	 * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
	 * appear only when the deck is empty as an indicator that the deck is empty.
	 * @param r a Java random
	 * @return a Card in the deck if the deck has cards and Joker otherwise
	 */
	public Card drawRandomCard (Random r) {
		if (!isDeckEmpty()) {
			
			int indexOfCard = r.nextInt(cardsInDeck+1);	//generates int between 0 and cardsInDeck
			Card randomCard = Deck[indexOfCard];		//draws the card within the deck at that index
			
			// REDUCE DECK
			for (int i = indexOfCard; i < cardsInDeck; ++i) {
				Deck[i] = Deck[i+1];
			}
			--cardsInDeck;
			return randomCard;
		} else { return Joker; } //return a card with a Joker rank, unusable
	}
	
	/**
	 * Returns the current deck size
	 * @return deck size
	 */
	public int returnDeckSize() {
		if (!isDeckEmpty()) {
			return cardsInDeck+1;
		} else { return 0;}
	}
	
	/**
	 * Prints the current cards in the deck to the console
	 */
	public void printDeck() {
		if (!isDeckEmpty()) {
		    for (int i = 0; i < cardsInDeck + 1; i++) {
		        System.out.printf("%d. %s\n", i+1, Deck[i].returnCardName());
		    }
	    } else { System.out.printf("The deck is empty.\n"); }

	}
	
	/**
	 * Check to see if the deck is empty
	 * @return true if deck is empty, false otherwise
	 */
	public boolean isDeckEmpty() {
		if (cardsInDeck + 1 > 0) { return false;}
		else { return true;}
	}
}
