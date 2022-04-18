package com.aetherwars.util;


import java.util.*;
import com.aetherwars.GamePlay;
import com.aetherwars.model.*;

public class Services {
    public Object handleInput(){
        // URUSAN semi gc gatau aku mah mau nangis
        return new Object();
    }

    // DRAW PHASE  1: NGAMBIL 3 KARTU DARI DECK pake getTop3Deck
    // 2. pilih dari hasil getTop3Deck
    // 3. Masukin ke hand
    public void drawPhase(GamePlay gamePlay) {
        ArrayList<Card> drawCards =  gamePlay.players[gamePlay.currPlayerIndex].getDeck().getTop3();
        // input drawCards yang dipilih dari frontend
        // remove selected card from drawCards and input to Hand
        gamePlay.players[gamePlay.currPlayerIndex].addHandCard(drawCards.get((int) handleInput()));
        drawCards.remove((int) handleInput());
        // input ulang drawCards ke Deck
        for (Card card : drawCards) {
            gamePlay.players[gamePlay.currPlayerIndex].getDeck().putCardOnDeckRandomly(card);
        }
        if (gamePlay.players[gamePlay.currPlayerIndex].getHandCard().size() > 5) {
            // input kartu buangan dari frontend
            gamePlay.players[gamePlay.currPlayerIndex].removeHandCard((int) handleInput());
        }
        // reset mana
        int newMana = gamePlay.round;
        if (newMana > 10){
            newMana = 10;
        }
        gamePlay.players[gamePlay.currPlayerIndex].setMana(newMana);
    }

    // PLANNING PHASE
    // Pemain dapat melakukan beberapa aksi (atau tidak sama sekali) dalam Planning Phase, yaitu:

    public void planningPhase(GamePlay gamePlay) {
        // 1. Meletakkan 0 atau lebih kartu karakter. Karakter yang baru saja diletakkan memiliki level 1 dan exp 0.
        gamePlay.board.putCharacterOnBoard(gamePlay.currPlayerIndex, gamePlay.players[gamePlay.currPlayerIndex].getHandCard((int) handleInput()), (String) handleInput());
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard((int) handleInput());
        // 2. Meletakkan 0 atau lebih kartu spell, lalu memilih karakter yang ditargetkan.
        // TODO GEDEARYA DHIKAARTHA: BUAT FUNGSI MENGAMBIL SPELL DARI HAND
        // gamePlay.board.putSpellOnBoard(gamePlay.currPlayerIndex, gamePlay.players[gamePlay.currPlayerIndex].getHandCard((int) handleInput()), (String) handleInput());
        // 3. Membuang 0 atau lebih kartu karakter atau kartu spell pada hand.
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard((int) handleInput());
        // 4. Membuang 0 atau lebih karakter yang ada di board.
        gamePlay.board.removeCardFromBoard(gamePlay.currPlayerIndex, (String) handleInput());
        // 5. Menggunakan 0 atau lebih mana untuk meningkatkan exp karakter di board.
        String choosenCharacter = (String) handleInput();
        //gamePlay.board.get(gamePlay.currPlayerIndex).get(choosenCharacter).get(0).setExperience(gamePlay.board.get(gamePlay.currPlayerIndex).get(choosenCharacter).get(0).getExperience() + (int) handleInput());
        //if (gamePlay.board.get(gamePlay.currPlayerIndex).get(choosenCharacter).size() > 1) {
          //  gamePlay.board.get(gamePlay.currPlayerIndex).get(choosenCharacter).get(2).setExperience(gamePlay.board.get(gamePlay.currPlayerIndex).get(choosenCharacter).get(2).getExperience() + (int) handleInput());
        }

    }
