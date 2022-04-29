package com.aetherwars;

import com.aetherwars.service.AttackPhase;
import com.aetherwars.service.DrawPhase;
import com.aetherwars.service.PlanningPhase;
import com.aetherwars.type.Phase;
import com.aetherwars.type.Type;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.aetherwars.model.*;
import com.aetherwars.model.Character;

import java.util.ArrayList;

public class GamePlayTest {
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");

    @Test
    public void testDrawPhase() throws Exception  {
        // make new gameplay
        GamePlay gamePlay = new GamePlay(player1, player2);

        // generate deck for both player
        gamePlay.getPlayers()[0].getDeck().generateCard(7);
        gamePlay.getPlayers()[1].getDeck().generateCard(7);

        // make new phase, test in draw phase
        DrawPhase dPhase = new DrawPhase();

        // get number of card in deck before it is taken
        int nCardBefore = gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getDeck().getCard().size();

        // get top three cards to put on player's hand
        ArrayList<Card> cards = dPhase.getTopThreeFromCurrPlayersDeck(gamePlay);

        // take first(index 0) card in deck
        dPhase.drawSelectedCardAndReturnRemainToDeck(gamePlay, cards, 0);

        // get number of card in deck after it is taken
        int nCardAfter = gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getDeck().getCard().size();

        assertEquals(1, nCardBefore-nCardAfter);
    }
    @Test
    public void testHandInDeckDrawPhase() throws Exception{
        // make new gameplay
        GamePlay gamePlay = new GamePlay(player1, player2);

        // generate deck for both player
        gamePlay.getPlayers()[0].getDeck().generateCard(7);
        gamePlay.getPlayers()[1].getDeck().generateCard(7);

        // make new phase, test in draw phase
        DrawPhase dPhase = new DrawPhase();

        // get number of card in deck before it is taken
        int nCardBefore = gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard().size();
        // get top three cards to put on player's hand
        ArrayList<Card> cards = dPhase.getTopThreeFromCurrPlayersDeck(gamePlay);

        // take first(index 0) card in deck
        dPhase.drawSelectedCardAndReturnRemainToDeck(gamePlay, cards, 0);

        // get number of card in deck after it is taken
        int nCardAfter = gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].getHandCard().size();

        assertEquals(1, nCardAfter-nCardBefore);
    }

    @Test
    public void testAttackCharacter() throws Exception {
        GamePlay gamePlay = new GamePlay(player1, player2);

        //make new random summoned
        Integer id1 = 1000;
        Integer manaCost1 = 1;
        Integer atk1 = 5;
        Integer hp1 = 10;
        Integer hpUp1 = 2;
        Integer attackUp1 = 3;

        Integer id2 = 1001;
        Integer manaCost2 = 1;
        Integer atk2 = 5;
        Integer hp2 = 10;
        Integer hpUp2 = 2;
        Integer attackUp2 = 3;
        Character char1 = new Character(id1, "test1", "aku hanya ada di dunia untuk testing", manaCost1, "gaada", atk1, Type.OVERWORLD, hp1, attackUp1, hpUp1);
        Character char2 = new Character(id2, "test2", "aku hanya ada di dunia untuk testing", manaCost2, "gaada", atk2, Type.OVERWORLD, hp2, attackUp2, hpUp2);
        SummonedCharacter sum1 = new SummonedCharacter(char1, 1, 0);
        SummonedCharacter sum2 = new SummonedCharacter(char2, 1, 0);
        sum1.attack(sum2);

        assertEquals(5, sum2.getTotalHp());
    }

    @Test
    public void testAttackPlayer() throws Exception {
        GamePlay gamePlay = new GamePlay(player1, player2);

        PlanningPhase pPhase = new PlanningPhase();
        AttackPhase aPhase = new AttackPhase();
        //make new random character
        Integer id1 = 1000;
        Integer manaCost1 = 1;
        Integer atk1 = 5;
        Integer hp1 = 10;
        Integer hpUp1 = 2;
        Integer attackUp1 = 1;
        Character char1 = new Character(id1, "test1", "aku hanya ada di dunia untuk testing", manaCost1, "gaada", atk1, Type.OVERWORLD, hp1, attackUp1, hpUp1);

        // add character to hand
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].addHandCard(char1);
        //set mana so player can put character
        gamePlay.getPlayers()[gamePlay.getCurrPlayerIndex()].setMana(5);
        //put character on board
        pPhase.placeCharCard(gamePlay, 0, "A");
        //attack
        aPhase.attackOtherPlayer(gamePlay, "A");
        //because attack value is 5 and player hp was 100, current hp should be 95
        assertEquals(95, gamePlay.getPlayers()[gamePlay.getOtherPlayerIndex()].getHp());
    }
}
