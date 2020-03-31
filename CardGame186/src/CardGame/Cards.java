package CardGame186;

public class Card {
	//a card needs to have these be constant throughout its existence, should never change
    private final int rank, suit;
    
    //these shouldn't change
    public static final String [] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; // there is no zero card rank, make it null
    public static final String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /**
     * Constructs a card (intended for a deck of 52).
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {
    	/*
    	 * RANK:
    	 * 	Ace = 1
    	 * 	Numbers = (2-10)
    	 * 	Jack = 11
    	 * 	Queen = 12
    	 *  King = 13
    	 * SUITS:
    	 * 	Clubs = 0
    	 * 	Diamonds = 1
    	 * 	Hearts = 2
    	 * 	Spades = 4
    	 */
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Returns a string with the rank of the card.
     * @return string of the rank
     */
    public String returnRank() {
    	return ranks[rank];
    } 
    
    /**
     * Returns a integer value for the rank of the card.
     * RANK:
     * Ace = 1
     * Numbers = (2-10)
     * Jack = 11
     * Queen = 12
     * King = 13
     * @return value of the rank of this card
     */
    public int returnRankValue() {
    	return rank;
    }  
    
    /**
     * Returns a string with the suit of the card.
     * @return string of the suit
     */
    public String returnSuit() {
    	return suits[suit];
    }

    /**
     * Returns a integer value for the suit of the card.
	 * SUITS:
	 * 	Clubs = 0
	 * 	Diamonds = 1
	 * 	Hearts = 2
	 * 	Spades = 4
     * @return value of the suit of this card
     */
    
    public int returnSuitValue() {
    	return suit;
    }
    
    /**
     * A user-readable string with the values of the card
     * @return the card's suit and rank
     */
    public String returnCardString() {
    	return (ranks[rank] + " of " + suits[suit]);
    }
    
    /**
     * Checks to see which card is higher tiered in both suits and ranks, compared to another card
     * @param that another card to compare 
     * @return returns 1 if this ("the caller" card) wins, -1 if that ("the called" card) wins, and 0 if they are equivalent
     */
    public int comparedTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }
}
