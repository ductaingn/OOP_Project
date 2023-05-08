/*
    GUI 2.* ís also GUI 3.1
 */
package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI21Controller implements Initializable {
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private AnchorPane main;
    @FXML
    private ImageView popupQuestionBank;
    @FXML
    private ImageView avatar;
    @FXML
    private ScrollPane questionListPane;

    private Stage stage;
    private Scene scene;
    private Parent root;


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

        Category category1= new Category("IT Course");
        Category subCategory1 = new Category("IT3070");
        Category subSubCategory1 = new Category("Chapter 1");
        category1.setCategoryChild(subCategory1);
        subCategory1.setCategoryChild(subSubCategory1);
        categoryComboBox.getItems().addAll(
                category1.getCategoryName(),
                subCategory1.getCategoryName(),
                subSubCategory1.getCategoryName());

        questionListPane.setVisible(false);
    }

    public void popupQuestionBank(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI12.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
