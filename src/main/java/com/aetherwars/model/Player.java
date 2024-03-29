package com.aetherwars.model;

import java.util.*;

import com.aetherwars.exception.InvalidHpException;
import com.aetherwars.exception.InvalidManaException;

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
        this.hp = 100;
    }
    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
        this.handCard = new ArrayList<Card>();
        this.mana = 0;
        this.hp = 100;
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
    public void setMana(Integer newMana) throws Exception {
        if(newMana < 0 || newMana > 10){
            throw new InvalidManaException(mana);
        }
        this.mana = newMana;
    }
    public void setHp(Integer newHp) throws Exception {
        if(newHp < 0){
            throw new InvalidHpException(newHp);
        }
        this.hp = newHp;
    }

    public void addHandCard(Card newCard){
        if(this.handCard.size() >= 5){
            return;
        }
        this.handCard.add(newCard);
    }

    public Card getHandCard(int i) throws Exception{
        if(this.handCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Hand");
        }
        return this.handCard.get(i);
    }

    public void removeHandCard(int i) throws Exception {
        if(this.handCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Hand");
        }
        //remove card i from arraylist
        this.handCard.remove(i);
        this.handCard.trimToSize();
    }

    public Card takeHandCard(int i) throws Exception {
        if(this.handCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Hand");
        }
        Card card = this.handCard.get(i);
        this.handCard.remove(i);
        return card;
    }
}