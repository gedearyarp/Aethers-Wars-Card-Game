package com.aetherwars.model;

public class LvlSpell extends Spell implements ISpell{
    public LvlSpell() {
        super(0, "", "", 0, "", SpellType.MORPH, StatusType.TEMP, 0);
    }

    @Override
    public void use(SummonedCharacter sumcharacter) {
        if(sumcharacter.getLevel() == 10) {
            return;
        }
        sumcharacter.setLevel(sumcharacter.getLevel() + 1);
        sumcharacter.setExperience(0);

        Integer baseAttack = sumcharacter.getBaseAttack() + sumcharacter.getCharacter().getAttackUp();
        sumcharacter.setBaseAttack(baseAttack);
        sumcharacter.getCharacter().setAttack(baseAttack);

        Integer baseHealth = sumcharacter.getBaseHealth() + sumcharacter.getCharacter().getHealthUp();
        sumcharacter.setBaseHealth(baseHealth);
        sumcharacter.getCharacter().setHealth(baseHealth);
    }

    public void use(SummonedCharacter sumcharacter, Boolean isEnemy){
        if (isEnemy) {
            if(sumcharacter.getLevel() == 1) {
                return;
            }
            sumcharacter.setLevel(sumcharacter.getLevel() - 1);
            sumcharacter.setExperience(0);

            Integer baseAttack = sumcharacter.getBaseAttack() - sumcharacter.getCharacter().getAttackUp();
            sumcharacter.setBaseAttack(baseAttack);
            sumcharacter.getCharacter().setAttack(baseAttack);

            Integer baseHealth = sumcharacter.getBaseHealth() - sumcharacter.getCharacter().getHealthUp();
            sumcharacter.setBaseHealth(baseHealth);
            if(sumcharacter.getCharacter().getHealth() > baseHealth) {
                sumcharacter.getCharacter().setHealth(baseHealth);
            }
        }
        else {
            use(sumcharacter);
        }
    }
}