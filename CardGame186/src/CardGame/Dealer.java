package CardGame186;

public class Dealer {
	private int dealerCards = 0;
	public Dealer() {
	}
	public static void main(String[] args) {
	}
	public int getDealerValue() {
		return dealerCards;
	}
	public void drawCards(Deck newDeck) {
		int cardValue = newDeck.drawCard().returnRankValue();
		if (cardValue == 1 && dealerCards < 11) {
			dealerCards += 11;
		}
		else if (cardValue == 1 && dealerCards >= 11){
			dealerCards += 1;
		}
		else if (cardValue > 10) {
			dealerCards += 10;
		}
		else {
		dealerCards += cardValue;
		}
	}
	public int ace(boolean oneOrEleven) {
		if (oneOrEleven == true){
			return 1;	
		}
		else {
			return 11;
		}
	}
	public void dealInitialCards(Deck newDeck) {
		drawCards(newDeck);
		drawCards(newDeck);
	}
	public void hit(Deck newDeck){
		drawCards(newDeck);
	}
}
