package com.example.businesscalculator;

public class Salary extends Employee {
    private double salary;
    public Salary(String name, double salary){
        super(name);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double wage() {
        return this.salary/12;
    }
}
