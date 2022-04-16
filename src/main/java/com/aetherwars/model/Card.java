package com.aetherwars.model;

public class Card {
    protected Integer id;
    protected String name;
    protected String description;
    protected Integer manaCost;
    protected String imagePath;
    protected String cardType;  //Character, Spell

    public Card() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.manaCost = 0;
        this.imagePath = "";
        this.cardType = "";
    }

    public Card(Integer id, String name, String description, Integer manaCost, String imagePath, String cardType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.imagePath = imagePath;
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nDescription: " + this.description + "\nmanaCost: " + this.manaCost;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
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

    public SpellType getSpellType() {
        return SpellType.NONE;
    }

    public void setDuration(Integer duration) {
    }

    public Integer getDuration() {
        return 0;
    }
}
