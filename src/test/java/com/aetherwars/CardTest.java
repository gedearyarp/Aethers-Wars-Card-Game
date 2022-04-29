package com.aetherwars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.aetherwars.model.*;
import com.aetherwars.type.*;

public class CardTest{
    Card card = new Card(1, "name", "description", 1, "imagePath", CardType.CHARACTER);

    @Test
    public void testCard(){
        assertEquals(1, card.getId());
    }

    @Test
    public void testUserDefinedCard(){
        assertEquals("name", card.getName());
    }

    @Test
    public void testCardToString(){
        assertEquals("Name: name\nDescription: description\nmanaCost: 1", card.toString());
    }
}