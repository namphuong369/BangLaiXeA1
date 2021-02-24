package com.nam.banglaixea1.Module;

public class Choice {
    private int color;
    private String name;
    private String text_total;

    private int number;
    private int number_total;
    private String warning;
    public Choice() {
    }

    public Choice(int color, String name, String text_total,  int number, int number_total,String warning) {
        this.color = color;
        this.name = name;
        this.text_total = text_total;
        this.number = number;
        this.number_total = number_total;
        this.warning=warning;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_total() {
        return text_total;
    }

    public void setText_total(String text_total) {
        this.text_total = text_total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber_total() {
        return number_total;
    }

    public void setNumber_total(int number_total) {
        this.number_total = number_total;
    }
}
