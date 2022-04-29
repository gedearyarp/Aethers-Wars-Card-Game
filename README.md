# Aether Wars Card Game
Aether Wars Card Game merupakan permainan kartu turn-based berbasis minecraft berbentuk desktop app yang memanfaatkan Library JavaFX.

Program ini dibentuk menggunakan prinsip Object-Oriented Programming dengan mengimplementasikan Inheritance, Composition, Interface, Polymorphism, Method Overriding, Exception, menggunakan Java API Collection, serta memerhatikan prinsip design SOLID dan konsep Design Pattern.

Program ini dibentuk oleh kelompok Muhammad Gare Deadlock dengan tujuan memenuhi salah satu Tugas Besar IF2210 Pemrograman Berorientasi Objek. 

## Table of Contents
* [Authors](#authors)
* [Data Structure](#data-structure)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)

## Authors
| Nama                           | NIM      |
| ------------------------------ | -------- |
| I Gede Arya Raditya P          | 13520036 |
| Arik Rayi Arkananta            | 13520048 |
| Samuel Christopher Swandi      | 13520075 |
| Grace Claudia                  | 13520078 |
| Andhika Arta Aryanto           | 13520081 |
| Januar Budi Ghifari            | 13520132 |

## Data Structure
```├───java
│   └───com
│       └───aetherwars
│           │   AetherWars.java     
│           │   Controller.java     
│           │   ControllerChild.java
│           │   GamePlay.java       
│           │
│           ├───exception
│           │       IndexOutOfBoundException.java
│           │       InvalidBoardException.java
│           │       InvalidHpException.java
│           │       InvalidIDException.java
│           │       InvalidManaException.java
│           │
│           ├───model
│           │       Board.java
│           │       Card.java
│           │       Character.java
│           │       Deck.java
│           │       ITempSpell.java
│           │       LvlSpell.java
│           │       MorphSpell.java
│           │       Player.java
│           │       PtnSpell.java
│           │       Spell.java
│           │       SummonedCharacter.java
│           │       SwapSpell.java
│           │
│           ├───service
│           │       AttackPhase.java
│           │       DrawPhase.java
│           │       PlanningPhase.java
│           │
│           ├───type
│           │       CardType.java
│           │       LvlSpellType.java
│           │       Phase.java
│           │       SpellType.java
│           │       StatusType.java
│           │       Type.java
│           │
│           └───util
│                   CSVReader.java
│
└───resources
    └───com
        └───aetherwars
            ├───card
            │   ├───data
            │   │       character.csv
            │   │       spell_morph.csv
            │   │       spell_ptn.csv
            │   │       spell_swap.csv
            │   │
            │   └───image
            │       │   PlayerOne.jpg
            │       │   PlayerTwo.jpg
            │       │
            │       ├───character
            │       │       Creeper.png
            │       │       Drowned.png
            │       │       Ender Dragon.png
            │       │       Enderman.png
            │       │       Endermite.png
            │       │       Ghast.png
            │       │       Magma Cube.png
            │       │       Obsidian.png
            │       │       Piglin Brute.png
            │       │       Sheep.png
            │       │       Shulker.png
            │       │       Skeleton.png
            │       │       Slime.png
            │       │       Villager.png
            │       │       Warden.png
            │       │       Wither Skeleton.png
            │       │       Wither.png
            │       │       Zombie.png
            │       │
            │       └───spell
            │           ├───lvl
            │           │       lvldown.png
            │           │       lvlup.png
            │           │
            │           ├───morph
            │           │       Creeper... Aw Man.png
            │           │       Crybaby Dominion.png
            │           │       Drowning.png
            │           │       Malin Kundang.png
            │           │       Sheepify.png
            │           │       Sugondese.png
            │           │
            │           ├───potion
            │           │       Aromatic Ginger Rice.png
            │           │       Bad Alcohol.png
            │           │       Contract of Living Space.png
            │           │       Deathly Magic.png
            │           │       Divine Wind.png
            │           │       GPU Very Good.png
            │           │       Grabkeun.png
            │           │       Halal Porkchop.png
            │           │       Herobrine's Blessing.png
            │           │       Honey Bottle.png
            │           │       Kordas' Curse.png
            │           │       Mother's Prayer.png
            │           │       Sadikin Elixir.png
            │           │       SNMPTN Acceptance Letter.png
            │           │       SNMPTN Rejection Letter.png
            │           │       Spectral's Power.png
            │           │       Witch's Eye.png
            │           │       Yoasobi.png
            │           │
            │           └───swap
            │                   Axolotl Blood.png
            │                   Bone Marrow.png
            │                   Cat Food.png
            │                   Cooked Beef Juice.png
            │                   Detergent.png
            │                   Ghast Tears.png
            │                   Morning's Blessing.png
            │                   Potion of Bargaining.png
            │                   Potion of Turtle Master.png
            │                   Swab Test.png
            │
            └───fxml
                    child.fxml
                    main.fxml
```

## Features
![image](https://user-images.githubusercontent.com/71170262/165959218-ae6f354e-d9f7-4092-b37d-ed5714ff1573.png)
![image](https://user-images.githubusercontent.com/71170262/165959234-c4ae8380-5264-47a8-9a0f-26e1d3d827b5.png)


## Screenshot

## Setup
Permainan ini membutuhkan : 
- g++
- make
- Linux

Langkah menjalankan program :

## Usage

## Project Status
Project ini sudah  _selesai_ 

### Copyright
2022 © Muhammad Gare Deadlock. All Rights Reserved.

