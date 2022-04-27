package com.aetherwars.model;

import com.aetherwars.type.*;

public class SwapSpell extends Spell implements ITempSpell{
    private Integer duration;

    public SwapSpell() {
        super(0, "", "", 0, "", SpellType.SWAP, StatusType.TEMP);
    }

    public SwapSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration) {
        super(id, name, description, manaCost, imagePath, SpellType.SWAP, StatusType.TEMP);
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void use(SummonedCharacter sumcharacter) {
        sumcharacter.addSwapDuration(duration);
        if(sumcharacter.getIsSwapped() == false)
        {
            Integer atk = sumcharacter.getCharacter().getAttack();
            Integer hp = sumcharacter.getCharacter().getHealth();
            Integer atkAdd = sumcharacter.getAttackAdd();
            Integer hpAdd = sumcharacter.getHpAdd();
            sumcharacter.getCharacter().setAttack(hp);
            sumcharacter.getCharacter().setHealth(atk);
            sumcharacter.setAttackAdd(hpAdd);
            sumcharacter.setHpAdd(atkAdd);
            sumcharacter.setIsSwapped(true);
        }
    }
}