package com.aetherwars.services;

import com.aetherwars.*;
import com.aetherwars.model.*;
import java.util.*;

public class DrawPhase {

    // NGAMBIL 3 KARTU DARI DECK pake getTop3Deck
    public ArrayList<Card> getTopThreeFromCurrPlayersDeck(GamePlay gamePlay) {
        return gamePlay.players[gamePlay.currPlayerIndex].getDeck().getTop3();
    }

    // input drawCards yang dipilih dari frontend
    public void drawSelectedCardAndReturnRemainToDeck(GamePlay gamePlay, ArrayList<Card> topThreeDeck, int selectedCardIndex) {
        // remove selected card from drawCards and input to Hand
        gamePlay.players[gamePlay.currPlayerIndex].addHandCard(topThreeDeck.get(selectedCardIndex));
        topThreeDeck.remove(selectedCardIndex);
        // input ulang drawCards ke Deck
        for (Card card : topThreeDeck) {
            gamePlay.players[gamePlay.currPlayerIndex].getDeck().putCardOnDeckRandomly(card);
        }
    }

    public void removeHandCardIfMoreThanFive(GamePlay gamePlay, Integer selectedCardIndex) {
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard(selectedCardIndex);
    }

    public void resetMana(GamePlay gamePlay) {
        // reset mana
        int newMana = gamePlay.round;
        if (newMana > 10){
            newMana = 10;
        }
        gamePlay.players[gamePlay.currPlayerIndex].setMana(newMana);
    }
}
