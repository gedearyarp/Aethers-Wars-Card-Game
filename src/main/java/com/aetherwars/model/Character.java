package com.aetherwars.model;

public class Character extends Card {
  private Integer attack;
  private Type type;
  private Integer health;
  private Integer level;
  private Integer experience;
  private Integer attackUp;
  private Integer healthUp;
  private Boolean isSwapped;
  private static final Integer maxLevel = 10;

  public Character() {
    super();
    this.attack = 0;
    this.type = Type.OVERWORLD; //default type overworld
    this.health = 0;
    this.level = 0;
    this.experience = 0;
    this.attackUp = 0;
    this.healthUp = 0;
    this.isSwapped = false;
  }

  public Character(Integer id, String name, String description, Integer manaCost, String imagePath, Integer attack, Type type, Integer health, Integer attackUp, Integer healthUp) {
    
    super(id,name,description,manaCost,imagePath);
    this.attack = attack;
    this.type = type;
    this.health = health;
    this.level = 1;
    this.experience = 0;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
    this.isSwapped = false;
  }

  @Override
  public String toString() {
    super.toString();
    return "Attack: " + this.attack + "\nType: " + this.type.name() + "\nHealth: " + this.health + "\nLevel: " + this.level + "\nExperience: " + this.experience;
  }

  public Integer getAttack() {
    return this.attack;
  }

  public void setAttack(Integer attack) {
    this.attack = attack;
  }

  public Type getType() {
    return this.type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Integer getHealth() {
    return this.health;
  }

  public void setHealth(Integer health) {
    this.health = health;
  }

  public Integer getLevel() {
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
    checkLevelUp();
  }

  public Integer getAttackUp() {
    return this.attackUp;
  }

  public void setAttackUp(Integer attackUp) {
    this.attackUp = attackUp;
  }

  public Integer getHealthUp() {
    return this.healthUp;
  }

  public void setHealthUp(Integer healthUp) {
    this.healthUp = healthUp;
  }

  public Boolean getIsSwapped() {
    return this.isSwapped;
  }

  public void setIsSwapped(Boolean isSwapped) {
    this.isSwapped = isSwapped;
  }

  public void levelUp(Integer remainder) {
    if(this.level < maxLevel) {
      this.level++;
      this.experience = remainder;
      this.attack += this.attackUp;
      this.health += this.healthUp;
    }
  } 

  public void checkLevelUp()
  {
    Integer[] required = {1,3,5,7,9,11,13,15,17,19};
    Integer i = this.level;
    if (this.experience > required[i-1])
    {
      Integer remainder = this.experience - (this.experience & required[i-1]);
      levelUp(remainder);
      checkLevelUp();
    }
  }
}
