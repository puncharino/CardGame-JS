package CardGame;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    //VARIABLES
    //////////////////////////////////////////////////////
    /**
     * The deck of cards.
     */
    private static ArrayList<Card> Deck;
    private static ArrayList<Card> PlayedCards = new ArrayList<>();

    private Random r;


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
        Deck = new ArrayList<>(); 	    // initialize new deck with max number of cards
        r = new Random();	//non-specified random seed
        //for every suit, make all 13 cards within that suit have an individual rank
        for (int suit = 0; suit <= 3; suit++) {
            //for every rank of every suit, create a card in Deck
            for (int rank = 1; rank <= 13; rank++) {
                Deck.add(new Card(rank, suit));
            }
        }
    }

    /**
     * Constructs a deck object with a set random seed. It will first generate the deck in a set order.
     * Order: For every suit, in this order - "Clubs", "Diamonds", "Hearts", "Spades" - make a card with every
     * every rank, in this order - "Joker", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
     * "King".
     *
     * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
     * appear only when the deck is empty as an indicator the the deck is empty. They are not part of the game.
     * @param random a Java random
     */
    public Deck (Random random) {

        Deck = new ArrayList<>(); 	    // Initialize new deck with max number of cards
        r = random;	                    // Specified random seed

        //for every suit, make all 13 cards within that suit have an individual rank
        for (int suit = 0; suit <= 3; suit++) {
            //for every rank of every suit, create a card in Deck
            for (int rank = 1; rank <= 13; rank++) {
                Deck.add(new Card(rank, suit));
            }
        }
    }

    // METHODS
    //////////////////////////////////////////////////////

    /**
     * Shuffles the deck of cards. Can only be done once per deck.
     * Utilizes a pseudo random unless given one in the constructor.
     */
    public void shuffle() {
        for (int i = Deck.size() - 1; i > 0; i--) {
            int index = r.nextInt(i + 1);

            //Temporary card
            Card temp = Deck.get(index);
            //Swap
            Deck.set(index,Deck.get(i));
            Deck.set(i, temp);
        }
    }

    /**
     * Draws a card from the top of the deck.
     *
     * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
     * appear only when the deck is empty as an indicator that the deck is empty.
     * @return the top Card in the deck if the deck has cards and Joker otherwise
     */
    public Card drawCard () {
        Card topCard = new Card(0,0);       // Joker by default
        if (!isDeckEmpty()) {
            topCard = Deck.get(Deck.size()-1);
            PlayedCards.add(topCard);                // Add any drawn cards to PlayedCards
            Deck.remove(topCard);
        }

        return topCard;
    }
    /**
     * Draws a random card from the deck.
     *
     * If a card called from this deck has a "Joker" rank or name, the card is NOT part of the initialized deck. It will
     * appear only when the deck is empty as an indicator that the deck is empty.
     * @param r a Java random
     * @return a Card in the deck if the deck has cards and Joker otherwise
     */
    public Card drawRandomCard (Random r) {
        Card randomCard = new Card(0,0);
        if (!isDeckEmpty()) {
            int indexOfCard = r.nextInt(Deck.size()+1);	//generates int between 0 and cardsInDeck
            randomCard = Deck.get(indexOfCard);		    //draws the card within the deck at that index

            // REDUCE DECK
            Deck.remove(randomCard);
        }
        return randomCard;
    }

    /**
     * Returns an ArrayList</Card> of the played cards, where the last element is the most recent card and the first is
     * the oldest.
     * @return the cards that have been played from this deck.
     */
    public static ArrayList<Card> getPlayedCards() {
        return PlayedCards;
    }
    /**
     * Returns the current deck size
     * @return deck size
     */
    public int returnDeckSize() {
        return Deck.size();
    }

    /**
     * Prints the current cards in the deck to the console
     */
    public void printDeck() {
        if (!isDeckEmpty()) {
            for (Card e : Deck) {
                System.out.println(e.returnCardName());
            }
        } else {
            System.out.print("The deck is empty.\n"); }

    }

    /**
     * Check to see if the deck is empty
     * @return true if deck is empty, false otherwise
     */
    public boolean isDeckEmpty() {
        return Deck.size() == 0;
    }

    /**
     * Clears all Cards from the deck and effectively resets it by initializing it again. Played Cards are also cleared.
     */
    public void reset() {
        Deck.clear();
        PlayedCards.clear();

        r = new Random();	//non-specified random seed, different from original
        //for every suit, make all 13 cards within that suit have an individual rank
        for (int suit = 0; suit <= 3; suit++) {
            //for every rank of every suit, create a card in Deck
            for (int rank = 1; rank <= 13; rank++) {
                Deck.add(new Card(rank, suit));
            }
        }
    }
}
