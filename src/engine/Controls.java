package engine;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.event.DocumentEvent;
import java.util.ArrayList;

public class Controls implements EventHandler<KeyEvent> {
    private static ArrayList<KeyCode> keysPressed = new ArrayList<>();
    private static Controls instance;

    private static int vertical, horizontal;

    /**
     * @return returns the Controls instance
     */
    public static Controls getControls() {
        if(instance==null)instance=new Controls();
        return instance;
    }

    private Controls() {horizontal=vertical=0;}

    /**
     * Gets called whenever a key is pressed or released
     * @param event
     */
    @Override
    public void handle(KeyEvent event) {
        if(event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            if (!keysPressed.contains(event.getCode()) )
                keysPressed.add(event.getCode());

            //set vertical axis
            if(event.getCode().equals(KeyCode.W) || event.getCode().equals(KeyCode.UP)) {
                vertical=vertical==-1?0:1;
            }
            if(event.getCode().equals(KeyCode.S) || event.getCode().equals(KeyCode.DOWN)) {
                vertical=vertical==1?0:-1;
            }
            //set horizontal axis
            if(event.getCode().equals(KeyCode.D) || event.getCode().equals(KeyCode.RIGHT)) {
                horizontal=horizontal==-1?0:1;
            }
            if(event.getCode().equals(KeyCode.A) || event.getCode().equals(KeyCode.LEFT)) {
                horizontal=horizontal==1?0:-1;
            }
        }
        if(event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            keysPressed.remove(event.getCode());

            //set vertical axis
            if(event.getCode().equals(KeyCode.W) || event.getCode().equals(KeyCode.UP)) {
                vertical=vertical==1?0:-1;
            }
            if(event.getCode().equals(KeyCode.S) || event.getCode().equals(KeyCode.DOWN)) {
                vertical=vertical==-1?0:1;
            }
            //set horizontal axis
            if(event.getCode().equals(KeyCode.D) || event.getCode().equals(KeyCode.RIGHT)) {
                horizontal=horizontal==1?0:-1;
            }
            if(event.getCode().equals(KeyCode.A) || event.getCode().equals(KeyCode.LEFT)) {
                horizontal=horizontal==-1?0:1;
            }
        }
    }

    /**
     * @param keycode the key to check for
     * @return Returns true if the specified key is down
     */
    public boolean isKeyPressed(KeyCode keycode) {
        return keysPressed.contains(keycode);
    }

    public static int getVertical() {
        return vertical;
    }

    public static int getHorizontal() {
        return horizontal;
    }
}
