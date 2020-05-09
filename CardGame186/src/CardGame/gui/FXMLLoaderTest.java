package CardGame.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLLoaderTest extends Application {

    public static void main(String[] args) {
        Application.launch(FXMLLoaderTest.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("cardGameTemplate.fxml"));
        
        stage.setTitle("BlackJack");
        stage.setScene(new Scene(root, 640, 400));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }

}