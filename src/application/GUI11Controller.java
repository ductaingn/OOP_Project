package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI11Controller implements Initializable{
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView popupQuestionBank;
    @FXML
    private ImageView avatar;
    Stage mainStage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            Image image1 = new Image(getClass().getResource("/images/avatar.jpg").toURI().toString());
            avatar.setImage(image1);
            Circle clip = new Circle();
            clip.setCenterX(20);
            clip.setCenterY(20);
            clip.setRadius(20);
            avatar.setClip(clip);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    public void popupQuestionBank(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI12.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //Close GUI 1.1 when GUI 2.1 is opened (This feature is not working!)
            GUI12Controller gui12Controller = loader.getController();
            if(gui12Controller.isSwitchedToGUI21()){
                closeStage();
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void closeStage(){
        try{
            mainStage = (Stage) mainPane.getScene().getWindow();
            mainStage.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
