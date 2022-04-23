package com.aetherwars.model;

import java.util.*;

public class SummonedCharacter{
    private Character character;
    private Integer level; 
    private Integer experience;
    private Integer attackAdd; 
    private Integer hpAdd;
    private static final Integer maxLevel = 10;
    private List<PtnSpell> activePtnSpells;
    private Integer swapDuration;
    private Boolean isSwapped;
    private Integer baseHealth;
    private Integer baseAttack;

    public SummonedCharacter() {
        this.character = null;
        this.level = 0;
        this.experience = 0;
        this.attackAdd = 0;
        this.hpAdd = 0;
        this.activePtnSpells = new ArrayList<PtnSpell>();
        this.swapDuration = 0;
        this.isSwapped = false;
        this.baseHealth = null;
        this.baseAttack = null;
    }
    
    public SummonedCharacter(Character character, Integer level, Integer experience) {
        this.character = character; 
        this.level = level;
        this.experience = experience;
        this.activePtnSpells = new ArrayList<PtnSpell>();
        this.attackAdd = 0;
        this.hpAdd = 0;
        this.swapDuration = 0;
        this.isSwapped = false;
        this.baseHealth = character.getHealth();
        this.baseAttack = character.getAttack();
    }

    //copy constructor
    public SummonedCharacter(SummonedCharacter character) {
        this.character = character.getCharacter();
        this.level = character.getLevel();
        this.experience = character.getExperience();
        this.attackAdd = character.getAttackAdd();
        this.hpAdd = character.getHpAdd();
        this.activePtnSpells = character.getActivePtnSpells();
        this.swapDuration = character.getSwapDuration();
        this.isSwapped = character.getIsSwapped();
        this.baseHealth = character.getBaseHealth();
        this.baseAttack = character.getBaseAttack();
    }

    public void setBaseHealth(Integer baseHealth){
        this.baseHealth = baseHealth;
    }

    public Integer getBaseAttack(){
        return this.baseAttack;
    }

    public void setBaseAttack(Integer baseAttack){
        this.baseAttack = baseAttack;
    }

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Integer getLevel()
    {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExperience() {
        return this.experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public List<PtnSpell> getActivePtnSpells() {
        return this.activePtnSpells;
    }

    public void setActivePtnSpells(List<PtnSpell> activePtnSpells) {
        this.activePtnSpells = activePtnSpells;
    }

    public void addSpell(PtnSpell spell) {
        activePtnSpells.add(spell);
    }

    public void removeSpell(Spell spell) {
        activePtnSpells.remove(spell);
    }

    public void setAttackAdd(Integer attackAdd) {
        this.attackAdd = attackAdd;
    }

    public void setHpAdd(Integer hpAdd) {
        this.hpAdd = hpAdd;
    }

    public Integer getAttackAdd() {
        return this.attackAdd;
    }

    public Integer getHpAdd() {
        return this.hpAdd;
    }

    public Integer getTotalAttack(){
        return character.getAttack() + attackAdd;
    }

    public Integer getTotalHp(){
        return character.getHealth() + hpAdd;
    }

    public Boolean getIsSwapped() {
        return this.isSwapped;
    }

    public void setIsSwapped(Boolean isSwapped) {
        this.isSwapped = isSwapped;
    }

    public Integer getSwapDuration() {
        return this.swapDuration;
    }

    public void setSwapDuration(Integer swapDuration) {
        this.swapDuration = swapDuration;
    }

    public void addSwapDuration(Integer swapDuration) {
        this.swapDuration += swapDuration;
    }

    public Integer getBaseHealth() {
        return this.baseHealth;
    }
    
    public void reduceDurationPtnSpell() {
        List<PtnSpell> newActivePtnSpells = new ArrayList<PtnSpell>();
        for(PtnSpell s : activePtnSpells){
            s.setDuration(s.getDuration() - 1);
            if (s.getDuration() != 0){
                newActivePtnSpells.add(s);
            }
            else
            {
                attackAdd -= s.getBoostAttack();
                hpAdd -= s.getBoostHP();
            }
        }
        setActivePtnSpells(newActivePtnSpells);
    }

    public void reduceSwap(){
        this.swapDuration--;
        if(this.swapDuration == 0){
            this.isSwapped = false;
            Integer temp = character.getAttack();
            this.character.setAttack(this.character.getHealth());
            this.character.setHealth(temp);
        }
    }

    public void levelUp(Integer remainder) {
        if (this.level < maxLevel) {
            this.level++;
            this.experience = remainder;
            character.setHealth(this.baseHealth + character.getHealthUp());
            character.setAttack(this.baseAttack + character.getAttackUp());
            this.baseHealth = character.getHealth();
            this.baseAttack = character.getAttack();
        }
    }

    public void checkLevelUp() {
        Integer[] required = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        Integer i = this.level;
        if (this.experience > required[i - 1]) {
            Integer remainder = this.experience - (this.experience & required[i - 1]);
            levelUp(remainder);
            checkLevelUp();
        }
    }

    @Override
    public String toString() {
        character.toString();
        return "Level: " + this.level + "\nExperience: " + this.experience;
    }

}
