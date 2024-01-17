package com.example.mydemo.entity;

public class AccountItem {

    private String name;

    private Integer imagePath;

    public AccountItem(int imagePath, String name) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImagePath() {
        return imagePath;
    }

    public void setImagePath(Integer imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "AccountItem{" +
                "name='" + name + '\'' +
                ", imagePath=" + imagePath +
                '}';
    }
}