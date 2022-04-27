package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;

public class AttackPhase {
    // 1. iterate tiap karakter yang player punya buat nyerang TODO : ini buat di main kali ya (?)
    // 2. pas nyerang, musuh juga nyerang
    // 3. bikin fungsi karakter mati
    // 4. bikin fungsi naik level karakter

    public void resetAllCharAttackedState(GamePlay game) {
        Board board = game.getBoard();
        for (int i = 0; i < board.get().size(); i++) {
            SummonedCharacter tempACharacter = game.getBoard().getCardFromBoard(game.getCurrPlayerIndex(), "A");
            SummonedCharacter tempBCharacter = game.getBoard().getCardFromBoard(game.getCurrPlayerIndex(), "B");
            SummonedCharacter tempCCharacter = game.getBoard().getCardFromBoard(game.getCurrPlayerIndex(), "C");
            SummonedCharacter tempDCharacter = game.getBoard().getCardFromBoard(game.getCurrPlayerIndex(), "D");
            SummonedCharacter tempECharacter = game.getBoard().getCardFromBoard(game.getCurrPlayerIndex(), "E");
            if(tempACharacter.getCharacter().getId() != 0)
            {
                tempACharacter.setHasAttacked(false);
            }
            if(tempBCharacter.getCharacter().getId() != 0)
            {
                tempBCharacter.setHasAttacked(false);
            }
            if(tempCCharacter.getCharacter().getId() != 0)
            {
                tempCCharacter.setHasAttacked(false);
            }

            if(tempDCharacter.getCharacter().getId() != 0)
            {
                tempDCharacter.setHasAttacked(false);
            }
            if(tempECharacter.getCharacter().getId() != 0)
            {
                tempECharacter.setHasAttacked(false);
            }
        }
    }

    public void attackOtherCharacter(GamePlay gamePlay, String attackingCharPos, String selectedCharPos){

    
        SummonedCharacter attackingChar = gamePlay.getBoard().getCardFromBoard(gamePlay.getCurrPlayerIndex(), attackingCharPos);
        SummonedCharacter selectedChar = gamePlay.getBoard().getCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharPos);
        System.out.println(attackingChar.toString());
        
        if(!attackingChar.getHasAttacked()) {
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
                gamePlay.getBoard().removeCardFromBoard(gamePlay.getCurrPlayerIndex(), attackingCharPos);
                if(selectedChar.getTotalHp() > 0){
                    selectedChar.setExperience(selectedChar.getExperience() + attackingChar.getExperience());
                    selectedChar.checkLevelUp();
                }
            }
            attackingChar.setHasAttacked(true);
        }    
    }

    public void attackOtherPlayer(GamePlay gamePlay, String attackingCharPos){
        if (gamePlay.getBoard().isBoardEmpty(gamePlay.getOtherPlayerIndex())){
            SummonedCharacter attackingChar = gamePlay.getBoard().getCardFromBoard(gamePlay.getCurrPlayerIndex(), attackingCharPos);
            if(!attackingChar.getHasAttacked()) {
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
                attackingChar.setHasAttacked(true);
            }
        }
    }
    
}
