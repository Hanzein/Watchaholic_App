package com.watch.usershop.model;

public class Category {

    private String name, icon, color, brief;
    private int no;

    public Category(String name, String icon, String color, String brief, int no) {
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.brief = brief;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getno() {
        return no;
    }

    public void setno(int id) {
        this.no = no;
    }
}

