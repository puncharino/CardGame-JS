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
	private Text LoseText; // Value injected by FXMLLoader

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

	private int playerTimesHit = 0;
	private int dealerTimesHit = 0;
	private BlackJack bj;
	@FXML
	public void HitAction(ActionEvent event) {
		System.out.println("You hit");
		playerTimesHit++;
		getPlayer().hit();

		if (playerTimesHit == 1) {
			playerCard5.setVisible(true);
			playerCard5.setImage(getPlayer().getHand().get(2).getCardFace());
		}

		if (playerTimesHit == 2) {
			playerCard2.setVisible(true);
			playerCard2.setImage(getPlayer().getHand().get(3).getCardFace());
		}

		if (playerTimesHit == 3) {
			playerCard6.setVisible(true);
			playerCard6.setImage(getPlayer().getHand().get(4).getCardFace());
		}

		if (playerTimesHit == 4) {
			playerCard1.setVisible(true);
			playerCard1.setImage(getPlayer().getHand().get(5).getCardFace());
		}

		playerScoreValue.setText("" + getPlayer().getHandTotal());

		if (bj.hasBusted(getPlayer())) {
			bustText.setVisible(true);
//			againButton.setVisible(true);
			hitButton.setDisable(true);
			standButton.setDisable(true);
		}
		// playerScoreValue = Player.getPlayerValue();

		if (getPlayer().getHandTotal() > 20) {
			hitButton.setDisable(true);
		}
	}

	@FXML
	void StandAction(ActionEvent event) {

		System.out.println("You stand");
		getDealer().setDealerTurn(true);

		// dealerCard3.setImage(BlackJack.dealer.getHand().get(0).cardFace);
		dealerCard4.setImage(getDealer().getHand().get(1).getCardFace());

//    	BlackJack.Start();

		//dealer draws
		while (getDealer().getHandTotal() < 22 && !dealerWin && gameState) {
			if (getDealer().getHandTotal() < 17) {
				getDealer().hit();

				// dealer card visibility

				if (dealerTimesHit == 0) {
					dealerCard5.setVisible(true);
					dealerCard5.setImage(getDealer().getHand().get(2).getCardFace());
				}

				if (dealerTimesHit == 1) {
					dealerCard2.setVisible(true);
					dealerCard2.setImage(getDealer().getHand().get(3).getCardFace());
				}

				if (dealerTimesHit == 2) {
					dealerCard6.setVisible(true);
					dealerCard6.setImage(getDealer().getHand().get(4).getCardFace());
				}

				if (dealerTimesHit == 3) {
					dealerCard1.setVisible(true);
					dealerCard1.setImage(getDealer().getHand().get(5).getCardFace());
				}
				dealerTimesHit++;

			} else if (getDealer().getHandTotal() > getPlayer().getHandTotal()) {
				dealerWin = true;
				gameState = false;
			} else if (getDealer().getHandTotal() < getPlayer().getHandTotal()) {
				dealerWin = false;
				gameState = false;

			} else if (getDealer().getHandTotal() == getPlayer().getHandTotal()) {
				dealerWin = false;
				gameState = false;
			}
		}

		dealerScoreValue.setText("" + getDealer().getHandTotal());
		if (!dealerWin) {
			winText.setVisible(true);

		} else {
			LoseText.setVisible(true);
		}
		hitButton.setDisable(true);
		standButton.setDisable(true);
//		againButton.setVisible(true);
	}

	@FXML
	void StartGame() {
		System.out.println("game started");
		if(hasBlackJack(getPlayer())) {
			winText.setVisible(true);
			hitButton.setDisable(true);
			standButton.setDisable(true);
//			againButton.setVisible(true);
		}

		// set initially drawn card images
		playerCard3.setImage(getPlayer().getHand().get(0).getCardFace());
		playerCard4.setImage(getPlayer().getHand().get(1).getCardFace());

		dealerCard3.setImage(getPlayer().getHand().get(0).getCardFace());

		dealerScoreValue.setText("" + getDealer().getHandTotal());
		playerScoreValue.setText("" + getPlayer().getHandTotal());

		startButton.setVisible(false);
		standButton.setVisible(true);
		hitButton.setVisible(true);

	}

	@FXML
	void reset() {
		
		System.out.println("Resetting...");
		BlackJack.restartBJ();
		StartGame();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		bj = new BlackJack();

		assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
	}

//    public static void returnCard(int timesHit) {
//    	return dealerCard5;
//	}

}
