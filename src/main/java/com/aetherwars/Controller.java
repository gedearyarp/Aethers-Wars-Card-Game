package com.aetherwars;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

import java.util.ArrayList;

import com.aetherwars.model.*;
import com.aetherwars.model.Character;
import com.aetherwars.service.AttackPhase;
import com.aetherwars.service.DrawPhase;
import com.aetherwars.service.PlanningPhase;
import com.aetherwars.type.*;

public class Controller {
    private Pane root;

    public void setParent(Pane parent) {
        this.root = parent;
    }

    public Integer toChild(ArrayList<Card> cards) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("com/aetherwars/fxml/child.fxml"));
            Pane child = loader.load();
            ControllerChild controllerChild = loader.getController();
            controllerChild.setParent(root);
            controllerChild.setCards(cards);
            root.getChildren().add(child);
            child.toFront();
            root.toBack();
            return controllerChild.getSelectedCard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

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
    private Integer playerOneTotalDeck;
    @FXML
    private Label playerTwoName;
    @FXML
    private Rectangle playerTwoHealth; // set width to adjust health
    private Integer playerTwoTotalDeck;

    @FXML
    private Button playerOneAvatar;
    @FXML
    private Pane playerOneImageRectangle;
    @FXML
    private Button playerOneCardA;
    @FXML
    private Label playerOneCardAAtkLabel;
    @FXML
    private Label playerOneCardAAtkCount;
    @FXML
    private Label playerOneCardAHpLabel;
    @FXML
    private Label playerOneCardAHpCount;
    @FXML
    private Label playerOneCardAExpLabel;

    @FXML
    private Button playerOneCardB;
    @FXML
    private Label playerOneCardBAtkLabel;
    @FXML
    private Label playerOneCardBAtkCount;
    @FXML
    private Label playerOneCardBHpLabel;
    @FXML
    private Label playerOneCardBHpCount;
    @FXML
    private Label playerOneCardBExpLabel;

    @FXML
    private Button playerOneCardC;
    @FXML
    private Label playerOneCardCAtkLabel;
    @FXML
    private Label playerOneCardCAtkCount;
    @FXML
    private Label playerOneCardCHpLabel;
    @FXML
    private Label playerOneCardCHpCount;
    @FXML
    private Label playerOneCardCExpLabel;

    @FXML
    private Button playerOneCardD;
    @FXML
    private Label playerOneCardDAtkLabel;
    @FXML
    private Label playerOneCardDAtkCount;
    @FXML
    private Label playerOneCardDHpLabel;
    @FXML
    private Label playerOneCardDHpCount;
    @FXML
    private Label playerOneCardDExpLabel;

    @FXML
    private Button playerOneCardE;
    @FXML
    private Label playerOneCardEAtkLabel;
    @FXML
    private Label playerOneCardEAtkCount;
    @FXML
    private Label playerOneCardEHpLabel;
    @FXML
    private Label playerOneCardEHpCount;
    @FXML
    private Label playerOneCardEExpLabel;

    @FXML
    private Button playerTwoAvatar;
    @FXML
    private Pane playerTwoImageRectangle;
    @FXML
    private Button playerTwoCardA;
    @FXML
    private Label playerTwoCardAAtkLabel;
    @FXML
    private Label playerTwoCardAAtkCount;
    @FXML
    private Label playerTwoCardAHpLabel;
    @FXML
    private Label playerTwoCardAHpCount;
    @FXML
    private Label playerTwoCardAExpLabel;

    @FXML
    private Button playerTwoCardB;
    @FXML
    private Label playerTwoCardBAtkLabel;
    @FXML
    private Label playerTwoCardBAtkCount;
    @FXML
    private Label playerTwoCardBHpLabel;
    @FXML
    private Label playerTwoCardBHpCount;
    @FXML
    private Label playerTwoCardBExpLabel;

    @FXML
    private Button playerTwoCardD;
    @FXML
    private Label playerTwoCardDAtkLabel;
    @FXML
    private Label playerTwoCardDAtkCount;
    @FXML
    private Label playerTwoCardDHpLabel;
    @FXML
    private Label playerTwoCardDHpCount;
    @FXML
    private Label playerTwoCardDExpLabel;

    @FXML
    private Button playerTwoCardC;
    @FXML
    private Label playerTwoCardCAtkLabel;
    @FXML
    private Label playerTwoCardCAtkCount;
    @FXML
    private Label playerTwoCardCHpLabel;
    @FXML
    private Label playerTwoCardCHpCount;
    @FXML
    private Label playerTwoCardCExpLabel;

    @FXML
    private Button playerTwoCardE;
    @FXML
    private Label playerTwoCardEAtkLabel;
    @FXML
    private Label playerTwoCardEAtkCount;
    @FXML
    private Label playerTwoCardEHpLabel;
    @FXML
    private Label playerTwoCardEHpCount;
    @FXML
    private Label playerTwoCardEExpLabel;

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
    private Button removeCardButton;
    private boolean removeCardButtonClicked = false;
    @FXML
    private Button addEXPbutton;
    private boolean addEXPbuttonClicked = false;
    @FXML
    private Button Card1;
    @FXML
    private Button Card2;
    @FXML
    private Button Card3;
    @FXML
    private Button Card4;
    @FXML
    private Button Card5;

    @FXML
    private Label drawPhaseLabel;
    @FXML
    private Label planningPhaseLabel;
    @FXML
    private Label attackPhaseLabel;
    @FXML
    private Label endPhaseLabel;

    @FXML
    private Text commandText;

    private GamePlay game;

    private Player playerOne;

    private Player playerTwo;

    private Integer currPlayer;

    private Integer clickedCardInHandIndex = -1;

    private String clickedCardInBoardPlayerOne = "";

    private String clickedCardInBoardPlayerTwo = "";

    private int currentPhaseCount = 0; // 1 = draw, 2 = planning, 3 = attack, 4 = end

    public void setCommandText(String text) {
        try {
            commandText.setText(text);
        } catch (Exception e) {
            System.out.println("Error in setCommandText");
        }
    }

    public void updatePlayer() {
        playerOne = game.getPlayers()[0];
        playerTwo = game.getPlayers()[1];
        playerOneName.setText(playerOne.getName() + " (" + playerOne.getHp() + "/100)");
        playerTwoName.setText(playerTwo.getName() + " (" + playerTwo.getHp() + "/100)");
        playerOneHealth.setWidth(playerOne.getHp() * 5);
        playerTwoHealth.setWidth(playerTwo.getHp() * 5);
    }

    public void drawPhase() {
        setCommandText("Select 1 card to draw! \n(if you have more than 5 card, you will discard the leftmost card)");
        updatePlayer();
        unplanningPhase();
        unattackPhase();
        drawPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        DrawPhase dPhase = new DrawPhase();
        ArrayList<Card> topThreeCards = dPhase.getTopThreeFromCurrPlayersDeck(game);
        // random integer selected card from 0 t0 2
        int selectedCard = (int) (Math.random() * 3);
        // Integer selectedCard = toChild(topThreeCards);
        try {
            dPhase.drawSelectedCardAndReturnRemainToDeck(game, topThreeCards, selectedCard);
            dPhase.resetMana(game);
        } catch (Exception e) {
            System.out.println("Draw Phase Error");
        }
    }

    public void unplanningPhase() {
        updatePlayer();
        addEXPbutton.setDisable(true);

        removeCardButton.setDisable(true);

        addEXPbutton.setOnMouseClicked(value -> {
        });

        removeCardButton.setOnMouseClicked(value -> {
        });

        Card1.setOnMouseClicked(value -> {
        });

        Card2.setOnMouseClicked(value -> {
        });

        Card3.setOnMouseClicked(value -> {
        });

        Card4.setOnMouseClicked(value -> {
        });

        Card5.setOnMouseClicked(value -> {
        });

        if (currPlayer == 0) {
            playerOneCardA.setOnMouseClicked(value -> {
            });

            playerOneCardB.setOnMouseClicked(value -> {
            });

            playerOneCardC.setOnMouseClicked(value -> {
            });

            playerOneCardD.setOnMouseClicked(value -> {
            });

            playerOneCardE.setOnMouseClicked(value -> {
            });
        } else {
            playerTwoCardA.setOnMouseClicked(value -> {
            });

            playerTwoCardB.setOnMouseClicked(value -> {
            });

            playerTwoCardC.setOnMouseClicked(value -> {
            });

            playerTwoCardD.setOnMouseClicked(value -> {
            });

            playerTwoCardE.setOnMouseClicked(value -> {
            });
        }

    }

    public boolean checkClickedCardInHand() {
        return clickedCardInHandIndex != -1;
    }

    public boolean checkRemoveCardCommand() {
        return removeCardButtonClicked;
    }

    public boolean checkAddExpCommand() {
        return addEXPbuttonClicked;
    }

    public void updateAll() {
        updatePlayer();
        connectHandInDeck();
        connectMouseHover();
        connectMana();
        connectRound();
        connectBoard();
        connectHoveredBoard();
    }

    public void planningPhase() {
        updatePlayer();
        unattackPhase();
        setCommandText("Put your card to the board!");

        updateAll();

        PlanningPhase pPhase = new PlanningPhase();

        planningPhaseLabel.setStyle("-fx-background-color: #00ff00");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");

        addEXPbutton.setDisable(false);
        removeCardButton.setDisable(false);

        addEXPbutton.setOnMouseClicked(value -> {
            addEXPbuttonClicked = true;
            removeCardButtonClicked = false;
        });

        removeCardButton.setOnMouseClicked(value -> {
            addEXPbuttonClicked = false;
            removeCardButtonClicked = true;
        });

        Card1.setOnMouseClicked(value -> {
            if (checkRemoveCardCommand()) {
                try {
                    pPhase.removeCardFromHand(game, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else if (checkAddExpCommand()) {
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else {
                clickedCardInHandIndex = 0;
            }
            updateAll();
        });

        Card2.setOnMouseClicked(value -> {
            if (checkRemoveCardCommand()) {
                try {
                    pPhase.removeCardFromHand(game, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else if (checkAddExpCommand()) {
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else {
                clickedCardInHandIndex = 1;
            }
            updateAll();
        });

        Card3.setOnMouseClicked(value -> {
            if (checkRemoveCardCommand()) {
                try {
                    pPhase.removeCardFromHand(game, 2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else if (checkAddExpCommand()) {
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else {
                clickedCardInHandIndex = 2;
            }
            updateAll();
        });

        Card4.setOnMouseClicked(value -> {
            if (checkRemoveCardCommand()) {
                try {
                    pPhase.removeCardFromHand(game, 3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else if (checkAddExpCommand()) {
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else {
                clickedCardInHandIndex = 3;
            }
            updateAll();
        });

        Card5.setOnMouseClicked(value -> {
            if (checkRemoveCardCommand()) {
                try {
                    pPhase.removeCardFromHand(game, 4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else if (checkAddExpCommand()) {
                addEXPbuttonClicked = false;
                removeCardButtonClicked = false;
            } else {
                clickedCardInHandIndex = 4;
            }
            updateAll();
        });

        // ================ PLAYER ONE ======================
        if (currPlayer == 0) {
            playerOneCardA.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "A");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerOne.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "A", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "A");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "A");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "A");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "A");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerOneCardB.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "B");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerOne.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "B", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "B");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "B");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "B");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "B");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerOneCardC.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "C");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerOne.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "C", 1);
                        }
                        pPhase.useMana(game, "C", 1);
                    } else if (checkClickedCardInHand()) {
                        if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "C");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "C");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "C");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "C");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerOneCardD.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "D");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerOne.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "D", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "D");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "D");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "D");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "D");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerOneCardE.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "E");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerOne.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "E", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "E");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "E");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "E");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "E");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerTwoCardA.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "A");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "A");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerTwoCardB.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "B");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "B");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerTwoCardC.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "C");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "C");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerTwoCardD.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "D");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "D");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerTwoCardE.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerOne.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "E");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "E");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            // ====================== PLAYER TWO PLANNING PHASE INTERACTION ===============
        } else {
            playerTwoCardA.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "A");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerTwo.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "A", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "A");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "A");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "A");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "A");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerTwoCardB.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "B");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerTwo.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "B", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "B");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "B");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "B");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "B");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerTwoCardC.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "C");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerTwo.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "C", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "C");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "C");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "C");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "C");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerTwoCardD.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "D");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerTwo.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "D", 1);
                        }
                    } else if (checkClickedCardInHand()) {
                        if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "D");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "D");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "D");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "D");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerTwoCardE.setOnMouseClicked(value -> {
                try {
                    if (checkRemoveCardCommand()) {
                        pPhase.removeCardFromBoard(game, "E");
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                    } else if (checkAddExpCommand()) {
                        addEXPbuttonClicked = false;
                        removeCardButtonClicked = false;
                        if (playerTwo.getMana() < 1) {
                            setCommandText("Mana is not enough to use");
                        } else {
                            pPhase.useMana(game, "E", 1);
                        }
                        ;
                    } else if (checkClickedCardInHand()) {
                        if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType()
                                .equals(CardType.CHARACTER)) {
                            pPhase.placeCharCard(game, clickedCardInHandIndex, "E");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "E");
                            if (!state) {
                                setCommandText("Mana is not enough to summon");
                            }
                        } else {
                            pPhase.placeSpell(game, clickedCardInHandIndex, "E");
                            updateAll();
                            boolean state = pPhase.checkManaAndReduceMana(game,
                                    game.getPlayers()[game.getCurrPlayerIndex()].getHandCard(clickedCardInHandIndex),
                                    "E");
                            if (!state) {
                                setCommandText("Mana is not enough to activate spell");
                            }
                        }
                    }
                    updateAll();
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            });

            playerOneCardA.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "A");
                            updateAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerOneCardB.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "B");
                            updateAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerOneCardC.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "C");
                            updateAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerOneCardD.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "D");
                            updateAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

            playerOneCardE.setOnMouseClicked(value -> {
                if (checkClickedCardInHand()) {
                    if (playerTwo.getHandCard().get(clickedCardInHandIndex).getCardType().equals(CardType.CHARACTER)) {
                    } else {
                        try {
                            pPhase.placeSpellEnemy(game, clickedCardInHandIndex, "E");
                            updateAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                updateAll();
            });

        }
    }

    public void unattackPhase() {
        AttackPhase aPhase = new AttackPhase();
        aPhase.resetAllCharAttackedState(game);

        playerOneCardA.setStyle("-fx-background-color: #ffffff");
        playerOneCardB.setStyle("-fx-background-color: #ffffff");
        playerOneCardC.setStyle("-fx-background-color: #ffffff");
        playerOneCardD.setStyle("-fx-background-color: #ffffff");
        playerOneCardE.setStyle("-fx-background-color: #ffffff");

        playerTwoCardA.setStyle("-fx-background-color: #ffffff");
        playerTwoCardB.setStyle("-fx-background-color: #ffffff");
        playerTwoCardC.setStyle("-fx-background-color: #ffffff");
        playerTwoCardD.setStyle("-fx-background-color: #ffffff");
        playerTwoCardE.setStyle("-fx-background-color: #ffffff");

        playerOneCardA.setOnMouseClicked(value -> {
        });

        playerOneCardB.setOnMouseClicked(value -> {
        });

        playerOneCardC.setOnMouseClicked(value -> {
        });

        playerOneCardD.setOnMouseClicked(value -> {
        });

        playerOneCardE.setOnMouseClicked(value -> {
        });

        playerOneAvatar.setOnMouseClicked(value -> {
        });

        playerTwoAvatar.setOnMouseClicked(value -> {
        });

        playerTwoCardA.setOnMouseClicked(value -> {
        });

        playerTwoCardB.setOnMouseClicked(value -> {
        });

        playerTwoCardC.setOnMouseClicked(value -> {
        });

        playerTwoCardD.setOnMouseClicked(value -> {
        });

        playerTwoCardE.setOnMouseClicked(value -> {
        });
    }

    public void updateBoardBackground(String pos) {
        if (currPlayer == 0) {
            if (pos.equals("A")) {
                playerOneCardA.setStyle("-fx-background-color: pink");
            } else if (pos.equals("B")) {
                playerOneCardB.setStyle("-fx-background-color: pink");
            } else if (pos.equals("C")) {
                playerOneCardC.setStyle("-fx-background-color: pink");
            } else if (pos.equals("D")) {
                playerOneCardD.setStyle("-fx-background-color: pink");
            } else if (pos.equals("E")) {
                playerOneCardE.setStyle("-fx-background-color: pink");
            }
        } else {
            if (pos.equals("A")) {
                playerTwoCardA.setStyle("-fx-background-color: pink");
            } else if (pos.equals("B")) {
                playerTwoCardB.setStyle("-fx-background-color: pink");
            } else if (pos.equals("C")) {
                playerTwoCardC.setStyle("-fx-background-color: pink");
            } else if (pos.equals("D")) {
                playerTwoCardD.setStyle("-fx-background-color: pink");
            } else if (pos.equals("E")) {
                playerTwoCardE.setStyle("-fx-background-color: pink");
            }
        }

    }

    public void attackPhase() {
        unplanningPhase();
        setCommandText(
                "Attack your opponent by clicking on your card(attacker) and your opponent's card(defender). \nAttacker card can only attack once per round");

        clickedCardInHandIndex = -1;
        attackPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        endPhaseLabel.setStyle("-fx-background-color: #1c8ae1");

        AttackPhase aPhase = new AttackPhase();

        if (currPlayer == 0) {
            playerOneCardA.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerOne = "A";
                if (!game.getBoard().get(0).get("A").getHasAttacked()) {
                    playerOneCardA.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(0).get("B").getHasAttacked()) {
                    playerOneCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("C").getHasAttacked()) {
                    playerOneCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("D").getHasAttacked()) {
                    playerOneCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("E").getHasAttacked()) {
                    playerOneCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerOneCardB.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerOne = "B";
                if (!game.getBoard().get(0).get("A").getHasAttacked()) {
                    playerOneCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("B").getHasAttacked()) {
                    playerOneCardB.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(0).get("C").getHasAttacked()) {
                    playerOneCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("D").getHasAttacked()) {
                    playerOneCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("E").getHasAttacked()) {
                    playerOneCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerOneCardC.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerOne = "C";
                if (!game.getBoard().get(0).get("A").getHasAttacked()) {
                    playerOneCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("B").getHasAttacked()) {
                    playerOneCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("C").getHasAttacked()) {
                    playerOneCardC.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(0).get("D").getHasAttacked()) {
                    playerOneCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("E").getHasAttacked()) {
                    playerOneCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerOneCardD.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerOne = "D";
                if (!game.getBoard().get(0).get("A").getHasAttacked()) {
                    playerOneCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("B").getHasAttacked()) {
                    playerOneCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("C").getHasAttacked()) {
                    playerOneCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("D").getHasAttacked()) {
                    playerOneCardD.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(0).get("E").getHasAttacked()) {
                    playerOneCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerOneCardE.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerOne = "E";
                if (!game.getBoard().get(0).get("A").getHasAttacked()) {
                    playerOneCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("B").getHasAttacked()) {
                    playerOneCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("C").getHasAttacked()) {
                    playerOneCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("D").getHasAttacked()) {
                    playerOneCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(0).get("E").getHasAttacked()) {
                    playerOneCardE.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
            });

            playerTwoAvatar.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    if (game.getBoard().isBoardEmpty(1)) {
                        try {
                            aPhase.attackOtherPlayer(game, clickedCardInBoardPlayerOne.toString());
                            updateBoardBackground(clickedCardInBoardPlayerOne);
                            updateAll();
                    } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        setCommandText("You can only attack when the board is empty");
                    }
                }
                updateAll();
            });

            playerTwoCardA.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerOne.toString(), "A");
                        updateBoardBackground(clickedCardInBoardPlayerOne);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerTwoCardB.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerOne.toString(), "B");
                        updateBoardBackground(clickedCardInBoardPlayerOne);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerTwoCardC.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerOne.toString(), "C");
                        updateBoardBackground(clickedCardInBoardPlayerOne);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerTwoCardD.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerOne.toString(), "D");
                        updateBoardBackground(clickedCardInBoardPlayerOne);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerTwoCardE.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerOne.toString(), "E");
                        updateBoardBackground(clickedCardInBoardPlayerOne);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

        } else {
            playerTwoCardA.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerTwo = "A";
                if (!game.getBoard().get(1).get("A").getHasAttacked()) {
                    playerTwoCardA.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(1).get("B").getHasAttacked()) {
                    playerTwoCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("C").getHasAttacked()) {
                    playerTwoCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("D").getHasAttacked()) {
                    playerTwoCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("E").getHasAttacked()) {
                    playerTwoCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerTwoCardB.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerTwo = "B";
                if (!game.getBoard().get(1).get("A").getHasAttacked()) {
                    playerTwoCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("B").getHasAttacked()) {
                    playerTwoCardB.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(1).get("C").getHasAttacked()) {
                    playerTwoCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("D").getHasAttacked()) {
                    playerTwoCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("E").getHasAttacked()) {
                    playerTwoCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerTwoCardC.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerTwo = "C";
                if (!game.getBoard().get(1).get("A").getHasAttacked()) {
                    playerTwoCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("B").getHasAttacked()) {
                    playerTwoCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("C").getHasAttacked()) {
                    playerTwoCardC.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(1).get("D").getHasAttacked()) {
                    playerTwoCardD.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("E").getHasAttacked()) {
                    playerTwoCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerTwoCardD.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerTwo = "D";
                if (!game.getBoard().get(1).get("A").getHasAttacked()) {
                    playerTwoCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("B").getHasAttacked()) {
                    playerTwoCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("C").getHasAttacked()) {
                    playerTwoCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("D").getHasAttacked()) {
                    playerTwoCardD.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(1).get("E").getHasAttacked()) {
                    playerTwoCardE.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerTwoCardE.setOnMouseClicked(value -> {
                clickedCardInBoardPlayerTwo = "E";
                if (!game.getBoard().get(1).get("E").getHasAttacked()) {
                    playerTwoCardE.setStyle("-fx-border-color: red; -fx-background-color: #1c8ae1");
                }
                if (!game.getBoard().get(1).get("A").getHasAttacked()) {
                    playerTwoCardA.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("B").getHasAttacked()) {
                    playerTwoCardB.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("C").getHasAttacked()) {
                    playerTwoCardC.setStyle("-fx-background-color: #ffffff");
                }
                if (!game.getBoard().get(1).get("D").getHasAttacked()) {
                    playerTwoCardD.setStyle("-fx-background-color: #ffffff");
                }
            });

            playerOneAvatar.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerOne != "") {
                    if (game.getBoard().isBoardEmpty(0)) {
                        try {
                            aPhase.attackOtherPlayer(game, clickedCardInBoardPlayerTwo.toString());
                            updateBoardBackground(clickedCardInBoardPlayerTwo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        setCommandText("You can only attack when the board is empty");
                    }
                }
                updateAll();
            });

            playerOneCardA.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerTwo != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerTwo.toString(), "A");
                        updateBoardBackground(clickedCardInBoardPlayerTwo);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerOneCardB.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerTwo != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerTwo.toString(), "B");
                        updateBoardBackground(clickedCardInBoardPlayerTwo);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerOneCardC.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerTwo != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerTwo.toString(), "C");
                        updateBoardBackground(clickedCardInBoardPlayerTwo);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerOneCardD.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerTwo != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerTwo.toString(), "D");
                        updateBoardBackground(clickedCardInBoardPlayerTwo);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

            playerOneCardE.setOnMouseClicked(value -> {
                if (clickedCardInBoardPlayerTwo != "") {
                    try {
                        aPhase.attackOtherCharacter(game, clickedCardInBoardPlayerTwo.toString(), "E");
                        updateBoardBackground(clickedCardInBoardPlayerTwo);
                        updateAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                updateAll();
            });

        }
    }

    public void endPhase() {
        unplanningPhase();
        endPhaseLabel.setStyle("-fx-background-color: #00ff00");
        planningPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        attackPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        drawPhaseLabel.setStyle("-fx-background-color: #1c8ae1");
        setCommandText("");
    }

    public void handleNextPhase() {
        System.out.println("curr phase: " + currentPhaseCount);
        if (currentPhaseCount == 0) {
            setCommandText("Click DRAW to start the game");
            nextPhaseButton.setText("DRAW!!");
            currentPhaseCount = 1;
            updatePlayer();
            connectBoard();
            connectDeck();
            connectHandInDeck();
            connectMouseHover();
            connectMana();
            connectRound();
            connectBoard();
            connectHoveredBoard();
        } else {
            nextPhaseButton.setText(">>>");
            game.nextPhase();
            updatePlayer();
            connectBoard();
            connectDeck();
            connectHandInDeck();
            connectMouseHover();
            connectMana();
            connectRound();
            connectBoard();
            connectHoveredBoard();

            if (currentPhaseCount == 1) {
                drawPhase();
                currentPhaseCount++;
                connectRound();
                System.out.println("CurrPlayer: " + currPlayer);
                if (currPlayer == 0) {
                    playerOneImageRectangle.setStyle("-fx-border-color: #1c8ae1; -fx-border-width:50");
                    playerTwoImageRectangle.setStyle("-fx-border-color: black");
                } else {
                    playerTwoImageRectangle.setStyle("-fx-border-color: #1c8ae1;-fx-border-width:50");
                    playerOneImageRectangle.setStyle("-fx-border-color: black");
                }
            } else if (currentPhaseCount == 2) {
                planningPhase();
                currentPhaseCount++;
            } else if (currentPhaseCount == 3) {
                attackPhase();
                currentPhaseCount++;
            } else if (currentPhaseCount == 4) {
                endPhase();
                nextPhaseButton.setText("End Turn");
                currentPhaseCount = 1;
                currPlayer = game.getCurrPlayerIndex();
            }

        }
    }

    public void connectHoveredBoard() {
        Board board = game.getBoard();
        if (currPlayer == 0) {
            String imagePathA = board.get(0).get("A").getCharacter().getImagePath();
            playerOneCardA.setOnMouseMoved(value -> {
                if (imagePathA != "" && board.get(0).get("A").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathA));

                    SummonedCharacter tempSum = board.get(0).get("A");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerOneCardA.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathB = board.get(0).get("B").getCharacter().getImagePath();
            playerOneCardB.setOnMouseMoved(value -> {
                if (imagePathB != "" && board.get(0).get("B").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathB));

                    SummonedCharacter tempSum = board.get(0).get("B");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerOneCardB.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathC = board.get(0).get("C").getCharacter().getImagePath();
            playerOneCardC.setOnMouseMoved(value -> {
                if (imagePathC != "" && board.get(0).get("C").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathC));

                    SummonedCharacter tempSum = board.get(0).get("C");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());

                }
            });

            playerOneCardC.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathD = board.get(0).get("D").getCharacter().getImagePath();
            playerOneCardD.setOnMouseMoved(value -> {
                if (imagePathD != "" && board.get(0).get("D").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathD));

                    SummonedCharacter tempSum = board.get(0).get("D");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerOneCardD.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathE = board.get(0).get("E").getCharacter().getImagePath();
            playerOneCardE.setOnMouseMoved(value -> {
                if (imagePathE != "" && board.get(0).get("E").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathE));

                    SummonedCharacter tempSum = board.get(0).get("E");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerOneCardE.setOnMouseExited(value -> {
                backToNormalHovered();
            });
        } else {
            String imagePathA = board.get(1).get("A").getCharacter().getImagePath();
            playerTwoCardA.setOnMouseMoved(value -> {
                if (imagePathA != "" && board.get(1).get("A").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathA));

                    SummonedCharacter tempSum = board.get(1).get("A");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerTwoCardA.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathB = board.get(1).get("B").getCharacter().getImagePath();
            playerTwoCardB.setOnMouseMoved(value -> {
                if (imagePathB != "" && board.get(1).get("B").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathB));

                    SummonedCharacter tempSum = board.get(1).get("B");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerTwoCardB.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathC = board.get(1).get("C").getCharacter().getImagePath();
            playerTwoCardC.setOnMouseMoved(value -> {
                if (imagePathC != "" && board.get(1).get("C").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathC));

                    SummonedCharacter tempSum = board.get(1).get("C");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());

                }
            });

            playerTwoCardC.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathD = board.get(1).get("D").getCharacter().getImagePath();
            playerTwoCardD.setOnMouseMoved(value -> {
                if (imagePathD != "" && board.get(1).get("D").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathD));

                    SummonedCharacter tempSum = board.get(1).get("D");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerTwoCardD.setOnMouseExited(value -> {
                backToNormalHovered();
            });

            String imagePathE = board.get(1).get("E").getCharacter().getImagePath();
            playerTwoCardE.setOnMouseMoved(value -> {
                if (imagePathE != "" && board.get(1).get("E").getCharacter().getHealth() > 0) {
                    hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePathE));

                    SummonedCharacter tempSum = board.get(1).get("E");
                    Character tempChar = tempSum.getCharacter();
                    Integer atk = tempChar.getAttack();
                    Integer hp = tempChar.getHealth();
                    Integer level = tempSum.getLevel();
                    String name = tempChar.getName();
                    String type = tempChar.getType().toString();
                    Integer hpAdd = tempSum.getHpAdd();
                    Integer atkAdd = tempSum.getAttackAdd();
                    Integer exp = tempSum.getExperience();
                    Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
                    String detailText = "Name: " + name + "\n" + "Type: " + type + "\n" + "Level: " + level + "\n"
                            + "HP: " + hp + "(" + hpAdd + ")" + "\n" + "Attack: " + atk + "(" + atkAdd + ")" + "\n"
                            + "\n" + "Experience: " + exp + "/" + expMax[level - 1] + "\n";
                    hoveredCardDetailText.setText(detailText);

                    hoveredCardDescriptionText.setText(tempChar.getDescription());
                }
            });

            playerTwoCardE.setOnMouseExited(value -> {
                backToNormalHovered();
            });

        }
    }

    public void initializeBoard() {
        playerOneCardAAtkLabel.setText("");
        playerOneCardAHpLabel.setText("");
        playerOneCardAAtkCount.setText("");
        playerOneCardAHpCount.setText("");
        playerOneCardAExpLabel.setText("");

        playerOneCardBAtkLabel.setText("");
        playerOneCardBHpLabel.setText("");
        playerOneCardBAtkCount.setText("");
        playerOneCardBHpCount.setText("");
        playerOneCardBExpLabel.setText("");

        playerOneCardCAtkLabel.setText("");
        playerOneCardCHpLabel.setText("");
        playerOneCardCAtkCount.setText("");
        playerOneCardCHpCount.setText("");
        playerOneCardCExpLabel.setText("");

        playerOneCardDAtkLabel.setText("");
        playerOneCardDHpLabel.setText("");
        playerOneCardDAtkCount.setText("");
        playerOneCardDHpCount.setText("");
        playerOneCardDExpLabel.setText("");

        playerOneCardEAtkLabel.setText("");
        playerOneCardEHpLabel.setText("");
        playerOneCardEAtkCount.setText("");
        playerOneCardEHpCount.setText("");
        playerOneCardEExpLabel.setText("");

        playerTwoCardAAtkLabel.setText("");
        playerTwoCardAHpLabel.setText("");
        playerTwoCardAAtkCount.setText("");
        playerTwoCardAHpCount.setText("");
        playerTwoCardAExpLabel.setText("");

        playerTwoCardBAtkLabel.setText("");
        playerTwoCardBHpLabel.setText("");
        playerTwoCardBAtkCount.setText("");
        playerTwoCardBHpCount.setText("");
        playerTwoCardBExpLabel.setText("");

        playerTwoCardCAtkLabel.setText("");
        playerTwoCardCHpLabel.setText("");
        playerTwoCardCAtkCount.setText("");
        playerTwoCardCHpCount.setText("");
        playerTwoCardCExpLabel.setText("");

        playerTwoCardDAtkLabel.setText("");
        playerTwoCardDHpLabel.setText("");
        playerTwoCardDAtkCount.setText("");
        playerTwoCardDHpCount.setText("");
        playerTwoCardDExpLabel.setText("");

        playerTwoCardEAtkLabel.setText("");
        playerTwoCardEHpLabel.setText("");
        playerTwoCardEAtkCount.setText("");
        playerTwoCardEHpCount.setText("");
        playerTwoCardEExpLabel.setText("");
    }

    public void connectBoard() {
        Board board = game.getBoard();
        String imagePathA = board.get(0).get("A").getCharacter().getImagePath();
        if (imagePathA != "" && board.get(0).get("A").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathA));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerOneCardA.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(0).get("A");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerOneCardAAtkLabel.setText("Atk");
            playerOneCardAAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerOneCardAHpLabel.setText("HP");
            playerOneCardAHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerOneCardAExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");
        } else {
            playerOneCardA.setGraphic(null);
            playerOneCardAAtkLabel.setText("");
            playerOneCardAHpLabel.setText("");
            playerOneCardAAtkCount.setText("");
            playerOneCardAHpCount.setText("");
            playerOneCardAExpLabel.setText("");
        }
        String imagePathB = board.get(0).get("B").getCharacter().getImagePath();
        if (imagePathB != "" && board.get(0).get("B").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathB));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerOneCardB.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(0).get("B");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerOneCardBAtkLabel.setText("Atk");
            playerOneCardBAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerOneCardBHpLabel.setText("HP");
            playerOneCardBHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerOneCardBExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerOneCardB.setGraphic(null);
            playerOneCardBAtkLabel.setText("");
            playerOneCardBHpLabel.setText("");
            playerOneCardBAtkCount.setText("");
            playerOneCardBHpCount.setText("");
            playerOneCardBExpLabel.setText("");
        }
        String imagePathC = board.get(0).get("C").getCharacter().getImagePath();
        if (imagePathC != "" && board.get(0).get("C").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathC));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerOneCardC.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(0).get("C");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerOneCardCAtkLabel.setText("Atk");
            playerOneCardCAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerOneCardCHpLabel.setText("HP");
            playerOneCardCHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerOneCardCExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerOneCardC.setGraphic(null);
            playerOneCardCAtkLabel.setText("");
            playerOneCardCHpLabel.setText("");
            playerOneCardCAtkCount.setText("");
            playerOneCardCHpCount.setText("");
            playerOneCardCExpLabel.setText("");
        }
        String imagePathD = board.get(0).get("D").getCharacter().getImagePath();
        if (imagePathD != "" && board.get(0).get("D").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathD));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerOneCardD.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(0).get("D");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerOneCardDAtkLabel.setText("Atk");
            playerOneCardDAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerOneCardDHpLabel.setText("HP");
            playerOneCardDHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerOneCardDExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerOneCardD.setGraphic(null);
            playerOneCardDAtkLabel.setText("");
            playerOneCardDHpLabel.setText("");
            playerOneCardDAtkCount.setText("");
            playerOneCardDHpCount.setText("");
            playerOneCardDExpLabel.setText("");
        }
        String imagePathE = board.get(0).get("E").getCharacter().getImagePath();
        if (imagePathE != "" && board.get(0).get("E").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathE));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerOneCardE.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(0).get("E");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerOneCardEAtkLabel.setText("Atk");
            playerOneCardEAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerOneCardEHpLabel.setText("HP");
            playerOneCardEHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerOneCardEExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerOneCardE.setGraphic(null);
            playerOneCardEAtkLabel.setText("");
            playerOneCardEHpLabel.setText("");
            playerOneCardEAtkCount.setText("");
            playerOneCardEHpCount.setText("");
            playerOneCardEExpLabel.setText("");
        }

        imagePathA = board.get(1).get("A").getCharacter().getImagePath();
        if (imagePathA != "" && board.get(1).get("A").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathA));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerTwoCardA.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(1).get("A");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerTwoCardAAtkLabel.setText("Atk");
            playerTwoCardAAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerTwoCardAHpLabel.setText("HP");
            playerTwoCardAHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerTwoCardAExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerTwoCardA.setGraphic(null);
            playerTwoCardAAtkLabel.setText("");
            playerTwoCardAHpLabel.setText("");
            playerTwoCardAAtkCount.setText("");
            playerTwoCardAHpCount.setText("");
            playerTwoCardAExpLabel.setText("");
        }
        imagePathB = board.get(1).get("B").getCharacter().getImagePath();
        if (imagePathB != "" && board.get(1).get("B").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathB));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerTwoCardB.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(1).get("B");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerTwoCardBAtkLabel.setText("Atk");
            playerTwoCardBAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerTwoCardBHpLabel.setText("HP");
            playerTwoCardBHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerTwoCardBExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerTwoCardB.setGraphic(null);
            playerTwoCardBAtkLabel.setText("");
            playerTwoCardBHpLabel.setText("");
            playerTwoCardBAtkCount.setText("");
            playerTwoCardBHpCount.setText("");
            playerTwoCardBExpLabel.setText("");
        }
        imagePathC = board.get(1).get("C").getCharacter().getImagePath();
        if (imagePathC != "" && board.get(1).get("C").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathC));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerTwoCardC.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(1).get("C");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerTwoCardCAtkLabel.setText("Atk");
            playerTwoCardCAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerTwoCardCHpLabel.setText("HP");
            playerTwoCardCHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerTwoCardCExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerTwoCardC.setGraphic(null);
            playerTwoCardCAtkLabel.setText("");
            playerTwoCardCHpLabel.setText("");
            playerTwoCardCAtkCount.setText("");
            playerTwoCardCHpCount.setText("");
            playerTwoCardCExpLabel.setText("");
        }
        imagePathD = board.get(1).get("D").getCharacter().getImagePath();
        if (imagePathD != "" && board.get(1).get("D").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathD));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerTwoCardD.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(1).get("D");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerTwoCardDAtkLabel.setText("Atk");
            playerTwoCardDAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerTwoCardDHpLabel.setText("HP");
            playerTwoCardDHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerTwoCardDExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerTwoCardD.setGraphic(null);
            playerTwoCardDAtkLabel.setText("");
            playerTwoCardDHpLabel.setText("");
            playerTwoCardDAtkCount.setText("");
            playerTwoCardDHpCount.setText("");
            playerTwoCardDExpLabel.setText("");
        }
        imagePathE = board.get(1).get("E").getCharacter().getImagePath();
        if (imagePathE != "" && board.get(1).get("E").getCharacter().getHealth() > 0) {
            ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePathE));
            cardView.setFitWidth(60);
            cardView.setFitHeight(60);
            cardView.setPreserveRatio(true);
            playerTwoCardE.setGraphic(cardView);

            SummonedCharacter tempSum = board.get(1).get("E");
            Character tempChar = tempSum.getCharacter();
            Integer atk = tempChar.getAttack();
            Integer hp = tempChar.getHealth();
            Integer level = tempSum.getLevel();
            Integer hpAdd = tempSum.getHpAdd();
            Integer atkAdd = tempSum.getAttackAdd();
            Integer exp = tempSum.getExperience();
            Integer[] expMax = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
            playerTwoCardEAtkLabel.setText("Atk");
            playerTwoCardEAtkCount.setText(atk.toString() + "(+" + atkAdd.toString() + ")");
            playerTwoCardEHpLabel.setText("HP");
            playerTwoCardEHpCount.setText(hp.toString() + "(+" + hpAdd.toString() + ")");
            playerTwoCardEExpLabel.setText(exp.toString() + "/" + expMax[level - 1] + "[" + level.toString() + "]");

        } else {
            playerTwoCardE.setGraphic(null);
            playerTwoCardEAtkLabel.setText("");
            playerTwoCardEHpLabel.setText("");
            playerTwoCardEAtkCount.setText("");
            playerTwoCardEHpCount.setText("");
            playerTwoCardEExpLabel.setText("");
        }

    }

    public void connectMana() {
        Integer mana;
        if (currPlayer == 0) {
            mana = game.getPlayers()[0].getMana();
        } else {
            mana = game.getPlayers()[1].getMana();
        }
        Integer maxMana = (int) Math.ceil((double) game.getRound() / 2);
        if (maxMana > 10) {
            maxMana = 10;
        }
        manaCount.setText(mana.toString() + "/" + maxMana);
    }

    public void connectRound() {
        updatePlayer();
        roundCount.setText(game.getRound().toString());
    }

    public void connectDeck() {
        updatePlayer();
        Deck deck;
        Integer deckCountSize = 0;
        if (currPlayer == 0) {
            deck = playerOne.getDeck();
            deckCountSize = deck.getCard().size();
            deckCount.setText(deckCountSize + "/" + playerOneTotalDeck);
        } else {
            deck = playerTwo.getDeck();
            deckCountSize = deck.getCard().size();
            deckCount.setText(deckCountSize + "/" + playerTwoTotalDeck);
        }
    }

    public void connectHandInDeck() {
        ArrayList<Card> inHand;
        Player[] players = game.getPlayers();
        if (currPlayer == 0) {
            inHand = players[0].getHandCard();
        } else {
            inHand = players[1].getHandCard();
        }
        System.out.println("Size inHand player" + currPlayer + ": " + inHand.size());

        if (inHand.size() == 0) {
            Card1.setGraphic(null);
            Card2.setGraphic(null);
            Card3.setGraphic(null);
            Card4.setGraphic(null);
            Card5.setGraphic(null);
        } else {
            String imagePath = inHand.get(0).getImagePath();
            if (inHand.size() > 0) {
                if (imagePath != "") {
                    ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePath));
                    cardView.setFitWidth(80);
                    cardView.setFitHeight(80);
                    cardView.setPreserveRatio(true);
                    Card1.setGraphic(cardView);
                } else {
                    Card1.setGraphic(null);
                }
                Card2.setGraphic(null);
                Card3.setGraphic(null);
                Card4.setGraphic(null);
                Card5.setGraphic(null);
            }

            if (inHand.size() > 1) {
                imagePath = inHand.get(1).getImagePath();
                if (imagePath != "") {
                    ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePath));
                    cardView.setFitWidth(80);
                    cardView.setFitHeight(80);
                    cardView.setPreserveRatio(true);
                    Card2.setGraphic(cardView);
                } else {
                    Card2.setGraphic(null);
                }
                Card3.setGraphic(null);
                Card4.setGraphic(null);
                Card5.setGraphic(null);
            }

            if (inHand.size() > 2) {
                imagePath = inHand.get(2).getImagePath();
                if (imagePath != "") {
                    ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePath));
                    cardView.setFitWidth(80);
                    cardView.setFitHeight(80);
                    cardView.setPreserveRatio(true);
                    Card3.setGraphic(cardView);
                } else {
                    Card3.setGraphic(null);
                }
                Card4.setGraphic(null);
                Card5.setGraphic(null);
            }

            if (inHand.size() > 3) {
                imagePath = inHand.get(3).getImagePath();
                if (imagePath != "") {
                    ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePath));
                    cardView.setFitWidth(80);
                    cardView.setFitHeight(80);
                    cardView.setPreserveRatio(true);
                    Card4.setGraphic(cardView);
                } else {
                    Card4.setGraphic(null);
                }
                Card5.setGraphic(null);
            }

            if (inHand.size() > 4) {
                imagePath = inHand.get(4).getImagePath();
                if (imagePath != "") {
                    ImageView cardView = new ImageView(new Image("com/aetherwars/" + imagePath));
                    cardView.setFitWidth(80);
                    cardView.setFitHeight(80);
                    cardView.setPreserveRatio(true);
                    Card5.setGraphic(cardView);
                } else {
                    Card5.setGraphic(null);
                }
            }
        }

    }

    public void setHoveredImage(ArrayList<Card> inHand, Integer pos) {
        updatePlayer();
        String imagePath = inHand.get(pos).getImagePath();
        if (imagePath != "") {
            hoveredCardImage.setImage(new Image("com/aetherwars/" + imagePath));
        }
        if (inHand.get(pos).getCardType().equals(CardType.CHARACTER)) {
            String name = inHand.get(pos).getName();
            Character temp = (Character) inHand.get(pos);
            String health = temp.getHealth().toString();
            Type charType = temp.getType();
            String attack = temp.getAttack().toString();
            String mana = temp.getmanaCost().toString();
            String details = "Name: " + name + "\nHealth: " + health + "\nType: " + charType + "\nAttack: " + attack
                    + "\nMana Cost: " + mana;
            hoveredCardDetailText.setText(details);
        } else {
            Spell temp = (Spell) inHand.get(pos);
            String name = temp.getName();
            String detailText = "";
            String mana = temp.getmanaCost().toString();
            if (temp.getSpellType().equals(SpellType.LVL)) {
                String spellType = temp.getSpellType().toString();
                String levelUpType = ((LvlSpell) temp).getLvlSpellType().toString();
                detailText = "Name: " + name + "\nSpell Type: " + spellType + "\nLevel Up Type: " + levelUpType;
            } else if (temp.getSpellType().equals(SpellType.MORPH)) {
                detailText = "Name: " + name + "\nMana Cost: " + mana + "\nSpell Type: "
                        + temp.getSpellType().toString();
            } else if ((temp.getSpellType().equals(SpellType.PTN))) {
                String boostAttack = ((PtnSpell) temp).getBoostAttack().toString();
                String boostHealth = ((PtnSpell) temp).getBoostHP().toString();
                String duration = ((PtnSpell) temp).getDuration().toString();
                detailText = "Name: " + name + "\nMana Cost: " + mana + "\nSpell Type: "
                        + temp.getSpellType().toString() + "\nBoost Attack: " + boostAttack + "\nBoost Health: "
                        + boostHealth + "\nDuration: " + duration;
            } else if ((temp.getSpellType().equals(SpellType.SWAP))) {
                String duration = ((SwapSpell) temp).getDuration().toString();
                detailText = "Name: " + name + "\nMana Cost: " + mana + "\nSpell Type: "
                        + temp.getSpellType().toString() + "\nDuration: " + duration;
            }
            hoveredCardDetailText.setText(detailText);
        }
    }

    public void connectCard1Hovered(ArrayList<Card> inHand) {
        Card1.setOnMouseMoved(value -> {
            if (inHand.get(0).getImagePath() != "") {
                ImageView cardView = new ImageView(new Image("com/aetherwars/" + inHand.get(0).getImagePath()));
                cardView.setFitWidth(80);
                cardView.setFitHeight(80);
                cardView.setPreserveRatio(true);
                Card1.setGraphic(cardView);
                hoveredCardDescriptionText.setText(inHand.get(0).getDescription());
                setHoveredImage(inHand, 0);
            }
        });

        Card1.setOnMouseExited(value -> {
            backToNormalHovered();
        });
    }

    public void connectCard2Hovered(ArrayList<Card> inHand) {
        Card2.setOnMouseMoved(value -> {
            if (inHand.get(1).getImagePath() != "") {
                ImageView cardView = new ImageView(new Image("com/aetherwars/" + inHand.get(1).getImagePath()));
                cardView.setFitWidth(80);
                cardView.setFitHeight(80);
                cardView.setPreserveRatio(true);
                Card2.setGraphic(cardView);
                hoveredCardDescriptionText.setText(inHand.get(1).getDescription());
                setHoveredImage(inHand, 1);
            }
        });

        Card2.setOnMouseExited(value -> {
            backToNormalHovered();
        });
    }

    public void connectCard3Hovered(ArrayList<Card> inHand) {
        Card3.setOnMouseMoved(value -> {
            if (inHand.get(2).getImagePath() != "") {
                ImageView cardView = new ImageView(new Image("com/aetherwars/" + inHand.get(2).getImagePath()));
                cardView.setFitWidth(80);
                cardView.setFitHeight(80);
                cardView.setPreserveRatio(true);
                Card3.setGraphic(cardView);
                hoveredCardDescriptionText.setText(inHand.get(2).getDescription());
                setHoveredImage(inHand, 2);
            }
        });

        Card3.setOnMouseExited(value -> {
            backToNormalHovered();
        });
    }

    public void connectCard4Hovered(ArrayList<Card> inHand) {
        Card4.setOnMouseMoved(value -> {
            if (inHand.get(3).getImagePath() != "") {
                ImageView cardView = new ImageView(new Image("com/aetherwars/" + inHand.get(3).getImagePath()));
                cardView.setFitWidth(80);
                cardView.setFitHeight(80);
                cardView.setPreserveRatio(true);
                Card4.setGraphic(cardView);
                hoveredCardDescriptionText.setText(inHand.get(3).getDescription());
                setHoveredImage(inHand, 3);
            }
        });

        Card4.setOnMouseExited(value -> {
            backToNormalHovered();
        });
    }

    public void connectCard5Hovered(ArrayList<Card> inHand) {
        Card5.setOnMouseMoved(value -> {
            if (inHand.get(4).getImagePath() != "") {
                ImageView cardView = new ImageView(new Image("com/aetherwars/" + inHand.get(4).getImagePath()));
                cardView.setFitWidth(80);
                cardView.setFitHeight(80);
                cardView.setPreserveRatio(true);
                Card5.setGraphic(cardView);
                hoveredCardDescriptionText.setText(inHand.get(4).getDescription());
                setHoveredImage(inHand, 4);
            }
        });

        Card5.setOnMouseExited(value -> {
            backToNormalHovered();
        });
    }

    public void connectMouseHover() {
        connectHoveredBoard();
        ArrayList<Card> inHand;
        if (currPlayer == 0) {
            inHand = game.getPlayers()[0].getHandCard();
        } else {
            inHand = game.getPlayers()[1].getHandCard();
        }

        System.out.println("Connecting mouse hover");
        System.out.println(inHand.size());
        if (inHand.size() == 0) {
            Card1.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card2.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card3.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card4.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card5.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
        } else if (inHand.size() == 1) {
            connectCard1Hovered(inHand);
            Card2.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card3.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card4.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card5.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
        } else if (inHand.size() == 2) {
            connectCard1Hovered(inHand);
            connectCard2Hovered(inHand);
            Card3.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card4.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card5.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
        } else if (inHand.size() == 3) {
            connectCard1Hovered(inHand);
            connectCard2Hovered(inHand);
            connectCard3Hovered(inHand);
            Card4.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
            Card5.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
        } else if (inHand.size() == 4) {
            connectCard1Hovered(inHand);
            connectCard2Hovered(inHand);
            connectCard3Hovered(inHand);
            connectCard4Hovered(inHand);
            Card5.setOnMouseMoved(value -> {
                backToNormalHovered();
            });
        } else if (inHand.size() == 5) {
            connectCard1Hovered(inHand);
            connectCard2Hovered(inHand);
            connectCard3Hovered(inHand);
            connectCard4Hovered(inHand);
            connectCard5Hovered(inHand);
        }
    }

    public void backToNormalHovered() {
        hoveredCardImage.setImage(null);
        hoveredCardDetailText.setText("");
        hoveredCardDescriptionText.setText("");
    }

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() throws Exception {
        playerOne = new Player("COW");
        playerTwo = new Player("CREEPER");
        playerOne.setMana(9);
        playerTwo.setMana(9);
        game = new GamePlay(playerOne, playerTwo);

        // TODO: player one and two avatar

        Image playerOneImage = new Image("com/aetherwars/card/image/PlayerOne.jpg");
        Image playerTwoImage = new Image("com/aetherwars/card/image/PlayerTwo.jpg");
        ImageView view = new ImageView(playerOneImage);
        view.setFitWidth(100);
        view.setFitHeight(100);
        view.setPreserveRatio(true);
        playerOneAvatar.setGraphic(view);
        view = new ImageView(playerTwoImage);
        view.setFitWidth(100);
        view.setFitHeight(100);
        view.setPreserveRatio(true);
        playerTwoAvatar.setGraphic(view);

        currPlayer = game.getCurrPlayerIndex();
        playerOneName.setText(playerOne.getName());
        playerTwoName.setText(playerTwo.getName());
        playerOneHealth.setWidth(500);
        playerTwoHealth.setWidth(500);
        // make new random variable Deck Number between 40-60
        Integer deckNumber1 = (int) (Math.random() * (60 - 40 + 1)) + 40;
        Integer deckNumber2 = (int) (Math.random() * (60 - 40 + 1)) + 40;
        playerOne.getDeck().generateCard(deckNumber1);
        playerTwo.getDeck().generateCard(deckNumber2);
        playerOneTotalDeck = playerOne.getDeck().getCard().size();
        playerTwoTotalDeck = playerTwo.getDeck().getCard().size();
        ArrayList<Card> playerOneTopThree = playerOne.getDeck().getTop3();
        ArrayList<Card> playerTwoTopThree = playerTwo.getDeck().getTop3();
        for (int i = 0; i < 3; i++) {
            playerOne.addHandCard(playerOneTopThree.get(i));
            playerTwo.addHandCard(playerTwoTopThree.get(i));

        }
        connectDeck();
        connectBoard();
        initializeBoard();
        nextPhaseButton.setText("START");
    }

}
