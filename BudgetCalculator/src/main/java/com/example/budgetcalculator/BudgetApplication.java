/** Group Members: Ej Boakye, Adam Eichman, Michel Emborsky, Jake Ferner, Hunter Uebelacker
* Date: 11/27/2022 
* Section: CSC 331 
* Purpose: BudgetApplication acts as a driver file that runs and starts the application. The method start trys to start the first scene which would 
be the * BudgetApplicationHome.fxml file. Throws an exception if file is not found or does not exist. */

package com.example.budgetcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BudgetApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BudgetApplication.class.getResource("BudgetCalculatorHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Budget Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
