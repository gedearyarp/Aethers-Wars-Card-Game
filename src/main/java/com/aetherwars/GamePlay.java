package com.aetherwars;

import com.aetherwars.model.*;

public class GamePlay {
    public Integer round;
    public Integer currPlayerIndex;
    public Phase phase;
    public Player[] players;
    public Board board;

    public GamePlay(Player playerA, Player playerB) {
        this.round = 0;
        this.phase = Phase.DRAW;
        this.currPlayerIndex = 0;
        this.players = new Player[2];
        this.players[0] = playerA;
        this.players[1] = playerB;
        this.board = new Board();
    }

    public Integer getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Phase getPhase() {
        return phase;
    }

    public Integer getRound() {
        return round;
    }

    public Board getBoard() {
        return board;
    }

    public void nextPhase() {
        if (this.phase == Phase.DRAW) {
            this.phase = Phase.PLANNING;
        }
        else if (this.phase == Phase.PLANNING) {
            this.phase = Phase.ATTACK;
        }
        else if (this.phase == Phase.ATTACK) {
            this.phase = Phase.END;
        }
        else if (this.phase == Phase.END) {
            this.round++;
            this.phase = Phase.DRAW;
        }
    }
}
