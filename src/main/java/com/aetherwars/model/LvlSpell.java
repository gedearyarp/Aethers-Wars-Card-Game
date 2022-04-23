package com.aetherwars.model;

import com.aetherwars.type.*;

public class LvlSpell extends Spell {
    private Integer boostLevel;
    private LvlSpellType lvlSpellType;

    public LvlSpell() {
        super(0, "", "", 0, "", SpellType.MORPH, StatusType.TEMP);
        this.boostLevel = 0;
        this.lvlSpellType = LvlSpellType.LVLUP;
    }

    public LvlSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, Integer boostLevel, LvlSpellType lvlSpellType) {
        super(id, name, description, manaCost, imagePath, SpellType.MORPH, StatusType.TEMP);
        this.boostLevel = boostLevel;
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
        sumcharacter.setLevel(sumcharacter.getLevel() + boostLevel);
        sumcharacter.setExperience(0);

        if(lvlSpellType == LvlSpellType.LVLUP) {
            Integer baseAttack = sumcharacter.getBaseAttack() + sumcharacter.getCharacter().getAttackUp();
            sumcharacter.setBaseAttack(baseAttack);
            sumcharacter.getCharacter().setAttack(baseAttack);
    
            Integer baseHealth = sumcharacter.getBaseHealth() + sumcharacter.getCharacter().getHealthUp();
            sumcharacter.setBaseHealth(baseHealth);
            sumcharacter.getCharacter().setHealth(baseHealth); 
        }
        if(lvlSpellType == LvlSpellType.LVLDOWN) {
            Integer baseAttack = sumcharacter.getBaseAttack() - sumcharacter.getCharacter().getAttackUp();
            sumcharacter.setBaseAttack(baseAttack);
            sumcharacter.getCharacter().setAttack(baseAttack);
    
            Integer baseHealth = sumcharacter.getBaseHealth() - sumcharacter.getCharacter().getHealthUp();
            sumcharacter.setBaseHealth(baseHealth);
            sumcharacter.getCharacter().setHealth(baseHealth); 
        }
    }

}