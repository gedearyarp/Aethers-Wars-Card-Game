package com.aetherwars.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.aetherwars.util.CSVReader;

public class MorphSpell extends Spell implements ISpell {
        private Integer targetID;

        public MorphSpell() {
            super(0, "", "", 0, "", SpellType.MORPH, StatusType.PERM, -1);
            this.targetID = 0;
        }

        public MorphSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer targetID) {
            super(id, name, description, manaCost, imagePath, SpellType.MORPH, StatusType.PERM, -1);
            this.targetID = targetID;
        }

        public Integer getTargetID() {
            return targetID;
        }

        public void setTargetID(Integer targetID) {
            this.targetID = targetID;
        }

        @Override
        public void use(SummonedCharacter sumcharacter) throws IOException { 
            CSVReader csvreader_character = new CSVReader(new File("src/main/resources/com/aetherwars/card/data/character.csv"), " ");
            List<String[]> character_data = csvreader_character.read();
            String[] targetCharacterData = character_data.get(this.targetID - 1);

            Integer targetId = Integer.parseInt(targetCharacterData[0]);
            String targetName = targetCharacterData[1];
            String targetDescription = targetCharacterData[3];
            Integer targetManaCost = Integer.parseInt(targetCharacterData[7]);
            String targetImagePath = targetCharacterData[4];
            Integer targetAttack  = Integer.parseInt(targetCharacterData[5]);
            Type targetType = Type.valueOf(targetCharacterData[2]);
            Integer targetHealth = Integer.parseInt(targetCharacterData[6]);
            Integer targetAttackUp = Integer.parseInt(targetCharacterData[8]);
            Integer targetHealthUp = Integer.parseInt(targetCharacterData[9]);

            Character targetCharacter = new Character(
                targetId,
                targetName,
                targetDescription,
                targetManaCost,
                targetImagePath,
                targetAttack,
                targetType,
                targetHealth,
                targetAttackUp,
                targetHealthUp
            );

            sumcharacter = new SummonedCharacter(targetCharacter, 1, 0);
        }
}
    

