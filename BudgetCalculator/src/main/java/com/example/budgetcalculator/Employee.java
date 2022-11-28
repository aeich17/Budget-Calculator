/** Group Members: Ej Boakye, Adam Eichman, Michel Emborsky, Jake Ferner, Hunter Uebelacker * Date: 11/27/2022 
* Section: CSC 331 * Purpose: The Employee class creates an object called Employee. The object has only one instance variable, 
* which is name. There is a get and set method for the name instance variable. */
package com.example.budgetcalculator;

abstract public class Employee {

    private String name;
    protected double wage;
    protected String type;
    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getWage() {
        return String.format("$%.2f", wage);
    }
    
}
