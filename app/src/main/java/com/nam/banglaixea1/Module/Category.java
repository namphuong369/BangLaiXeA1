package com.nam.banglaixea1.Module;

import androidx.annotation.NonNull;

public class Category {
    public  static final int KHAI_NIEM=1;
    public static final int VAN_HOA=2;
    public static final int DIEM_LIET=3;
    public static final int KY_THUAT=4;
    public static final int BIEN_BAO=5;
    public static final int SA_HINH=6;
    private int id;
    private String name;
    private int count;
    public Category(){
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category(int count) {
        this.count = count;
    }

    public Category(String name, int count) {
        this.name = name;
        this.count=count;
    }

    public Category(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
