package com.example.businesscalculator;

public class Hourly_Employee extends Employee{
    private double hours;
    private double pay;
    public Hourly_Employee(String name, double hours, double pay){
        super(name);
        this.hours = hours;
        this.pay = pay;
    }

    @Override
    public double wage() {
        return this.hours * this.pay;
    }
}
