package com.aetherwars;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import com.aetherwars.service.DrawPhase;
import com.aetherwars.type.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ControllerChild implements Initializable {
    // card 1
    @FXML
    private Text drawPhaseText;

    @FXML
    private GridPane card1draw;
    @FXML
    private Button card1;
    @FXML
    private Text card1mana;
    @FXML
    private Text card1atkhp;

    // card 2
    @FXML
    private GridPane card2draw;
    @FXML
    private Button card2;
    @FXML
    private Text card2mana;
    @FXML
    private Text card2atkhp;

    // card 3
    @FXML
    private GridPane card3draw;
    @FXML
    private Button card3;
    @FXML
    private Text card3mana;
    @FXML
    private Text card3atkhp;

    private Integer selectedCard;

    public Integer getSelectedCard() {
        return selectedCard;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        drawPhaseText.setText("Select 1 card to draw! \n(if you have more than 5 card, you will discard the leftmost card)");

        DrawPhase dPhase = new DrawPhase();

        ArrayList<Card> cards = Controller.topThreeCard;
        // set all image
        ImageView view = new ImageView(new Image("com/aetherwars/" + cards.get(0).getImagePath()));
        view.setFitHeight(100);
        view.setFitWidth(100);
        view.setPreserveRatio(true);
        card1.setGraphic(view);
        view = new ImageView(new Image("com/aetherwars/" + cards.get(1).getImagePath()));
        view.setFitHeight(100);
        view.setFitWidth(100);
        view.setPreserveRatio(true);
        card2.setGraphic(view);
        view = new ImageView(new Image("com/aetherwars/" + cards.get(2).getImagePath()));
        view.setFitHeight(100);
        view.setFitWidth(100);
        view.setPreserveRatio(true);
        card3.setGraphic(view);


        if (cards.size() == 1) {
            card2draw.setVisible(false);
            card3draw.setVisible(false);
        } else if (cards.size() == 2) {
            card3draw.setVisible(false);
        }
        // =========== card 1 ===========
        if (cards.get(0).getCardType().equals(CardType.CHARACTER)) {
            card1mana.setText(cards.get(0).getName() + "(Character)");

            Character temp = (Character) cards.get(0);
            String health = temp.getHealth().toString();
            Type charType = temp.getType();
            String attack = temp.getAttack().toString();
            String mana = temp.getmanaCost().toString();
            String details = "Health: " + health + "\nType: " + charType + "\nAttack: " + attack + "\nMana Cost: "
                    + mana;
            card1atkhp.setText(details);
        } else {
            Spell temp = (Spell) cards.get(0);
            String mana = temp.getmanaCost().toString();
            String detailText = "";
            if (temp.getSpellType().equals(SpellType.LVL)) {
                card1mana.setText(cards.get(0).getName() + "(LevelUp Spell)");

                String spellType = temp.getSpellType().toString();
                String levelUpType = ((LvlSpell) temp).getLvlSpellType().toString();
                detailText = "Spell Type: " + spellType + "\nLevel Up Type: " + levelUpType;
            } else if (temp.getSpellType().equals(SpellType.MORPH)) {
                card1mana.setText(cards.get(0).getName() + "(Morph Spell)");

                detailText = "Mana Cost: " + mana + "\nSpell Type: " + temp.getSpellType().toString();
            } else if ((temp.getSpellType().equals(SpellType.PTN))) {
                card1mana.setText(cards.get(0).getName() + "(Potion Spell)");

                String boostAttack = ((PtnSpell) temp).getBoostAttack().toString();
                String boostHealth = ((PtnSpell) temp).getBoostHP().toString();
                String duration = ((PtnSpell) temp).getDuration().toString();
                detailText = "Mana Cost: " + mana + "\nSpell Type: "
                        + temp.getSpellType().toString() + "\nBoost Attack: " + boostAttack + "\nBoost Health: "
                        + boostHealth + "\nDuration: " + duration;
            } else if ((temp.getSpellType().equals(SpellType.SWAP))) {
                card1mana.setText(cards.get(0).getName() + "(Swap Spell)");

                String duration = ((SwapSpell) temp).getDuration().toString();
                detailText = "Mana Cost: " + mana + "\nSpell Type: "
                        + temp.getSpellType().toString() + "\nDuration: " + duration;
            }
            card1atkhp.setText(detailText);
        }

        // =========== card 2 ===========
        if (cards.size() > 1) {
            if (cards.get(1).getCardType().equals(CardType.CHARACTER)) {
                card2mana.setText(cards.get(1).getName() + "(Character)");
    
                Character temp = (Character) cards.get(1);
                String health = temp.getHealth().toString();
                Type charType = temp.getType();
                String attack = temp.getAttack().toString();
                String mana = temp.getmanaCost().toString();
                String details = "Health: " + health + "\nType: " + charType + "\nAttack: " + attack + "\nMana Cost: "
                        + mana;
                card2atkhp.setText(details);
            } else {
                Spell temp = (Spell) cards.get(1);
                String mana = temp.getmanaCost().toString();
                String detailText = "";
                if (temp.getSpellType().equals(SpellType.LVL)) {
                    card2mana.setText(cards.get(1).getName() + "(LevelUp Spell)");
    
                    String spellType = temp.getSpellType().toString();
                    String levelUpType = ((LvlSpell) temp).getLvlSpellType().toString();
                    detailText = "Spell Type: " + spellType + "\nLevel Up Type: " + levelUpType;
                } else if (temp.getSpellType().equals(SpellType.MORPH)) {
                    card2mana.setText(cards.get(1).getName() + "(Morph Spell)");
    
                    detailText = "Mana Cost: " + mana + "\nSpell Type: " + temp.getSpellType().toString();
                } else if ((temp.getSpellType().equals(SpellType.PTN))) {
                    card2mana.setText(cards.get(1).getName() + "(Potion Spell)");
    
                    String boostAttack = ((PtnSpell) temp).getBoostAttack().toString();
                    String boostHealth = ((PtnSpell) temp).getBoostHP().toString();
                    String duration = ((PtnSpell) temp).getDuration().toString();
                    detailText = "Mana Cost: " + mana + "\nSpell Type: "
                            + temp.getSpellType().toString() + "\nBoost Attack: " + boostAttack + "\nBoost Health: "
                            + boostHealth + "\nDuration: " + duration;
                } else if ((temp.getSpellType().equals(SpellType.SWAP))) {
                    card2mana.setText(cards.get(1).getName() + "(Swap Spell)");
    
                    String duration = ((SwapSpell) temp).getDuration().toString();
                    detailText = "Mana Cost: " + mana + "\nSpell Type: "
                            + temp.getSpellType().toString() + "\nDuration: " + duration;
                }
                card2atkhp.setText(detailText);
            }
        }
  

        // =========== card 3 ===========
        if (cards.size() > 2) {
            if (cards.get(2).getCardType().equals(CardType.CHARACTER)) {
                card3mana.setText(cards.get(2).getName() + "(Character)");
    
                Character temp = (Character) cards.get(2);
                String health = temp.getHealth().toString();
                Type charType = temp.getType();
                String attack = temp.getAttack().toString();
                String mana = temp.getmanaCost().toString();
                String details = "Health: " + health + "\nType: " + charType + "\nAttack: " + attack + "\nMana Cost: "
                        + mana;
                card3atkhp.setText(details);
            } else {
                Spell temp = (Spell) cards.get(2);
                String mana = temp.getmanaCost().toString();
                String detailText = "";
                if (temp.getSpellType().equals(SpellType.LVL)) {
                    card3mana.setText(cards.get(2).getName() + "(LevelUp Spell)");
    
                    String spellType = temp.getSpellType().toString();
                    String levelUpType = ((LvlSpell) temp).getLvlSpellType().toString();
                    detailText = "Spell Type: " + spellType + "\nLevel Up Type: " + levelUpType;
                } else if (temp.getSpellType().equals(SpellType.MORPH)) {
                    card3mana.setText(cards.get(2).getName() + "(Morph Spell)");
    
                    detailText = "Mana Cost: " + mana + "\nSpell Type: " + temp.getSpellType().toString();
                } else if ((temp.getSpellType().equals(SpellType.PTN))) {
                    card3mana.setText(cards.get(2).getName() + "(Potion Spell)");
    
                    String boostAttack = ((PtnSpell) temp).getBoostAttack().toString();
                    String boostHealth = ((PtnSpell) temp).getBoostHP().toString();
                    String duration = ((PtnSpell) temp).getDuration().toString();
                    detailText = "Mana Cost: " + mana + "\nSpell Type: "
                            + temp.getSpellType().toString() + "\nBoost Attack: " + boostAttack + "\nBoost Health: "
                            + boostHealth + "\nDuration: " + duration;
                } else if ((temp.getSpellType().equals(SpellType.SWAP))) {
                    card3mana.setText(cards.get(2).getName() + "(Swap Spell)");
    
                    String duration = ((SwapSpell) temp).getDuration().toString();
                    detailText = "Mana Cost: " + mana + "\nSpell Type: "
                            + temp.getSpellType().toString() + "\nDuration: " + duration;
                }
                card3atkhp.setText(detailText);
            }
        }

        card1.setOnMouseClicked(value -> {
            this.selectedCard = 1;
            try {
				dPhase.drawSelectedCardAndReturnRemainToDeck(Controller.game, cards, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            card1.getScene().getWindow().hide();
        });

        card2.setOnMouseClicked(value -> {
            this.selectedCard = 2;
            try {
				dPhase.drawSelectedCardAndReturnRemainToDeck(Controller.game, cards, 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            card1.getScene().getWindow().hide();
        });

        card3.setOnMouseClicked(value -> {
            this.selectedCard = 3;
            try {
				dPhase.drawSelectedCardAndReturnRemainToDeck(Controller.game, cards, 2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            card1.getScene().getWindow().hide();
        });
    }
}
