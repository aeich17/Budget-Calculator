// Menu Class
// Purpose: Is used to store userTaxRate and userRevenue in an instance of the class. Contains getter and setter methods.

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


