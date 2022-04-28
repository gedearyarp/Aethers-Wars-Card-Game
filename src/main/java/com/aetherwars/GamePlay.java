package com.aetherwars;

import com.aetherwars.model.*;
import com.aetherwars.type.*;

public class GamePlay {
    private Integer round;
    private Integer currPlayerIndex;
    private Phase phase;
    private Player[] players;
    private Board board;

    public GamePlay(Player playerA, Player playerB) {
        this.round = 1;
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

    public Integer getOtherPlayerIndex() {
        return (currPlayerIndex == 0) ? 1 : 0;
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

    public void setCurrPlayerIndex(Integer currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public void reduceSpellDuration() {
        String[] arr = {"A", "B", "C", "D", "E"};
        for(int i = 0; i <= 1; i++) {
            for(String boardPos: arr) {
                if(this.board.get(i).get(boardPos).getCharacter().getId() != 0) {
                    this.board.get(i).get(boardPos).reduceDurationPtnSpell();
                    this.board.get(i).get(boardPos).reduceSwap();
                }
            }
        }
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
            if (this.getCurrPlayerIndex() == 0) {
                this.setCurrPlayerIndex(1);
            } else {
                this.setCurrPlayerIndex(0);
            }
            this.round++;
            this.phase = Phase.DRAW;
            reduceSpellDuration();
        }
    }
}
