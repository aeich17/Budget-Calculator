package com.example.budgetcalculator;

public class Area {
    private double percentage;
    private String areaName;
    public Area(String areaName, double percentage){
        this.areaName = areaName;
        if (percentage > 100 || percentage < 0){
            throw new IllegalArgumentException("The percentage has to be between 0 and 100.");
        }
        else{
            this.percentage = percentage;
        }
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        if (percentage >= 100 || percentage <= 0){
            throw new IllegalArgumentException("The percentage has to be between 0 and 100.");
        }
        else{
            this.percentage = percentage;
        }
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
