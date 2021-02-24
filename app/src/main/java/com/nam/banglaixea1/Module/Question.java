package com.nam.banglaixea1.Module;

public class Question {
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answer;
    private int your_answer;
    private int category;
    private int question_image;
    private int warning;

    public Question() {
    }

    public Question(int your_answer) {
        this.your_answer = your_answer;
    }

    public Question(String question, String option1, String option2, String option3, String option4, int answer, int your_answer, int category, int question_image, int warning) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.your_answer = your_answer;
        this.category = category;
        this.question_image = question_image;
        this.warning=warning;
    }

    public Question(int id, String question, String option1, String option2, String option3, String option4, int answer, int your_answer, int category, int question_image, int warning) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.your_answer = your_answer;
        this.category = category;
        this.question_image = question_image;
        this.warning = warning;
    }

    private Question getQuestionModel(String question, String option1, String option2, String option3, String option4, int answer, int your_answer, int category, int question_image, int warning)
    {
        Question q=new Question();
        q.question = question;
        q.option1 = option1;
        q.option2 = option2;
        q.option3 = option3;
        q.option4 = option4;
        q.answer = answer;
        q.your_answer = your_answer;
        q.category = category;
        q.question_image = question_image;
        q.warning=warning;
        return q;
    }
    private Question getQuestionModel(int id, String question, String option1, String option2, String option3, String option4, int answer, int your_answer, int category, int question_image, int warning)
    {
        Question q=new Question();
        q.id=id;
        q.question = question;
        q.option1 = option1;
        q.option2 = option2;
        q.option3 = option3;
        q.option4 = option4;
        q.answer = answer;
        q.your_answer = your_answer;
        q.category = category;
        q.question_image = question_image;
        q.warning=warning;
        return q;
    }
    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public int getYour_answer() {
        return your_answer;
    }

    public void setYour_answer(int your_answer) {
        this.your_answer = your_answer;
    }

    public int getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(int question_image) {
        this.question_image = question_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
