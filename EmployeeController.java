package com.example.budgetcalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.budgetcalculator.Employee;

import io.reactivex.rxjava3.core.Observable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;



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
    private TextField hours;

    @FXML
    private VBox menuSide;

    @FXML
    private TextField name;

    @FXML
    private Button removeEmployee;

    @FXML
    private Button addEmployee;

    @FXML
    private TextField salaryWage;

    @FXML
    private ChoiceBox<String> wageType;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, Double> hoursColumn;

    @FXML
    private TableColumn<Employee, String> wageColumn;

    private ObservableList<Employee> employeeList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wageType.getItems().addAll("Salary", "Hourly");
        employeeList =  FXCollections.observableArrayList();

        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));
        

        hoursColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("hours"));
        wageColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("wage"));


    }

    public void addEmployeeBtn() throws Exception {

        Employee newEmployee;
        if (wageType.getValue() == "Salary") {
            newEmployee = new Salary(name.getText(), Double.parseDouble(salaryWage.getText()));
        }
        else if (wageType.getValue() == "Hourly") {
            newEmployee = new Hourly_Employee(name.getText(), Double.parseDouble(hours.getText()), Double.parseDouble(salaryWage.getText()));
        }
        else {
            newEmployee = null;
        }


        if (newEmployee != null) {
            employeeList.add(newEmployee);

        }
        table.setItems(employeeList);
    }

    public void removeEmployeeBtn() throws Exception {
        // if (table.getSelectionModel().getSelectedIndex() != null) {
            employeeList.remove(table.getSelectionModel().getSelectedIndex());
            System.out.println(table.getSelectionModel().getSelectedIndex());
        // }
        table.setItems(employeeList);
    }
    
    public void changeSceneBtn2() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Area.fxml"));
        Stage window = (Stage) employeeNext.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
