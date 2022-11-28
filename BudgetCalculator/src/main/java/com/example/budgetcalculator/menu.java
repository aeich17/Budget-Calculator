// Menu Class
// Purpose: Is used to store userTaxRate and userRevenue in an instance of the class. Contains getter and setter methods.
/** Group Members: Ej Boakye, Adam Eichman, Michel Emborsky, Jake Ferner, Hunter Uebelacker 
* Date: 11/27/2022 * Section: CSC 331 * Purpose: EmployeeController is the controller class for the Employees.fxml scene. 
* This scene includes buttons, Vbox, textfields, and a choice box. Method changeSceneBtn2 changes the scene to the Area.fxml file. 
* Throws an exception if file is not found or does not exist. */
package com.example.budgetcalculator;


public class Menu {
    public double userRevenue;
    public double userTax;
    public double userAfterTax;

    public Menu(double userRevenue, double userTax, double userAfterTax) {
        this.userAfterTax = userAfterTax;
        this.userTax = userTax;
        this.userRevenue = userRevenue;
    }

    public void setUserRevenue() {
        userRevenue = this.userRevenue;
    }
    public double getUserRevenue() {
        return userRevenue;
    }
    public void setUserAfterTax() {
        userAfterTax = this.userAfterTax;
    }
    public double getUserAfterTax() {
        return userAfterTax;
    }
    public double getUserTax() {
        return userTax;
    }

    public void setUserTax(double userTax) {
        this.userTax = userTax;
    }

}


