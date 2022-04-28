package com.aetherwars.model;

import com.aetherwars.type.*;

public class LvlSpell extends Spell {
    private LvlSpellType lvlSpellType;

    public LvlSpell() {
        super(0, "", "", 0, "", SpellType.LVL, StatusType.PERM);
        this.lvlSpellType = LvlSpellType.LVLUP;
    }

    public LvlSpell(Integer id, String name, String description,String imagePath,LvlSpellType lvlSpellType) {
        super(id, name, description, 0, imagePath, SpellType.LVL, StatusType.PERM);
        this.lvlSpellType = lvlSpellType;
    }

    public LvlSpellType getLvlSpellType() {
        return lvlSpellType;
    }

    public void setLvlSpellType(LvlSpellType lvlSpellType) {
        this.lvlSpellType = lvlSpellType;
    }


    @Override
    public void use(SummonedCharacter sumcharacter) {
        if(lvlSpellType == LvlSpellType.LVLUP && sumcharacter.getLevel() == 10) {
            return;
        }
        if(lvlSpellType == LvlSpellType.LVLDOWN && sumcharacter.getLevel() == 1) {
            return;
        }

        if(lvlSpellType == LvlSpellType.LVLUP) {
            sumcharacter.setLevel(sumcharacter.getLevel() + 1);
            sumcharacter.setExperience(0);
            Integer baseAttack = sumcharacter.getBaseAttack() + sumcharacter.getCharacter().getAttackUp();
            sumcharacter.setBaseAttack(baseAttack);
            sumcharacter.getCharacter().setAttack(baseAttack);
    
            Integer baseHealth = sumcharacter.getBaseHealth() + sumcharacter.getCharacter().getHealthUp();
            sumcharacter.setBaseHealth(baseHealth);
            sumcharacter.getCharacter().setHealth(baseHealth); 
        }
        if(lvlSpellType == LvlSpellType.LVLDOWN) {
            sumcharacter.setLevel(sumcharacter.getLevel() - 1);
            sumcharacter.setExperience(0);
            Integer baseAttack = sumcharacter.getBaseAttack() - sumcharacter.getCharacter().getAttackUp();
            sumcharacter.setBaseAttack(baseAttack);
            sumcharacter.getCharacter().setAttack(baseAttack);
    
            Integer baseHealth = sumcharacter.getBaseHealth() - sumcharacter.getCharacter().getHealthUp();
            sumcharacter.setBaseHealth(baseHealth);
            sumcharacter.getCharacter().setHealth(baseHealth); 
        }
    }

}