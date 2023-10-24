package own.game.models;

import javafx.geometry.Point3D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class P1Tank {

    private ImageView imageView;
    private int x, y;
    private int push;

    //координаты разрешения //todo танк сейчас может уехать с границ канваса
    public P1Tank(Pane root, int x, int y, int push) {
        imageView = new ImageView("./models/tank_p1_40x40.png");
        this.x = x/2;
        this.y = y/2;
        imageView.setX(this.x);
        imageView.setY(this.y);
        this.push = push;
        root.getChildren().add(imageView);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPush() {
        return push;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
