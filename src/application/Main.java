package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("GUI11.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("main.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setTitle("OOP Project");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}