package own.game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import own.game.config.ObjectConfiguration;
import own.game.controllers.P1Controller;
import own.game.controls.ControlSettings;
import own.game.models.P1Missile;
import own.game.models.P1Tank;
import own.game.stage.Stage1;

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

        //creating canvas
        Stage1 stage1 = new Stage1(root);

        //creating objects
        P1Tank p1Tank = new P1Tank(root, 800, 600, 4); //добавить removeImage
        P1Controller p1Controller = new P1Controller();
        List<P1Missile> p1Missiles = new ArrayList<>();

        //setting updates
        ControlSettings controlSettings = new ControlSettings(root, p1Controller, p1Tank, p1Missiles);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate(p1Missiles);
            }
        };
        timer.start();

        //Всякие инструменты
        //System.out.println(Toolkit.getToolkit().getKeyCodeForChar("w"));
        //удаление элементов:
        //root.getChildren().removeAll(bullet.getView(), enemy.getView());
        return root;
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