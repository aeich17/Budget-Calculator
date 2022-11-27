package com.example.budgetcalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;


public class BudgetController implements Initializable {
    private Scene scene;


    @FXML
    private Button Business;

    @FXML
    private Button Personal;

    @FXML
    private Button Settings;

    @FXML
    private Button homeNext;

    @FXML
    private TextField userRevenue;

    @FXML
    private TextField userTaxRate;

    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    
    public void changeSceneBtn1() throws Exception {
        int revenue, tax, tax1, afterTaxRevenue;

        try {
            revenue = Integer.parseInt(userRevenue.getText());
            tax = Integer.parseInt(userTaxRate.getText());
            tax1 = (tax / 100) + 1;
            afterTaxRevenue = revenue * tax1;


        } catch (NumberFormatException ex) {
            userRevenue.setText("Enter amount");
            userTaxRate.setText("Enter percentage");
            userRevenue.requestFocus();
        }
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
        Stage window = (Stage) homeNext.getScene().getWindow();
        window.setScene(new Scene(root));
    }


}
