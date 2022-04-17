package com.aetherwars.model;
import java.util.*;

public class Deck{
    private ArrayList<Card> deckCard;

    public Deck(){
        this.deckCard = new ArrayList<Card>();
    }

    public ArrayList<Card> getCard(){
        return this.deckCard;
    }

    public ArrayList<Card> getTop3(){
        ArrayList<Card> top3 = new ArrayList<Card>();
        for(int i = 0; i < 3; i++){
            if(this.deckCard.size() > i){
                top3.add(this.deckCard.get(i));
            }
        }
        return top3;
    }

    public void addCard(Card newCard){
        if(this.deckCard.size() >= 60){
            return;
        }
        this.deckCard.add(newCard);
    }

    public Card getCard(Integer i){
        if(this.deckCard.size() <= i || i < 0){
            return null;
        }
        return this.deckCard.get(i);
    }

    public void removeCard(Integer i){
        if(this.deckCard.size() <= i || i < 0){
            return;
        }
        this.deckCard.remove(i);
    }

    public Card takeCard(Integer i){
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

    public void generateDeck(){
        // TODO: generate deck
    }
}
