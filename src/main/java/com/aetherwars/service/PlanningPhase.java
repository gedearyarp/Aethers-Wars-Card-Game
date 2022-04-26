package com.aetherwars.service;

import com.aetherwars.*;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;

public class PlanningPhase {
    // PLANNING PHASE
    // Pemain dapat melakukan beberapa aksi (atau tidak sama sekali) dalam Planning Phase, yaitu:

    public void placeCharCard(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) throws Exception {
        // 1. Meletakkan 0 atau lebih kartu karakter. Karakter yang baru saja diletakkan memiliki level 1 dan exp 0.
        gamePlay.getBoard().putCharacterOnBoard(gamePlay.getCurrPlayerIndex(), (Character) gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition);
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
    }

    public void placeSpell(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) throws Exception {
        // 2. Meletakkan 0 atau lebih kartu spell, lalu memilih karakter yang ditargetkan.
        gamePlay.getBoard().putSpellOnBoard(gamePlay.getCurrPlayerIndex(), (Spell) gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard(selectedHandIndex), selectedBoardPosition);
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].removeHandCard(selectedHandIndex);
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
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].setMana(gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getMana() - mana);
    }
}
