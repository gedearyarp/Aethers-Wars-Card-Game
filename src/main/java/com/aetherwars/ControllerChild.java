package com.aetherwars;

import java.util.ArrayList;

import com.aetherwars.model.Card;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ControllerChild {
    // card 1
    @FXML
    private GridPane card1draw;
    @FXML
    private ImageView card1image;
    @FXML
    private Label card1mana;
    @FXML
    private Label card1atkhp;

    // card 2
    @FXML
    private GridPane card2draw;
    @FXML
    private ImageView card2image;
    @FXML
    private Label card2mana;
    @FXML
    private Label card2atkhp;

    // card 3
    @FXML
    private GridPane card3draw;
    @FXML
    private ImageView card3image;
    @FXML
    private Label card3mana;
    @FXML
    private Label card3atkhp;

    private Pane parent;

    private Integer selectedCard;

    public void setParent(Pane parent) {
        this.parent = parent;
    }

    public void toParent() {
        parent.toFront();
    }

    public void setCards(ArrayList<Card> cards) {

        // set all image
        card1image.setImage(new Image(cards.get(0).getImagePath()));
        card2image.setImage(new Image(cards.get(1).getImagePath()));
        card3image.setImage(new Image(cards.get(2).getImagePath()));

        // set label for mana
        card1mana.setText(cards.get(0).getmanaCost().toString());
        card2mana.setText(cards.get(1).getmanaCost().toString());
        card3mana.setText(cards.get(2).getmanaCost().toString());

        card1draw.setOnMouseClicked(value -> {
            this.selectedCard = 1; 
            toParent();
        });
        
        card2draw.setOnMouseClicked(value -> {
            this.selectedCard = 2; 
            toParent();
        });
 
        card3draw.setOnMouseClicked(value -> {
            this.selectedCard = 3; 
            toParent();
        });
    }
        

    public Integer getSelectedCard() {
        return selectedCard;
    }
}
