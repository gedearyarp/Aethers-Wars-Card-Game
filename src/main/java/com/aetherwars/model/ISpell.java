package com.aetherwars.model;
import java.io.IOException;

interface ISpell {
    void use(SummonedCharacter sumcharacter) throws IOException;
}
