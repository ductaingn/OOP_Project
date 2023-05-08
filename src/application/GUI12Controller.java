package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI12Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public boolean switchedSuccessfully=false;

    public void switchToGUI21(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI21.fxml"));
            Parent root = (Parent) loader.load();
            stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            switchedSuccessfully=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSwitchedToGUI21(){
        return switchedSuccessfully;
    }
}
