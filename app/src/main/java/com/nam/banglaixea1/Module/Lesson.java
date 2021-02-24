package com.nam.banglaixea1.Module;

public class Lesson {
    private int id;
    private int color;
    private int number;

    private String content;
    private String result;
    private int check;
    private int timer;
    private int state;
    private int number_warning;
    private int number_null_answer;
    private int number_correct_answer;
    private int number_wrong_answer;
    public Lesson(int id, int color, int number, String content,int check,int timer,int state) {
        this.id = id;
        this.color = color;
        this.number = number;
        this.content = content;
        this.check=check;
        this.timer=timer;
        this.state=state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Lesson() {
    }



    public Lesson(String content) {
        this.content = content;
    }

    public Lesson(int color, String content,int check,int timer,int state) {
        this.color = color;
        this.content = content;
        this.check=check;
        this.timer=timer;
        this.state=state;

    }

    public Lesson( String content,int check, int timer,int state,int number_warning,int number_null_answer,int number_correct_answer,int number_wrong_answer) {
        this.content = content;
        this.check = check;
        this.timer = timer;
        this.state=state;
        this.number_warning=number_warning;
        this.number_null_answer=number_null_answer;
        this.number_correct_answer=number_correct_answer;
        this.number_wrong_answer=number_wrong_answer;
    }

    public Lesson(int color, int number, String result,int state) {
        this.color = color;
        this.number = number;
        this.result = result;
        this.state=state;
    }

    public int getNumber_warning() {
        return number_warning;
    }

    public void setNumber_warning(int number_warning) {
        this.number_warning = number_warning;
    }

    public int getNumber_null_answer() {
        return number_null_answer;
    }

    public void setNumber_null_answer(int number_null_answer) {
        this.number_null_answer = number_null_answer;
    }

    public int getNumber_correct_answer() {
        return number_correct_answer;
    }

    public void setNumber_correct_answer(int number_correct_answer) {
        this.number_correct_answer = number_correct_answer;
    }

    public int getNumber_wrong_answer() {
        return number_wrong_answer;
    }

    public void setNumber_wrong_answer(int number_wrong_answer) {
        this.number_wrong_answer = number_wrong_answer;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
