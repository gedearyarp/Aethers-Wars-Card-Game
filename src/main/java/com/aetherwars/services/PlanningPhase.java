package com.aetherwars.services;

import com.aetherwars.*;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import java.io.IOException;

public class PlanningPhase {
    // PLANNING PHASE
    // Pemain dapat melakukan beberapa aksi (atau tidak sama sekali) dalam Planning Phase, yaitu:

    public void placeCharCard(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) {
        // 1. Meletakkan 0 atau lebih kartu karakter. Karakter yang baru saja diletakkan memiliki level 1 dan exp 0.
        gamePlay.board.putCharacterOnBoard(gamePlay.currPlayerIndex, (Character) gamePlay.players[gamePlay.currPlayerIndex].getHandCard(selectedHandIndex), selectedBoardPosition);
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard(selectedHandIndex);
    }

    public void placeSpell(GamePlay gamePlay, Integer selectedHandIndex, String selectedBoardPosition) throws IOException {
        // 2. Meletakkan 0 atau lebih kartu spell, lalu memilih karakter yang ditargetkan.
        gamePlay.board.putSpellOnBoard(gamePlay.currPlayerIndex, (Spell) gamePlay.players[gamePlay.currPlayerIndex].getHandCard(selectedHandIndex), selectedBoardPosition);
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard(selectedHandIndex);
    }

    public void removeCardFromHand(GamePlay gamePlay, Integer selectedHandIndex) {
        // 3. Membuang 0 atau lebih kartu karakter atau kartu spell pada hand.
        gamePlay.players[gamePlay.currPlayerIndex].removeHandCard(selectedHandIndex);
    }

    public void removeCardFromBoard(GamePlay gamePlay, String selectedBoardPosition) {
        // 4. Membuang 0 atau lebih karakter yang ada di board.
        gamePlay.board.removeCardFromBoard(gamePlay.currPlayerIndex, selectedBoardPosition);
    }

    public void useMana(GamePlay gamePlay, String selectedBoardPosition, Integer mana) {
        // 5. Menggunakan 0 atau lebih mana untuk meningkatkan exp karakter di board.;
        gamePlay.board.get(gamePlay.currPlayerIndex).get(selectedBoardPosition).setExperience(gamePlay.board.get(gamePlay.currPlayerIndex).get(selectedBoardPosition).getExperience() + mana);
        gamePlay.players[gamePlay.currPlayerIndex].setMana(gamePlay.players[gamePlay.currPlayerIndex].getMana() - mana);
    }
}
