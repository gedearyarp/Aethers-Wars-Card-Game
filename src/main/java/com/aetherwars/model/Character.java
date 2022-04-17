package com.aetherwars.model;


public class Character extends Card {
  private Integer attack;
  private Type type;
  private Integer health;
  private Integer attackUp;
  private Integer healthUp;
  
  public Character() {
    super(0, "", "", 0, "", CardType.CHARACTER);
    this.attack = 0;
    this.type = Type.OVERWORLD; //default type overworld
    this.health = 0;
    this.attackUp = 0;
    this.healthUp = 0;
  }

  public Character(Integer id, String name, String description, Integer manaCost, String imagePath, Integer attack, Type type, Integer health, Integer attackUp, Integer healthUp) {
    super(id, name, description, manaCost, imagePath, CardType.CHARACTER);
    this.attack = attack;
    this.type = type;
    this.health = health;
    this.attackUp = attackUp;
    this.healthUp = healthUp;
  }

  //copy constructor
  public Character(Character character) {
    super(character.getId(), character.getName(), character.getDescription(), character.getmanaCost(), character.getImagePath(), CardType.CHARACTER);
    this.attack = character.getAttack();
    this.type = character.getType();
    this.health = character.getHealth();
    this.attackUp = character.getAttackUp();
    this.healthUp = character.getHealthUp();
  }

  @Override
  public String toString() {
    return super.toString() + "\nAttack: " + this.attack + "\nType: " + this.type.name() + "\nHealth: " + this.health;
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
}
