package com.example.budgetcalculator;

public class Salary extends Employee {

    private double salary;
    public Salary(String name, double salary){
        super(name);
        this.salary = salary;
        this.type = "Salary";
        calculateWage();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
        calculateWage();
    }

    private void calculateWage() {
        wage = this.salary/12;
    }

}
