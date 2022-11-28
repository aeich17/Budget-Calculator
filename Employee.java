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
