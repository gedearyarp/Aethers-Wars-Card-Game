package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;
import java.util.*;

public class DrawPhase {

    // NGAMBIL 3 KARTU DARI DECK pake getTop3Deck
    public ArrayList<Card> getTopThreeFromCurrPlayersDeck(GamePlay gamePlay) {
        return gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getDeck().getTop3();
    }

    // input drawCards yang dipilih dari frontend
    public void drawSelectedCardAndReturnRemainToDeck(GamePlay gamePlay, ArrayList<Card> topThreeDeck, int selectedCardIndex) {
        // remove selected card from drawCards and input to Hand
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].addHandCard(topThreeDeck.get(selectedCardIndex));
        topThreeDeck.remove(selectedCardIndex);
        // input ulang drawCards ke Deck
        for (Card card : topThreeDeck) {
            gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getDeck().putCardOnDeckRandomly(card);
        }
    }

    public void removeHandCardIfMoreThanFive(GamePlay gamePlay, Integer selectedCardIndex) throws Exception {
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedCardIndex);
    }

    public void resetMana(GamePlay gamePlay) throws Exception {
        // reset mana
        int newMana = gamePlay.getRound();
        if (newMana > 10){
            newMana = 10;
        }
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].setMana(newMana);
    }
}
