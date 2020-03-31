package CardGame186;

import java.util.Random;

public class Deck {
	private Card [] Deck;
	public Deck () {
		Deck = new Card [52];
		int i = 0;
		
		//for every suit, make all 13 cards within that suit have an individual rank
		for (int suit = 0; suit <= 3; suit++) {
			//for every rank of every suit, create a card in Deck
		    for (int rank = 1; rank <= 13; rank++) {
		        Deck[i] = new Card(rank, suit);
		        i++;
		    }
		}
		this.shuffle();
	}
	
	public void shuffle() {
		Random r = new Random();
	    for (int i = this.Deck.length - 1; i > 0; i--) {
          int index = r.nextInt(i + 1);
          
          //Temporary card
          Card temp = this.Deck[index];
          //Swap
          this.Deck[index] = this.Deck[i];
          this.Deck[i] = temp;
          }
	}
	
	/*
	 * TO-DO:
	 * method: Pull out a card from the top of the deck and "reduce" the deck size by one
	 * method: Current deck size
	 */
	
	public static void printDeck(Card[] deck) {
	    for (int i = 0; i < deck.length; i++) {
	        System.out.println(deck[i].returnCardString());
	    }
	}
}
