package com.aetherwars.model;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;



public class MorphSpell extends Spell {
        private Integer targetID;

        public MorphSpell() {
            super(0, "", "", 0, "", SpellType.MORPH, StatusType.TEMP, 0);
            this.targetID = 0;
        }

        public MorphSpell(Integer id, String name, String description, Integer manaCost, String imagePath, Integer duration, Integer targetID) {
            super(id, name, description, manaCost, imagePath, SpellType.MORPH, StatusType.TEMP, duration);
            this.targetID = targetID;
        }

        public Integer getTargetID() {
            return targetID;
        }

        public void setTargetID(Integer targetID) {
            this.targetID = targetID;
        }



        @Override
        public void use(SummonedCharacter sumcharacter) {
            //TODO : nyari karakted dari ID
        }
}
    

