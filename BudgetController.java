package com.example.budgetcalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BudgetController implements Initializable {

    @FXML
    private Button Business;

    @FXML
    private ImageView menuClose;

    @FXML
    private ImageView Menu;

    @FXML
    private Button Personal;

    @FXML
    private Button Settings;

    @FXML
    private VBox menuSide;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
    
  public void changeSceneBtn1() throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
    Stage window = (Stage) homeNext.getScene().getWindow();
    window.setScene(new Scene(root));
  }


}
