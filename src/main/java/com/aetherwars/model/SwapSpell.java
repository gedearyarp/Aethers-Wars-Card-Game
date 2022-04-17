package com.aetherwars.model;

public class SwapSpell extends Spell implements ISpell{
    public SwapSpell() {
        super(0, "", "", 0, "", SpellType.SWAP, StatusType.TEMP, 0);
    }

    public SwapSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration) {
        super(id, name, description, manaCost, imagePath, SpellType.SWAP, StatusType.TEMP, duration);
    }

    public void use(SummonedCharacter sumcharacter) {
        sumcharacter.addSwapDuration(duration);
        if(sumcharacter.getIsSwapped() == false)
        {
            Integer atk = sumcharacter.getCharacter().getAttack();
            Integer hp = sumcharacter.getCharacter().getHealth();
            sumcharacter.getCharacter().setAttack(atk);
            sumcharacter.getCharacter().setHealth(hp);
            sumcharacter.setIsSwapped(true);
        }
    }
}