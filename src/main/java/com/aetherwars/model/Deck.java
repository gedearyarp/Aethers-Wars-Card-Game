package com.aetherwars.model;

import java.util.*;
import java.io.File;

import com.aetherwars.util.CSVReader;
import com.aetherwars.type.*;

public class Deck{
    private ArrayList<Card> deckCard;

    public Deck(){
        this.deckCard = new ArrayList<Card>();
    }

    public ArrayList<Card> getCard(){
        return this.deckCard;
    }

    public boolean isDeckEmpty(){
        return this.deckCard.isEmpty();
    }

    public ArrayList<Card> getTop3(){
        ArrayList<Card> top3 = new ArrayList<Card>();
        if (this.deckCard.size() < 3){
            for (int i = 0; i < this.deckCard.size(); i++){
                top3.add(this.deckCard.get(i));
            }
        } else {
            for (int i = 0; i < 3; i++){
                top3.add(this.deckCard.get(i));
            }
        }
        for(int i = 0; i < 3; i++){
            this.deckCard.remove(0);
        }
        return top3;
    }

    public void addCard(Card newCard) throws Exception{
        if(this.deckCard.size() >= 60){
            throw new IndexOutOfBoundsException("Deck");
        }
        this.deckCard.add(newCard);
    }

    public Card getCard(Integer i) throws Exception{
        if(this.deckCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Deck");
        }
        return this.deckCard.get(i);
    }

    public void removeCard(int i) throws Exception{
        if(this.deckCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Deck");
        }
        this.deckCard.remove(i);
    }

    public Card takeCard(int i) throws Exception{
        if(this.deckCard.size() <= i || i < 0){
            throw new IndexOutOfBoundsException("Deck");
        }
        Card card = this.deckCard.get(i);
        this.deckCard.remove(i);
        return card;
    }

    public void putCardOnDeckRandomly(Card card){
        Random rd = new Random();
        Integer i = rd.nextInt(this.deckCard.size());
        this.deckCard.add(i, card);
    }

    public void generateCard(Integer deckSize) throws Exception {
        CSVReader csvreader_character = new CSVReader(new File("src/main/resources/com/aetherwars/card/data/character.csv"), "\t");
        CSVReader csvreader_spell_morph = new CSVReader(new File("src/main/resources/com/aetherwars/card/data/spell_morph.csv"), "\t");
        CSVReader csvreader_spell_ptn = new CSVReader(new File("src/main/resources/com/aetherwars/card/data/spell_ptn.csv"), "\t");
        CSVReader csvreader_spell_swap = new CSVReader(new File("src/main/resources/com/aetherwars/card/data/spell_swap.csv"), "\t");
        csvreader_character.setSkipHeader(true);
        csvreader_spell_morph.setSkipHeader(true);
        csvreader_spell_ptn.setSkipHeader(true);
        csvreader_spell_swap.setSkipHeader(true);
        List<String[]> character_data = csvreader_character.read();
        List<String[]> spell_morph_data = csvreader_spell_morph.read();
        List<String[]> spell_ptn_data = csvreader_spell_ptn.read();
        List<String[]> spell_swap_data = csvreader_spell_swap.read();

        Integer characterSizeDeck = deckSize / 2;
        Integer spellSizeDeck = deckSize - characterSizeDeck;
        Random rd = new Random();
        
        for(int i = 0; i < characterSizeDeck; i++){
            Integer rd_c = rd.nextInt(character_data.size());
            String[] character_data_i = character_data.get(rd_c);
            Integer id = Integer.parseInt(character_data_i[0]);
            String name = character_data_i[1];
            String description = character_data_i[3];
            Integer manaCost = Integer.parseInt(character_data_i[7]);
            String imagePath = character_data_i[4];
            Integer attack = Integer.parseInt(character_data_i[5]);
            Type type = Type.valueOf(character_data_i[2]);
            Integer health = Integer.parseInt(character_data_i[6]);
            Integer attackUp = Integer.parseInt(character_data_i[8]);
            Integer healthUp = Integer.parseInt(character_data_i[9]);

            Character character = new Character(
                id,
                name,
                description,
                manaCost,
                imagePath,
                attack,
                type,
                health,
                attackUp,
                healthUp
            );

            this.addCard(character);
        }

        for(int i=0; i < spellSizeDeck; i++){
            Integer rd_s = rd.nextInt(4);
            if (rd_s == 0){
                Integer rd_s_m = rd.nextInt(spell_morph_data.size());
                String[] spell_morph_data_i = spell_morph_data.get(rd_s_m);
                
                Integer id = Integer.parseInt(spell_morph_data_i[0]);
                String name = spell_morph_data_i[1];
                String description = spell_morph_data_i[2];
                Integer manaCost = Integer.parseInt(spell_morph_data_i[5]);
                String imagePath = spell_morph_data_i[3];
                Integer targetId = Integer.parseInt(spell_morph_data_i[4]);

                MorphSpell spell = new MorphSpell(
                    id,
                    name,
                    description,
                    manaCost,
                    imagePath,
                    targetId
                );

                this.addCard(spell);
            }
            else if (rd_s == 1){
                Integer rd_s_p = rd.nextInt(spell_ptn_data.size());
                String[] spell_ptn_data_i = spell_ptn_data.get(rd_s_p);
                
                Integer id = Integer.parseInt(spell_ptn_data_i[0]);
                String name = spell_ptn_data_i[1];
                String description = spell_ptn_data_i[2];
                Integer manaCost = Integer.parseInt(spell_ptn_data_i[6]);
                String imagePath = spell_ptn_data_i[3];
                Integer duration = Integer.parseInt(spell_ptn_data_i[7]);
                Integer boostAttack = Integer.parseInt(spell_ptn_data_i[4]);
                Integer boostHp = Integer.parseInt(spell_ptn_data_i[5]);

                PtnSpell spell = new PtnSpell(
                    id,
                    name,
                    description,
                    manaCost,
                    imagePath,
                    duration,
                    boostAttack,
                    boostHp
                );

                this.addCard(spell);
            }
            else if (rd_s == 2){
                Integer rd_s_s = rd.nextInt(spell_swap_data.size());
                String[] spell_swap_data_i = spell_swap_data.get(rd_s_s);
                
                Integer id = Integer.parseInt(spell_swap_data_i[0]);
                String name = spell_swap_data_i[1];
                String description = spell_swap_data_i[2];
                Integer manaCost = Integer.parseInt(spell_swap_data_i[5]);
                String imagePath = spell_swap_data_i[3];
                Integer duration = Integer.parseInt(spell_swap_data_i[4]);
                
                SwapSpell spell = new SwapSpell(
                    id,
                    name,
                    description,
                    manaCost,
                    imagePath,
                    duration
                );

                this.addCard(spell);
            }
            else if(rd_s == 3){
                //rd between 1 and 2
                Integer rd_lvl = rd.nextInt(2);
                if(rd_lvl == 0){
                    Integer id = 401;
                    String name = "I love you";
                    String description = "This card will support you in your fight against the enemy until you level up";
                    String imagepath = "card/image/spell/lvl/lvlup.png";
                    LvlSpell spell = new LvlSpell(
                        id,
                        name,
                        description,
                        imagepath,
                        LvlSpellType.LVLUP
                    );
                    this.addCard(spell);
                }else{
                    Integer id = 402;
                    String name = "Crippling Depression";
                    String description = "This card will give you crippling depression";
                    String imagepath = "card/image/spell/lvl/lvldown.png";
                    LvlSpell spell = new LvlSpell(
                            id,
                            name,
                            description,
                            imagepath,
                            LvlSpellType.LVLDOWN);
                    this.addCard(spell);
                }
                
            }
        }

        Collections.shuffle(this.deckCard);
    }

    
}
