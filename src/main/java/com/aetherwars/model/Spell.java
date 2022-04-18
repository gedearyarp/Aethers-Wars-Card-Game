package com.aetherwars.model;

import java.io.IOException;

public class Spell extends Card {
    protected SpellType spellType;
    protected StatusType statusType;
    protected Integer duration;

    public Spell(){
        super(0, "", "", 0, "", CardType.SPELL);
        this.spellType = SpellType.PTN;
        this.statusType = StatusType.PERM;
        this.duration = 0;
    }

    public Spell(Integer id, String name, String description, Integer manaCost, String imagePath, SpellType spellType, StatusType statusType, Integer duration){
        super(id,name, description, manaCost, imagePath, CardType.SPELL);
        this.spellType = spellType;
        this.statusType = statusType;
        this.duration = duration;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void use(SummonedCharacter sumcharacter) throws IOException {

    }

    @Override
    public String toString() {
        return super.toString() + "\nSpell Type : " + this.spellType.name() + " Status Type : " + this.statusType.name(); 
    }
}
