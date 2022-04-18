package com.aetherwars.services;

import com.aetherwars.GamePlay;

public class EndPhase {
    public void changeTurn(GamePlay gamePlay) {
        if (gamePlay.currPlayerIndex == 0) {
            gamePlay.currPlayerIndex = 1;
        } else {
            gamePlay.currPlayerIndex = 0;
            gamePlay.round++;
        }
        gamePlay.nextPhase();
    }
}
