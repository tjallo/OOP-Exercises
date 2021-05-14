package snake;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.awt.*;

/**
 * A JavaFX Pane that displays the snake game represented by the given world
 */
public class SnakeGame extends Pane {

    public static final int SCALE = 16;

    public SnakeGame(World w) {
        setPrefSize(w.getSize() * SCALE, w.getSize() * SCALE);
        w.getSnake().addListener(segment -> {
            Rectangle body = new Rectangle(SCALE, SCALE, Color.GREEN);
            body.xProperty().bind(segment.getXProperty().multiply(SCALE));
            body.yProperty().bind(segment.getYProperty().multiply(SCALE));
            getChildren().add(body);
        });

        Rectangle rect1 = new Rectangle(SCALE, SCALE);
        rect1.setFill(Color.RED);
        rect1.xProperty().bind(w.getSnake().getXProperty().multiply(SCALE));
        rect1.yProperty().bind(w.getSnake().getYProperty().multiply(SCALE));

        getChildren().add(rect1);

        Circle circle1 = new Circle(SCALE / 2);
        circle1.setFill(Color.BLUE);
        circle1.centerXProperty().bind(w.getFood().getXProperty().multiply(SCALE).add(SCALE / 2));
        circle1.centerYProperty().bind(w.getFood().getYProperty().multiply(SCALE).add(SCALE / 2));

        getChildren().add(circle1);
    }

    public static Pane createUserInterface(World w) {
        VBox uivBox = new VBox();

        Label scoreLbl = new Label("points");
        Label runningLbl = new Label("Press 's' to start");

        scoreLbl.textProperty().bind(w.getScoreProperty().asString("Your score is %d"));
        w.getRunningProperty().addListener((e, x, y) ->
        {
            if (y) {
                runningLbl.textProperty().set("");
            } else runningLbl.textProperty().set("Press s to unpause");
        });

        uivBox.getChildren().addAll(scoreLbl, runningLbl);

        return uivBox;
    }
}

