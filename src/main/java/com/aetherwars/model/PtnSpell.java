package com.aetherwars.model;

public class PtnSpell extends Spell {
    private Integer boostAttack;
    private Integer boostHP;
    
    public PtnSpell() {
        super();
        this.boostAttack = 0;
        this.boostHP = 0;
    }
    public PtnSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, Integer boostAttack, Integer boostHP) {
        super(id, name, description, manaCost, imagePath, duration, SpellType.PTN, StatusType.TEMP);
        this.boostAttack = boostAttack;
        this.boostHP = boostHP;
    }

    public void usePtn(Character character)
    {
        character.setAttack(character.getAttack() + boostAttack);
        character.setHealth(character.getHealth() + boostHP);
    }
}