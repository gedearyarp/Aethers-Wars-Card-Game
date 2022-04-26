package com.aetherwars.service;

import com.aetherwars.GamePlay;

public class EndPhase {
    public void changeTurn(GamePlay gamePlay) {
        if (gamePlay.getCurrPlayerIndex() == 0) {
            gamePlay.setCurrPlayerIndex(1);
        } else {
            gamePlay.setCurrPlayerIndex(0);
            gamePlay.setRound(gamePlay.getRound() + 1);
        }
        gamePlay.nextPhase();
    }
}
