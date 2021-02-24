package com.nam.banglaixea1.Module;

public class Note  {
    private String title;
    private String content;
    private int color;
    private boolean expandable;

    public Note() {
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public Note(String title, String content,int color) {
        this.title = title;
        this.content = content;
        this.color=color;
        this.expandable=false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
