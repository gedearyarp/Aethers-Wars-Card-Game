package com.aetherwars.model;
import java.util.*;

public class Board {
    private ArrayList<HashMap<String, ArrayList<Card>>> board;

    public Board(){
        this.board = new ArrayList<HashMap<String, ArrayList<Card>>>();
        this.board.get(0).put("A", new ArrayList<Card>());
        this.board.get(0).put("B", new ArrayList<Card>());
        this.board.get(0).put("C", new ArrayList<Card>());
        this.board.get(0).put("D", new ArrayList<Card>());
        this.board.get(0).put("E", new ArrayList<Card>());
        this.board.get(1).put("A", new ArrayList<Card>());
        this.board.get(1).put("B", new ArrayList<Card>());
        this.board.get(1).put("C", new ArrayList<Card>());
        this.board.get(1).put("D", new ArrayList<Card>());
        this.board.get(1).put("E", new ArrayList<Card>());
    }

    public ArrayList<HashMap<String, ArrayList<Card>>> get(){
        return this.board;
    }

    public HashMap<String, ArrayList<Card>> get(Integer player){
        return this.board.get(player);
    }

    public boolean isBoardEmpty(int player, String position){
        return this.board.get(player).get(position).size() == 0;
    }

    public void putCharacterOnBoard(int player, Card card, String dest){
        if (player == 1 && this.isBoardEmpty(player, dest)){
            this.board.get(player).get(dest).add(card);
        }
        else if (player == 2 && this.isBoardEmpty(player, dest)){
            this.board.get(player).get(dest).add(card);
        }
    }
    
    // TODO GEDEARYA DHIKAARTHA: BUAT FUNGSI APPLY EFFECT UNTUK FUNGSI DI BAWAH INI
    public void putSpellOnBoard(int player, Spell spell, String dest){
        if (this.board.get(player).get(dest).size() >= 1) {
            if(spell.getSpellType() == SpellType.PTN){
                if (this.board.get(player).get(dest).get(1).getSpellType()  == SpellType.PTN){
                    if (this.board.get(player).get(dest).get(1).getId() == spell.getId()){
                        this.board.get(player).get(dest).get(1).setDuration(spell.getDuration() + this.board.get(player).get(dest).get(1).getDuration());
                    }
                    else{
                        // APUS DI (1), GANTI YG BARU
                        Card originalCard = this.board.get(player).get(dest).get(2);
                        this.board.get(player).put(dest, new ArrayList<Card>());
                        this.board.get(player).get(dest).add(originalCard);
                        this.board.get(player).get(dest).add(spell);
                        this.board.get(player).get(dest).add(originalCard);
                        // --KASIH EFEK KE SI KARTU 0
                        // JANGANLUPA ORIAN BRADERR
                        // RESMIAN ONLY NO TRONDOL
                        // --EFEK GANTI, DURASI BARU
                        
                    }
                }
                else if (this.board.get(player).get(dest).size() == 1){
                    this.board.get(player).get(dest).add(spell);
                    // APPLY EFFECT
                }
            }
            else if(spell.getSpellType() == SpellType.LVL){
                    // --NAMBAH LEVEL KARAKTER, XP RESET
                    // --APPLY EFFECT
            }
            
            else if(spell.getSpellType() == SpellType.SWAP){
                if (this.board.get(player).get(dest).get(1).getSpellType()  == SpellType.SWAP){
                    // --TAMBAH DURASI
                }
                else if (this.board.get(player).get(dest).size() == 1){
                    this.board.get(player).get(dest).add(spell);
                    // --APPLY EFFECT
                }
            }
            else if(spell.getSpellType() == SpellType.MORPH){
                    // --GANTI KARAKTER BEBAS TAPI EXP SAMA LVL RESET
                    // --APPLY EFFECT
            }
        }
    }
    public void removeCardFromBoard(int player, String position){
        this.board.get(player).put(position, new ArrayList<Card>());
    }

    public Card getCardFromBoard(int player, String position){
        return this.board.get(player).get(position).get(0);
    }
}