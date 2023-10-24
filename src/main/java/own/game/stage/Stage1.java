package own.game.stage;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Stage1 {

    Canvas canvas;

    public Stage1 (Pane root) {
        //setting canvas
        canvas = new Canvas(800, 600);
        canvas.setFocusTraversable(true);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill((Color.rgb(255, 255, 128, 1.0)));
        gc.fillRect(0, 0, 800, 600);
        gc.strokeLine(400, 0, 400, 600);
        root.getChildren().add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
