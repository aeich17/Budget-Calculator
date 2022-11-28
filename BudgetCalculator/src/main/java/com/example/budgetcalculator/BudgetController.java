/** Group Members: Ej Boakye, Adam Eichman, Michel Emborsky, Jake Ferner, Hunter Uebelacker * Date: 11/27/2022
* Section: CSC 331 * Purpose: BudgetController is the controller for the BudgetCalculatorHome.fxml. It deals with all the actions that take place
* within that scene. This scene includes buttons and textfields. There are two text fields that collect user inputted data.
* The changeSceneBtn1 method changes the scene to the Employees.fxml file. Throws an exception if file is not found or does not exist. */
package com.example.budgetcalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Button homeNext;

    @FXML
    private TextField userRevenue;

    @FXML
    private TextField userTaxRate;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    double afterTaxRevenue;
    double revenue;
    double taxAmount;
    public void changeSceneBtn1() throws Exception {;
        double tax, tax1;

        try {
            revenue = Double.parseDouble(userRevenue.getText());
            tax = Double.parseDouble(userTaxRate.getText());
            tax1 = (tax / 100);
            taxAmount = revenue * tax1;
            afterTaxRevenue = (revenue - taxAmount);

        } catch (NumberFormatException ex) {
            userRevenue.setText("Enter amount");
            userTaxRate.setText("Enter percentage");
            userRevenue.requestFocus();
        }


        Menu menu = new Menu(revenue, taxAmount, afterTaxRevenue); // change to pass afterTax

        Parent root = FXMLLoader.load(getClass().getResource("Employees.fxml"));
        Stage window = (Stage) homeNext.getScene().getWindow();
        window.setScene(new Scene(root));

    }

}
