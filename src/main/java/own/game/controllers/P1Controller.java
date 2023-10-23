package own.game.controllers;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import own.game.models.P1Tank;

public class P1Controller {

    public int push;
    public P1Controller(int push) {
        this.push = push;
    }

    public void moveUp(P1Tank p1Tank) {
        p1Tank.getImageView().setY(p1Tank.getY() - push);
        p1Tank.setY(p1Tank.getY() - push);
        p1Tank.getImageView().setRotate(0);
    }

    public void moveLeft(P1Tank p1Tank) {
        p1Tank.getImageView().setX(p1Tank.getX() - push);
        p1Tank.setX(p1Tank.getX() - push);
        p1Tank.getImageView().setRotate(270);
    }

    public void moveRight(P1Tank p1Tank) {
        p1Tank.getImageView().setX(p1Tank.getX() + push);
        p1Tank.setX(p1Tank.getX() + push);
        p1Tank.getImageView().setRotate(90);
    }

    public void moveDown(P1Tank p1Tank) {
        p1Tank.getImageView().setY(p1Tank.getY() + push);
        p1Tank.setY(p1Tank.getY() + push);
        p1Tank.getImageView().setRotate(180);
    }

}
