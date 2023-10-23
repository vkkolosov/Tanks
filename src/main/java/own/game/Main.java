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
import own.game.controllers.MovementController;
import own.game.controllers.P1Controller;
import own.game.models.P1Tank;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tanks");
        stage.setScene(new Scene(createContent()));

        stage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);

        P1Tank p1Tank = new P1Tank(800, 600);
        P1Controller p1Controller = new P1Controller(1);

        Canvas canvas = new Canvas(800, 600);
        canvas.setFocusTraversable(true);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill((Color.rgb(255, 255, 128, 1.0)));
        gc.fillRect(0, 0, 800, 600);
        gc.strokeLine(400, 0, 400, 600);

        //русские буквы не работают
        canvas.setOnKeyTyped(event -> {
            if (event.getCharacter().equals("w") || event.getCharacter().equals("ц"))
                p1Controller.moveUp(p1Tank);

            if (event.getCharacter().equals("s") || event.getCharacter().equals("ы"))
                p1Controller.moveDown(p1Tank);

            if (event.getCharacter().equals("a") || event.getCharacter().equals("ф"))
                p1Controller.moveLeft(p1Tank);

            if (event.getCharacter().equals("d") || event.getCharacter().equals("в"))
                p1Controller.moveRight(p1Tank);

            //non working
            if (event.getCode() == KeyCode.S)
                p1Controller.moveDown(p1Tank);
        });

        //удаление элементов:
        //root.getChildren().removeAll(bullet.getView(), enemy.getView());

        root.getChildren().add(canvas);
        root.getChildren().add(p1Tank.getImageView());

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}