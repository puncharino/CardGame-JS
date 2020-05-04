/**
 * Sample Skeleton for 'cardGameTemplate.fxml' Controller Class
 */

package CardGame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

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

	@FXML
	public void HitAction(ActionEvent event) {
		System.out.println("You hit");
		playerTimesHit++;
		BlackJack.player.hit();

		if (playerTimesHit == 1) {
			playerCard5.setVisible(true);
			playerCard5.setImage(BlackJack.player.getHand().get(2).cardFace);
		}

		if (playerTimesHit == 2) {
			playerCard2.setVisible(true);
			playerCard2.setImage(BlackJack.player.getHand().get(3).cardFace);
		}

		if (playerTimesHit == 3) {
			playerCard6.setVisible(true);
			playerCard6.setImage(BlackJack.player.getHand().get(4).cardFace);
		}

		if (playerTimesHit == 4) {
			playerCard1.setVisible(true);
			playerCard1.setImage(BlackJack.player.getHand().get(5).cardFace);
		}

		playerScoreValue.setText("" + BlackJack.getPlayerScore());

		if (BlackJack.isBust()) {
			bustText.setVisible(true);
//			againButton.setVisible(true);
			hitButton.setDisable(true);
			standButton.setDisable(true);
		}
		// playerScoreValue = Player.getPlayerValue();

		if (BlackJack.getPlayerScore() > 20) {
			hitButton.setDisable(true);
		}
	}

	@FXML
	void StandAction(ActionEvent event) {

		System.out.println("You stand");
		BlackJack.dealer.dealerTurn = true;

		// dealerCard3.setImage(BlackJack.dealer.getHand().get(0).cardFace);
		dealerCard4.setImage(BlackJack.dealer.getHand().get(1).cardFace);

//    	BlackJack.Start();

		//dealer draws
		while (BlackJack.dealer.getHandTotal() < 22 && !BlackJack.dealerWin && BlackJack.gameState) {
			if (BlackJack.dealer.getHandTotal() < 17) {
				BlackJack.dealer.hit();

				// dealer card visibility

				if (dealerTimesHit == 0) {
					dealerCard5.setVisible(true);
					dealerCard5.setImage(BlackJack.dealer.getHand().get(2).cardFace);
				}

				if (dealerTimesHit == 1) {
					dealerCard2.setVisible(true);
					dealerCard2.setImage(BlackJack.dealer.getHand().get(3).cardFace);
				}

				if (dealerTimesHit == 2) {
					dealerCard6.setVisible(true);
					dealerCard6.setImage(BlackJack.dealer.getHand().get(4).cardFace);
				}

				if (dealerTimesHit == 3) {
					dealerCard1.setVisible(true);
					dealerCard1.setImage(BlackJack.dealer.getHand().get(5).cardFace);
				}
				dealerTimesHit++;

			} else if (BlackJack.dealer.getHandTotal() > BlackJack.player.getHandTotal()) {
				BlackJack.dealerWin = true;
				BlackJack.gameState = false;
			} else if (BlackJack.dealer.getHandTotal() < BlackJack.player.getHandTotal()) {
				BlackJack.dealerWin = false;
				BlackJack.gameState = false;

			} else if (BlackJack.player.getHandTotal() == BlackJack.dealer.getHandTotal()) {
				BlackJack.dealerWin = false;
				BlackJack.gameState = false;
			}
		}

		dealerScoreValue.setText("" + BlackJack.getDealerScore());
		if (!BlackJack.dealerWin) {
			winText.setVisible(true);

		} else {
			LoseText.setVisible(true);
		}
		hitButton.setDisable(true);
		standButton.setDisable(true);
//		againButton.setVisible(true);
	}

	@FXML
	void StartGame(ActionEvent event) {
		System.out.println("game started");
		if(BlackJack.player.getHandTotal() == 21) {
			winText.setVisible(true);
			hitButton.setDisable(true);
			standButton.setDisable(true);
//			againButton.setVisible(true);
		}

		// set initially drawn card images
		playerCard3.setImage(BlackJack.player.getHand().get(0).cardFace);
		playerCard4.setImage(BlackJack.player.getHand().get(1).cardFace);

		dealerCard3.setImage(BlackJack.dealer.getHand().get(0).cardFace);

		dealerScoreValue.setText("" + BlackJack.getDealerScore());
		playerScoreValue.setText("" + BlackJack.getPlayerScore());

		startButton.setVisible(false);
		standButton.setVisible(true);
		hitButton.setVisible(true);

	}

	@FXML
	void reset() {
		
		System.out.println("Resetting...");
		//FXMLLoaderTest.close(FXMLLoaderTest.stage1);
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		BlackJack.dealStartingCards();

		// playerScoreValue.setText(""+ BlackJack.getPlayerScore());
		// dealerScoreValue.setText(""+ BlackJack.getDealerScore());

		assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
		assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";

	}

//    public static void returnCard(int timesHit) {
//    	return dealerCard5;
//	}

}
