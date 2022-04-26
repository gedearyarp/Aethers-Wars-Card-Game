package com.aetherwars.model;

import com.aetherwars.type.*;

public class PtnSpell extends Spell implements ITempSpell{
    private Integer boostAttack;
    private Integer boostHP;
    private Integer duration;
    
    public PtnSpell() {
        super(0, "", "", 0, "", SpellType.PTN, StatusType.TEMP);
        this.boostAttack = 0;
        this.boostHP = 0;
        this.duration = 0;
    }
    public PtnSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, Integer boostAttack, Integer boostHP) {
        super(id, name, description, manaCost, imagePath,SpellType.PTN, StatusType.TEMP);
        this.boostAttack = boostAttack;
        this.boostHP = boostHP;
        this.duration = duration;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    public void setBoostHP(double d) {
        this.boostHP = (int)d;
    }  
}