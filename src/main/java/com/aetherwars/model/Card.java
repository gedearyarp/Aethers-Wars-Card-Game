package com.aetherwars.model;

public class Card {
    protected Integer id;
    protected String name;
    protected String description;
    protected Integer manaCost;
    protected String imagePath;

    public Card() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.manaCost = 0;
        this.imagePath = "";
    }

    public Card(Integer id, String name, String description, Integer manaCost, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nmanaCost: " + this.manaCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getmanaCost() {
        return manaCost;
    }

    public void setmanaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }
}
