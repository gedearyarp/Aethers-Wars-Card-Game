package com.aetherwars.model;

public class PtnSpell extends Spell implements ISpell{
    private Integer boostAttack;
    private Integer boostHP;
    
    public PtnSpell() {
        super(0, "", "", 0, "", SpellType.PTN, StatusType.TEMP,0);
        this.boostAttack = 0;
        this.boostHP = 0;
    }
    public PtnSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, Integer boostAttack, Integer boostHP) {
        super(id, name, description, manaCost, imagePath,SpellType.PTN, StatusType.TEMP, duration);
        this.boostAttack = boostAttack;
        this.boostHP = boostHP;
    }

    @Override
    public void use(SummonedCharacter sumcharacter) {
        sumcharacter.setAttackAdd(sumcharacter.getAttackAdd() + boostAttack);
        sumcharacter.setHpAdd(sumcharacter.getHpAdd() + boostHP);
        sumcharacter.addSpell(this);
    } 
    
    public Integer getBoostAttack() {
        return boostAttack;
    }

    public void setBoostAttack(Integer boostAttack) {
        this.boostAttack = boostAttack;
    }

    public Integer getBoostHP() {
        return boostHP;
    }

    public void setBoostHP(Integer boostHP) {
        this.boostHP = boostHP;
    }    
}