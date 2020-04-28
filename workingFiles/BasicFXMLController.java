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

    @FXML // fx:id="bustText"
    private Text bustText; // Value injected by FXMLLoader
    
    @FXML // fx:id="againButton"
    private Button againButton; // Value injected by FXMLLoader



    @FXML
    void HitAction(ActionEvent event) {
    	System.out.println("You hit");
    	
    	BlackJack.playerHit();
    	playerScoreValue.setText(""+ BlackJack.getPlayerScore());
    	
    	if(BlackJack.getPlayerScore() > 21) {
    		bustText.setVisible(true);
    		againButton.setVisible(true);
    	}
    	//playerScoreValue = Player.getPlayerValue();
    	
    	
    }

    @FXML
    void StandAction(ActionEvent event) {
    	System.out.println("You stand");
    	
    	BlackJack.playerStand();
    	BlackJack.Start();
    	dealerScoreValue.setText(""+ BlackJack.getDealerScore());
    	if(BlackJack.dealerWin == false) {
    		winText.setVisible(true);
    		againButton.setVisible(true);
    	}
    }

    @FXML
    void StartGame(ActionEvent event) {
    	System.out.println("game started");
    	
    	startButton.setVisible(false);
    	standButton.setVisible(true);
    	hitButton.setVisible(true);
    	
    	
    	
    }
    
    @FXML
    void reset() {
    	System.out.println("Resetting...");
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	BlackJack.dealStartingCards();
    	playerScoreValue.setText(""+ BlackJack.getPlayerScore());
    	dealerScoreValue.setText(""+ BlackJack.getDealerScore());
    	
    	
    	
        assert standButton != null : "fx:id=\"standButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";
        assert hitButton != null : "fx:id=\"hitButton\" was not injected: check your FXML file 'cardGameTemplate.fxml'.";

    }
}
