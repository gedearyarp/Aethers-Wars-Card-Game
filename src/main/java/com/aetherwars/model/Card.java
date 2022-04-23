package com.aetherwars.model;

import com.aetherwars.type.*;

public class Card {
    protected Integer id;
    protected String name;
    protected String description;
    protected Integer manaCost;
    protected String imagePath;
    protected CardType cardType;

    public Card() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.manaCost = 0;
        this.imagePath = "";
        this.cardType = CardType.CHARACTER;
    }

    public Card(Integer id, String name, String description, Integer manaCost, String imagePath, CardType cardType) {
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
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardType getCardType() {
        return this.cardType;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getmanaCost() {
        return this.manaCost;
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

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
