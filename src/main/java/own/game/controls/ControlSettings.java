package own.game.controls;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import own.game.controllers.P1Controller;
import own.game.models.P1Missile;
import own.game.models.P1Tank;

import java.util.List;

import static own.game.config.ObjectConfiguration.missileTimer;

public class ControlSettings {

    public ControlSettings(Pane root,
                           P1Controller p1Controller,
                           P1Tank p1Tank,
                           List<P1Missile> p1Missiles) {

        root.setOnKeyPressed(event -> {
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
            //on key pressed - todo очевидно есть delay между onKeyTyped и onKeyPressed
            //todo важно, у onKeyPressed - стоит таймер ~5-7 сек, затем release
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
                    P1Missile.addMissile(root, p1Missiles, new P1Missile(p1Tank, root));
                    missileTimer = 10;
                }
            }
        });
    }
}
