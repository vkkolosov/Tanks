package own.game.models;

import javafx.scene.image.ImageView;

public class P1Tank {

    private ImageView imageView;
    private int x, y;

    //координаты разрешения
    public P1Tank(int x, int y) {
        imageView = new ImageView("./models/tank_p1_40x40.png");
        this.x = x/2;
        this.y = y/2;
        imageView.setX(this.x);
        imageView.setY(this.y);
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
