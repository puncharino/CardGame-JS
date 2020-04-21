package CardGame186;
import java.util.Random;

public class BlackJack {
	public static void main(String[] args) {	
	Player player = new Player();
	Dealer dealer = new Dealer();
	Random r = new Random(2332);
	Deck newDeck = new Deck(52, r);
	boolean playerTurn = true;
	player.dealInitialCards(newDeck);
	dealer.dealInitialCards(newDeck);
	System.out.println("Player: " + player.getPlayerValue());
	System.out.println("Dealer: " + dealer.getDealerValue());
	 while (newDeck.returnDeckSize() > 0 && player.getPlayerValue() < 22 && dealer.getDealerValue() < 22 && dealer.getDealerValue() != 21) {
		 if (playerTurn && player.getPlayerValue() != 21) {
		player.hit(newDeck);
		playerTurn = false;
		System.out.println("Player: " + player.getPlayerValue());
	 }
		 else if (!playerTurn && dealer.getDealerValue() < 17){
		dealer.hit(newDeck);
		System.out.println("Dealer " + dealer.getDealerValue());
		playerTurn = true;
	 	}
		 else if (player.getPlayerValue() < 21 && dealer.getDealerValue() >= 17) {
			 playerTurn = true;
		}
	  }
   }
}
