package CardGame.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLLoaderTest extends Application {

    public static void main(String[] args) {
        Application.launch(FXMLLoaderTest.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("BlackJack");
        stage.setScene(createScene());
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }

    public static Scene createScene() throws IOException {
        Parent root = FXMLLoader.load(FXMLLoaderTest.class.getResource("cardGameTemplate.fxml"));

        return new Scene(root, 640, 400);
    }


}