package com.example.budgetcalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.scene.AmbientLight;
import javafx.scene.shape.Sphere;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;

import java.io.IOException;

public class PieController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // set title for the stage
        stage.setTitle("Budget Pie Chart");
        Area a1 = new Area("tax", 15);
        Area a2 = new Area("employees", 22);
        Area a3 = new Area("food", 30);
        Area a4 = new Area("shipment", 15);
        Area a5 = new Area("marketing", 18);
        Area[] areaData = {a1, a2, a3, a4, a5};

        // piechart data
        PieChart.Data data[] = new PieChart.Data[5];

        // string and integer data



        for (int i = 0; i < areaData.length; i++) {
            data[i] = new PieChart.Data(areaData[i].getAreaName(), areaData[i].getPercentage());
        }

        // create a pie chart
        PieChart pie_chart = new
                PieChart(FXCollections.observableArrayList(data));

        // create a Group
        Group group = new Group(pie_chart);

        // create a scene
        Scene scene = new Scene(group, 500, 300);

        // set the scene
        stage.setScene(scene);

        stage.show();
    }





    public static void main(String[] args) {
        launch();
    }
}
