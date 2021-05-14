package snake;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * Handles controls of a snake game, where the 'a' and 'd' keys can be used to
 * move and 's' (un)pauses the game
 */
public class InputHandler {

    private final EventHandler<KeyEvent> keyHandler;
    private final EventHandler<MouseEvent> mouseHandler;

    public InputHandler(World w) {
        Snake s = w.getSnake();
        keyHandler = keyEvent -> {

            if (keyEvent.getCode() == KeyCode.A) {

                s.setDirection(s.getDirection().rotateLeft());

            } else if (keyEvent.getCode() == KeyCode.D) {

                s.setDirection(s.getDirection().rotateRight());

            } else if (keyEvent.getCode() == KeyCode.S) {

                if (w.isRunning()) {
                    w.setRunning(false);
                } else {
                    w.setRunning(true);
                }

            }

            keyEvent.consume();
        };

        mouseHandler = mouseEvent -> {
            int x = (int) (mouseEvent.getX() / SnakeGame.SCALE);
            int y = (int) (mouseEvent.getY() / SnakeGame.SCALE);

            if (x < w.getSize() && y < w.getSize() && x >= 0 && y >= 0) {
                w.getFood().moveTo(x, y);
            }
            mouseEvent.consume();
        };
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }
}
