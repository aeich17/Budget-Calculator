package com.example.budgetcalculator;

public class Hourly_Employee extends Employee{
    private double hours;
    private double pay;
    public Hourly_Employee(String name, double hours, double pay){
        super(name);
        this.hours = hours;
        this.pay = pay;
        this.type = "Hourly";
        calculateWage();
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
        calculateWage();
    }

    private void calculateWage() {
        wage = this.hours * this.pay;
    }

    // public String type() {
    //     return "Hourly";
    // }
}
