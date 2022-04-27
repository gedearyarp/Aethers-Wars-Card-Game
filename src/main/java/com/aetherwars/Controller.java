package com.aetherwars;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import com.aetherwars.model.*;
import com.aetherwars.type.*;

public class Controller {
    @FXML
    private GridPane mainPage;
    @FXML
    private Label roundCount;
    @FXML
    private Rectangle Deck;
    @FXML
    private Text deckCount;
    @FXML
    private Rectangle Mana;
    @FXML
    private Text manaCount;
    @FXML
    private Button nextPhaseButton;

    @FXML
    private Label playerOneName;
    @FXML
    private Rectangle playerOneHealth; // set width to adjust health
    @FXML
    private Label playerTwoName;
    @FXML
    private Rectangle playerTwoHealth; // set width to adjust health

    @FXML
    private ImageView playerOneImage;
    @FXML
    private ImageView playerOneCardA;
    @FXML
    private ImageView playerOneCardB;
    @FXML
    private ImageView playerOneCardC;
    @FXML
    private ImageView playerOneCardD;
    @FXML
    private ImageView playerOneCardE;

    @FXML
    private ImageView playerTwoImage;
    @FXML
    private ImageView playerTwoCardA;
    @FXML
    private ImageView playerTwoCardB;
    @FXML
    private ImageView playerTwoCardD;
    @FXML
    private ImageView playerTwoCardC;
    @FXML
    private ImageView playerTwoCardE;

    @FXML
    private ImageView hoveredCardImage;
    @FXML
    private Rectangle hoveredCardDetail; // for card details of cards health, attack, etc
    @FXML
    private Text hoveredCardDetailText;
    @FXML
    private Rectangle hoveredCardDescription;
    @FXML
    private Text hoveredCardDescriptionText;

    @FXML
    private Button Card1;
    private Image Card1Image;
    @FXML
    private Button Card2;
    private Image Card2Image;
    @FXML
    private Button Card3;
    private Image Card3Image;
    @FXML
    private Button Card4;
    private Image Card4Image;
    @FXML
    private Button Card5;
    private Image Card5Image;

    @FXML
    private Label drawPhaseLabel;
    @FXML
    private Label planningPhaseLabel;
    @FXML
    private Label attackPhaseLabel;
    @FXML
    private Label endPhaseLabel;

    private GamePlay game;

    private Player playerOne;

    private Player playerTwo;

    private int currentPhaseCount = 1; // 1 = draw, 2 = planning, 3 = attack, 4 = end

    public void drawPhase() {
        drawPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
    }

    public void planningPhase() {
        planningPhaseLabel.setStyle("-fx-background-color: #00ff00");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
    }

    public void attackPhase() {
        attackPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
    }

    public void endPhase() {
        endPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
    }

    public void handleNextPhase() {
        // game.nextPhase();
        connectHandInDeck();
        nextPhaseButton.setText(">>>");
        if (currentPhaseCount == 1) {
            drawPhase();
            currentPhaseCount++;
        }
        else if (currentPhaseCount == 2) {
            planningPhase();
            currentPhaseCount++;
        }
        else if (currentPhaseCount == 3) {
            attackPhase();
            currentPhaseCount++;
        }
        else if (currentPhaseCount == 4) {
            endPhase();
            currentPhaseCount = 1;
        }
    }

    public void connectHandInDeck() {
        // playerTwo -> deck in hand
        Card1Image = new Image("com/aetherwars/card/image/character/Creeper.png");
        ImageView card1View = new ImageView(Card1Image);
        card1View.setFitHeight(80);
        card1View.setPreserveRatio(true);
        Card1.setGraphic(card1View);

        Card2Image = new Image("com/aetherwars/card/image/character/Ender Dragon.png");
        ImageView card2View = new ImageView(Card2Image);
        card2View.setFitHeight(80);
        card2View.setPreserveRatio(true);
        Card2.setGraphic(card2View);
        
        Card3Image = new Image("com/aetherwars/card/image/character/Drowned.png");
        ImageView card3View = new ImageView(Card3Image);
        card3View.setFitHeight(80);
        card3View.setPreserveRatio(true);
        Card3.setGraphic(card3View);

        Card4Image = new Image("com/aetherwars/card/image/character/Ghast.png");
        ImageView card4View = new ImageView(Card4Image);
        card4View.setFitHeight(80);
        card4View.setPreserveRatio(true);
        Card4.setGraphic(card4View);
        
        Card5Image= new Image("com/aetherwars/card/image/character/Sheep.png");
        ImageView card5View = new ImageView(Card5Image);
        card5View.setFitHeight(80);
        card5View.setPreserveRatio(true);
        Card5.setGraphic(card5View);        
    }


    public void backToNormalHovered() {
        hoveredCardImage.setImage(null);
        hoveredCardDetailText.setText("");
        hoveredCardDescriptionText.setText("");
    }

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {
        playerOne = new Player("DIPA");
        playerTwo = new Player("SEM");

        game = new GamePlay(playerOne, playerTwo);

        nextPhaseButton.setText("START");

        playerOneName.setText(playerOne.getName());
        playerTwoName.setText(playerTwo.getName());
        playerOneHealth.setWidth(500);
        playerTwoHealth.setWidth(500);


        Card1.setOnMouseMoved(value -> {
            hoveredCardImage.setImage(Card1Image);
            hoveredCardImage.setPreserveRatio(true);
            String detailText = "Creeper has 10 hp";
            String descriptionText = "Creper is a weak character";
            hoveredCardDetailText.setText(detailText);
            hoveredCardDescriptionText.setText(descriptionText);
        });

        Card1.setOnMouseExited(value -> {
            backToNormalHovered();
        });

        Card2.setOnMouseMoved(value -> {
            hoveredCardImage.setImage(Card2Image);
            hoveredCardImage.setPreserveRatio(true);
            String detailText = "Creeper has 10 hp";
            String descriptionText = "Creper is a weak character";
            hoveredCardDetailText.setText(detailText);
            hoveredCardDescriptionText.setText(descriptionText);
            
        });

        Card2.setOnMouseExited(value -> {
            backToNormalHovered();
        });

        Card3.setOnMouseMoved(value -> {
            hoveredCardImage.setImage(Card3Image);
            hoveredCardImage.setPreserveRatio(true);
            String detailText = "Creeper has 10 hp";
            String descriptionText = "Creper is a weak character";
            hoveredCardDetailText.setText(detailText);
            hoveredCardDescriptionText.setText(descriptionText);
        });

        Card3.setOnMouseExited(value -> {
            backToNormalHovered();
        });

        Card4.setOnMouseMoved(value -> {
            hoveredCardImage.setImage(Card4Image);
            hoveredCardImage.setPreserveRatio(true);
            String detailText = "Creeper has 10 hp";
            String descriptionText = "Creper is a weak character";
            hoveredCardDetailText.setText(detailText);
            hoveredCardDescriptionText.setText(descriptionText);
        });

        Card4.setOnMouseExited(value -> {
            backToNormalHovered();
        });

        Card5.setOnMouseMoved(value -> {
            hoveredCardImage.setImage(Card5Image);
            hoveredCardImage.setPreserveRatio(true);
            String detailText = "Creeper has 10 hp";
            String descriptionText = "Creper is a weak character";
            hoveredCardDetailText.setText(detailText);
            hoveredCardDescriptionText.setText(descriptionText);
        });

        Card5.setOnMouseExited(value -> {
            hoveredCardImage.setImage(null);
        });

    }

}
