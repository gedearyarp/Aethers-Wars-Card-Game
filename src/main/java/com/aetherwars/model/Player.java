package com.aetherwars.model;
import java.util.*;

public class Player {
    private String name;
    private Integer mana;
    private Integer hp;
    private ArrayList<Card> deckCard;
    private ArrayList<Card> handCard;

    public Player() {
        this.name = "";
        this.deckCard = new ArrayList<Card>();
        this.handCard = new ArrayList<Card>();
        this.mana = 0;
        this.hp = 80;
    }
    public Player(String name) {
        this.name = name;
        this.deckCard = new ArrayList<Card>();
        this.handCard = new ArrayList<Card>();
        this.mana = 0;
        this.hp = 80;
    }
    public Player(String name, Integer mana, Integer hp) {
        this.name = name;
        this.deckCard = new ArrayList<Card>();
        this.handCard = new ArrayList<Card>();
        this.mana = mana;
        this.hp = hp;
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

    public String getName(){
        return this.name;
    }
    public Integer getMana(){
        return this.mana;
    }
    public Integer getHp(){
        return this.hp;
    }
    public ArrayList<Card> getDeckCard(){
        return this.deckCard;
    }
    public ArrayList<Card> getHandCard(){
        return this.handCard;
    }
    public ArrayList<Card> getTop3Deck(){
        ArrayList<Card> top3 = new ArrayList<Card>();
        for(int i = 0; i < 3; i++){
            if(this.deckCard.size() > i){
                top3.add(this.deckCard.get(i));
            }
        }
        return top3;
    }

    public void addHandCard(Card newCard){
        if(this.handCard.size() >= 5){
            return;
        }
        this.handCard.add(newCard);
    }
    public void addDeckCard(Card newCard){
        if(this.deckCard.size() >= 60){
            return;
        }
        this.deckCard.add(newCard);
    }

    public Card getHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return null;
        }
        return this.handCard.get(i);
    }

    public Card getDeckCard(Integer i){
        if(this.deckCard.size() <= i || i < 0){
            return null;
        }
        return this.deckCard.get(i);
    }

    public void removeHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return;
        }
        this.handCard.remove(i);
    }
    public void removeDeckCard(Integer i){
        if(this.deckCard.size() <= i || i < 0){
            return;
        }
        this.deckCard.remove(i);
    }

    public Card takeHandCard(Integer i){
        if(this.handCard.size() <= i || i < 0){
            return null;
        }
        Card card = this.handCard.get(i);
        this.handCard.remove(i);
        return card;
    }

    public Card takeDeckCard(Integer i){
        if(this.deckCard.size() <= i || i < 0){
            return null;
        }
        Card card = this.deckCard.get(i);
        this.deckCard.remove(i);
        return card;
    }

    public void putCardOnDeckRandomly(Card card){
        Random rd = new Random();
        Integer i = rd.nextInt(this.deckCard.size());
        this.deckCard.add(i, card);
    }

    private void generateDeck(){
        // TODO: generate deck
    }
}
