package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    Dice dice1, dice2;
    Game currentGame;

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.currentGame = new Game();
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());
        currentGame.rollDices(this.dice1.getValue(), this.dice2.getValue());
        updateGame();
    }

    public void updateGame() {
        //Actualizar la logica del juego y los resultados en la interfaz
        if (currentGame.isWin()) {
            shootLabel.setText("¡Ganaste!");
            pointLabel.setText("-");
        } else if (currentGame.isLose()) {
            shootLabel.setText("¡Perdiste!");
            pointLabel.setText("-");
        } else if (currentGame.isPointEstablished()) {
            shootLabel.setText("Tiro: " + currentGame.getShoot());
            pointLabel.setText("Punto: " + currentGame.getPoint());
        } else {
            shootLabel.setText("Tiro: " + currentGame.getShoot());
            pointLabel.setText("-");
        }
    }

    public void resetGame() {
        currentGame.resetGame();
        shootLabel.setText("-");
        pointLabel.setText("-");
    }

}
