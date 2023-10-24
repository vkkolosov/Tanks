package own.game.models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.List;

public class P1Missile {

    private ImageView imageView;
    private Pane pane;
    private int x, y;
    private int rotate;
    private int speed;

    public P1Missile(P1Tank p1Tank, Pane root) {
        imageView = new ImageView("./models/p1_missile_8x8.png");
        speed = 5;
        this.pane = root;

        switch ((int)p1Tank.getImageView().getRotate()) {
            case 0:
                this.y = p1Tank.getY() - 20;
                this.x = p1Tank.getX() + 16;
                this.rotate = 0;
                break;
            case 90:
                this.y = p1Tank.getY() + 16;
                this.x = p1Tank.getX() + 40;
                this.rotate = 90;
                break;
            case 180:
                this.y = p1Tank.getY() + 40;
                this.x = p1Tank.getX() + 16;
                this.rotate = 180;
                break;
            case 270:
                this.y = p1Tank.getY() + 16;
                this.x = p1Tank.getX() - 20;
                this.rotate = 270;
                break;
        }

        imageView.setX(this.x);
        imageView.setY(this.y);

    }

    public void update() {
        switch (rotate) {
            case 0:
                y = y - speed;
                imageView.setY(y);
                if (y < 100)
                    pane.getChildren().remove(imageView);
                break;
            case 90:
                x = x + speed;
                imageView.setX(x);
                if (x > 700)
                    pane.getChildren().remove(imageView);
                break;
            case 180:
                y = y + speed;
                imageView.setY(y);
                if (y > 500)
                    pane.getChildren().remove(imageView);
                break;
            case 270:
                x = x - speed;
                imageView.setX(x);
                if (x < 100)
                    pane.getChildren().remove(imageView);
                break;
        }
    }

    public static void addMissile(Pane root, List<P1Missile> p1Missiles, P1Missile p1Missile) {
        root.getChildren().add(p1Missile.getImageView());
        p1Missiles.add(p1Missile);
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

    public ImageView getImageView() {
        return imageView;
    }
}
