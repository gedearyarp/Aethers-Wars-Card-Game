package com.aetherwars.model;

public class Spell extends Card {
    protected SpellType spellType;
    protected StatusType statusType;
    protected Integer duration;

    public Spell(){
        super();
        this.spellType = SpellType.PTN;
        this.statusType = StatusType.PERM;
        this.duration = 0;
    }

    public Spell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, SpellType spellType, StatusType statusType){
        super(id,name, description, manaCost, imagePath);
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

    @Override
    public String toString() {
        super.toString();
        return "Spell Type : " + this.spellType.name() + " Status Type : " + this.statusType.name() + " Duration : " + this.duration; 
    }
}
