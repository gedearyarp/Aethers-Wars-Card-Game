package com.aetherwars.model;

import com.aetherwars.type.*;

public abstract class Spell extends Card {
    protected SpellType spellType;
    protected StatusType statusType;

    public Spell(){
        super(0, "", "", 0, "", CardType.SPELL);
        this.spellType = SpellType.PTN;
        this.statusType = StatusType.PERM;
    }

    public Spell(Integer id, String name, String description, Integer manaCost, String imagePath, SpellType spellType, StatusType statusType) {
        super(id,name, description, manaCost, imagePath, CardType.SPELL);
        this.spellType = spellType;
        this.statusType = statusType;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellType spellType) {
        this.spellType = spellType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    abstract void use(SummonedCharacter sumcharacter) throws Exception;

    @Override
    public String toString() {
        return super.toString() + "\nSpell Type : " + this.spellType.name() + " Status Type : " + this.statusType.name(); 
    }
}
