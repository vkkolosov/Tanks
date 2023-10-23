package own.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import own.game.controllers.MovementController;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        //new scene
        Group scene = new Group();

        //engine example
        /*
        @Override
        public void run () {
            while (playing) {
                update();
                draw();
                control();
            }
        }
        */

        //draw
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);
        gc.strokeLine(400, 0, 400, 600);
        //set image
        ImageView image = new ImageView("./models/tank_p1_64x64.png");
        image.setFitHeight(64);
        image.setFitWidth(64);
        image.setX(400 - image.getFitWidth() / 2);
        image.setY(600 - image.getFitHeight());

        //MovementController mc = new MovementController();
        //mc.makeMovable(image, scene);

        System.out.println(image.getX());
        System.out.println(image.getY());

        //add to scene
        scene.getChildren().addAll(canvas, image);

        //run a scene
        primaryStage.setScene(new Scene(scene, 800, 600));

        primaryStage.getScene().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.W) {
                    image.setY(image.getY() - 10);
                }
            }
        });

        primaryStage.show();
    }
}