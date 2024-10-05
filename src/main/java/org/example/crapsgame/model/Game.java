package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    private boolean pointEstablished;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
        this.pointEstablished = false;

    }

    public boolean isWin() {
        return this.win;
    }

    public boolean isLose() {
        return this.lose;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isPointEstablished() {
        return this.pointEstablished;
    }

    public int getShoot() {
        return this.shoot;
    }

    //Logica del juego (comprueba si gano o perdio)
    public void rollDices(int dice1Value, int dice2Value) {
        this.shoot = dice1Value + dice2Value;
        shootCount++;

        if (!pointEstablished) {
            if (shoot == 7 || shoot == 11) {
                win = true; // Ganas
            } else if (shoot == 2 || shoot == 3 || shoot == 12) {
                lose = true; // Pierdes
            } else {
                point = shoot; // Establece el punto
                pointEstablished = true;
            }
        } else {
            // Si ya hay un punto establecido, verifica si ganaste o perdiste
            if (shoot == point) {
                win = true; // Ganas
            } else if (shoot == 7) {
                lose = true; // Pierdes
            }
        }
    }

    //Reinicia el estado del juego
    public void resetGame() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
        this.win = false;
        this.lose = false;
        this.pointEstablished = false;
    }
}
