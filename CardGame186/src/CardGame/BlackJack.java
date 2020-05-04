package CardGame;

import java.util.Random;

public class BlackJack {
	 static int playerBet = 0;
	 static int playerWinnings = 0;
	 boolean playerTurn = true;
	 static boolean dealerWin = false;
	 static Random r = new Random();
	 //104 for 21 bug
	 static Deck newDeck = new Deck(r);
	 static Player player = new Player(newDeck);
	 static Dealer dealer = new Dealer(newDeck);
	 static boolean gameState = true;

	public static void Start() {

		while (dealer.getHandTotal() < 21 && !dealerWin && gameState) {
			if (dealer.getHandTotal() < 17) {
				dealer.hit();
				// BasicFXMLController.dealerUpdate();

			} else if (dealer.getHandTotal() > player.getHandTotal()) {
				dealerWin = true;
				gameState = false;
			} else if (dealer.getHandTotal() < player.getHandTotal()) {
				dealerWin = false;
				gameState = false;

				playerWinnings = playerBet * 2;
			} else if (player.getHandTotal() == dealer.getHandTotal()) {
				playerWinnings = playerBet;
				dealerWin = false;
				gameState = false;
			}
		}

	}

	public void bet(int bet) {
		playerBet = bet;
	}

	public void playerHit() {
		if (playerTurn && player.getHandTotal() < 21) {
			player.hit();
		} else {
			playerTurn = false;
		}
	}

	public void playerStand() {
		playerTurn = false;
	}

	public static int getPlayerScore() {
		return player.getHandTotal();
	}

	public static int getDealerScore() {
		return dealer.getHandTotal();
	}

	public static void dealStartingCards() {
		newDeck.shuffle();
		for (int i = 0; i < 2; i++) {
			player.hit();
			dealer.hit();
		}
	}

	public static boolean isBust() {
		if (player.getHandTotal() > 21) {
			return true;
		} else
			return false;

	}
	
	public static Player getPlayer() {
		return player;
	}

}