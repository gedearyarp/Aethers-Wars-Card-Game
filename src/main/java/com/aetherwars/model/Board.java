package com.aetherwars.model;

import java.util.*;

public class Board {
    private ArrayList<HashMap<String, SummonedCharacter>> board;

    public Board(){
        this.board = new ArrayList<HashMap<String, SummonedCharacter>>();
        this.board.get(0).put("A", new SummonedCharacter());
        this.board.get(0).put("B", new SummonedCharacter());
        this.board.get(0).put("C", new SummonedCharacter());
        this.board.get(0).put("D", new SummonedCharacter());
        this.board.get(0).put("E", new SummonedCharacter());
        this.board.get(1).put("A", new SummonedCharacter());
        this.board.get(1).put("B", new SummonedCharacter());
        this.board.get(1).put("C", new SummonedCharacter());
        this.board.get(1).put("D", new SummonedCharacter());
        this.board.get(1).put("E", new SummonedCharacter());
    }

    public ArrayList<HashMap<String, SummonedCharacter>> get(){
        return this.board;
    }

    public HashMap<String, SummonedCharacter> get(Integer player){
        return this.board.get(player);
    }


    public boolean isBoardEmpty(int player){
        return this.board.get(player).get("A").getCharacter() == null &&
                this.board.get(player).get("B").getCharacter() == null &&
                this.board.get(player).get("C").getCharacter() == null &&
                this.board.get(player).get("D").getCharacter() == null &&
                this.board.get(player).get("E").getCharacter() == null;
    }

    public boolean isBoardEmpty(int player, String position){
        return this.board.get(player).get(position).getCharacter() == null;
    }

    public void putCharacterOnBoard(int player, Character card, String dest){
        if (this.isBoardEmpty(player, dest)){
            this.board.get(player).put(dest, new SummonedCharacter(card,1,0));
        }
    }

    public void putSpellOnBoard(int player, Spell spell, String dest) throws Exception{
        if (!this.isBoardEmpty(player,dest)){
            spell.use(this.board.get(player).get(dest));
        }
    }

    public void removeCardFromBoard(int player, String position){
        this.board.get(player).put(position, new SummonedCharacter());
    }

    public SummonedCharacter getCardFromBoard(int player, String position){
        return this.board.get(player).get(position);
    }
}