package com.aetherwars.model;
import java.util.*;

public class Player {
    private String name;
    private Integer mana;
    private Integer hp;
    private ArrayList<Card> handCard;
    private Deck deck;

    public Player() {
        this.name = "";
        this.deck = new Deck();
        this.handCard = new ArrayList<Card>();
        this.mana = 0;
        this.hp = 80;
    }
    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
        this.handCard = new ArrayList<Card>();
        this.mana = 0;
        this.hp = 80;
    }
    public Player(String name, Integer mana, Integer hp) {
        this.name = name;
        this.deck = new Deck();
        this.handCard = new ArrayList<Card>();
        this.mana = mana;
        this.hp = hp;
    }

    public String getName(){
        return this.name;
    }
    public Integer getMana(){
        return this.mana;
    }
    public Integer getHp(){
        return this.hp;
    }
    public ArrayList<Card> getHandCard(){
        return this.handCard;
    }
    public Deck getDeck(){
        return this.deck;
    }

    public void setName(String newName){
        this.name = newName;
    }
    public void setMana(Integer newMana){
        if(newMana <= 0){
            this.mana = 0;
            return;
        }
        if(newMana >= 10){
            this.mana = 10;
            return;
        }
        this.mana = newMana;
    }
    public void setHp(Integer newHp){
        if(newHp <= 0){
            this.hp = 0;
            return;
        }
        this.hp = newHp;
    }

    public void addHandCard(Card newCard){
        if(this.handCard.size() >= 5){
            return;
        }
        this.handCard.add(newCard);
    }

    public Card getHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return null;
        }
        return this.handCard.get(i);
    }

    public void removeHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return;
        }
        this.handCard.remove(i);
    }

    public Card takeHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return null;
        }
        Card card = this.handCard.get(i);
        this.handCard.remove(i);
        return card;
    }
}