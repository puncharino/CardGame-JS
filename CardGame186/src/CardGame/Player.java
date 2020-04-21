package CardGame186;

public class Player {
	private int playerCards = 0;
	public Player() {
	}
	public static void main(String[] args) {
	}
	public int getPlayerValue(){
		return playerCards;
	}
	public void drawCards(Deck newDeck) {
		int cardValue = newDeck.drawCard().returnRankValue();
		if (cardValue == 1 && playerCards < 11) {
			playerCards += 11;
		}
		else if (cardValue == 1 && playerCards >= 11){
			playerCards += 1;
		}
		else if (cardValue > 10) {
			playerCards += 10;
		}
		else {
		playerCards += cardValue;
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
