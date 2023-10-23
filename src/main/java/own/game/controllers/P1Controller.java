package own.game.controllers;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import own.game.models.P1Tank;

public class P1Controller {

    public void moveUp(P1Tank p1Tank) {
        p1Tank.setY(p1Tank.getY() - 10);
    }

    public void moveLeft(P1Tank p1Tank) {
        p1Tank.setY(p1Tank.getX() - 10);
    }

    public void moveRight(P1Tank p1Tank) {
        p1Tank.setY(p1Tank.getX() + 10);
    }

    public void moveDown(P1Tank p1Tank) {
        p1Tank.setY(p1Tank.getY() + 10);
    }

}
