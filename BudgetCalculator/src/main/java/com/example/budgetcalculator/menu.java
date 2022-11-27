// Menu Class
// Purpose: Is used to store userTaxRate and userRevenue in an instance of the class. Contains getter and setter methods.

package com.example.budgetcalculator;


public class Menu {
    public double userRevenue;
    public double userAfterTax;

    public Menu(double userRevenue, double userTaxRate) {
        this.userAfterTax = userAfterTax;
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
}

