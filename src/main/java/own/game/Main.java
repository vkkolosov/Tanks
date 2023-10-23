package own.game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import own.game.controllers.MovementController;
import own.game.controllers.P1Controller;
import own.game.models.P1Tank;


public class Main extends Application {

    private GraphicsContext g;
    private Image image;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tanks");
        stage.setScene(new Scene(createContent()));

        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);

        image = new Image("./models/tank_p1_40x40.png");

        Canvas canvas = new Canvas(800, 600);
        g = canvas.getGraphicsContext2D();
        g.drawImage(image, 0, 0);

        root.getChildren().add(canvas);

        return root;
    }

    public void onUpdate() {
        g.drawImage(image, 0, 0);
    }
}