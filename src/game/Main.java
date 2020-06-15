package game;

import engine.Controls;
import engine.GameScene;
import game.scenes.MainMenuScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private Canvas canvas;
    private boolean isRunning;
    private final int fps = 60, width=1600, height = 900;
    private static GameScene gameScene;


    /**
     * Entry pint for the game
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Space Invaders");
        Group root = new Group();
        canvas = new Canvas(Properties.width, Properties.height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        scene.setOnKeyPressed(Controls.getControls());

        scene.setOnKeyReleased(Controls.getControls());

        gameScene = new MainMenuScene();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                gameScene.update();
                gc.clearRect(0, 0, Properties.width, Properties.height);
                gameScene.draw(gc);
            }
        }.start();
        primaryStage.show();
    }

    /**
     * Sets the displayed scene to the provided GameScene and initializes it
     * @param scene
     */
    public static void setScene(GameScene scene) {
        scene.init();
        gameScene = scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
