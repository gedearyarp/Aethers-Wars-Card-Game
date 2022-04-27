package com.aetherwars.model;

import java.util.*;
import com.aetherwars.exception.*;

public class Board {
    private ArrayList<HashMap<String, SummonedCharacter>> board;

    public Board(){
        this.board = new ArrayList<HashMap<String, SummonedCharacter>>();
        this.board.add(new HashMap<String, SummonedCharacter>());
        this.board.add(new HashMap<String, SummonedCharacter>());
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
        return this.board.get(player).get("A").getCharacter().getId() == 0 &&
                this.board.get(player).get("B").getCharacter().getId() == 0 &&
                this.board.get(player).get("C").getCharacter().getId() == 0 &&
                this.board.get(player).get("D").getCharacter().getId() == 0 &&
                this.board.get(player).get("E").getCharacter().getId() == 0;
    }

    public boolean isBoardEmpty(int player, String position){
        return this.board.get(player).get(position).getCharacter().getId() == 0;
    }

    public void putCharacterOnBoard(int player, Character card, String dest) throws Exception{
        if (this.isBoardEmpty(player, dest)){
            this.board.get(player).put(dest, new SummonedCharacter(card,1,0));
        }
        else {
            throw new InvalidBoardException(dest, "char");
        }
    }

    public void putSpellOnBoard(int player, Spell spell, String dest) throws Exception{
        if (!this.isBoardEmpty(player,dest)){
            spell.use(this.board.get(player).get(dest));
        }
        else {
            throw new InvalidBoardException(dest, "spell");
        }
    }

    public void removeCardFromBoard(int player, String position){
        // this.board.get(player).get(position).setCharacter(new SummonedCharacter());
        // SummonedCharacter temp = this.board.get(player).get(position);
        // this.board.get(player).get(position) = new SummonedCharacter();

        //this.board.get(player).get(position) = new SummonedCharacter();
        this.board.get(player).put(position, new SummonedCharacter());
    }

    public SummonedCharacter getCardFromBoard(int player, String position){
        return this.board.get(player).get(position);
    }
}