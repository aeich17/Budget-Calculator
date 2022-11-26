package com.example.budgetcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ChoiceBox;



public class EmployeeController implements Initializable {
    private Scene scene;

    @FXML
    private Button Business;

    @FXML
    private Button Personal;

    @FXML
    private Button Settings;

    @FXML
    private Button employeeNext;

    @FXML
    private VBox menuSide;
    
    @FXML
    private TextField hours;

    @FXML
    private VBox menuSide;

    @FXML
    private TextField name;

    @FXML
    private Button removeEmployee;

    @FXML
    private TextField salaryWage;

    @FXML
    private ChoiceBox<?> wageType;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    
    public void changeSceneBtn2() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Area.fxml"));
        Stage window = (Stage) employeeNext.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
