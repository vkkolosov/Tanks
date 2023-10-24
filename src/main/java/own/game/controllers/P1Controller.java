package own.game.controllers;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;
import own.game.models.P1Tank;

public class P1Controller {

    //todo добавить turnLeft, turnRight и т.д.
    public void moveUp(P1Tank p1Tank) {
        p1Tank.getImageView().setY(p1Tank.getY() - p1Tank.getPush());
        p1Tank.setY(p1Tank.getY() - p1Tank.getPush());
        p1Tank.getImageView().setRotate(0);
    }

    public void moveLeft(P1Tank p1Tank) {
        p1Tank.getImageView().setX(p1Tank.getX() - p1Tank.getPush());
        p1Tank.setX(p1Tank.getX() - p1Tank.getPush());
        p1Tank.getImageView().setRotate(270);
    }

    public void moveRight(P1Tank p1Tank) {
        p1Tank.getImageView().setX(p1Tank.getX() + p1Tank.getPush());
        p1Tank.setX(p1Tank.getX() + p1Tank.getPush());
        p1Tank.getImageView().setRotate(90);
    }

    public void moveDown(P1Tank p1Tank) {
        p1Tank.getImageView().setY(p1Tank.getY() + p1Tank.getPush());
        p1Tank.setY(p1Tank.getY() + p1Tank.getPush());
        p1Tank.getImageView().setRotate(180);
    }

}
