package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;
import com.aetherwars.type.*;

public class AttackPhase {
    // 1. iterate tiap karakter yang player punya buat nyerang TODO : ini buat di main kali ya (?)
    // 2. pas nyerang, musuh juga nyerang
    // 3. bikin fungsi karakter mati
    // 4. bikin fungsi naik level karakter

    // public void attackOtherCharacter(GamePlay gamePlay, String attackingCharacter, String selectedCharacter){
    //     SummonedCharacter attackingChar = gamePlay.board.get(gamePlay.currPlayerIndex).getCardFromBoard(gamePlay.currPlayerIndex, attackingCharacter);
    //     SummonedCharacter selectedChar = gamePlay.board.get(gamePlay.getOtherPlayerIndex()).getCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharacter);
    //     selectedChar.setHealth(selectedChar.getHealth() - attackingChar.getAttack());
    //     attackingChar.setHealth(attackingChar.getHealth() - selectedChar.getAttack());
    //     if (selectedChar.getHealth() <= 0){
    //         gamePlay.board.get(gamePlay.getOtherPlayerIndex()).removeCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharacter);
    //         if (attackingChar.getHealth() > 0){
    //             attackingChar.setExperience(attackingChar.getExperience() + selectedChar.getExperience());
    //             attackingChar.checkLevelUp();
    //         }
    //     }
    //     if (attackingChar.getHealth() <= 0){
    //         gamePlay.board.get(gamePlay.currPlayerIndex).removeCardFromBoard(gamePlay.currPlayerIndex, attackingCharacter);
    //         if(selectedChar.getHealth() > 0){
    //             selectedChar.setExperience(selectedChar.getExperience() + attackingChar.getExperience());
    //             selectedChar.checkLevelUp();
    //         }
    //     }
    // }

    public void attackOtherCharacter(GamePlay gamePlay, String attackingCharacter, String selectedCharacter){
        SummonedCharacter attackingChar = gamePlay.board.get(gamePlay.currPlayerIndex).getCardFromBoard(gamePlay.currPlayerIndex, attackingCharacter);
        SummonedCharacter selectedChar = gamePlay.board.get(gamePlay.getOtherPlayerIndex()).getCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharacter);
        
        //   OVERWORLD
        //   NETHER
        //   END

        attackingChar.attack(selectedChar);
        selectedChar.attack(attackingChar);

        if (selectedChar.getCharacter().getHealth() <= 0){
            gamePlay.board.get(gamePlay.getOtherPlayerIndex()).removeCardFromBoard(gamePlay.getOtherPlayerIndex(), selectedCharacter);
            if (attackingChar.getCharacter().getHealth() > 0){
                attackingChar.setExperience(attackingChar.getExperience() + selectedChar.getExperience());
                attackingChar.checkLevelUp();
            }
        }
        if (attackingChar.getCharacter().getHealth() <= 0){
            gamePlay.board.get(gamePlay.currPlayerIndex).removeCardFromBoard(gamePlay.currPlayerIndex, attackingCharacter);
            if(selectedChar.getCharacter().getHealth() > 0){
                selectedChar.setExperience(selectedChar.getExperience() + attackingChar.getExperience());
                selectedChar.checkLevelUp();
            }
        }
    }

    public void attackOtherPlayer(GamePlay gamePlay,String attackingCharacter, String selectedPlayer){
        if (gamePlay.board.get(gamePlay.getOtherPlayerIndex().isBoardEmpty())){
            SummonedCharacter attackingChar = gamePlay.board.get(gamePlay.currPlayerIndex).getCardFromBoard(gamePlay.currPlayerIndex, attackingCharacter);
            Player selectedPlayer = gamePlay.board.get(gamePlay.getOtherPlayerIndex());
            selectedPlayer.setHp(selectedPlayer.getHp() - attackingChar.getCharacter().getAttack());
            if (selectedPlayer.getHp() <= 0){
                // MENANG
            }
        }
    }
    
}
