package com.example.budgetcalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;

public class AreaController {

    @FXML
    private Button Business;

    @FXML
    private Button Personal;

    @FXML
    private Button Settings;

    @FXML
    private TextField areaNameInput;

    @FXML
    private Button areaNext;

    @FXML
    private TableView<Area> allTable;

    @FXML
    private TableColumn<Area, String> areaTable;

    @FXML
    private TableColumn<Area, Integer> percentTable;

    @FXML
    private Label percentLabel;

    @FXML
    private Slider percentSlider;

    @FXML
    private Label percentLeft;

    @FXML
    private Button removeArea;

    @FXML
    private Button addArea;



    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private double areaPercentage = 0.00;
    private double percentLeftFinal = 1.00;

    public void initialize() {

            percentSlider.valueProperty().addListener((ov, oldValue, newValue) -> {
                areaPercentage = (newValue.intValue() / 100.0);
                percentLabel.setText(percent.format(areaPercentage));
            });


        areaTable.setCellValueFactory(new PropertyValueFactory<Area, String>("areaName"));
        percentTable.setCellValueFactory(new PropertyValueFactory<Area, Integer>("percentage"));

    }

    double countPercent = 100;

    ArrayList<String> arrayAreas = new ArrayList<String>();

    // Add
    @FXML
    void addAreaAction(ActionEvent event) {   // change to try catch
        countPercent -= Math.round(areaPercentage * 100);


        if ((countPercent <= 100) & (countPercent >= 0)) {
            Area area = new Area(areaNameInput.getText(), areaPercentage);
            ObservableList<Area> areas = allTable.getItems();
            areas.add(area);
            allTable.setItems(areas);
            percentLeftFinal = countPercent / 100;
            arrayAreas.add(String.valueOf(area));
            percentLeft.setText(percent.format(percentLeftFinal));
            areaNameInput.clear();
            percentSlider.setValue(percentSlider.getMin());
        }

        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("User Error");
            errorAlert.setContentText("Total percentage must be no more than 100");
            errorAlert.showAndWait();
            countPercent += Math.round(areaPercentage * 100);
            percentSlider.setValue(percentSlider.getMin());

        }
    }

    @FXML
    void removeAreaAction(ActionEvent event) {
        Area tempArea = allTable.getSelectionModel().getSelectedItem();
        countPercent += (tempArea.getPercentage()) * 100;
        percentLeftFinal = countPercent / 100;
        percentLeft.setText(percent.format(percentLeftFinal));
        ObservableList<Area> chosenRow = allTable.getSelectionModel().getSelectedItems();
        ArrayList<Area> rowDelete = new ArrayList<>(chosenRow);
        arrayAreas.add(String.valueOf(chosenRow));  // Test
        rowDelete.forEach(row -> allTable.getItems().remove(row));
    }




    public void changeSceneBtn3() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Pie.fxml"));
        Stage window = (Stage) areaNext.getScene().getWindow();
        window.setScene(new Scene(root));

    }
}

