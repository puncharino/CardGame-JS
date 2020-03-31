package CardGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class displayFrame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BlackJack186");
        
        Button button1 = new Button("Button 1");
        
        
        button1.setText("Click Me!");
        button1.setMaxSize(100, 200);
        
        button1.setStyle("-fx-background-color: #009900; ");
        int counter = 0;
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello");
            }
        });
        
        
        Scene scene = new Scene(button1, 0, 0);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setFullScreen(false);
        
        
        scene.setCursor(Cursor.HAND);
        
//        String styles =
//                "-fx-background-color: #0000ff;" +
//                "-fx-border-color: #ff0000;" ;
//        button.setStyle(styles);
        
        
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}