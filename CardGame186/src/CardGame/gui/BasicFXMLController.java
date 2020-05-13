/**
 * Sample Skeleton for 'cardGameTemplate.fxml' Controller Class
 */

package CardGame.gui;

import CardGame.BlackJack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static CardGame.BlackJack.*;

public class BasicFXMLController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="standButton"
	private Button standButton; // Value injected by FXMLLoader

	@FXML // fx:id="startButton"
	private Button startButton; // Value injected by FXMLLoader

	@FXML // fx:id="hitButton"
	private Button hitButton;

	@FXML // fx:id="dealerScoreValue"
	private Text dealerScoreValue; // Value injected by FXMLLoader

	@FXML // fx:id="playerScoreValue"
	private Text playerScoreValue; // Value injected by FXMLLoader

	@FXML // fx:id="winText"
	private Text winText; // Value injected by FXMLLoader

	@FXML // fx:id="LoseText"
	private Text loseText; // Value injected by FXMLLoader

	@FXML // fx:id="bustText"
	private Text bustText; // Value injected by FXMLLoader

	@FXML // fx:id="againButton"
	private Button againButton; // Value injected by FXMLLoader

	// CARD VARIABLES

	@FXML // fx:id="playerCard1"
	private ImageView playerCard1; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard2"
	private ImageView playerCard2; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard3"
	private ImageView playerCard3; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard4"
	private ImageView playerCard4; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard5"
	private ImageView playerCard5; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard6"
	private ImageView playerCard6; // Value injected by FXMLLoader

	// Dealer Cards
	@FXML // fx:id="dealerCard1"
	private ImageView dealerCard1; // Value injected by FXMLLoader

	@FXML // fx:id="dealerCard2"
	private ImageView dealerCard2; // Value injected by FXMLLoader

	@FXML // fx:id="dealerCard3"
	private ImageView dealerCard3; // Value injected by FXMLLoader

	@FXML // fx:id="dealerCard4"
	private ImageView dealerCard4; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard5"
	private ImageView dealerCard5; // Value injected by FXMLLoader

	@FXML // fx:id="playerCard6"
	private ImageView dealerCard6; // Value injected by FXMLLoader
	private final Throwable Exception = new UnsupportedOperationException("More than 4 cards drawn is not currently supported");



	private enum endState {
		WIN,LOSE,BUST
	}

	/**
	 * Performs a hit with the player, which adds a card to their visible hand and updates their scores. Checks for
	 * a player bust.
	 */
	@FXML
	public void HitAction() throws Throwable {
		//TODO LOG
		System.out.println("You hit");

		switch (playerHit(BlackJack.getPlayer())) {
			case 1:
				playerCard5.setVisible(true);
				playerCard5.setImage(getPlayer().getHand().get(2).getCardFace());
				break;
			case 2:
				playerCard2.setVisible(true);
				playerCard2.setImage(getPlayer().getHand().get(3).getCardFace());
				break;
			case 3:
				playerCard6.setVisible(true);
				playerCard6.setImage(getPlayer().getHand().get(4).getCardFace());
				break;
			case 4:
				playerCard1.setVisible(true);
				playerCard1.setImage(getPlayer().getHand().get(5).getCardFace());
				break;
			default:
				throw Exception;
		}

		/* Sets the visible score to the hand's total */
		playerScoreValue.setText(Integer.toString(getPlayer().getHandTotal()));

		if (getPlayer().getHandTotal() == 21) {
			gameEnd(endState.WIN);
		} else if (hasBusted(getPlayer())) {
			gameEnd(endState.BUST);
		} else if (getPlayer().getHandTotal() > 21) {
			hitButton.setDisable(true);
		}
	}


	void gameEnd (endState state) {
		switch (state) {
			case WIN:
				winText.setVisible(true);
				break;
			case LOSE:
				loseText.setVisible(true);
				break;
			case BUST:
				bustText.setVisible(true);
				break;
		}

		/* Finally, disable all other buttons */
		hitButton.setDisable(true);
		standButton.setDisable(true);
	}

	@FXML
	void StandAction() throws InterruptedException {
		//TODO LOG
		System.out.println("You stand");
		getDealer().setDealerTurn(true);

		// dealerCard3.setImage(BlackJack.dealer.getHand().get(0).cardFace);
		dealerCard4.setImage(getDealer().getHand().get(1).getCardFace());

		/* FIX? */
		while (getDealer().getHandTotal() < 22) {
			/* Draw cards while the dealer has less than 17 points */
			if (getDealer().getHandTotal() < 17) {
				switch (playerHit(BlackJack.getDealer())) {
					case 1:
						dealerCard5.setVisible(true);
						dealerCard5.setImage(getDealer().getHand().get(2).getCardFace());
						break;
					case 2:
						dealerCard2.setVisible(true);
						dealerCard2.setImage(getDealer().getHand().get(3).getCardFace());
						break;
					case 3:
						dealerCard6.setVisible(true);
						dealerCard6.setImage(getDealer().getHand().get(4).getCardFace());
						break;
					case 4:
						dealerCard1.setVisible(true);
						dealerCard1.setImage(getDealer().getHand().get(5).getCardFace());
						break;
				}
			} else if (dealerWin(getPlayer())) {
				gameEnd(endState.LOSE);
				break;
			} else {
				gameEnd(endState.WIN);
				break;
			}
			dealerScoreValue.setText(Integer.toString(getDealer().getHandTotal()));
		}
		dealerScoreValue.setText(Integer.toString(getDealer().getHandTotal()));

		if (getDealer().getHandTotal() > 21) {
			gameEnd((endState.WIN));		// Player Win
		} else if (dealerWin(getPlayer())) {
			gameEnd(endState.LOSE);
		} else {
			gameEnd(endState.WIN);
		}

	}

	@FXML
	void StartGame() {
		System.out.println("game started");
		if(hasBlackJack(getPlayer())) {
			winText.setVisible(true);
			hitButton.setDisable(true);
			standButton.setDisable(true);
		}

		// set initially drawn card images
		playerCard3.setImage(getPlayer().getHand().get(0).getCardFace());
		playerCard4.setImage(getPlayer().getHand().get(1).getCardFace());

		dealerCard3.setImage(getDealer().getHand().get(0).getCardFace());

		dealerScoreValue.setText(Integer.toString(getDealer().getHandTotal()));
		playerScoreValue.setText(Integer.toString(getPlayer().getHandTotal()));

		startButton.setVisible(false);
		standButton.setVisible(true);
		hitButton.setVisible(true);

	}

	@FXML
	void reset() {
		
		System.out.println("Resetting...");
		BlackJack.restartBJ();
		//TODO this is very hard
		System.err.println("This is not yet implemented...");
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		restartBJ();

		playerCard3.setImage(getPlayer().getHand().get(0).getCardBack());
		playerCard4.setImage(getPlayer().getHand().get(1).getCardBack());

		dealerCard3.setImage(getDealer().getHand().get(0).getCardBack());
		dealerCard4.setImage(getDealer().getHand().get(1).getCardBack());

		assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
	}

//    public static void returnCard(int timesHit) {
//    	return dealerCard5;
//	}

}
