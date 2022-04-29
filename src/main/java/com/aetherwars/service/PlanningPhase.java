package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import com.aetherwars.type.*;
import com.aetherwars.type.SpellType;

public class PlanningPhase {
    // PLANNING PHASE
    // Pemain dapat melakukan beberapa aksi (atau tidak sama sekali) dalam Planning Phase, yaitu:

    public boolean checkManaAndReduceMana(GamePlay gamePlay, Card card, String selectedBoardPosition) throws Exception {
        if(card.getCardType() == CardType.SPELL){
            if(card.getSpellType() == SpellType.LVL){
                int[] manaCostLVL = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
                int targetLVL = gamePlay.getBoard().getCardFromBoard(gamePlay.getCurrPlayerIndex(), selectedBoardPosition).getLevel();
                card.setmanaCost(manaCostLVL[targetLVL]);
            } 
        }
        if (gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getMana() >= card.getmanaCost()) {
            int newMana = gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getMana() - card.getmanaCost();
            gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].setMana(newMana);
            return true;
        } else {
            return false;
        }
    }
    public void placeCharCard(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) throws Exception {
        // 1. Meletakkan 0 atau lebih kartu karakter. Karakter yang baru saja diletakkan memiliki level 1 dan exp 0.
        if (checkManaAndReduceMana(gamePlay, gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition)) {
            gamePlay.getBoard().putCharacterOnBoard(gamePlay.getCurrPlayerIndex(), (Character) gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition);
            gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
        }
    }

    public void placeSpell(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) throws Exception {
        // 2. Meletakkan 0 atau lebih kartu spell, lalu memilih karakter yang ditargetkan.
        if (checkManaAndReduceMana(gamePlay, gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition)) {
            gamePlay.getBoard().putSpellOnBoard(gamePlay.getCurrPlayerIndex(), (Spell) gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition);
            gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
        }
        
    }

    public void placeSpellEnemy(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition)
            throws Exception {
        // 2. Meletakkan 0 atau lebih kartu spell, lalu memilih karakter yang
        // ditargetkan.
        if (checkManaAndReduceMana(gamePlay,gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition)) {
            gamePlay.getBoard().putSpellOnBoard(gamePlay.getOtherPlayerIndex(),
                    (Spell) gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex),
                    selectedBoardPosition);
            gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
        }
    }

    public void removeCardFromHand(GamePlay gamePlay, Integer selectedHandIndex) throws Exception {
        // 3. Membuang 0 atau lebih kartu karakter atau kartu spell pada hand.
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
    }

    public void removeCardFromBoard(GamePlay gamePlay, String selectedBoardPosition) {
        // 4. Membuang 0 atau lebih karakter yang ada di board.
        gamePlay.getBoard().removeCardFromBoard(gamePlay.getCurrPlayerIndex(), selectedBoardPosition);
    }

    public void useMana(GamePlay gamePlay, String selectedBoardPosition, Integer mana) throws Exception {
        // 5. Menggunakan 0 atau lebih mana untuk meningkatkan exp karakter di board.;
        gamePlay.getBoard().get(gamePlay.getCurrPlayerIndex()).get(selectedBoardPosition).setExperience(gamePlay.getBoard().get(gamePlay.getCurrPlayerIndex()).get(selectedBoardPosition).getExperience() + mana);

        gamePlay.getBoard().get(gamePlay.getCurrPlayerIndex()).get(selectedBoardPosition).checkLevelUp();
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].setMana(gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getMana() - mana);
    }
}
