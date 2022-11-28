package com.example.budgetcalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;

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
    private VBox menuSide;

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

    private double moneyAfterTax;

    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private double areaPercentage = 0.00;
    private double percentLeftFinal = 1.00;

    private double totalWage;

    private Menu menu;


    public void initialize() {

        percentSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                areaPercentage = (newValue.intValue() / 100.0);
                percentLabel.setText(percent.format(areaPercentage));
            }

        });


        areaTable.setCellValueFactory(new PropertyValueFactory<Area, String>("areaName"));
        percentTable.setCellValueFactory(new PropertyValueFactory<Area, Integer>("percentage"));

    }

    double countPercent = 100;

    ArrayList<Area> arrayAreas = new ArrayList<Area>();

    public void setPreviousValues(double totalWage, Menu menu) {
        this.totalWage = totalWage;
        this.menu = menu;
    }

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
            percentLeft.setText(percent.format(percentLeftFinal));
            areaNameInput.clear();
            percentSlider.setValue(percentSlider.getMin());
            arrayAreas.add(area);
        }

        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("User Error");
            errorAlert.setContentText("Total percentage must be no more than 100");
            errorAlert.showAndWait();
            countPercent += Math.round(areaPercentage * 100);
            percentSlider.setValue(percentSlider.getMin());
           // arrayAreas.add(String.valueOf(chosenRow));
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
        rowDelete.forEach(row -> allTable.getItems().remove(row));
    }


   public void changeSceneBtn3() throws Exception {

    Stage stage = new Stage();
       
    double userAfterTaxWage = menu.getUserAfterTax() - totalWage;
    PieChart.Data data[] = new PieChart.Data[arrayAreas.size() + 1];

    int i;
    for (i = 0; i <= arrayAreas.size() - 1; i ++) {
        data[i] = new PieChart.Data(arrayAreas.get(i).getAreaName(), arrayAreas.get(i).getPercentage() * userAfterTaxWage / menu.getUserRevenue());

    }
    data[i + 1] = new PieChart.Data("Wages", totalWage / menu.getUserRevenue());
    data[i + 2] = new PieChart.Data("User Tax", menu.getUserTax() / menu.getUserRevenue());

    PieChart pie_chart = new PieChart(FXCollections.observableArrayList(data));

    FXMLLoader loader = new FXMLLoader(getClass().getResource("Pie.fxml"));
    Parent root = (Parent) loader.load();
    PieController pie = loader.getController();

     pie.setPreviousValues(pie_chart);


// //     area2.setMoneyAfterTax(2000);
    pie.start(stage);

    // Group group = new Group(pie_chart);

    // create a scene
    // Scene scene = new Scene(group, 500, 300);
    // window.setScene(new Scene(root));


    // create a pie chart
   

// create a Group


    // set the scene
    // stage.setScene(scene);

    // stage.show();

   }
}



