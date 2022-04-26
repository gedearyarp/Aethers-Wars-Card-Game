package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;

public class AttackPhase {
    // 1. iterate tiap karakter yang player punya buat nyerang TODO : ini buat di main kali ya (?)
    // 2. pas nyerang, musuh juga nyerang
    // 3. bikin fungsi karakter mati
    // 4. bikin fungsi naik level karakter

    public void attackOtherCharacter(GamePlay gamePlay, String attackingCharPos, String selectedCharPos){
        SummonedCharacter attackingChar = gamePlay.getBoard().getCardFromBoard(gamePlay.currPlayerIndex, attackingCharPos);
        SummonedCharacter selectedChar = gamePlay.getBoard().getCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharPos);

        attackingChar.attack(selectedChar);
        selectedChar.attack(attackingChar);

        if (selectedChar.getTotalHp() <= 0){
            gamePlay.getBoard().removeCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharPos);
            if (attackingChar.getTotalHp() > 0){
                attackingChar.setExperience(attackingChar.getExperience() + selectedChar.getExperience());
                attackingChar.checkLevelUp();
            }
        }
        if (attackingChar.getTotalHp() <= 0){
            gamePlay.getBoard().removeCardFromBoard(gamePlay.currPlayerIndex, attackingCharPos);
            if(selectedChar.getTotalHp() > 0){
                selectedChar.setExperience(selectedChar.getExperience() + attackingChar.getExperience());
                selectedChar.checkLevelUp();
            }
        }
    }

    public void attackOtherPlayer(GamePlay gamePlay, String attackingCharPos){
        if (gamePlay.getBoard().isBoardEmpty(gamePlay.getOtherPlayerIndex())){
            SummonedCharacter attackingChar = gamePlay.getBoard().getCardFromBoard(gamePlay.currPlayerIndex, attackingCharPos);
            Player selectedPlayer = gamePlay.getPlayers()[gamePlay.getOtherPlayerIndex()];
            try {
                selectedPlayer.setHp(selectedPlayer.getHp() - attackingChar.getTotalAttack());
            } catch (Exception e) {
                try {
                    selectedPlayer.setHp(0);
                } catch (Exception e1) {}
            }
            if (selectedPlayer.getHp() <= 0){
                // MENANG
            }
        }
    }
    
}
