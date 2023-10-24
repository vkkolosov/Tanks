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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import own.game.config.ObjectConfiguration;
import own.game.controllers.MovementController;
import own.game.controllers.P1Controller;
import own.game.models.P1Missile;
import own.game.models.P1Tank;

import java.util.ArrayList;
import java.util.List;

import static own.game.config.ObjectConfiguration.missileTimer;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tanks");
        stage.setScene(new Scene(createContent()));

        stage.show();
    }

    private Parent createContent() {
        //setting common parameters
        ObjectConfiguration objectConfiguration = new ObjectConfiguration();

        //setting frame
        Pane root = new Pane();
        root.setPrefSize(800, 600);

        //creating objects
        P1Tank p1Tank = new P1Tank(800, 600, 4);
        P1Controller p1Controller = new P1Controller();
        List<P1Missile> p1Missiles = new ArrayList<>();

        //setting canvas
        Canvas canvas = new Canvas(800, 600);
        canvas.setFocusTraversable(true);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill((Color.rgb(255, 255, 128, 1.0)));
        gc.fillRect(0, 0, 800, 600);
        gc.strokeLine(400, 0, 400, 600);

        //setting updates
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate(p1Missiles);
            }
        };
        timer.start();

        //include elements into the frame
        root.getChildren().add(canvas);
        root.getChildren().add(p1Tank.getImageView());

        //setting control
        canvas.setOnKeyPressed(event -> {
            /*
            //русские буквы не работают - key typed
            if (event.getCharacter().equals("w") || event.getCharacter().equals("ц"))
                p1Controller.moveUp(p1Tank);

            if (event.getCharacter().equals("s") || event.getCharacter().equals("ы"))
                p1Controller.moveDown(p1Tank);

            if (event.getCharacter().equals("a") || event.getCharacter().equals("ф"))
                p1Controller.moveLeft(p1Tank);

            if (event.getCharacter().equals("d") || event.getCharacter().equals("в"))
                p1Controller.moveRight(p1Tank);

            if (event.getCharacter().equals("i") || event.getCharacter().equals("ш")) {
                if (missileTimer == 0) {
                    addMissile(root, p1Missiles, new P1Missile(p1Tank, root));
                    missileTimer = 10;
                }
            }
            */
            //on key pressed
            if (event.getCode() == KeyCode.W)
                p1Controller.moveUp(p1Tank);

            if (event.getCode() == KeyCode.S)
                p1Controller.moveDown(p1Tank);

            if (event.getCode() == KeyCode.A)
                p1Controller.moveLeft(p1Tank);

            if (event.getCode() == KeyCode.D)
                p1Controller.moveRight(p1Tank);

            if (event.getCode() == KeyCode.I) {
                if (missileTimer == 0) {
                    addMissile(root, p1Missiles, new P1Missile(p1Tank, root));
                    missileTimer = 10;
                }
            }
        });

        //удаление элементов:
        //root.getChildren().removeAll(bullet.getView(), enemy.getView());

        return root;
    }

    public void addMissile(Pane root, List<P1Missile> p1Missiles, P1Missile p1Missile) {
        root.getChildren().add(p1Missile.getImageView());
        p1Missiles.add(p1Missile);
    }

    public void onUpdate(List<P1Missile> p1Missiles) {
        if (missileTimer > 0) {
            missileTimer--;
        }
        p1Missiles.forEach(p1Missile -> p1Missile.update());
    }

    public static void main(String[] args) {
        launch(args);
    }
}